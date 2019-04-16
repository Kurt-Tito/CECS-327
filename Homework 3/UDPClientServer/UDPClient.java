import java.net.*;
import java.io.*;
import java.util.Enumeration;

public class UDPClient {

	public static void main(String[] args) { //args: message, hostAddress, serverPort

		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket(); //constructs a datagram socket and binds it to any available port on the localhost moachine 
			byte[] m = args[0].getBytes(); //encodes string from args[0] into a sequence of bytes to byte array m
			InetAddress aHost = InetAddress.getByName(args[1]); //gets the IP address of a host, entered in args[1]
			int serverPort = Integer.parseInt(args[2]); //gets the server port entered in args[2]
			DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort); //constructs a datagram packet for sending packets
			aSocket.send(request); //sends the datagram packet, request, which includes the data, length, host ip address, and host port number
			byte[] buffer = new byte[1000]; //Initializes new byte array 'buffer' with 1000 bytes
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length); //Constructs datagram packet 'reply' for receiving packets
			aSocket.receive(reply); //receives a datagram packet from this socket
			System.out.println("Reply: " +new String(reply.getData())); //prints the data received from the server
		} catch (SocketException e) {
			System.out.println("Socket: " +e.getMessage()); //prints the details of an error in creating or accessing a socket
		} catch (IOException e) {
			System.out.println("IO: " +e.getMessage()); //prints the details of an IO Exception that has occurred
		} catch (Exception e) {
			e.printStackTrace(); //prints this throwable and its backtrace to the error stream
		} finally {
			if (aSocket != null)
				aSocket.close(); //closes aSoocket
		}
	}

	//Returns Local IPv4 Address as a String
	public static String getLocalIPAdress() throws Exception{
		String hostAddress = "";
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while (interfaces.hasMoreElements()) {
			NetworkInterface networkInterface = interfaces.nextElement();
			if (!networkInterface.isUp())
				continue;
			
			Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
			while(addresses.hasMoreElements()) {
				InetAddress addr = addresses.nextElement();
				if (addr.getHostAddress().toString().length() < 17)
					hostAddress = addr.getHostAddress().toString();
			}
		}

		return hostAddress;
	}

}
