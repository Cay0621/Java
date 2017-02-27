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
				Thread.sleep(50);//ÿ��50����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			switch (this.direct) 
			{
			case 0://��
				y -= speed;
				break;
				
			case 1://��
				x += speed;
				break;
				
			case 2://��
				y += speed;
				break;

			case 3://��
				x -= speed;
				break;
			}
			//System.out.println("�ӵ�λ�ã�" + x + "," + y);
			
			if(x < 0 || x > 400 || y < 0 || y > 300)
			{
				isAlive = false;
				break;
			}
		}
	}
	
}
