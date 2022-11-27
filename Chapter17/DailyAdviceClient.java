package Chapter17;

import java.io.BufferedReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;

public class DailyAdviceClient{
    public static void main(String[] args) {
        // connect 
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", 5000);
        try(SocketChannel socketChannel = SocketChannel.open(serverAddress);){
            Reader reader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String advice = bufferedReader.readLine();
            System.out.println("Today Advice: " + advice);
            bufferedReader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}