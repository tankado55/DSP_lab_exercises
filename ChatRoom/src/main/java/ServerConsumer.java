import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;

public class ServerConsumer extends Thread {

    private DataOutputStream outToClient;
    Queue queue;
    ArrayList<Socket> clientList;

    ServerConsumer(ArrayList<Socket> clientList, Queue queue) {
        this.queue = queue;
        this.clientList = clientList;
    }

    public void run(){
        while (true) {
            consume(queue.take());
            System.out.println("Server Consumer");
        }
    }

    public void consume(String string){
        for (Socket client : clientList) {
            try {
                outToClient =
                        new DataOutputStream(client.getOutputStream());
                outToClient.writeBytes(string + '\n');
            } catch (IOException e) {e.printStackTrace();}

        }
    }
}
