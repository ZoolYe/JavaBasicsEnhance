package zool.java.basics.generic;

import org.junit.jupiter.api.Test;

public class Demo5 {

	//编写一个泛型方法，实现指定位置上的数组元素的交换
	public <T> void swap(T []arr, int pos1 ,int pos2) {
		 
		 T temp = arr[pos1];
		 arr[pos1] = arr[pos2];
		 arr[pos2] = temp;
		 
	}
	
	//编写一个泛型方法，接收一个任意数组，并颠倒数组中的所有元素
	public <T> void reverse(T []arr) {
		
		int start = 0;
		int end = arr.length-1;
		
		while(start<end) {
			
			T temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
			
		}
		
	}
	
	@Test
	public void test1() {
		int []arr = {1,2,3,4,5,6,7,8,9,0};
		System.out.println(arr.toString());
		//swap(arr, 1, 4);
	}
	
}
