package thread_p;

import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;

class MulTimer extends Thread
{
	MulExamData md;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 10; i >0; i--) {
			try {
				
				sleep(1000);
				
				if(md.chk) break;
				System.out.println(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		md.chk=true;
		System.out.println("시험 종료");
		md.print();
	}
}

class MulExam extends Thread
{
	
	MulExamData md;
	




	@Override
	public void run() {
		
		Iterator<String> it = md.map.keySet().iterator();
		// TODO Auto-generated method stub
		md.cnt=0;
		while(it.hasNext())
		{
			
			String key = it.next();
			if(md.chk) break;
			String input = JOptionPane.showInputDialog(key);
			if(md.chk) break;
			md.solve(key,input);
			
				
			System.out.println("입력값:"+input);
		}
		md.chk=true;
	}
}
class MulExamData
{
	LinkedHashMap<String, String> map = new LinkedHashMap<>();
	LinkedHashMap< String,String> ok = new LinkedHashMap<>();
	LinkedHashMap< String,String> nono = new LinkedHashMap<>();
	boolean chk = false;
	int cnt;
	void solve(String key,String input)
	{
		if(map.get(key).equals(input))
		{
			ok.put(cnt+". "+key, map.get(key));
		}else{
			nono.put(cnt+". "+key, input+"("+map.get(key)+")");
		}
		cnt++;
	}
	
	void print()
	{
		timeover();
		
		
		System.out.println("정답>>>>");
		printModule(ok);
		System.out.println("오답>>>>");
		printModule(nono);
	}
	void timeover()
	{
		Iterator<String> it = map.keySet().iterator();
		
		for (int i = 0; i <cnt; i++) {
			it.next();
		}
		
		while(it.hasNext())
		{
			String key = it.next();
			nono.put(cnt+". "+key, "시간초과("+map.get(key)+")");
			cnt++;
		}
		
		
	}
	void printModule(LinkedHashMap< String,String> map)
	{
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}

public class ExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MulTimer mm = new MulTimer();
		MulExam me = new MulExam();
		
		MulExamData md = new MulExamData();
		md.map.put("2+3", "5");
		md.map.put("4*5", "20");
		md.map.put("8-5", "3");
		md.map.put("15/3", "5");
		md.map.put("9%4", "1");
		
		mm.md = md;
		me.md = md;
		
		mm.start();
		me.start();
	}

}
