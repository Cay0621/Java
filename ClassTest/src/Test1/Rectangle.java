package Test1;

public class Rectangle extends Shape {

	
	public Rectangle(Point center, int w, int h) {
		super(center, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return (width * height);
	}

}
