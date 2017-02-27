package Iterator;

import java.util.*;

public class IteratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add("12");
		list.add("#");
		list.add("34");
		list.add("#");
		list.add("56");
		list.add("#");
		
		for(Object o : list)
		{
			System.out.println(o);
		}
		System.out.println("=======================");
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			//System.out.println(it.next());
			if("#".equals(obj))
			{
				//�ڵ������в�ʹ���б��remove����,����ʹ��iterator��remove����
				//list.remove(obj);
				it.remove();
			}		
		}
		for(Object o : list)
		{
			System.out.println(o);
		}
	}

}
