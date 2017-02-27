package com.tankgame;

public class Bullet implements Runnable{
	int x;
	int y;
	int direct;
	int speed = Constant.BULLETSPEED;
	
	boolean isAlive = true;
	
	public Bullet(int x, int y, int direct) {
		super();
		this.x = x;
		this.y = y;
		this.direct = direct;
	}
	
	public void setStatus(boolean status)
	{
		if(status)
		{
			speed = 0;
		}
		else
		{
			speed = Constant.BULLETSPEED;
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(50);//每隔50毫秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			switch (this.direct) 
			{
			case 0://上
				y -= speed;
				break;
				
			case 1://右
				x += speed;
				break;
				
			case 2://下
				y += speed;
				break;

			case 3://左
				x -= speed;
				break;
			}
			//System.out.println("子弹位置：" + x + "," + y);
			
			if(x < 0 || x > 400 || y < 0 || y > 300)
			{
				isAlive = false;
				break;
			}
		}
	}
	
}
