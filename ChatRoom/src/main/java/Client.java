import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client extends Thread {

    int id;
    Client(int id){
        this.id = id;
    }

    public void run() {
        try {
            Socket clientSocket = new Socket("localhost", 6789);

            DataOutputStream outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer =
                    new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes("from the client n." + id + '\n');
            while (true){
                String received = inFromServer.readLine();
                System.out.println("I'm " + id + ", received:" + received);
            }
            //clientSocket.close();
        }catch (Exception e) {e.printStackTrace();}
    }
}
