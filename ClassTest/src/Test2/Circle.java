package Test2;

public class Circle extends Shape {

	Point center;
	double r;
	
	public Circle(Point center, double r) {
		super();
		this.center = center;
		this.r = r;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return (Math.PI * r * r);
	}

}
