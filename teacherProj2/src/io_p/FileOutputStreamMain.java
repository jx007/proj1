package io_p;

import java.io.FileOutputStream;

public class FileOutputStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String str = "식곤증이 사라질때가 되었을 텐데\r아직 졸리다니!!!!";
		String str = "ejfowefjeojfoewf";
		
		try {
			FileOutputStream fos = new FileOutputStream("fff/abcd.txt");
			
			//fos.write('A');
			
			for (int i = 0; i < str.length(); i++) {
				fos.write(str.charAt(i));
			}
			
			
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
