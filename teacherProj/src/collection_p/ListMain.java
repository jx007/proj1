package collection_p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class ListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List vv = new Vector();
		vv = new ArrayList();
		
		vv.add(1);
		vv.add("추주헌");
		vv.add(new int[]{33,44,55});
		vv.add(new Vector());
		vv.add(new Random());
		
		System.out.println(vv);
		
		for (int i = 0; i <vv.size(); i++) {
			System.out.println(vv.get(i));
		}
		
		vv.add(2, "윤성문");
		System.out.println(vv);
		vv.set(3, "조대화");
		vv.set(5, "추주헌");
		System.out.println(vv);
		
		vv.remove(4);
		System.out.println(vv);
		
		List ss = new ArrayList(vv.subList(1, 3));
		ss.add("송정윤");
		System.out.println(ss);
		
		System.out.println(vv.contains("정수홍"));
		System.out.println(vv.indexOf("추주헌"));
		System.out.println(vv);
		//vv.retainAll(ss);
		//vv.removeAll(ss);
		
		vv.remove(0);
		System.out.println(vv);
		
		Collections.sort(vv);
		
		System.out.println(vv);
		
		List t1 = new ArrayList();
		List t2 = new ArrayList();
		List fa = new ArrayList();
		
		t1.add("박재상");
		t1.add("박정권");
		t1.add("최정");
		t1.add("김광현");
		t1.add("엄정욱");
		t1.add("박희수");
		t1.add("이호준");
		t2.add("이호준");
		t2.add("엄정욱");
		t2.add("박재홍");
		t2.add("이신협");
		t2.add("장동건");
		fa.add("이병규");
		fa.add("이승엽");
		fa.add("박정권");
		fa.add("장동건");
		fa.add("박용택");
		fa.add("홍성흔");
		
		System.out.println("t1:"+t1);
		System.out.println("t2:"+t2);
		System.out.println("fa:"+fa);
		
		List 임종천 = new Vector(fa);
		fa.removeAll(t1);
		fa.removeAll(t2);
		
		t1.removeAll(t2);
		t1.removeAll(임종천);
		t2.removeAll(임종천);
		
		
		System.out.println("t1:"+t1);
		System.out.println("t2:"+t2);
		System.out.println("fa:"+fa);

	}

}
