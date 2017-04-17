package collection_p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class TTStud 
{
	String name, res;
	LinkedHashMap<String, Integer> jum = new LinkedHashMap();
	LinkedHashMap<String,String> kind = new LinkedHashMap();
	int sum, avg, rank, num;
	
	TTStud(String ban, int num,String name, int kor,int eng, int mat, int lol)
	{
		this(ban, num, name, kor, eng, mat);
		jum.put("롤",lol);
		kind.put("성", "남자");
		
		cal();
	}
	
	TTStud(String ban,int num, String name, int kor,int eng, int mat)
	{
		this.num = num;
		this.name = name;
		jum.put("국어",kor);
		jum.put("영어",eng);
		jum.put("수학",mat);
		kind.put("반", ban);
		kind.put("성", "여자");
		kind.put("전체", "전체");
		
		cal();
	}
	
	void cal()
	{
		sum =0;
		
		Collection<Integer> vv = jum.values();
		
		for (Integer oo : vv) {
			sum += oo;
		}
		
		avg = sum/jum.size();
		
		res = "불합격";
		if(avg>=70) res="합격";
	}

	@Override
	public String toString() {
		return  kind.get("반") + "\t" + name + "\t" + num + "\t" + kind.get("성") + "\t" + jum
				+ "\t" + sum + "\t" + avg + "\t" + rank;
	}
	
	
}

class TTStCom implements Comparator{
	Object kind;

	public TTStCom(Object kind) {
		super();
		this.kind = kind;
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		HashMap str = new HashMap<>();
		str.put("반", "개나리, 소나리, 닭나리, 말마리");
		str.put("성", "남자, 여자");
		str.put("전체", "전체");
		
		int res=1;
		
		if(kind instanceof String)
		{
	
			res = ((String)str.get(kind)).indexOf(((String)o1))-
			((String)str.get(kind)).indexOf(((String)o2));
	
		}else{
			TTStud me = (TTStud)o1;
			TTStud you = (TTStud)o2;
			
			res = you.avg-me.avg;
			if(res==0) res = me.num - you.num;
		}
		
		return res;
	}
}

public class TreeMapExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TTStud> input = new ArrayList();
		
		input.add(new TTStud("소나리",2,"윤지섭",88,89,87,74 ));
		input.add(new TTStud("개나리",3,"김경호",78,87,65,54 ));
		input.add(new TTStud("소나리",1,"주민제", 43,32,21 ));
		input.add(new TTStud("말마리",2,"선한비",34,56,78 ));
		input.add(new TTStud("개나리",2,"송정윤", 89,90,98));
		input.add(new TTStud("말마리",2,"정수홍", 87,76,65,54));
		input.add(new TTStud("개나리",5,"박현진",89,90,98));
		input.add(new TTStud("소나리",2,"정연욱", 12,23,34,45));
		
		Scanner sc = new Scanner(System.in);
		
		String [] kind = {"전체","반","성","성,반"};
		
		for (int i = 0; i < kind.length; i++) {
			System.out.print(i+","+kind[i]+" ");
		}
		System.out.print("\n입력:");
		
		int no = sc.nextInt(); 
		
		String [] arr = kind[no].split(",");

		TreeMap total = new TreeMap(new TTStCom(arr[0]));
		
		for(TTStud ts : input)
		{
			TreeMap nowMap = total;
			//TTStud ts = (TTStud)oo;

			for (int i = 0; i < arr.length-1; i++) {
				if(nowMap.containsKey(ts.kind.get(arr[i])))
					nowMap = (TreeMap)nowMap.get(ts.kind.get(arr[i]));
				else{
					TreeMap bufMap = new TreeMap(new TTStCom(arr[i+1]));
					nowMap.put(ts.kind.get(arr[i]),bufMap);
					
					nowMap = bufMap;
				}
			}

			TreeSet<TTStud> nowSS;
			
			if(nowMap.containsKey(ts.kind.get(arr[arr.length-1])))
				nowSS = (TreeSet)nowMap.get(ts.kind.get(arr[arr.length-1]));
			else{
				nowSS = new TreeSet(new TTStCom(0));
				nowMap.put(ts.kind.get(arr[arr.length-1]),nowSS);
			}
			
			nowSS.add(ts);
		}
		
		mapPrint(total);
	
	}
	
	static void mapPrint(TreeMap map)
	{
		Iterator it = map.keySet().iterator();

		while(it.hasNext())
		{
			TTStud sum = new TTStud("",999,"합계", 0,0,0,0);
			Object key = it.next();
			
			System.out.println(key+">>>>>>");
			
			Object obj = map.get(key);
			if(obj instanceof TreeMap)
				mapPrint((TreeMap)obj);
			else{
				Iterator<TTStud> sit = ((TreeSet)map.get(key)).iterator();
				
				while(sit.hasNext())
				{
					TTStud now = sit.next();
					
					Iterator<String> jit = now.jum.keySet().iterator();
					while(jit.hasNext())
					{
						String jkey = jit.next();
						int jjj = sum.jum.get(jkey)+now.jum.get(jkey);
						sum.jum.put(jkey, jjj);
					}
					
					System.out.println(now);
				}
				System.out.println(sum);
			}			
		}
	}
	

}
