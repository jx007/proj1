package collection_p;

import java.util.Stack;

class Url{
	String now=null;
	
	Stack back = new Stack();
	Stack next = new Stack();
	
	void goUrl(String url)
	{
		System.out.println("--------goUrl("+url+")");
		
		next.clear();
		
		if(now!=null)
			back.push(now);
		
		now =url;
		
		print();
	}
	
	void goBack()
	{
		System.out.println("--------goBack()");
		
		if(!back.isEmpty())
		{
			next.push(now);
			
			now = (String)back.pop();
			print();
		}
		else{
			System.out.println("뒤가 없어요");
		}
		
		
	}
	
	void goNext()
	{
		System.out.println("--------goNext()");
		
		if(!next.isEmpty())
		{
			back.push(now);
			
			now = (String)next.pop();
			print();
		}
		else{
			System.out.println("앞이 없어요");
		}	
	}
	
	void print()
	{
		System.out.println("현재:"+now);
		System.out.println("뒤로:"+back);
		System.out.println("앞으로:"+next);
	}
}
public class UrlMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Url uu = new Url();
		uu.goUrl("나베르");
		uu.goUrl("구그레");
		uu.goUrl("나테");
		uu.goUrl("다움");
		
		uu.goBack();
		uu.goBack();
		uu.goBack();
		uu.goBack();
		uu.goBack();
		
		uu.goNext();
		uu.goUrl("야후");
	}

}
