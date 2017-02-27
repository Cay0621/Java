package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Point> map = new HashMap<String, Point>();

		map.put("1,2", new Point(1, 2));
		map.put("3,4", new Point(3, 4));

		Point p = map.get("1,2");
		System.out.println(p);// (1,2)

		// ����keyΪ"1,2"��Ԫ��,���԰�keyΪ"1,2"��Ԫ�ص�ֵ�滻Ϊ�µ�Point����
		map.put("1,2", new Point(5, 6));

		System.out.println(map.size());// 2
		p = map.get("1,2");
		System.out.println(p);// (5,6)

		// ͳ��ÿ�����ֳ��ֵĴ���
		String str = "123,456,234,456,789,909,234,123,788,900,456";

		String[] arr = str.split(",");
		System.out.println(arr.length);//11
		Map<String, Integer> mm = new HashMap<String, Integer>();

		for (String s : arr) {
			if (mm.containsKey(s)) {
				mm.put(s, mm.get(s) + 1);
			} else
				mm.put(s, 1);
		}

		System.out.println(mm.size());// 7
		//ʹ�õ�����
		Iterator<String> it = mm.keySet().iterator();
		while (it.hasNext()) {
			String s = it.next().toString();
			int nCounts = mm.get(s);
			System.out.println(s + "," + nCounts);
		}
		
		//ʹ��keyֵ����
		System.out.println("=========================");
		Set<String> keys = mm.keySet();
		for(String k : keys){
			System.out.println(k + "," + mm.get(k));
		}
		
		//ʹ��key-value�Ա���
		System.out.println("=========================");
		Set<Entry<String, Integer>> entryset = mm.entrySet();
		for(Entry<String, Integer> entry : entryset){
			String key = entry.getKey();
			Integer i = entry.getValue();
			System.out.println(key + "," + i);
		}
	}
}
