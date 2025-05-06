import java.lang.*;
import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) {
        String data = "Pratik";
        try {
            ServerSocket srvr = new ServerSocket(1234);
            Socket skt = srvr.accept();
            System.out.println("SERVER CONNECTED!");
            PrintWriter out = new PrintWriter(skt.getOutputStream(),true);
            System.out.println("Sending string: " + data+"\n");
            out.println(data);
            out.close();
            skt.close();
            srvr.close();
        }
        catch (Exception e) {
            System.out.println("Error!");
        }
    }
}
