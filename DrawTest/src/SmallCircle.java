import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.SampleModel;

import javax.swing.*;


public class SmallCircle extends JFrame{

	/**
	 * @param args
	 */
	MyPanel mp = null;
	public SmallCircle()
	{
		mp = new MyPanel();
		this.add(mp);
		this.setSize(400, 300);
		this.setLocation(250, 250);
		this.setVisible(true);
		this.setTitle("����");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallCircle sm = new SmallCircle();
	}

}

//�Զ��������
class MyPanel extends JPanel
{	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);//������
		
		g.drawOval(10, 10, 30, 30);
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
	}

}