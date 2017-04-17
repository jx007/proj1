package collection_p;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class PlayerCom implements Comparator{
	
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		String str ="out,1,2,3,h";

		return str.indexOf(((String)o1))-
				str.indexOf(((String)o2));
	}
}

public class HashBaseBall {

	//out, 1,2,3,h
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr={"23-1","5-1","7-2","23-out","11-1",
				"23-h","6-1","2-2","23-1","7-3","2-2",
				"23-out"};
		
		//LinkedHashMap player = new LinkedHashMap();
		TreeMap player = new TreeMap();
		
		for(String str: arr)
		{
			//String pp = str.substring(0,str.indexOf("-"));
			
			int pp = 
			Integer.parseInt(str.substring(0,str.indexOf("-")));
			String hit = str.substring(str.indexOf("-")+1);
			
			//HashMap nowPP;
			TreeMap nowPP;
			
			if(player.containsKey(pp))
				nowPP = (TreeMap)player.get(pp);
			else
				nowPP = new TreeMap(new PlayerCom());
			
			player.put(pp, nowPP);
			
			int a = 1;	// 안타횟수 
			if (nowPP.containsKey(hit))	// key 값을 물어본다.
				a += (int) nowPP.get(hit);	//Object value = map.get(key); key 를 보고 value 값을 가지고 온다.

			nowPP.put(hit, a);
			
		}
		Iterator it = player.keySet().iterator();
		
		while(it.hasNext())
		{
			Object key = it.next();
			System.out.println(key+">>>");
			
			TreeMap ppp = (TreeMap)player.get(key);
			
			Iterator pit = ppp.keySet().iterator();
			
			while(pit.hasNext())
			{
				Object kkey = pit.next();
				System.out.println("\t"+kkey+":"+ppp.get(kkey));
			}	
			
		}	
		
		
	}
	

}
