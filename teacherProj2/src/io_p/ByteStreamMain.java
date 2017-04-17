package io_p;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte [] inArr = {4,-128,-127,-3,-2,-1,0,1,2,3,11,56,76,126,127};
		byte [] outArr;
		for(byte bb : inArr)
		{
			System.out.println(bb+":"+(int)bb);
		}
		
		System.out.println("-------------------------");
		
		ByteArrayInputStream bis = new ByteArrayInputStream(inArr);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int data;
		int cnt =0;
		while((data = bis.read())!=-1)
		{
			cnt++;
			System.out.println(data+":"+(byte)data);
			bos.write(data);
			
		}
		System.out.println(cnt);
		outArr = bos.toByteArray();
		try {
			bis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(inArr));
		System.out.println(Arrays.toString(outArr));
		
		
		
		/*System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());
		System.out.println(bis.read());*/
	}

}
