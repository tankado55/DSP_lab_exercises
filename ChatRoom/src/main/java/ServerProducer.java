import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class ServerProducer extends Thread{

    private BufferedReader inFromClient;
    Socket socket = null;
    Queue queue;


    ServerProducer(Socket socket, Queue queue) {
        this.socket = socket;
        this.queue = queue;
        try {
            inFromClient =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String messageFromClient = inFromClient.readLine();
            queue.put(messageFromClient);
            System.out.println("Server Producer");
        } catch (IOException e) {e.printStackTrace();}
    }
}
