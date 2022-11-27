package Chapter17;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.charset.StandardCharsets.UTF_8;
public class SimpleChatClient {
    private JTextArea incoming;
    private JTextField outgoing;
    private BufferedReader reader;
    private PrintWriter writer;


    public void go() {
        // call the setUpNetworking() method 
        // make gui and register a listener with the send button
        setUpNetworking();
        JScrollPane scroller = createScrollableTextArea();
        outgoing = new JTextField(20);
        JButton button = new JButton("Send");
        button.addActionListener(e->sendMessage());
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel panel = new JPanel();
        panel.add(scroller);
        panel.add(outgoing);
        panel.add(button);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(400, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new IncomingReader());
    } 
    private void setUpNetworking() {
    // open a SocketChannel to the server
    // make a PrintWriter and assign to writer instance variable
        try{
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 5000)); // DO NOT DO try(SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 5000));){}, you will get nothing...
            reader = new BufferedReader(Channels.newReader(socketChannel, UTF_8));
            writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
            System.out.println("Networking established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    private JScrollPane createScrollableTextArea(){
        incoming = new JTextArea(15, 30);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane scroller = new JScrollPane(incoming);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroller;
    }

    private void sendMessage() {
    // get the text from the text field and 
    // send it to the server using the writer (a PrintWriter)
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }

    public class IncomingReader implements Runnable{
        @Override
        public void run() {
            String message;
            try{
                while((message=reader.readLine())!=null){
                    System.out.println("read "+message);
                    incoming.append(message+"\n");
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        
    }

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }
}

