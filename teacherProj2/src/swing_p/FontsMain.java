package swing_p;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FontsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphicsEnvironment ge = 
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		Font [] fs = ge.getAllFonts();
		
		for(Font ff: fs)
		{
			System.out.println(ff.getFontName());
		}
		
		String str = "¼±»ý´ÔÀº ±Í¿©¿ö¿ä Love 1234567890";
		
		JFrame jf = new JFrame();
		
		jf.setBounds(1600, 0, 400, 600);
		
		Font [] arr ={
				new Font("Arial", Font.ITALIC, 20),
				new Font("Serif", Font.ITALIC, 20),
				new Font("Serif", Font.BOLD, 20),
				new Font("Serif", Font.BOLD+Font.ITALIC, 20),
				new Font("Serif", Font.PLAIN, 20),
				new Font("Serif", Font.PLAIN, 30),
				new Font("Serif", Font.PLAIN, 40)
		};
		
		jf.setLayout(new GridLayout(arr.length, 1));
		
		for(Font ff: arr)
		{
			JLabel lb = new JLabel(str);
			lb.setFont(ff);
			jf.add(lb);
		}
		jf.setVisible(true);
	}

}
