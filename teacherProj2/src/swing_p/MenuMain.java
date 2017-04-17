package swing_p;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MenuMain extends JFrame{
	
	public MenuMain() {
		// TODO Auto-generated constructor stub
		setBounds(1600, 100, 300, 200);
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		JMenu main1= new JMenu("파일");
		JMenu main2= new JMenu("편집");
		JMenu main3= new JMenu("보기");
		
		mb.add(main1);
		mb.add(main2);
		mb.add(main3);
		
		JMenuItem item1_1 = new JMenuItem("새로 만들기");
		
		
		ImageIcon icon = new ImageIcon("fff/btn.png");
		JMenuItem item1_2 = new JMenuItem("개로 만들기",icon);
		item1_2.setText("열기");
		JMenuItem item1_3 = new JMenuItem("소로 만들기");
		item1_3.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_MASK)
				);
		
		JMenuItem item1_4 = new JMenuItem("닭쳐");
		
		main1.add(item1_1);
		main1.add(item1_2);
		main1.add(item1_3);
		main1.addSeparator();
		main1.add(item1_4);
		
		JMenu item2_1 = new JMenu("편집용지");
		JMenu item2_2 = new JMenu("머리글");
		item2_2.setEnabled(false);
		main2.add(item2_1);
		main2.add(item2_2);
		
		JMenuItem item2_1_1 = new JMenuItem("A4");
		JMenuItem item2_1_2 = new JMenuItem("B4");
		JMenuItem item2_1_3 = new JMenuItem("C4");
		item2_1_2.setSelected(true);
		item2_1.add(item2_1_1);
		item2_1.add(item2_1_2);
		item2_1.add(item2_1_3);
		
		JCheckBoxMenuItem item3_1 = new JCheckBoxMenuItem("안내선");
		JCheckBoxMenuItem item3_2 = new JCheckBoxMenuItem("격자", true);
		
		main3.add(item3_1);
		main3.add(item3_2);
		
		JRadioButtonMenuItem item3_3 = new JRadioButtonMenuItem("프레젠테이션");
		JRadioButtonMenuItem item3_4 = new JRadioButtonMenuItem("개요", true);
		JRadioButtonMenuItem item3_5 = new JRadioButtonMenuItem("출력");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(item3_3);
		bg.add(item3_4);
		bg.add(item3_5);
		
		main3.add(item3_3);
		main3.add(item3_4);
		main3.add(item3_5);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuMain();
	}

}

