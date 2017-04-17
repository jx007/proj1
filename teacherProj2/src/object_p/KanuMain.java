package object_p;
class Kanu{
	final String name;
	int cnt;
	
	
	public Kanu(String name, int cnt) {
		super();
		this.name = name;
		this.cnt = cnt;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		//name="추주헌 똥개";
		return name.equals(((Kanu)obj).name);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new Kanu(name, cnt);
	}
	
	@Override
	public String toString() {
		return "Kanu [name=" + name + ", cnt=" + cnt + "]";
	}
	
	
}
public class KanuMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Kanu [] arr = {
				new Kanu("아메리카노", 1),
				new Kanu("아프리카노", 2),
				new Kanu("아메리카노", 1),
				new Kanu("러시아노", 3),
				new Kanu("아프리카노", 1)
		};
		
		Kanu [] 임종천 = new Kanu[0];
		
		
		for(Kanu kk: arr)
		{
			boolean chk = true;
			
			for(Kanu 버려: 임종천)
			{
				if(kk.equals(버려))
				{
					버려.cnt+=kk.cnt;
					chk=false;
				}
			}
			if(chk)
			{
				Kanu [] 바꿔 = new Kanu[임종천.length+1];
				for (int i = 0; i < 임종천.length; i++) {
					바꿔[i] = 임종천[i];
				}
				바꿔[임종천.length]= (Kanu)kk.clone();
				//바꿔[임종천.length]= kk;
				임종천 = 바꿔;
			}
		}
		
		for(Kanu ret: 임종천)
		{
			System.out.println(ret);
		}
		System.out.println("------------------------");
		
		for(Kanu ret: arr)
		{
			System.out.println(ret);
		}
		//arr[0].name ="추주헌 메롱";
	}

}
