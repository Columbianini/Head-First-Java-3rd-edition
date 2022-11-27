package Chapter17;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import static java.nio.charset.StandardCharsets.UTF_8;
public class SimpleChatClientA {
    private JTextField outgoing;
    private PrintWriter writer;

    public void go() {
        // call the setUpNetworking() method 
        // make gui and register a listener with the send button
        setUpNetworking();
        outgoing = new JTextField(20);
        JButton button = new JButton("send");
        button.addActionListener(e->sendMessage());
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel panel = new JPanel();
        panel.add(outgoing);
        panel.add(button);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);           
    } 
    private void setUpNetworking() {
    // open a SocketChannel to the server
    // make a PrintWriter and assign to writer instance variable
        try{
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 5000)); // DO NOT DO try(SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 5000));){}, you will get nothing...
            writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
            System.out.println("Networking established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    private void sendMessage() {
    // get the text from the text field and 
    // send it to the server using the writer (a PrintWriter)
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }

    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }
}

