package Comparable;

import java.util.*;

public class ComparableTest implements Comparable<ComparableTest>{

	private int x;
	private int y;
	
	
	public ComparableTest(int x, int y) {
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


	public int compareTo(ComparableTest o) {
		// TODO Auto-generated method stub
		int r = x * x + y * y;
		int other = o.x * o.x + o.y * o.y;
		
		return r - other;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + x + "," + y + ")";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ComparableTest> list = new ArrayList<ComparableTest>();
		list.add(new ComparableTest(1, 5));
		list.add(new ComparableTest(3, 4));
		list.add(new ComparableTest(2, 2));
		
		Comparator<ComparableTest> c = new Comparator<ComparableTest>(){

			/**
			 * 
			 * @param arg0
			 * @param arg1
			 * @return
			 */
			public int compare(ComparableTest arg0, ComparableTest arg1) {
				// TODO Auto-generated method stub
				return arg0.getX() - arg1.getX();
			}
			
		};
		
		//for Comparable
		//Collections.sort(list);//从大到小排序
		
		//for Comparator
		Collections.sort(list, c);
		System.out.println(list);
	}

	
	
}
