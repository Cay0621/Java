package com.tankgame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import javax.imageio.*;
import java.io.*;

import javax.swing.*;

public class MyPanel extends JPanel implements KeyListener , Runnable{

	//�����Լ���̹��
	Hero heroTank = null;
	//�������̹��
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	Vector<TankNode> tns = new Vector<TankNode>();
	
	//ը������
	Vector<Bomb> bombs = new Vector<Bomb>();
	
	int enSize = Constant.ENEMYCOUNT;
	boolean isGamePause = false;
	
	Image img1 = null;
	Image img2 = null;
	Image img3 = null;
	
	public MyPanel(String flag) {
		//�ָ���¼
		Recorder.readRecorder();
		
		heroTank = new Hero(200, 200);
		
		if(flag.equals("newGame"))
		{
			//��ʼ������̹��
			for(int i = 0;i < enSize;++i)
			{
				EnemyTank et = new EnemyTank((i + 1) * 50, 0);
				et.setColor(0);//0�������̹����ɫ��1�����Լ�̹����ɫ
				et.setDirect(2);
				
				//��MyPanel�ĵ���̹�����������õ���̹��
				et.setEts(ets);	
				
				Thread t = new Thread(et);
				t.start();
				
				Bullet bu = new Bullet(et.x + 10, et.y + 30, 2);
				//�������̹���ӵ�����
				et.bullets.add(bu);
				
				Thread t2 = new Thread(bu);
				t2.start();
				ets.add(et);
			}
		}
		else
		{
			tns = Recorder.getRecorder();
			//��ʼ������̹��
			for(int i = 0;i < tns.size();++i)
			{
				TankNode tn = tns.get(i);
				EnemyTank et = new EnemyTank(tn.x, tn.y);
				et.setColor(0);//0�������̹����ɫ��1�����Լ�̹����ɫ
				et.setDirect(tn.direct);
				
				//��MyPanel�ĵ���̹�����������õ���̹��
				et.setEts(ets);	
				
				Thread t = new Thread(et);
				t.start();
				
				Bullet bu = new Bullet(et.x + 10, et.y + 30, 2);
				//�������̹���ӵ�����
				et.bullets.add(bu);
				
				Thread t2 = new Thread(bu);
				t2.start();
				ets.add(et);
			}
		}
		
//		img1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src\\images\\bomb1.jpg"));
//		img2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src\\images\\bomb2.jpg"));
//		img3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src\\images\\bomb3.jpg"));
		
		try {
			img1 = ImageIO.read(new File("src\\images\\bomb1.jpg"));
			img2 = ImageIO.read(new File("src\\images\\bomb2.jpg"));
			img3 = ImageIO.read(new File("src\\images\\bomb3.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void showInfo(Graphics g)
	{
		//��������̹�˺�Ӣ��̹�˵�ʣ������
		this.DrawTank(g, 50, 320, 0, 0);//����
		this.DrawTank(g, 250, 320, 0, 1);//�Լ�
		g.setColor(Color.BLACK);
		
		Font f = new Font("����", Font.BOLD, 20);
		g.setFont(f);
		g.drawString(":" + String.valueOf(Recorder.getEnNum()), 75, 340);
		g.drawString(":" + String.valueOf(Recorder.getLife()), 275, 340);
		
		//������ҵ��ܳɼ�
		g.drawString("�����ܳɼ���", 400, 50);
		this.DrawTank(g, 420, 60, 0, 0);
		g.setColor(Color.BLACK);
		g.drawString(":" + Recorder.getAllDeadEnemy(), 450, 80);
	}


	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		//������ʾ̹�˵���Ϣ
		showInfo(g);
		
		//��̹��Hero
		if(heroTank.isAlive)
			this.DrawTank(g, heroTank.getX(), heroTank.getY(), heroTank.getDirect(), 1);//�Լ�
		
		//�����ӵ�
		for(int i = 0;i < heroTank.bullets.size();++i)
		{
			Bullet b = heroTank.bullets.get(i);
			//��һ���ӵ�
			if(b != null && b.isAlive)
			{
				g.draw3DRect(b.x, b.y, 1, 1, false);
			}
			
			if(b.isAlive == false)
				heroTank.bullets.remove(b);
			
		}
		
		//��������̹��
		for(int i = 0;i < ets.size();++i)
		{
			EnemyTank et = ets.get(i);
			if(et.isAlive)
			{
				this.DrawTank(g, et.getX(), et.getY(), et.getDirect(), 0);//����
				for(int j = 0;j < et.bullets.size();++j)
				{
					Bullet bu = et.bullets.get(j);
					if(bu.isAlive)
					{
						g.draw3DRect(bu.x, bu.y, 1, 1, false);
					}
					else 
					{
						//�������̹���������ʹ�������ȥ��
						et.bullets.remove(bu);
					}
				}
			}
		}
		
		//����ը��
		for(int i = 0;i < bombs.size();++i)
		{
			//ȡ��ը��
			Bomb b = bombs.get(i);
			if(b.life > 6)
			{
				g.drawImage(img1, b.x, b.y, 30, 30, this);
			}
			else if(b.life > 3)
			{
				g.drawImage(img2, b.x, b.y, 30, 30, this);
			}
			else
			{
				g.drawImage(img3, b.x, b.y, 30, 30, this);
			}
			//��ը����life��С
			b.lifeDown();
			//���ը������ֵΪ0���Ͱ�ը�����������Ƴ�
			if(b.life == 0)
			{
				bombs.remove(b);
			}
		}
	}
	
	public void hitHeroTank()
	{
		//ȡ��ÿһ�����˵�̹��
		for(int i = 0;i < ets.size();++i)
		{
			//ȡ��̹��
			EnemyTank et = ets.get(i);
			
			//ȡ���ӵ�
			for(int j = 0;j < et.bullets.size();++j)
			{
				Bullet b = et.bullets.get(j);
				if(heroTank.isAlive)
					this.hitTank(b,heroTank);
			}
		}
	}
	
	//�ж�hero���ӵ��Ƿ���е���̹��
	public void hitEnemyTank()
	{
		for(int i = 0;i < heroTank.bullets.size();++i)
		{
			//ȡ���ӵ�
			Bullet b = heroTank.bullets.get(i);
			
			if(b.isAlive)
			{
				//ȡ������̹��
				for(int j = 0;j < ets.size();++j)
				{
					//ȡ��̹��
					EnemyTank et = ets.get(j);
					if(et.isAlive)
					{
						hitTank(b, et);
					}
				}
			}
		}
	}
	
	
	//�ж��ӵ��Ƿ����̹��,���б�ըЧ��
	public void hitTank(Bullet b, Tank et)
	{
		//�ж�̹�˷���
		switch(et.direct)
		{
		case 0:
		case 2:
			if(b.x >= et.x && b.x <= et.x + 20 && b.y >= et.y && b.y <= et.y + 30)
			{
				//����
				b.isAlive = false;//�ӵ���ʧ
				et.isAlive = false;//̹����ʧ
				if(et instanceof EnemyTank)
					Recorder.reduceEnemyCount();
				else if(et instanceof Hero)
					Recorder.reduceLift();
				
				//����ը��,����vb��
				Bomb bomb = new Bomb(et.x, et.y);
				bombs.add(bomb);
			}
			break;
			
		case 1:
		case 3:
			if(b.x >= et.x && b.x <= et.x + 30 && b.y >= et.y && b.y <= et.y + 20)
			{
				//����
				b.isAlive = false;//�ӵ���ʧ
				et.isAlive = false;//̹����ʧ
				if(et instanceof EnemyTank)
					Recorder.reduceEnemyCount();
				else if(et instanceof Hero)
					Recorder.reduceLift();
				
				//����ը��,����vb��
				Bomb bomb = new Bomb(et.x, et.y);
				bombs.add(bomb);
			}
			break;
		}
	}
	

	public void DrawTank(Graphics g, int x, int y, int dir, int type)
	{
		//����̹�˻����Լ�̹��
		switch(type)
		{
		case 0://����
			g.setColor(Color.CYAN);
			break;
			
		case 1://�Լ�
			g.setColor(Color.YELLOW);
			break;
		}
		
		//����
		switch(dir)
		{
		case 0://����
			//�����
			g.fill3DRect(x, y, 5, 30, false);
			//�Ҿ���
			g.fill3DRect(x + 15, y, 5, 30, false);
			//�м����
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			//�м�Բ��
			g.fillOval(x + 5, y + 10, 10, 10);
			//��Ͳ
			g.drawLine(x + 10, y + 15, x + 10, y);
			break;
			
		case 1://����
			//�Ͼ���
			g.fill3DRect(x, y, 30, 5, false);
			//�¾���
			g.fill3DRect(x, y + 15, 30, 5, false);
			//�м����
			g.fill3DRect(x + 5, y + 5, 20, 10, false);
			//�м�Բ��
			g.fillOval(x + 10, y + 5, 10, 10);
			//��Ͳ
			g.drawLine(x + 15, y + 10, x + 30, y + 10);
			break;
			
		case 2://����
			//�����
			g.fill3DRect(x, y, 5, 30, false);
			//�Ҿ���
			g.fill3DRect(x + 15, y, 5, 30, false);
			//�м����
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			//�м�Բ��
			g.fillOval(x + 5, y + 10, 10, 10);
			//��Ͳ
			g.drawLine(x + 10, y + 15, x + 10, y + 30);
			break;
			
		case 3://����
			//�Ͼ���
			g.fill3DRect(x, y, 30, 5, false);
			//�¾���
			g.fill3DRect(x, y + 15, 30, 5, false);
			//�м����
			g.fill3DRect(x + 5, y + 5, 20, 10, false);
			//�м�Բ��
			g.fillOval(x + 10, y + 5, 10, 10);
			//��Ͳ
			g.drawLine(x + 15, y + 10, x, y + 10);
			break;
		}
	}
	
	
	public void GameStatus(boolean status)
	{
		//Ӣ��̹����ͣ/����
		heroTank.setStatus(status);
		for(int i = 0;i < heroTank.bullets.size();++i)
		{
			Bullet b = heroTank.bullets.get(i);
			b.setStatus(status);
		}
		
		//����̹����ͣ/����
		for(int i = 0;i < ets.size();++i)
		{
			EnemyTank et = ets.get(i);
			et.setStatus(status);
			
			for(int j = 0;j < et.bullets.size();++j)
			{
				Bullet b = et.bullets.get(j);
				b.setStatus(status);
			}
		}
		
		//�ӵ���ͣ/����
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(!isGamePause)
		{
			if(e.getKeyCode() == KeyEvent.VK_W)
			{
				
				this.heroTank.setDirect(0);
				this.heroTank.moveUp();
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_D)
			{
				this.heroTank.setDirect(1);
				this.heroTank.moveRight();
			}
			else if(e.getKeyCode() == KeyEvent.VK_S)
			{
				
				this.heroTank.setDirect(2);
				this.heroTank.moveDown();
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_A)
			{
				this.heroTank.setDirect(3);
				this.heroTank.moveLeft();
			}
		}
		
		//��ͣ/����
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			isGamePause = !isGamePause;
			GameStatus(isGamePause);
		}
		
		//�����ӵ�
		if(e.getKeyCode() == KeyEvent.VK_J)
		{
			if(heroTank.bullets.size() < 5)
				this.heroTank.ShotEnemy();
		}
		
		//�ػ�
		repaint();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.hitEnemyTank();
			
			//�жϵ���̹�˵��ӵ��Ƿ����hero̹��
			this.hitHeroTank();
			
			repaint();
		}
	}
}

class MyStartPanel extends JPanel implements Runnable
{
	int times = 0 ;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		if(times % 2 == 0)
		{
			g.setColor(Color.yellow);
			Font mf = new Font("������κ",Font.BOLD, 30);
			g.setFont(mf);
			g.drawString("stage: 1", 150, 150);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			times++;
			
			//�ػ�
			this.repaint();
		}
	}
	
}
