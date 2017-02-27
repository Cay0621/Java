package LayoutTest;

import java.awt.*;
import javax.swing.*;

public class BorderLayoutTest extends JFrame {

	/**
	 * @param args
	 */
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public BorderLayoutTest()
	{
		//BorderLayout
		jb1 = new JButton("中部");
		jb2 = new JButton("北部");
		jb3 = new JButton("东部");
		jb4 = new JButton("南部");
		jb5 = new JButton("西部");
		
		this.add(jb1,BorderLayout.CENTER);
		this.add(jb2,BorderLayout.NORTH);
		this.add(jb3,BorderLayout.EAST);
		this.add(jb4,BorderLayout.SOUTH);
		this.add(jb5,BorderLayout.WEST);
		
		this.setTitle("边界布局测试");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setLocation(250, 250);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BorderLayoutTest bt = new BorderLayoutTest();
	}

}
