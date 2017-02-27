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
		jb1 = new JButton("关羽");
		jb2 = new JButton("张飞");
		jb3 = new JButton("赵云");
		jb4 = new JButton("马超");
		jb5 = new JButton("黄忠");
		jb6 = new JButton("魏延");
		
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
		
		this.setTitle("流式布局测试");
		this.setVisible(true);
		
		//使点击关闭按钮后退出窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		
		//禁止用户改变窗口大小
		this.setResizable(false);
		this.setLocation(250, 250);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlowLayoutTest ft = new FlowLayoutTest();
	}

}
