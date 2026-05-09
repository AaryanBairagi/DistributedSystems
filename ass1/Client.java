import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            if (console.ready()) {
                String msg = console.readLine();
                out.println(msg);
            }

            if (in.ready()) {
                System.out.println("Server: " + in.readLine());
            }
        }
    }
}