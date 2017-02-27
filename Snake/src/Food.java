import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Food {
	int row,col;
	int w = Garden.BLOCK_SIZE;
	int h = Garden.BLOCK_SIZE;
	private static Random r = new Random();
	private Color color = Color.GREEN;

	public Food(int row, int col) {
		//super();
		this.row = row;
		this.col = col;
	}
	
	public void reAppear() {
		this.row = r.nextInt(Garden.ROWS - 2) + 2;//避免出现在标题栏上
		this.col = r.nextInt(Garden.COLS);
	}
	
	public void drawFood(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillOval(Garden.BLOCK_SIZE * col, Garden.BLOCK_SIZE * row, w, h);
		g.setColor(c);
		
		if(color == Color.GREEN) 
			color = Color.RED;
		else
			color = Color.GREEN;
	}

	public Food() {
		//super();
		this(r.nextInt(Garden.ROWS - 2) + 2,r.nextInt(Garden.COLS));
	}
	
	public Rectangle getHeadRect() {
		return new Rectangle(Garden.BLOCK_SIZE * col, Garden.BLOCK_SIZE * row,w,h);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
}
