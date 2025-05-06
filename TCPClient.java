import java.lang.*;
import java.io.*;
import java.net.*;
public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket skt = new Socket("Localhost",1234);
            BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            System.out.println("Received string: ");
            while (!in.ready()) {}
                System.out.println(in.readLine());
                in.close();
            }
            catch(Exception e) {
                System.out.println("Error: Invalid input or communication failure.");
            }
        }
    }
