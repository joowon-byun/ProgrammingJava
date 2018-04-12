import java.net.*;

public class MulticastServer {

    final static String INET_ADDR  = "224.0.1.200";
    final static int PORT = 8888;

    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        InetAddress addr = InetAddress.getByName(INET_ADDR);

        try (DatagramSocket serverSocket = new DatagramSocket()) {
            for (int i = 0; i < 5; i++) {
                String msg = "Sent message no " + i;

                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                        msg.getBytes().length, addr, PORT);
                serverSocket.send(msgPacket);

                System.out.println("Server sent packet with msg : " + msg);
                Thread.sleep(500);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
