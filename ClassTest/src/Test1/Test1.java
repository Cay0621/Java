package Test1;

public class Test1 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(4, 5);
		Object[] os = new Shape[2];
		os[0] = new Circle(p, 2, 2);
		os[1] = new Rectangle(p, 1, 6);
		
		double area;
		
		for(Object o : os)
		{
			if(o instanceof Circle)
			{
				area = ((Circle)o).getArea();
			}
			else
			{
				area = ((Rectangle)o).getArea();
			}
			System.out.println(o.getClass().getName() + ":" + area);
		}
	}

}
