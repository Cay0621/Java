import java.util.HashMap;
import java.util.Iterator;

public class HashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap hm = new HashMap();
		
		Emp e1 = new Emp("123","cay",1234f);
		Emp e2 = new Emp("234","amy",2345f);
		hm.put("123",e1);
		hm.put("234",e2);
		
//		String id = "123";
//		if(hm.containsKey(id))
//		{
//			Emp e = (Emp)hm.get(id);
//			System.out.println("�ҵ����Ϊ" + id + "��Ա��");
//			System.out.println("Ա����ţ�" + e.getIdNo());
//			System.out.println("Ա��������" + e.getName());
//			System.out.println("Ա�����ʣ�" + e.getSalary());
//		}
//		else 
//		{
//			System.out.println("δ�ҵ����Ϊ" + id + "��Ա��");
//		}
		
		Iterator it = hm.keySet().iterator();
		while(it.hasNext())//�Ƿ�����һ��
		{
			//ȡ��key
			String key = it.next().toString();
			Emp e = (Emp)hm.get(key);
			//System.out.println("�ҵ����Ϊ" + id + "��Ա��");
			System.out.println("Ա����ţ�" + e.getIdNo());
			System.out.println("Ա��������" + e.getName());
			System.out.println("Ա�����ʣ�" + e.getSalary());
			System.out.println();
		}
	}

}
