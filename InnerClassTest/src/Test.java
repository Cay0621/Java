import java.util.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"abcda","da","faf","a"};
		Arrays.sort(strs,new Comparator()
		{
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return (((String)o1).length() - ((String)o2).length());
			}
		});
		System.out.println(Arrays.toString(strs));
	}

}
