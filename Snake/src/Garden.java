import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Garden extends Frame {

	/**
	 * @param args
	 */
	public static final int ROWS = 30;
	public static final int COLS = 30;
	public static final int BLOCK_SIZE = 15;
	
	private int score = 0;
	private Font gameOverFont = new Font("ËÎÌו",Font.BOLD,60);
	
	PaintThread paintThread = new PaintThread();
	private boolean gameOver = false;
	
	
	Image offScreenImage = null;
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	Snake s = new Snake(this);
	Food f = new Food();
	
	public void launch(){
		this.setSize(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
		this.setLocation(200, 200);
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//super.windowClosing(e);
				System.exit(0);
			}
			
		});
		this.setVisible(true);
		
		this.addKeyListener(new KeyMonitor());
		new Thread(paintThread).start();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
		g.setColor(Color.DARK_GRAY);
		for(int i = 1;i < ROWS;++i)
			g.drawLine(0, BLOCK_SIZE * i, COLS * BLOCK_SIZE, BLOCK_SIZE * i);
		for(int i = 1;i < ROWS;++i)
			g.drawLine(BLOCK_SIZE * i, 0, BLOCK_SIZE * i, ROWS * BLOCK_SIZE);
		
		g.setColor(Color.YELLOW);	
		g.drawString("Score:" + score, 50, 50);
		
		if(gameOver == true) {
			g.setFont(gameOverFont);
			g.drawString("Game Over!", 70, 220);
			paintThread.gameOver();
		}
		
		g.setColor(c);
		s.eat(f);
		f.drawFood(g);
		s.drawSnake(g);
		
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Garden().launch();
	}
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		//super.update(g);
		if(offScreenImage == null) {
			offScreenImage = this.createImage(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	protected class PaintThread implements Runnable {
 
		private boolean running = true;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(running) {
				repaint();
				try {
					Thread.sleep(100);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		public void gameOver() {
			running = false;
		}
		
	}
	
	public void stop() {
		gameOver = true;
	}

	private class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//super.keyPressed(e);
			s.keyPressed(e);
		}
		
	}
}
