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
		
		this.setTitle("���񲼾ֲ���");
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
		GridLayoutTest gt = new GridLayoutTest();
	}

}
