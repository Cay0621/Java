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
//			System.out.println("找到编号为" + id + "该员工");
//			System.out.println("员工编号：" + e.getIdNo());
//			System.out.println("员工姓名：" + e.getName());
//			System.out.println("员工工资：" + e.getSalary());
//		}
//		else 
//		{
//			System.out.println("未找到编号为" + id + "的员工");
//		}
		
		Iterator it = hm.keySet().iterator();
		while(it.hasNext())//是否还有下一个
		{
			//取出key
			String key = it.next().toString();
			Emp e = (Emp)hm.get(key);
			//System.out.println("找到编号为" + id + "该员工");
			System.out.println("员工编号：" + e.getIdNo());
			System.out.println("员工姓名：" + e.getName());
			System.out.println("员工工资：" + e.getSalary());
			System.out.println();
		}
	}

}
