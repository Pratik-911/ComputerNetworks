import java.io.*;
import java.net.*;

class FactClient {
    public static void main(String args[]) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        byte[] sendData;
        byte[] receiveData = new byte[1024];

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Enter a number to calculate its factorial: ");
            String input = inFromUser.readLine();

            try {
                sendData = input.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
                clientSocket.send(sendPacket);

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("FROM SERVER: Factorial is " + result);
            } catch (Exception e) {
                System.out.println("Error!!!");
            }
        }
    }
}
