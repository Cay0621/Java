package Test2;

public class Rectangle extends Shape {
	Point leftTop;
	int width;
	int height;
	public Rectangle(Point leftTop, int width, int heig) {
		super();
		this.leftTop = leftTop;
		this.width = width;
		this.height = heig;
	}
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return (width * height);
	}
	
	
}
