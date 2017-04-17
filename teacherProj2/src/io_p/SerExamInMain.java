package io_p;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerExamInMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileInputStream fis = 
					new FileInputStream("fff/eee.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			((StudReg)ois.readObject()).print();
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
