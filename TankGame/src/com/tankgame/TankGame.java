package com.tankgame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TankGame extends JFrame implements ActionListener{

	/**
	 * @param args
	 */
	MyPanel mp = null;
	MyStartPanel msp = null;
	JMenuBar jmb = null;
	
	//��ʼ��Ϸ
	JMenu jm1 = null;
	JMenuItem jmiStart = null;
	JMenuItem jmiSaveExit = null;
	JMenuItem jmiExit = null;
	JMenuItem jmiLast = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankGame tank = new TankGame();
	}

	//���캯��
	public TankGame()
	{
		//����˵�
		jmb = new JMenuBar();
		jm1 = new JMenu("��Ϸ(&G)");
		jm1.setMnemonic('G');
		jmiStart = new JMenuItem("��ʼ��Ϸ(&N)");
		jmiStart.addActionListener(this);
		jmiStart.setActionCommand("newgame");
		
		jmiLast = new JMenuItem("�����Ͼ�(&L)");
		jmiLast.addActionListener(this);
		jmiLast.setActionCommand("lastgame");
		
		jmiExit = new JMenuItem("�˳���Ϸ(&E)");
		jmiExit.addActionListener(this);
		jmiExit.setActionCommand("exitgame");
		
		jmiSaveExit = new JMenuItem("�����˳�");
		jmiSaveExit.addActionListener(this);
		jmiSaveExit.setActionCommand("saveexit");
		
		jm1.add(jmiStart);
		jm1.add(jmiLast);
		jm1.add(jmiSaveExit);
		jm1.add(jmiExit);
		jmb.add(jm1);
		this.setJMenuBar(jmb);
		
		msp = new MyStartPanel();
		this.add(msp);
		
		Thread t = new Thread(msp);
		t.start();
		
		this.setTitle("̹�˴�ս");
		this.setVisible(true);
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("newgame"))
		{
			mp = new MyPanel("newgame");
		
			Thread t = new Thread(mp);
			t.start();
			
			//��ɾ�������
			this.remove(msp);
			this.add(mp);
			
			this.addKeyListener(mp);
			this.setVisible(true);
		}
		else if(e.getActionCommand().equals("exitgame"))
		{
			//������ٵ���̹�˵�������
			Recorder.saveRecorder();
			
			System.exit(0);
		}
		else if(e.getActionCommand().equals("saveexit"))
		{	
			Recorder.setEts(mp.ets);
			Recorder.keepRecorder();
			System.exit(0);
		}
		else if(e.getActionCommand().equals("lastgame"))
		{
			mp = new MyPanel("lastgame");
			
			Thread t = new Thread(mp);
			t.start();
			
			//��ɾ�������
			this.remove(msp);
			this.add(mp);
			
			this.addKeyListener(mp);
			this.setVisible(true);
		}
	}
}
