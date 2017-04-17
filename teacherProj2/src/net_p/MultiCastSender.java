package net_p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiCastSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			MulticastSocket ms = new MulticastSocket();
			String msg="바나나 부페";
			InetAddress is = InetAddress.getByName("230.0.0.1");
			DatagramPacket ds = new DatagramPacket(
					msg.getBytes(), 
					msg.getBytes().length,
					is,
					7777
					);
			ms.send(ds);
			ms.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
