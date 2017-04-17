package thread_p;
class SRSTh extends Thread
{

	public SRSTh(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.currentThread().isInterrupted()) {	//인터럽트가 요청되지 않으면 실행
			try {
				sleep(1000);
				
				System.out.println(getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("인터럽트 요청:"+e.getMessage());
			}
		}
	}
}
public class SRSMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		SRSTh t1 = new SRSTh("*");
		SRSTh t2 = new SRSTh("**");
		SRSTh t3 = new SRSTh("***");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println(Thread.activeCount());
		Thread.sleep(2000);
		t1.suspend();
		Thread.sleep(2000);
		t2.suspend();
		
		Thread.sleep(2000);
		System.out.println(Thread.activeCount());
		t1.resume();
		Thread.sleep(3000);
		t1.interrupt();		//인터럽트 요청
		t2.stop();
		Thread.sleep(3000);
		System.out.println(Thread.activeCount());
		t3.stop();
		
		t1 = new SRSTh("뉴*");
		t1.start();
	}

}
