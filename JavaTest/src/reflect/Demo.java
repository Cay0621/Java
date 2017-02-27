package reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Demo {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		List list1 = new ArrayList();
		List<String> list2 = new ArrayList<String>();
		
		list1.add("Hello");
		list1.add(10);
		
		list2.add("Hello");
		//list2.add(10);
		
		Class c = list2.getClass();
		try {
			//泛型只在编译的有效，在运行时无效
			//利用反射机制绕过编译，将int值加入到String集合中
			Method m = c.getDeclaredMethod("add", Object.class);
			m.invoke(list2, 10);
			
			System.out.println(list2.size());//2
			System.out.println(list2);//Hello, 10
			
			//此处不能使用for each遍历
			for (String string : list2) {
				System.out.println(string);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
