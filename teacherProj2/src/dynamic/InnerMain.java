package dynamic;

class Anony{
	int qq = 5555;
	
	void mm()
	{
		System.out.println("Anony mm()");
	}
}

class Outer
{
	int k =9999;
	int x =10;
	
	static int z = 30;
	
	class Inner
	{
		int y = 200;
		
		int xx = x;
	}
	
	static class StInner
	{
		int y = 200;
		
		//int xx = x;
		int zz = z;
	}
	
	void meth()
	{
		class LocalInner{
			
			int xx = x;
			int d = 1234;
		}
		
		LocalInner li = new LocalInner();
		
		System.out.println(li.d);
	}
	
	void meth_2()
	{
		
		
		Anony an = new Anony(){
			@Override
			void mm() {
				// TODO Auto-generated method stub
				System.out.println("익명 재정의 mm()");
				
				qq = 8888;
			}
		};
		
		an.mm();
		
		System.out.println(an.qq);
	}
}
public class InnerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer oo = new Outer();
		Outer.Inner ii = oo.new Inner();
		//oo.meth().LocalInner li;
		
		//System.out.println(ii.k);
		
		//Outer.StInner is = oo.new StInner();
		Outer.StInner is = new Outer.StInner();
		
		oo.meth_2();
	}

}
