package BinarySearch;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 7, 12, 35, 40, 54, 68 };

		BinaryFind bf = new BinaryFind();
		int value = 25;
		
		//bf.find1(arr, 0, arr.length - 1, value);
		int index = bf.find2(arr, 0, arr.length - 1, value);
		if(index != -1)
			System.out.println("找到下标为" + index + "的值" + value);
		else 
			System.out.println("未找到" + value + "的值");
	}

}

class BinaryFind {
	public void find1(int arr[], int left, int right, int value) {
		int mid = (left + right) / 2;
		int midValue = arr[mid];

		if (left <= right) {
			if (midValue > value)
				find1(arr, left, mid - 1, value);
			else if (midValue < value)
				find1(arr, mid + 1, right, value);
			else if (midValue == value) {
				System.out.println("找到下标为" + mid + "的值" + value);
				return;
			}
		}
	}
	public int find2(int arr[], int left, int right, int value)
	{
		while(left <= right)
		{
			int mid = (left + right) / 2;
			int midValue = arr[mid];
			
			if(midValue < value)
				left = mid + 1;
			else if(midValue > value)
				right = mid - 1;
			else if(midValue == value)
				return mid;
		}
		return -1;
	}
}