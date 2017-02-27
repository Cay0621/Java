package EventTest;
/**
 *	功能：通过键盘操作小球的运动 
 */

import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class keyEventTest extends JFrame{

	/**
	 * @param args
	 */
	MyPanel_1 mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		keyEventTest kt = new keyEventTest();
	}
	
	public keyEventTest()
	{
		this.setSize(400,300);
		mp = new MyPanel_1(400,300);
		this.add(mp);
		
		this.addKeyListener(mp);
		
		this.setTitle("事件测试2");
		this.setLocation(250, 250);
		this.setVisible(true);
		
	}
}

class MyPanel_1 extends JPanel implements KeyListener
{
	int x = 10;
	int y = 10;
	final int width;
	final int height; 
	
	public MyPanel_1(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.fillOval(x, y, 20, 20);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			if(y > 0) y -= 5;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(y < height - 20) y+= 5;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(x > 0) x -= 5;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(x < width - 20) x += 5;
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
}