package LifeUnderWaterClient;

import LifeUnderWater.CollectionServiceGrpc;
import LifeUnderWater.CollectionServiceOuterClass.CollectionSummary;
import LifeUnderWater.CollectionServiceOuterClass.Command;
import LifeUnderWater.CollectionServiceOuterClass.RecordPathPoint;
import LifeUnderWater.CollectionServiceOuterClass.RobotStatus;
import LifeUnderWater.NamingServiceGrpc;
import LifeUnderWater.NamingServiceOuterClass.RegisterResponse;
import LifeUnderWater.NamingServiceOuterClass.ServiceInfo;
import LifeUnderWater.NamingServiceOuterClass.ServiceRequest;
import LifeUnderWater.PollutionLevelServiceGrpc;
import LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk;
import LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet;
import LifeUnderWater.PositionServer.Coordinate;
import LifeUnderWater.PositionServer.PositionAsk;
import LifeUnderWater.PositionServer.PositionRet;
import LifeUnderWater.PositionServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client {

    private static final int NAMING_PORT = 50050;
    private static final int POSITION_PORT = 50051;
    private static final int POLLUTION_PORT = 50052;
    private static final int COLLECTION_PORT = 50053;

    private final ManagedChannel namingChannel;
    private final ManagedChannel positionChannel;
    private final ManagedChannel pollutionChannel;
    private final ManagedChannel collectionChannel;
    private final NamingServiceGrpc.NamingServiceBlockingStub namingStub;
    private final PositionServiceGrpc.PositionServiceBlockingStub positionStub;
    private final PollutionLevelServiceGrpc.PollutionLevelServiceBlockingStub pollutionStub;
    private final CollectionServiceGrpc.CollectionServiceStub collectionStub;
    private final String host;

    public Client(String host) {
        this.host = host;
        namingChannel = buildChannel(host, NAMING_PORT);
        positionChannel = buildChannel(host, POSITION_PORT);
        pollutionChannel = buildChannel(host, POLLUTION_PORT);
        collectionChannel = buildChannel(host, COLLECTION_PORT);

        namingStub = NamingServiceGrpc.newBlockingStub(namingChannel);
        positionStub = PositionServiceGrpc.newBlockingStub(positionChannel);
        pollutionStub = PollutionLevelServiceGrpc.newBlockingStub(pollutionChannel);
        collectionStub = CollectionServiceGrpc.newStub(collectionChannel);
    }

    private ManagedChannel buildChannel(String host, int port) {
        // All services use plain local gRPC, so we keep the channel setup simple here.
        return ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
    }

    public void shutdown() throws InterruptedException {
        namingChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        positionChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        pollutionChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        collectionChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void showGui() {
        JFrame frame = new JFrame("LifeUnderWater Client");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(new Dimension(900, 700));
        frame.setLayout(new BorderLayout());

        JTextArea serviceArea = createOutputArea(8, 40);
        serviceArea.setText(buildServiceOverviewText());
        frame.add(createSection("Service Overview", new JScrollPane(serviceArea)), BorderLayout.NORTH);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Naming", buildNamingPanel());
        tabs.addTab("Position", buildPositionPanel());
        tabs.addTab("Pollution", buildPollutionPanel());
        tabs.addTab("Collection", buildCollectionPanel());
        frame.add(tabs, BorderLayout.CENTER);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                closeFrame(frame);
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel buildNamingPanel() {
        JTextField registerNameField = new JTextField("PollutionLevelService");
        JTextField registerHostField = new JTextField(host);
        JTextField registerPortField = new JTextField(String.valueOf(POLLUTION_PORT));
        JTextField discoverNameField = new JTextField("PollutionLevelService");
        JTextArea outputArea = createOutputArea(14, 40);

        JButton registerDefaultsButton = new JButton("Register 4 Services");
        registerDefaultsButton.addActionListener(event -> runAsync(() -> {
            appendOutput(outputArea, "Registering the 4 known services...");

            appendOutput(outputArea, registerService("NamingService", host, NAMING_PORT));
            appendOutput(outputArea, registerService("PositionService", host, POSITION_PORT));
            appendOutput(outputArea, registerService("PollutionLevelService", host, POLLUTION_PORT));
            appendOutput(outputArea, registerService("CollectionService", host, COLLECTION_PORT));
        }, outputArea));

        JButton registerButton = new JButton("Register One Service");
        registerButton.addActionListener(event -> runAsync(() -> {
            String name = registerNameField.getText().trim();
            String serviceHost = registerHostField.getText().trim();
            int port = parseInt(registerPortField.getText(), "Service Port");

            String result = registerService(name, serviceHost, port);
            appendOutput(outputArea, result);
        }, outputArea));

        JButton discoverButton = new JButton("Discover Service");
        discoverButton.addActionListener(event -> runAsync(() -> {
            String name = discoverNameField.getText().trim();
            ServiceInfo serviceInfo = namingStub.discoverService(ServiceRequest.newBuilder()
                    .setName(name)
                    .build());

            if (serviceInfo.getName().isEmpty()) {
                appendOutput(outputArea, "No service found for name: " + name);
            } else {
                appendOutput(outputArea, "Found service:");
                appendOutput(outputArea, formatServiceInfo(serviceInfo));
            }
        }, outputArea));

        JPanel panel = createVerticalPanel();
        panel.add(createFieldGrid(
                "Service Name", registerNameField,
                "Service Host", registerHostField,
                "Service Port", registerPortField));
        panel.add(createButtonRow(registerDefaultsButton, registerButton));
        panel.add(createFieldGrid(
                "Discover Name", discoverNameField));
        panel.add(createButtonRow(discoverButton));
        panel.add(createSection("Output", new JScrollPane(outputArea)));
        return panel;
    }

    private JPanel buildPositionPanel() {
        JTextField latitudeField = new JTextField("532000000");
        JTextField longitudeField = new JTextField("-6000000");
        JTextArea outputArea = createOutputArea(16, 40);

        JButton invokeButton = new JButton("Get Position");
        invokeButton.addActionListener(event -> runAsync(() -> {
            long latitude = parseLong(latitudeField.getText(), "Latitude E7");
            long longitude = parseLong(longitudeField.getText(), "Longitude E7");

            PositionRet response = positionStub.getPosition(PositionAsk.newBuilder()
                    .setLatitudeE7(latitude)
                    .setLongitudeE7(longitude)
                    .build());

            appendOutput(outputArea, "Request sent with:");
            appendOutput(outputArea, "latitude_e7=" + latitude + ", longitude_e7=" + longitude);
            appendOutput(outputArea, "Returned positions: " + response.getPositionsCount());

            for (Coordinate coordinate : response.getPositionsList()) {
                appendOutput(outputArea,
                        "Position -> latitude_e7=" + coordinate.getLatitudeE7()
                                + ", longitude_e7=" + coordinate.getLongitudeE7());
            }
        }, outputArea));

        JPanel panel = createVerticalPanel();
        panel.add(createFieldGrid(
                "Latitude E7", latitudeField,
                "Longitude E7", longitudeField));
        panel.add(createButtonRow(invokeButton));
        panel.add(createSection("Output", new JScrollPane(outputArea)));
        return panel;
    }

    private JPanel buildPollutionPanel() {
        JTextField pollutionField = new JTextField("10");
        JTextArea outputArea = createOutputArea(16, 40);

        JButton invokeButton = new JButton("Get Pollution Level");
        invokeButton.addActionListener(event -> runAsync(() -> {
            int baseLevel = parseInt(pollutionField.getText(), "Pollution Level");

            Iterator<PollutionLevelRet> responses = pollutionStub.getPollutionLevel(
                    PollutionLevelAsk.newBuilder()
                            .setPollutionLevel(baseLevel)
                            .build());

            appendOutput(outputArea, "Streaming result started from base level: " + baseLevel);
            while (responses.hasNext()) {
                PollutionLevelRet response = responses.next();
                appendOutput(outputArea, "Level -> " + response.getLevel());
            }
            appendOutput(outputArea, "Streaming result finished.");
        }, outputArea));

        JPanel panel = createVerticalPanel();
        panel.add(createFieldGrid(
                "Base Level", pollutionField));
        panel.add(createButtonRow(invokeButton));
        panel.add(createSection("Output", new JScrollPane(outputArea)));
        return panel;
    }

    private JPanel buildCollectionPanel() {
        JTextArea pathInputArea = new JTextArea("100,200\n300,400\n500,600", 6, 40);
        JTextArea batteryInputArea = new JTextArea("80\n15", 6, 40);
        JTextArea outputArea = createOutputArea(16, 40);

        JButton recordPathButton = new JButton("Record Path");
        recordPathButton.addActionListener(event -> runAsync(() ->
                callRecordCollectionPath(pathInputArea.getText(), outputArea), outputArea));

        JButton targetedButton = new JButton("Start Targeted Collection");
        targetedButton.addActionListener(event -> runAsync(() ->
                callStartTargetedCollection(batteryInputArea.getText(), outputArea), outputArea));

        JPanel panel = createVerticalPanel();
        panel.add(createSection("Path Points (one line: latitude,longitude)", new JScrollPane(pathInputArea)));
        panel.add(createButtonRow(recordPathButton));
        panel.add(createSection("Battery Values (one line: percentage)", new JScrollPane(batteryInputArea)));
        panel.add(createButtonRow(targetedButton));
        panel.add(createSection("Output", new JScrollPane(outputArea)));
        return panel;
    }

    private String registerService(String name, String serviceHost, int port) {
        RegisterResponse registerResponse = namingStub.registerService(ServiceInfo.newBuilder()
                .setName(name)
                .setHost(serviceHost)
                .setPort(port)
                .build());

        return "Register result -> " + name + " at " + serviceHost + ":" + port
                + " : " + registerResponse.getStatus();
    }

    private void callRecordCollectionPath(String rawText, JTextArea outputArea) throws InterruptedException {
        CountDownLatch finishLatch = new CountDownLatch(1);

        // Client streaming means we keep sending many points first,
        // and the server only sends one final summary at the end.
        StreamObserver<CollectionSummary> responseObserver = new StreamObserver<CollectionSummary>() {
            @Override
            public void onNext(CollectionSummary value) {
                appendOutput(outputArea, "Summary -> " + value.getResult());
            }

            @Override
            public void onError(Throwable throwable) {
                appendOutput(outputArea, "Record path failed: " + throwable.getMessage());
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                appendOutput(outputArea, "Record path finished.");
                finishLatch.countDown();
            }
        };

        StreamObserver<RecordPathPoint> requestObserver = collectionStub.recordCollectionPath(responseObserver);

        for (String line : rawText.split("\\R")) {
            if (line.trim().isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Each path line must be: latitude,longitude");
            }

            long latitude = parseLong(parts[0].trim(), "Path Latitude");
            long longitude = parseLong(parts[1].trim(), "Path Longitude");

            appendOutput(outputArea, "Sending point -> " + latitude + ", " + longitude);
            requestObserver.onNext(RecordPathPoint.newBuilder()
                    .setLatitudeE7(latitude)
                    .setLongitudeE7(longitude)
                    .build());
        }

        requestObserver.onCompleted();
        finishLatch.await(5, TimeUnit.SECONDS);
    }

    private void callStartTargetedCollection(String rawText, JTextArea outputArea) throws InterruptedException {
        CountDownLatch finishLatch = new CountDownLatch(1);

        // Bidirectional streaming lets the client send robot state
        // while the server answers with command messages.
        StreamObserver<Command> responseObserver = new StreamObserver<Command>() {
            @Override
            public void onNext(Command value) {
                appendOutput(outputArea, "Command -> " + value.getAction());
            }

            @Override
            public void onError(Throwable throwable) {
                appendOutput(outputArea, "Targeted collection failed: " + throwable.getMessage());
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                appendOutput(outputArea, "Targeted collection finished.");
                finishLatch.countDown();
            }
        };

        StreamObserver<RobotStatus> requestObserver = collectionStub.startTargetedCollection(responseObserver);

        for (String line : rawText.split("\\R")) {
            if (line.trim().isEmpty()) {
                continue;
            }

            int battery = parseInt(line.trim(), "Battery Percentage");
            appendOutput(outputArea, "Sending battery value -> " + battery);
            requestObserver.onNext(RobotStatus.newBuilder()
                    .setBatteryPercentage(battery)
                    .build());
        }

        requestObserver.onCompleted();
        finishLatch.await(5, TimeUnit.SECONDS);
    }

    private JPanel createVerticalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }

    private JPanel createFieldGrid(Object... labelFieldPairs) {
        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        for (int i = 0; i < labelFieldPairs.length; i += 2) {
            panel.add(new JLabel(String.valueOf(labelFieldPairs[i])));
            panel.add((JTextField) labelFieldPairs[i + 1]);
        }
        return panel;
    }

    private JPanel createButtonRow(JButton... buttons) {
        JPanel panel = new JPanel();
        for (JButton button : buttons) {
            panel.add(button);
        }
        return panel;
    }

    private JPanel createSection(String title, java.awt.Component component) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }

    private JTextArea createOutputArea(int rows, int columns) {
        JTextArea textArea = new JTextArea(rows, columns);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }

    private void runAsync(ThrowingTask task, JTextArea outputArea) {
        new Thread(() -> {
            try {
                task.run();
            } catch (IllegalArgumentException | StatusRuntimeException exception) {
                appendOutput(outputArea, "Request failed: " + exception.getMessage());
            } catch (Exception exception) {
                appendOutput(outputArea, "Unexpected error: " + exception.getMessage());
            }
        }).start();
    }

    private void appendOutput(JTextArea outputArea, String text) {
        SwingUtilities.invokeLater(() -> {
            outputArea.append(text + System.lineSeparator());
            outputArea.setCaretPosition(outputArea.getDocument().getLength());
        });
    }

    private int parseInt(String value, String fieldName) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(fieldName + " must be a whole number.");
        }
    }

    private long parseLong(String value, String fieldName) {
        try {
            return Long.parseLong(value.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(fieldName + " must be a whole number.");
        }
    }

    private String buildServiceOverviewText() {
        return "This simple client can call all 4 services.\n"
                + "\n"
                + "NamingService -> register and discover services on port " + NAMING_PORT + "\n"
                + "PositionService -> ask for positions on port " + POSITION_PORT + "\n"
                + "PollutionLevelService -> stream pollution levels on port " + POLLUTION_PORT + "\n"
                + "CollectionService -> test client stream and bidirectional stream on port " + COLLECTION_PORT + "\n"
                + "\n"
                + "Host used by this client: " + host + "\n"
                + "Tip: register the 4 services in NamingService first, then use discover.";
    }

    private String formatServiceInfo(ServiceInfo serviceInfo) {
        return "name=" + serviceInfo.getName()
                + ", host=" + serviceInfo.getHost()
                + ", port=" + serviceInfo.getPort();
    }

    private void closeFrame(JFrame frame) {
        try {
            shutdown();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            JOptionPane.showMessageDialog(frame,
                    "Client shutdown was interrupted: " + exception.getMessage());
        }
        frame.dispose();
    }

    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        Client client = new Client(host);

        SwingUtilities.invokeLater(client::showGui);
    }

    @FunctionalInterface
    private interface ThrowingTask {
        void run() throws Exception;
    }
}
