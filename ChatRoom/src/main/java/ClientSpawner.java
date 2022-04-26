public class ClientSpawner {
    public static void main (String argv[]) throws Exception {
        for (int i = 0; i < 5; i++) {
            Client client = new Client(i);
            new Thread(client).start();
        }
        System.out.println("Clients spawned!");
    }
}
