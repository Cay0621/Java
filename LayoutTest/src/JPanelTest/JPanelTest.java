package JPanelTest;

import java.awt.BorderLayout;

import javax.swing.*;

public class JPanelTest extends JFrame {

	/**
	 * @param args
	 */
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JPanel jp1,jp2;
	
	public JPanelTest()
	{
		//JPanel:Ĭ������ʽ���ֹ���
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jb1 = new JButton("1");
		jb2 = new JButton("2");
		jb3 = new JButton("3");
		jb4 = new JButton("4");
		jb5 = new JButton("5");
		jb6 = new JButton("6");
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		jp2.add(jb5);
		jp2.add(jb6);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jb4,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);
		
		this.setTitle("JPanel���ֲ���");
		this.setVisible(true);
		
		//ʹ����رհ�ť���˳�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		
		//��ֹ�û��ı䴰�ڴ�С
		//this.setResizable(false);
		this.setLocation(250, 250);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPanelTest jt = new JPanelTest();;
		
	}

}