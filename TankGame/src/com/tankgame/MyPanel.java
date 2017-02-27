package com.tankgame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import javax.imageio.*;
import java.io.*;

import javax.swing.*;

public class MyPanel extends JPanel implements KeyListener , Runnable{

	//定义自己的坦克
	Hero heroTank = null;
	//定义敌人坦克
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	Vector<TankNode> tns = new Vector<TankNode>();
	
	//炸弹集合
	Vector<Bomb> bombs = new Vector<Bomb>();
	
	int enSize = Constant.ENEMYCOUNT;
	boolean isGamePause = false;
	
	Image img1 = null;
	Image img2 = null;
	Image img3 = null;
	
	public MyPanel(String flag) {
		//恢复记录
		Recorder.readRecorder();
		
		heroTank = new Hero(200, 200);
		
		if(flag.equals("newGame"))
		{
			//初始化敌人坦克
			for(int i = 0;i < enSize;++i)
			{
				EnemyTank et = new EnemyTank((i + 1) * 50, 0);
				et.setColor(0);//0代表敌人坦克颜色，1代表自己坦克颜色
				et.setDirect(2);
				
				//将MyPanel的敌人坦克向量交给该敌人坦克
				et.setEts(ets);	
				
				Thread t = new Thread(et);
				t.start();
				
				Bullet bu = new Bullet(et.x + 10, et.y + 30, 2);
				//加入敌人坦克子弹集合
				et.bullets.add(bu);
				
				Thread t2 = new Thread(bu);
				t2.start();
				ets.add(et);
			}
		}
		else
		{
			tns = Recorder.getRecorder();
			//初始化敌人坦克
			for(int i = 0;i < tns.size();++i)
			{
				TankNode tn = tns.get(i);
				EnemyTank et = new EnemyTank(tn.x, tn.y);
				et.setColor(0);//0代表敌人坦克颜色，1代表自己坦克颜色
				et.setDirect(tn.direct);
				
				//将MyPanel的敌人坦克向量交给该敌人坦克
				et.setEts(ets);	
				
				Thread t = new Thread(et);
				t.start();
				
				Bullet bu = new Bullet(et.x + 10, et.y + 30, 2);
				//加入敌人坦克子弹集合
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
		//画出敌人坦克和英雄坦克的剩余数量
		this.DrawTank(g, 50, 320, 0, 0);//敌人
		this.DrawTank(g, 250, 320, 0, 1);//自己
		g.setColor(Color.BLACK);
		
		Font f = new Font("宋体", Font.BOLD, 20);
		g.setFont(f);
		g.drawString(":" + String.valueOf(Recorder.getEnNum()), 75, 340);
		g.drawString(":" + String.valueOf(Recorder.getLife()), 275, 340);
		
		//画出玩家的总成绩
		g.drawString("您的总成绩：", 400, 50);
		this.DrawTank(g, 420, 60, 0, 0);
		g.setColor(Color.BLACK);
		g.drawString(":" + Recorder.getAllDeadEnemy(), 450, 80);
	}


	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		//画出提示坦克的信息
		showInfo(g);
		
		//画坦克Hero
		if(heroTank.isAlive)
			this.DrawTank(g, heroTank.getX(), heroTank.getY(), heroTank.getDirect(), 1);//自己
		
		//遍历子弹
		for(int i = 0;i < heroTank.bullets.size();++i)
		{
			Bullet b = heroTank.bullets.get(i);
			//画一颗子弹
			if(b != null && b.isAlive)
			{
				g.draw3DRect(b.x, b.y, 1, 1, false);
			}
			
			if(b.isAlive == false)
				heroTank.bullets.remove(b);
			
		}
		
		//画出敌人坦克
		for(int i = 0;i < ets.size();++i)
		{
			EnemyTank et = ets.get(i);
			if(et.isAlive)
			{
				this.DrawTank(g, et.getX(), et.getY(), et.getDirect(), 0);//敌人
				for(int j = 0;j < et.bullets.size();++j)
				{
					Bullet bu = et.bullets.get(j);
					if(bu.isAlive)
					{
						g.draw3DRect(bu.x, bu.y, 1, 1, false);
					}
					else 
					{
						//如果敌人坦克死亡，就从向量中去掉
						et.bullets.remove(bu);
					}
				}
			}
		}
		
		//画出炸弹
		for(int i = 0;i < bombs.size();++i)
		{
			//取出炸弹
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
			//让炸弹的life减小
			b.lifeDown();
			//如果炸弹生命值为0，就把炸弹从向量中移除
			if(b.life == 0)
			{
				bombs.remove(b);
			}
		}
	}
	
	public void hitHeroTank()
	{
		//取出每一个敌人的坦克
		for(int i = 0;i < ets.size();++i)
		{
			//取出坦克
			EnemyTank et = ets.get(i);
			
			//取出子弹
			for(int j = 0;j < et.bullets.size();++j)
			{
				Bullet b = et.bullets.get(j);
				if(heroTank.isAlive)
					this.hitTank(b,heroTank);
			}
		}
	}
	
	//判断hero的子弹是否击中敌人坦克
	public void hitEnemyTank()
	{
		for(int i = 0;i < heroTank.bullets.size();++i)
		{
			//取出子弹
			Bullet b = heroTank.bullets.get(i);
			
			if(b.isAlive)
			{
				//取出敌人坦克
				for(int j = 0;j < ets.size();++j)
				{
					//取出坦克
					EnemyTank et = ets.get(j);
					if(et.isAlive)
					{
						hitTank(b, et);
					}
				}
			}
		}
	}
	
	
	//判断子弹是否击中坦克,进行爆炸效果
	public void hitTank(Bullet b, Tank et)
	{
		//判断坦克方向
		switch(et.direct)
		{
		case 0:
		case 2:
			if(b.x >= et.x && b.x <= et.x + 20 && b.y >= et.y && b.y <= et.y + 30)
			{
				//击中
				b.isAlive = false;//子弹消失
				et.isAlive = false;//坦克消失
				if(et instanceof EnemyTank)
					Recorder.reduceEnemyCount();
				else if(et instanceof Hero)
					Recorder.reduceLift();
				
				//创建炸弹,放入vb中
				Bomb bomb = new Bomb(et.x, et.y);
				bombs.add(bomb);
			}
			break;
			
		case 1:
		case 3:
			if(b.x >= et.x && b.x <= et.x + 30 && b.y >= et.y && b.y <= et.y + 20)
			{
				//击中
				b.isAlive = false;//子弹消失
				et.isAlive = false;//坦克消失
				if(et instanceof EnemyTank)
					Recorder.reduceEnemyCount();
				else if(et instanceof Hero)
					Recorder.reduceLift();
				
				//创建炸弹,放入vb中
				Bomb bomb = new Bomb(et.x, et.y);
				bombs.add(bomb);
			}
			break;
		}
	}
	

	public void DrawTank(Graphics g, int x, int y, int dir, int type)
	{
		//敌人坦克或者自己坦克
		switch(type)
		{
		case 0://敌人
			g.setColor(Color.CYAN);
			break;
			
		case 1://自己
			g.setColor(Color.YELLOW);
			break;
		}
		
		//方向
		switch(dir)
		{
		case 0://向上
			//左矩形
			g.fill3DRect(x, y, 5, 30, false);
			//右矩形
			g.fill3DRect(x + 15, y, 5, 30, false);
			//中间矩形
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			//中间圆形
			g.fillOval(x + 5, y + 10, 10, 10);
			//炮筒
			g.drawLine(x + 10, y + 15, x + 10, y);
			break;
			
		case 1://向右
			//上矩形
			g.fill3DRect(x, y, 30, 5, false);
			//下矩形
			g.fill3DRect(x, y + 15, 30, 5, false);
			//中间矩形
			g.fill3DRect(x + 5, y + 5, 20, 10, false);
			//中间圆形
			g.fillOval(x + 10, y + 5, 10, 10);
			//炮筒
			g.drawLine(x + 15, y + 10, x + 30, y + 10);
			break;
			
		case 2://向下
			//左矩形
			g.fill3DRect(x, y, 5, 30, false);
			//右矩形
			g.fill3DRect(x + 15, y, 5, 30, false);
			//中间矩形
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			//中间圆形
			g.fillOval(x + 5, y + 10, 10, 10);
			//炮筒
			g.drawLine(x + 10, y + 15, x + 10, y + 30);
			break;
			
		case 3://向左
			//上矩形
			g.fill3DRect(x, y, 30, 5, false);
			//下矩形
			g.fill3DRect(x, y + 15, 30, 5, false);
			//中间矩形
			g.fill3DRect(x + 5, y + 5, 20, 10, false);
			//中间圆形
			g.fillOval(x + 10, y + 5, 10, 10);
			//炮筒
			g.drawLine(x + 15, y + 10, x, y + 10);
			break;
		}
	}
	
	
	public void GameStatus(boolean status)
	{
		//英雄坦克暂停/继续
		heroTank.setStatus(status);
		for(int i = 0;i < heroTank.bullets.size();++i)
		{
			Bullet b = heroTank.bullets.get(i);
			b.setStatus(status);
		}
		
		//敌人坦克暂停/继续
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
		
		//子弹暂停/继续
		
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
		
		//暂停/继续
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			isGamePause = !isGamePause;
			GameStatus(isGamePause);
		}
		
		//发射子弹
		if(e.getKeyCode() == KeyEvent.VK_J)
		{
			if(heroTank.bullets.size() < 5)
				this.heroTank.ShotEnemy();
		}
		
		//重绘
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
			
			//判断敌人坦克的子弹是否击中hero坦克
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
			Font mf = new Font("华文新魏",Font.BOLD, 30);
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
			
			//重绘
			this.repaint();
		}
	}
	
}
