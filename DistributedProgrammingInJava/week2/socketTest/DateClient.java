import java.net.*;
import java.io.*;

public class DateClient {
    public static void main(String[] args) {
        try {
            // make connection to server socket
            Socket socket = new Socket("127.0.0.1", 6013);

            //write the Date to the socket
            PrintWriter pout = new PrintWriter(socket.getOutputStream(), true);
            pout.println(new java.util.Date().toString() + "1233456");

            // read the date from the socket
            InputStream in = socket.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            System.out.println(bin.readLine());

            // close the socket connection
            socket.close();
        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}