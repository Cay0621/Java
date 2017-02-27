import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Snake {
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	private Node n = new Node(20,30,DIRECTION.LEFT);
	private Garden gar;
	
	public Snake(Garden g) {
		this.head = n;
		this.tail = n;
		this.size = 1;
		this.gar = g;
	}
	
	public void addToTail() {
		Node node = null;
		switch(tail.dir) {
		case LEFT:
			node = new Node(tail.row, tail.col + 1, tail.dir);
			break;
			
		case UP:
			node = new Node(tail.row + 1, tail.col, tail.dir);
			break;
			
		case RIGHT:
			node = new Node(tail.row, tail.col - 1, tail.dir);
			break;
			
		case DOWN:
			node = new Node(tail.row - 1, tail.col, tail.dir);
			break;
		}
		tail.nextNode = node;
		node.prevNode = tail;
		tail = node;
		size++;
	}
	
	public void addToHead() {
		Node node = null;
		switch(head.dir) {
		case LEFT:
			node = new Node(head.row, head.col - 1, head.dir);
			break;
			
		case UP:
			node = new Node(head.row - 1, head.col, head.dir);
			break;
			
		case RIGHT:
			node = new Node(head.row, head.col + 1, head.dir);
			break;
			
		case DOWN:
			node = new Node(head.row + 1, head.col, head.dir);
			break;
		}
		node.nextNode = head;
		head.prevNode = node;
		head = node;
		size++;
	}
	
	public void drawSnake(Graphics g) {
		if(size == 0) return;
		
		move();
		
		for(Node n = head; n != null; n = n.nextNode)
			n.draw(g);
		
		
	}
	
	private void move() {
		// TODO Auto-generated method stub
		addToHead();
		deleteFromTail();
		checkDead();
	}
	
	private void checkDead() {
		if(head.row < 2 || head.col < 0 || head.row > Garden.ROWS || head.col > Garden.COLS) {
			gar.stop();
		}
		
		for(Node n = head.nextNode;n != null;n = n.nextNode) {
			if(head.row == n.row && head.col == n.col)
				gar.stop();
		}
	}

	private void deleteFromTail() {
		// TODO Auto-generated method stub
		if(size == 0) return;
		tail = tail.prevNode;
		tail.nextNode = null;
	}
	
	public void eat(Food f) {
		if(this.getHeadRect().intersects(f.getHeadRect())) {
			f.reAppear();
			this.addToHead();
			gar.setScore(gar.getScore() + 5);
		}
	}
	
	private Rectangle getHeadRect() {
		return new Rectangle(Garden.BLOCK_SIZE * head.col, Garden.BLOCK_SIZE * head.row,head.w,head.h);
	}

	private class Node {
		int w = Garden.BLOCK_SIZE;
		int h = Garden.BLOCK_SIZE;
		int row, col;
		DIRECTION dir = DIRECTION.LEFT;
		Node nextNode = null;
		Node prevNode = null;
		
		Node(int row, int col, DIRECTION dir) {
			//super();
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		
		void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.BLACK);
			g.fillRect(Garden.BLOCK_SIZE * col, Garden.BLOCK_SIZE * row, w, h);
			g.setColor(c);
		}
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_LEFT:
			if(key != KeyEvent.VK_RIGHT)
				head.dir = DIRECTION.LEFT;
			break;
			
		case KeyEvent.VK_RIGHT:
			if(key != KeyEvent.VK_LEFT)
				head.dir = DIRECTION.RIGHT;
			break;
			
		case KeyEvent.VK_UP:
			if(key != KeyEvent.VK_DOWN)
				head.dir = DIRECTION.UP;
			break;
			
		case KeyEvent.VK_DOWN:
			if(key != KeyEvent.VK_UP)
				head.dir = DIRECTION.DOWN;
			break;
		}
		
	}
}
