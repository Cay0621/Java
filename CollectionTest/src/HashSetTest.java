import java.util.*;

public class HashSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Point> set = new HashSet<Point>();
		Point p1 = new Point(3, 4);
		Point p2 = new Point(3, 4);
		set.add(p1);
		set.add(p2);
		
		//重载equals和hashCode
		System.out.println(p1 == p2);//false
		System.out.println(p1.equals(p2));//true
		System.out.println(p1.hashCode() == p2.hashCode());//true
		
		System.out.println(set.size());//1
		for(Point p : set){
			System.out.println(p);
		}
		
		set.add(new Point(1, 2));
		System.out.println(set.size());//2
		System.out.println(set.contains(new Point(1, 2)));//true
		
//		//只重载equals
//		System.out.println(p1 == p2);//false
//		System.out.println(p1.equals(p2));//true
//		System.out.println(p1.hashCode() == p2.hashCode());//false
//		
//		System.out.println(set.size());//2
//		for(Point p : set){
//			System.out.println(p);
//		}
//		
//		set.add(new Point(1, 2));
//		System.out.println(set.size());//3
//		System.out.println(set.contains(new Point(1, 2)));//false
//		
//		//只重载hashCode
//		System.out.println(p1 == p2);//false
//		System.out.println(p1.equals(p2));//false
//		System.out.println(p1.hashCode() == p2.hashCode());//true
//		
//		System.out.println(set.size());//2
//		for(Point p : set){
//			System.out.println(p);
//		}
//		
//		set.add(new Point(1, 2));
//		System.out.println(set.size());//3
//		System.out.println(set.contains(new Point(1, 2)));//false
	}

}

class Point {
	private int x;
	private int y;

	public Point() {

	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + x + "," + y + ")";
	}

	
}