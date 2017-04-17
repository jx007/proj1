package lamda;

import java.util.Arrays;

class Stud{
	String name;
	int [] jum;
	int sum, avg;
	public Stud(String name, int kor, int eng, int mat) {
		this.name = name;
		this.jum = new int[]{kor, eng,  mat};
		this.sum = 0;
		
		for(int jj:jum)
		{
			sum+= jj;
		}
		
		this.avg = sum/jum.length;
	}
	@Override
	public String toString() {
		return "Stud [name=" + name + ", jum=" + Arrays.toString(jum) + ", sum=" + sum + ", avg=" + avg + "]";
	}
	
	
}
public class ExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stud [] arr = {
				new Stud("추주헌",77,78,76),
				new Stud("선한비",77,78,76),
				new Stud("임종천",67,68,69),
				new Stud("윤성문",88,89,77),
				new Stud("송정윤",98,97,99)
		};
		
		//Arrays.sort(arr,(o1, o2)->((Stud) o2).avg-((Stud) o1).avg);
		//Arrays.sort(arr,(o1, o2)->o2.avg-o1.avg);
		
		///여러 연산이 있을 경우 {} 로 묶어서 처리
		/// 리턴 값이 있는 경우는 반드시 return 처리해야 한다.
		Arrays.sort(arr,(o1, o2)->{
			int res = o2.avg-o1.avg;
			if(res==0) 
				res = o1.name.compareTo(o2.name);
			return res;		// 리턴 값이 있는 경우는 반드시 return 처리해야 한다.			
		});
		
		for(Stud st: arr)
			System.out.println(st);
	}

}
