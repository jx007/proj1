package io_p;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteSteamBufMain2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte [] inArr = {4,-128,-127,-3,-2,-1,0,1,2,3,11,56,76,126,127};
		byte [] outArr;
		byte [] buf = new byte[4];
		int cnt=0, len;
		
		ByteArrayInputStream bis = new ByteArrayInputStream(inArr);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		
		
		
		while(bis.available()>0)
		{
			cnt++;
			len=bis.read(buf);
			bos.write(buf,0,len);
			
			System.out.println(Arrays.toString(buf));
		}
		
		outArr = bos.toByteArray();
		System.out.println(cnt);
		System.out.println(Arrays.toString(inArr));
		System.out.println(Arrays.toString(outArr));
	}

}
