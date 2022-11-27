package Chapter17;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.Scanner;

public class DailyAdviceServer {
    final private String[] adviceList = {
        "Take smaller bites",
        "Go for the tight jeans. No they do NOT make you look fat.",
        "One word: inappropriate",
        "Just for today, be honest. Tell your boss what you *really* think",
        "You might want to rethink that haircut."};
    private final Random random = new Random();

    private String getAdvice(){
        return adviceList[random.nextInt(adviceList.length)];
    }

    private void go(){
        // connection 
        try(ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.bind(new InetSocketAddress(5000));
            
            while(serverChannel.isOpen()){
                SocketChannel clientChannel = serverChannel.accept();
                PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChannel));
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        (new DailyAdviceServer()).go();
    }
}
