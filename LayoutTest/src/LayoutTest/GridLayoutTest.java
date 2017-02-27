package LayoutTest;

import java.awt.*;

import javax.swing.*;

public class GridLayoutTest extends JFrame {

	/**
	 * @param args
	 */
	JButton jbs[] = null;
	int size = 9;
	
	public GridLayoutTest()
	{
		jbs = new JButton[size];
		
		for(int i = 0;i < size;++i)
			jbs[i] = new JButton(String.valueOf(i));
		
		this.setLayout(new GridLayout(3,3));
		
		for(int i = 0;i < size;++i)
		{
			this.add(jbs[i]);
		}
		
		this.setTitle("网格布局测试");
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
		GridLayoutTest gt = new GridLayoutTest();
	}

}
