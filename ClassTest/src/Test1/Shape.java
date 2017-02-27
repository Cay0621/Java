package Test1;

public abstract class Shape {
	Point center;
	int width;
	int height;
	
	public Shape(Point center,int w,int h) {
		super();
		this.center = center;
		this.width = w;
		this.height = h;
	}

	abstract double getArea();
}
