package EventTest;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest extends JFrame /*implements ActionListener*/{

	/**
	 * @param args
	 */
	MyPanel mp = null;
	JButton jb1 = null,jb2 = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventTest et = new EventTest();
	}
	
	public EventTest()
	{
		mp = new MyPanel();
		mp.setBackground(Color.BLACK);
		jb1 = new JButton("蓝色");
		jb2 = new JButton("红色");
		
		this.add(jb1,BorderLayout.NORTH);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		
		//注册监听
		jb1.addActionListener(mp);
		jb2.addActionListener(mp);
		
//		jb1.addActionListener(this);
//		jb2.addActionListener(this);
		//如果用this的话，需要将EventTest实现ActionListener接口的actionPerformed
		
		Cat cat = new Cat();
		jb1.addActionListener(cat);
		jb2.addActionListener(cat);
		
		//jb1,jb2为事件源对象，即事件产生者(触发者)
		//mp,cat为事件监听对象，即事件接收者
		
		//指定action命令
		jb1.setActionCommand("蓝色");
		jb2.setActionCommand("红色");
		
		this.setTitle("事件测试");
		this.setLocation(250, 250);
		this.setVisible(true);
		this.setSize(200,150);
	}
}

class Cat implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("黑色"))
			System.out.println("猫-黑色");
		else if(e.getActionCommand().equals("红色"))
			System.out.println("猫-红色");
	}
	
}

class MyPanel extends JPanel implements ActionListener
{

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("蓝色"))
		{
			System.out.println("蓝色");
			setBackground(Color.BLUE);
		}
		else if(e.getActionCommand().equals("红色"))
		{
			System.out.println("红色");
			setBackground(Color.RED);
		}
	}
}