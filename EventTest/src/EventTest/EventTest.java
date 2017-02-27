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
		jb1 = new JButton("��ɫ");
		jb2 = new JButton("��ɫ");
		
		this.add(jb1,BorderLayout.NORTH);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		
		//ע�����
		jb1.addActionListener(mp);
		jb2.addActionListener(mp);
		
//		jb1.addActionListener(this);
//		jb2.addActionListener(this);
		//�����this�Ļ�����Ҫ��EventTestʵ��ActionListener�ӿڵ�actionPerformed
		
		Cat cat = new Cat();
		jb1.addActionListener(cat);
		jb2.addActionListener(cat);
		
		//jb1,jb2Ϊ�¼�Դ���󣬼��¼�������(������)
		//mp,catΪ�¼��������󣬼��¼�������
		
		//ָ��action����
		jb1.setActionCommand("��ɫ");
		jb2.setActionCommand("��ɫ");
		
		this.setTitle("�¼�����");
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
		if(e.getActionCommand().equals("��ɫ"))
			System.out.println("è-��ɫ");
		else if(e.getActionCommand().equals("��ɫ"))
			System.out.println("è-��ɫ");
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
		if(e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("��ɫ");
			setBackground(Color.BLUE);
		}
		else if(e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("��ɫ");
			setBackground(Color.RED);
		}
	}
}