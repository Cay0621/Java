package CollectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CountChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, Integer> mp = countChars("aabbbccdddaadbc");

		//迭代方法1
		Set<Entry<Character, Integer>> s = mp.entrySet();
		Iterator i = s.iterator();
		while(i.hasNext())
		{
			Entry<Character, Integer> entry = (Entry<Character, Integer>) i.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		//迭代方法2
		Set<Character> keys = mp.keySet();
		Iterator ite = keys.iterator();
		while(ite.hasNext())
		{
			char c = (char) ite.next();
			int val = mp.get(c);
			System.out.println(c + ":" + val);
		}
		
//		for (Entry<Character, Integer> entry : s) {
//			System.out.println(entry.toString());
//		}
	}
	
	public static Map<Character,Integer> countChars(String str)
	{
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		
		for(int i = 0;i < str.length(); ++i){
			char c = str.charAt(i);
			
			if(mp.containsKey(c))
				mp.put(c, mp.get(c) + 1);
			else
				mp.put(c, 1);
		}
		return mp;
	}

}
