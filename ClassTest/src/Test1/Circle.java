package Test1;

public class Circle extends Shape {

	public Circle(Point center, int w, int h) {
		super(center, w, h);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return (Math.PI * width * width);
	}

}
