package net_p;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import net.ChatForm;

class TCPMulCliSender extends Thread implements ActionListener{
	DataOutputStream dos;
	String name;
	ChatForm win;
	public TCPMulCliSender(Socket socket,ChatForm win) {
		// TODO Auto-generated constructor stub
		
		try {
			this.win = win;
			dos = new DataOutputStream(socket.getOutputStream());
			name = "["+socket.getLocalAddress()+"] ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			dos.writeUTF(name);
			
			win.tf.addActionListener(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            String msg =win.tf.getText();
            dos.writeUTF(name+msg);
            win.tf.setText("");
            
            win.tf.setFocusable(true);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

class TCPMulCliReceiver extends Thread
{
	DataInputStream dis;
	ChatForm win;
	public TCPMulCliReceiver(Socket socket,ChatForm win) {
		// TODO Auto-generated constructor stub
		
		try {
			this.win = win;
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(dis!=null)
		{
			try {
				win.ta.append("\n"+dis.readUTF());
                win.ta.setCaretPosition(win.ta.getDocument().getLength());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class TCPMulClient {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("192.168.0.29",7777);
			ChatForm win = new ChatForm("클라이언트");
            //System.out.println("서버연결 성공");
            win.ta.setText("서버연결 성공");
            if(socket!=null)
            {
                win.tf.setEnabled(true);
            }
			
			
			new TCPMulCliSender(socket, win).start();
			new TCPMulCliReceiver(socket,win).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
