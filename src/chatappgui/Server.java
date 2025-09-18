import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server {
    private static JTextArea textArea;
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static BufferedReader input;
    private static PrintWriter output;
    private static JPanel messagePanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Server Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(messagePanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        JTextField inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.setBackground(new Color(230, 230, 230));
        frame.add(inputField, BorderLayout.SOUTH);

        frame.setVisible(true);

        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                addMessageBubble(message, "Server");
                output.println("Server: " + message);
                inputField.setText("");
            }
        });

        try {
            serverSocket = new ServerSocket(12345);
            clientSocket = serverSocket.accept();
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            output = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = input.readLine()) != null) {
                addMessageBubble(clientMessage, "Client");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add message bubbles
    private static void addMessageBubble(String message, String sender) {
        JPanel bubblePanel = new JPanel();
        bubblePanel.setLayout(new BoxLayout(bubblePanel, BoxLayout.X_AXIS));

        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        messageLabel.setBackground(new Color(240, 240, 240));
        messageLabel.setOpaque(true);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        if (sender.equals("Server")) {
            messageLabel.setBackground(new Color(173, 216, 230));  // Light blue for Server
            bubblePanel.add(Box.createHorizontalGlue());  // Align to the right
            bubblePanel.add(messageLabel);
        } else {
            messageLabel.setBackground(new Color(144, 238, 144));  // Light green for Client
            bubblePanel.add(messageLabel);
        }

        messagePanel.add(bubblePanel);
        messagePanel.revalidate();
        messagePanel.repaint();
    }
}
