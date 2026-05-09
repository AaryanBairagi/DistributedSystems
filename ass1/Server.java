import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        Socket socket = server.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Client connected!");

        while (true) {
            if (in.ready()) {
                System.out.println("Client: " + in.readLine());
            }

            if (console.ready()) {
                String msg = console.readLine();
                out.println(msg);
            }
        }
    }
}