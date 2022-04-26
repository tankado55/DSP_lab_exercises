import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static void main(String argv[]) throws Exception {
        ArrayList<Socket> clientList = new ArrayList<Socket>();
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Queue queue = new Queue();
        System.out.println("Server started!");

        ServerConsumer consumer = new ServerConsumer(clientList, queue);
        new Thread(consumer).start();

        while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            clientList.add(connectionSocket);
            // thread creation passing the established socket as arg
            ServerProducer producer =
                    new ServerProducer(connectionSocket, queue);

            // start of the thread
            producer.start();
        }
    }
}
