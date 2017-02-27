package com.tankgame;

import java.util.Vector;

public class Tank {
	int x = 0;//横坐标
	int y = 0;//纵坐标
	int direct = 0;//坦克方向，0上，1右，2下，3左
	
	//设置坦克速度
	int speed = Constant.TANKSPEED;
	int color;
	
	boolean isAlive = true;
	boolean isPause = false;
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Tank(int x, int y) {
		//super();
		this.x = x;
		this.y = y;
	}
	
	public void setStatus(boolean status)
	{
		isPause = status;
		if(status)
		{
			speed = 0;
		}
		else
		{
			speed = Constant.TANKSPEED;
		}
	}
}

//自己的坦克
class Hero extends Tank
{
	//子弹
	Bullet bullet = null;//一颗子弹
	Vector<Bullet> bullets = new Vector<Bullet>();//子弹集合
	public Hero(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void ShotEnemy()
	{
		if(!isPause)
		{
			switch (this.direct) 
		
			{
			case 0:
				bullet = new Bullet(x + 10, y, this.direct);
				break;
				
			case 1:
				bullet = new Bullet(x + 30, y + 10, this.direct);
				break;
				
			case 2:
				bullet = new Bullet(x + 10, y + 30, this.direct);
				break;
	
			case 3:
				bullet = new Bullet(x, y + 10, this.direct);
				break;
			}
			
			bullets.add(bullet);//将子弹放入集合
			Thread t = new Thread(bullet);
			t.start();
		}
	}
	
	//坦克向上移动
	public void moveUp()
	{
		this.y -= speed;
	}
	
	//坦克向右移动
	public void moveRight()
	{
		this.x += speed;
	}
	
	//坦克向下移动
	public void moveDown()
	{
		this.y += speed;
	}
	
	//坦克向左移动
	public void moveLeft()
	{
		this.x -= speed;
	}
	
	
}

//敌人坦克
class EnemyTank extends Tank implements Runnable
{
	//boolean isAlive = true;
	//定义子弹向量
	Vector<Bullet> bullets = new Vector<Bullet>();//子弹集合
	
	int times = 0;
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	
	public EnemyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	//得到MyPanel上的敌人坦克向量
	public void setEts(Vector<EnemyTank> vv)
	{
		this.ets = vv;
	}
	
	//判断是否碰到别的坦克
	public boolean isTouchOtherEnemy()
	{
		boolean b = false;
		
		switch(direct)
		{
		case 0:
			for(int i = 0;i < ets.size();++i)
			{
				EnemyTank et = ets.get(i);
				if(et != this)
				{
					//如果敌人坦克的方向是向上或者向下
					if(et.direct == 0 || et.direct == 2)
					{
						if(this.x >= et.x && this.x <= et.x + 20 &&
								this.y >= et.y && this.y <= et.y + 30)
							return true;
						
						if(this.x + 20 >= et.x && this.x + 20 <= et.x + 20 &&
								this.y >= et.y && this.y <= et.y + 30)
							return true;
					}
					if(et.direct == 1 || et.direct == 3)
					{
						if(this.x >= et.x && this.x <= et.x + 30 &&
								this.y >= et.y && this.y <= et.y + 20)
							return true;
						
						if(this.x + 20 >= et.x && this.x + 20 <= et.x + 30 &&
								this.y >= et.y && this.y <= et.y + 20)
							return true;
					}
				}
			}
			break;
			
		case 1:
			for(int i = 0;i < ets.size();++i)
			{
				EnemyTank et = ets.get(i);
				if(et != this)
				{
					//如果敌人坦克的方向是向上或者向下
					if(et.direct == 0 || et.direct == 2)
					{
						if(this.x + 30 >= et.x && this.x + 30 <= et.x + 20 &&
								this.y >= et.y && this.y <= et.y + 30)
							return true;
						
						if(this.x + 30 >= et.x && this.x + 30 <= et.x + 20 &&
								this.y + 20 >= et.y && this.y + 20 <= et.y + 20)
							return true;
					}
					if(et.direct == 1 || et.direct == 3)
					{
						if(this.x + 30 >= et.x && this.x + 30 <= et.x + 30 &&
								this.y >= et.y && this.y <= et.y + 20)
							return true;
						
						if(this.x + 30 >= et.x && this.x + 30 <= et.x + 30 &&
								this.y + 20 >= et.y && this.y + 20 <= et.y + 20)
							return true;
					}
				}
			}
			break;
			
		case 2:
			for(int i = 0;i < ets.size();++i)
			{
				EnemyTank et = ets.get(i);
				if(et != this)
				{
					//如果敌人坦克的方向是向上或者向下
					if(et.direct == 0 || et.direct == 2)
					{
						if(this.x>= et.x && this.x<= et.x + 20 &&
								this.y + 30 >= et.y && this.y + 30 <= et.y + 30)
							return true;
						
						if(this.x + 20 >= et.x && this.x + 20 <= et.x + 20 &&
								this.y + 30 >= et.y && this.y + 30 <= et.y + 30)
							return true;
					}
					if(et.direct == 1 || et.direct == 3)
					{
						if(this.x>= et.x && this.x<= et.x + 30 &&
								this.y + 30 >= et.y && this.y + 30 <= et.y + 20)
							return true;
						
						if(this.x + 20 >= et.x && this.x + 20 <= et.x + 30 &&
								this.y + 30 >= et.y && this.y + 30 <= et.y + 20)
							return true;
					}
				}
			}
			break;
			
		case 3:
			for(int i = 0;i < ets.size();++i)
			{
				EnemyTank et = ets.get(i);
				if(et != this)
				{
					//如果敌人坦克的方向是向上或者向下
					if(et.direct == 0 || et.direct == 2)
					{
						if(this.x>= et.x && this.x<= et.x + 20 &&
								this.y>= et.y && this.y<= et.y + 30)
							return true;
						
						if(this.x>= et.x && this.x<= et.x + 20 &&
								this.y + 20 >= et.y && this.y + 20 <= et.y + 30)
							return true;
					}
					if(et.direct == 1 || et.direct == 3)
					{
						if(this.x>= et.x && this.x<= et.x + 30 &&
								this.y>= et.y && this.y<= et.y + 20)
							return true;
						
						if(this.x>= et.x && this.x<= et.x + 30 &&
								this.y + 20 >= et.y && this.y + 20 <= et.y + 20)
							return true;
					}
				}
			}
			break;
		}
		
		return b;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			switch(this.direct)
			{
			case 0:
				for(int i = 0;i < 30;++i)
				{
					if(y > 0 && !this.isTouchOtherEnemy())
						y -= speed;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			case 1:
				for(int i = 0;i < 30;++i)
				{
					if(x < 400 - speed && !this.isTouchOtherEnemy())
						x += speed;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			case 2:
				for(int i = 0;i < 30;++i)
				{
					if(y < 300 - speed && !this.isTouchOtherEnemy())
						y += speed;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			case 3:
				for(int i = 0;i < 30;++i)
				{
					if(x > 0 && !this.isTouchOtherEnemy())
						x -= speed;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}
			
			if(!isPause)
			{
				times++;
			
				if(times % 2 == 0)
				{
					if(isAlive)
					{
						if(bullets.size() < 5)
						{
							Bullet bu = null;
							switch(direct)
							{
							case 0:
								bu = new Bullet(x + 10, y, direct);
								break;
								
							case 1:
								bu = new Bullet(x + 30, y + 10, direct);
								break;
								
							case 2:
								bu = new Bullet(x + 10, y + 30, direct);
								break;
	
							case 3:
								bu = new Bullet(x, y + 10, direct);
								break;
							}
							bullets.add(bu);
							Thread t = new Thread(bu);
							t.start();
						}
						
					}
				}

				this.direct = (int)(Math.random() * 4);
				
				//判断敌人坦克是否死亡
				if(!isAlive)
					break;
			}
		}
		
	}
	
}