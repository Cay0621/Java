import java.util.*;

public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		Emp e1 = new Emp("123","cay",1234f);
		Emp e2 = new Emp("234","amy",1234f);
		ll.addFirst(e1);
		ll.addFirst(e2);
		
		Object o1 = ll.getFirst();
		if(o1 instanceof Emp)
		{
			Emp e = (Emp)o1;
			System.out.println("Ա����ţ�" + e.getIdNo());
			System.out.println("Ա��������" + e.getName());
			System.out.println("Ա�����ʣ�" + e.getSalary());
		}
		System.out.println();
		
		Object o2 = ll.getLast();
		if(o1 instanceof Emp)
		{
			Emp e = (Emp)o2;
			System.out.println("Ա����ţ�" + e.getIdNo());
			System.out.println("Ա��������" + e.getName());
			System.out.println("Ա�����ʣ�" + e.getSalary());
		}
		
	}

}
