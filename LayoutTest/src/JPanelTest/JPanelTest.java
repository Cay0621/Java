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
		//JPanel:默认以流式布局管理
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
		
		this.setTitle("JPanel布局测试");
		this.setVisible(true);
		
		//使点击关闭按钮后退出窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		
		//禁止用户改变窗口大小
		//this.setResizable(false);
		this.setLocation(250, 250);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPanelTest jt = new JPanelTest();;
		
	}

}