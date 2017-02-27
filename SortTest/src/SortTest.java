import java.util.Calendar;

public class SortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int len = 100000;
		int[] arr = new int[len];
		for(int i = 0;i < len;++i)
			arr[i] = (int)(Math.random() * 10000) + 1;
		Calendar cal1 = null,cal2 = null;
		/*
		Bubble b = new Bubble();
		cal1 = Calendar.getInstance();
		System.out.println("冒泡排序前时间：" + cal1.getTime());
		b.sort(arr);
		cal2 = Calendar.getInstance();
		System.out.println("冒泡排序后时间：" + cal2.getTime());
		System.out.println();
		
		Select s = new Select();
		cal1 = Calendar.getInstance();
		System.out.println("选择排序前时间：" + cal1.getTime());
		s.sort(arr);
		cal2 = Calendar.getInstance();
		System.out.println("选择排序后时间：" + cal2.getTime());
		System.out.println();*/
		
//		Insert i = new Insert();
//		cal1 = Calendar.getInstance();
//		System.out.println("选择排序前时间：" + cal1.getTime());
//		i.sort(arr);
//		cal2 = Calendar.getInstance();
//		System.out.println("选择排序后时间：" + cal2.getTime());
//		System.out.println();
		
		Quick q = new Quick();
		cal1 = Calendar.getInstance();
		System.out.println("快速排序前时间：" + cal1.getTime());
		q.sort(0, arr.length - 1, arr);
		cal2 = Calendar.getInstance();
		System.out.println("快速排序后时间：" + cal2.getTime());
		System.out.println();
	}

}

class Bubble {
	public void sort(int arr[]) {
		int tmp;
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr.length - 1 - i; ++j) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
//		for (int i = 0; i < arr.length; ++i)
//			System.out.print(arr[i] + " ");
	}
}

class Select {
	public void sort(int[] arr) {
		int tmp = 0;
		for (int i = 0; i < arr.length - 1; ++i) {
			int min = arr[i];
			int minIndex = i;

			for (int j = i + 1; j < arr.length - 1; ++j) {
				if (min > arr[j]) {
					minIndex = j;
					min = arr[j];
				}
			}
			
			tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;
		}
//		
//		for (int i = 0; i < arr.length; ++i)
//			System.out.print(arr[i] + " ");
	}
}

class Insert {
	public void sort(int []arr) {
		for(int i = 1 ;i < arr.length;++i) {
			int insertValue = arr[i];
			int index = i - 1;
			while(index >= 0 && insertValue < arr[index]) {
				arr[index + 1] = arr[index];
				index --;
			}
			arr[index + 1] = insertValue;
		}
		
//		for (int i = 0; i < arr.length; ++i)
//			System.out.print(arr[i] + " ");
	}
}

class Quick {
	public void sort(int left,int right,int[] arr) {
		int l = left;
		int r = right;
		int midValue = arr[(l + r) / 2];
		int tmp = 0;
		
		while(l < r) {
			while(arr[l] < midValue) l++;
			while(arr[r] > midValue) r--;
			
			if(l >= r) break;
			
			tmp = arr[l];
			arr[l] = arr[r];
			arr[r] = tmp;
			
			if(arr[l] == midValue) --r;
			if(arr[r] == midValue) ++l;
			
			if(l == r){
				l++;
				r--;
			}
			
			if(left < r) sort(left, r, arr);
			if(right > l) sort(l, right, arr);
		}
	}
}