package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPMulServer {

	ExecutorService service;
	ServerSocketChannel server;
	List<SocketChannel > list = new Vector();
	////List에 채널을 사용하는 것이 더 안전함
	
	public TCPMulServer() {
		// TODO Auto-generated constructor stub
		
		service = 
		Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		try {
			server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Runnable rrr = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("서버시작");
				
				while(true)
				{
					try {
						SocketChannel socket = server.accept();
						
						Client client = new Client(socket);
						
						list.add(socket);
						System.out.println(socket.getRemoteAddress()+" 연결:"+list.size());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		service.submit(rrr);
	}
	
	
	class Client{
		SocketChannel socket;
		Charset charset = Charset.forName("UTF-8");
		public Client(SocketChannel socket) {
			this.socket = socket;
			 recieve();
		}
		
		void recieve()
		{
			Runnable rrr = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					while(true)
					{
						try {
							ByteBuffer buf = ByteBuffer.allocate(1024);
							
							int cnt = socket.read(buf);
							
							if(cnt==-1)
								throw new Exception();
							
							buf.flip();
							String msg = charset.decode(buf).toString();
							
							System.out.println(socket.getRemoteAddress()+":"+msg);
							for(SocketChannel cc: list)
							{
								//cc.send(msg);
								ByteBuffer www = charset.encode(msg);
									
		
								cc.write(www);
								
							}
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							
							try {
								
								list.remove(socket);
								System.out.println(socket.getRemoteAddress()+" 연결종료:"+list.size());
								if(socket!=null  && socket.isOpen())
									socket.close();
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								//e1.printStackTrace();
							}
						}
					}
				}
			};
			
			service.submit(rrr);
		}
		
		
		void send(String msg)
		{
			ByteBuffer buf = charset.encode(msg);
			try {
				
				System.out.println(socket.getRemoteAddress()+"->"+msg);
				socket.write(buf);
			} catch (IOException e) {
				
			}
			
		
			/*
			 * 오히려 에러 발생!!!!  하지 말것
			 * 
			 * Runnable rrr = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					ByteBuffer buf = charset.encode(msg);
					try {
						
						System.out.println(socket.getRemoteAddress()+"->"+msg);
						socket.write(buf);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						
						try {
							list.remove(Client.this);
							System.out.println(socket.getRemoteAddress()+" 연결종료:"+list.size());
							socket.close();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}
					}
					
				}
			};
			
			
			service.submit(rrr);*/
			
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPMulServer();
	}

}
