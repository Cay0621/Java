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
	
	//开始游戏
	JMenu jm1 = null;
	JMenuItem jmiStart = null;
	JMenuItem jmiSaveExit = null;
	JMenuItem jmiExit = null;
	JMenuItem jmiLast = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankGame tank = new TankGame();
	}

	//构造函数
	public TankGame()
	{
		//定义菜单
		jmb = new JMenuBar();
		jm1 = new JMenu("游戏(&G)");
		jm1.setMnemonic('G');
		jmiStart = new JMenuItem("开始游戏(&N)");
		jmiStart.addActionListener(this);
		jmiStart.setActionCommand("newgame");
		
		jmiLast = new JMenuItem("继续上局(&L)");
		jmiLast.addActionListener(this);
		jmiLast.setActionCommand("lastgame");
		
		jmiExit = new JMenuItem("退出游戏(&E)");
		jmiExit.addActionListener(this);
		jmiExit.setActionCommand("exitgame");
		
		jmiSaveExit = new JMenuItem("存盘退出");
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
		
		this.setTitle("坦克大战");
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
			
			//先删除旧面板
			this.remove(msp);
			this.add(mp);
			
			this.addKeyListener(mp);
			this.setVisible(true);
		}
		else if(e.getActionCommand().equals("exitgame"))
		{
			//保存击毁敌人坦克的总数量
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
			
			//先删除旧面板
			this.remove(msp);
			this.add(mp);
			
			this.addKeyListener(mp);
			this.setVisible(true);
		}
	}
}
