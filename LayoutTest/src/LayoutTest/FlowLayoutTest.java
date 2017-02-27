package LayoutTest;

import java.awt.*;
import javax.swing.*;

public class FlowLayoutTest extends JFrame {

	/**
	 * @param args
	 */
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public FlowLayoutTest()
	{
		//FlowLayout
		jb1 = new JButton("����");
		jb2 = new JButton("�ŷ�");
		jb3 = new JButton("����");
		jb4 = new JButton("��");
		jb5 = new JButton("����");
		jb6 = new JButton("κ��");
		
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
//		LEFT 
//		RIGHT 
//		CENTER 
//		LEADING 
//		TRAILING 
		
		this.setTitle("��ʽ���ֲ���");
		this.setVisible(true);
		
		//ʹ����رհ�ť���˳�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		
		//��ֹ�û��ı䴰�ڴ�С
		this.setResizable(false);
		this.setLocation(250, 250);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlowLayoutTest ft = new FlowLayoutTest();
	}

}
