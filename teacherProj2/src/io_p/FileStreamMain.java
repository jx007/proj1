package io_p;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class FileStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileInputStream fis = 
					new FileInputStream("fff/bsy.jpg");
			
			FileOutputStream fos = 
					new FileOutputStream("fff/sss.jpg");
			
			byte [] buf = new byte[1024];
			
			int data;
			
			while(fis.available()>0)
			{
				data = fis.read(buf);
				
				fos.write(buf, 0, data);
				
				System.out.println(Arrays.toString(buf));
			}
			
			fos.close();
			fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
