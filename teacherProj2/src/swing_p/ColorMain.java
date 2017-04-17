package swing_p;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorMain extends JFrame{

	public ColorMain() {
		// TODO Auto-generated constructor stub
		setBounds(1600, 0, 600, 600);
		setLayout(null);
		
		String str = "∂À¿Ô¿Ã";
		
		Color [] bc = {
				Color.PINK, 
				new Color(255, 0, 0),
				new Color(255,255,0,20),
		};
		Color [] fc = {
				new Color(0,255,200),
				Color.GREEN,
				new Color(0,0,255),
		};
		
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 600, 600);
		p1.setLayout(new GridLayout(bc.length, 1));
		p1.setBackground(new Color(255,0,0,50));
		for (int i = 0; i < fc.length; i++) {
			JButton btn = new JButton(str);
			btn.setBackground(bc[i]);
			btn.setForeground(fc[i]);
			p1.add(btn);
		}

		
		
		ImageIcon icon = new ImageIcon("fff/bsy.jpg");
		JButton p2 = new JButton(icon);
		p2.setBounds(0, 0, 600, 600);
		add(p1);
		add(p2);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ColorMain();
		
	}

}
