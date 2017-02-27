package Test2;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(3, 4);
		Shape[] ss = new Shape[2];
		ss[0] = new Circle(p,1.0);
		ss[1] = new Rectangle(p, 3, 4);
		
		double area;
		for(Shape s : ss)
		{
			if(s instanceof Circle)
			{
				area = ((Circle)s).getArea();
			}
			else
			{
				area = ((Rectangle)s).getArea();
			}
			System.out.println(s.getClass().getName() + ":" + area);
		}
	}

}
