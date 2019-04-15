import java.net.*;
import java.io.*;

public class UDPServer {

	public static void main(String[] args) { //args: portNumber
		
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket(Integer.parseInt(args[0])); //constructs datagram socket, aSocket, binded with specified port entered in args[0]
			byte[] buffer = new byte[1000]; //Initializes new byte array, buffer, with 1000 bytes
			while (true) { 
				DatagramPacket request = new DatagramPacket(buffer, buffer.length); //constructs datagrampacket for receiving packets 
				aSocket.receive(request); //receives datagram packet from this socket, aSocket
				DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort()); //constructs a packet for sending
				aSocket.send(reply); //sends the datagram packet, reply, from this socket
			}
		} catch (SocketException e) {
			System.out.println("Socket: " +e.getMessage()); //prints the details of an error in creating or accessing a socket
		} catch (IOException e) {
			System.out.print("IO: " +e.getMessage()); //prints the details of an IO Exception that has occurred
		} finally {
			if (aSocket != null)
				aSocket.close(); //closes the datagram socket, aSocket
		}

	}

}
