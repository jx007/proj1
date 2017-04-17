package swing_p;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComponentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame jf = new JFrame();
		
		/*jf.setSize(600, 500);
		jf.setLocation(1700, 100);*/
		jf.setBounds(1700, 100, 600, 500);
		jf.setLayout(null);
		
		JButton b1 = new JButton("눌러바");
		b1.setBounds(50,50, 100, 50);
		jf.add(b1);
		
		ImageIcon img = new ImageIcon("fff/bsy.jpg");
		Image ori = img.getImage();
		Image aft = ori.getScaledInstance(100, 200, Image.SCALE_SMOOTH);
		ImageIcon img2 = new ImageIcon(aft);
		JButton b2 = new JButton(img2);
		b2.setBounds(150,50, 100, 100);
		jf.add(b2);
		
		JList job = new JList<>();
		job.setLayout(new GridLayout(7, 1));
		job.setBounds(30, 200, 100, 150);
		job.add(new JButton("의사"));
		job.add(new JButton("판사"));
		job.add(new JButton("안사"));
		job.add(new JButton("주사"));
		job.add(new JButton("독사"));
		job.add(new JButton("살모사"));
		job.setSelectedIndex(3);
		jf.add(job);
		
		Vector arr = new Vector<>();
		arr.add("안락사");
		arr.add("검사");
		arr.add("성기사");
		arr.add("맨사");
		arr.add("장의사");
		
		JList job2 = new JList<>(arr);
		job2.setLayout(new GridLayout(5, 1));
		job2.setBounds(130, 200, 100, 100);
		job2.setSelectedIndex(3);
		jf.add(job2);
		
		JLabel hoLB = new  JLabel("취미:");
		hoLB.setBounds(30, 350, 50,50);
		jf.add(hoLB);
		
		JCheckBox ho1 = new JCheckBox("게임");
		JCheckBox ho2 = new JCheckBox("독설",true);
		JCheckBox ho3 = new JCheckBox("사진",true);
		
		ho1.setBounds(80, 350, 60,50);
		ho2.setBounds(140, 350, 60,50);
		ho3.setBounds(200, 350, 60,50);
		
		jf.add(ho1);
		jf.add(ho2);
		jf.add(ho3);
		
		
		
		
		JLabel genLB = new  JLabel("성별:");
		genLB.setBounds(30, 400, 50,50);
		jf.add(genLB);
		
		JRadioButton gen1 = new JRadioButton("남자");
		JRadioButton gen2 = new JRadioButton("여자",true);
		JRadioButton gen3 = new JRadioButton("it",true);
		
		gen1.setBounds(80, 400, 60,50);
		gen2.setBounds(140, 400, 60,50);
		gen3.setBounds(200, 400, 60,50);
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(gen1);
		bg.add(gen2);
		bg.add(gen3);
		
		jf.add(gen1);
		jf.add(gen2);
		jf.add(gen3);
		
		JLabel idLB = new  JLabel("id:");
		idLB.setBounds(330, 20, 50,50);
		jf.add(idLB);
		
		JTextField id = new JTextField("아이디를 입력");
		id.setBounds(380, 20, 100, 50);
		jf.add(id);
		
		JLabel pwLB = new  JLabel("pw:");
		pwLB.setBounds(330, 70, 50,50);
		jf.add(pwLB);
		
		JPasswordField pw = new JPasswordField();
		pw.setBounds(380, 70, 100, 50);
		jf.add(pw);
		
		
		JLabel emailLB = new  JLabel("email:");
		emailLB.setBounds(330, 120, 50,50);
		jf.add(emailLB);
		
		String [] emailArr = {
				"나베르","구그레","다움","나테"
		};
		JComboBox email = new JComboBox<>(emailArr);
		email.setBounds(380, 120, 100,50);
		jf.add(email);
		
		
		JLabel conLB = new  JLabel("con:");
		conLB.setBounds(330, 170, 50,50);
		jf.add(conLB);
		
		JTextArea con = new JTextArea("아이디를 입력");
		con.setBounds(380, 170, 100, 50);
		jf.add(con);
		
		
		JLabel frLB = new  JLabel("fr:");
		frLB.setBounds(330, 220, 50,50);
		jf.add(frLB);
		
		String [][] rowData={
				{"김경호","1111-1111","35"},
				{"윤지섭","2222-2222","30"},
				};
		String []columnNames={"이름","전화","나이"};
		
		JTable fr = new JTable(rowData, columnNames);
		//fr.setBounds(380, 230, 170, 200);
		//jf.add(fr);
		
		JPanel jp = new JPanel();
		jp.setBounds(380, 230, 170, 200);
		jp.setLayout(new BorderLayout());
		jp.add(new JScrollPane(fr));
		
		jf.add(jp);
		
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
