package zool.java.basics.demo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Demo4 {

	
	@Test
	public void testSum() {
		sum(1,2,3,3,3);
	}
	
	//可变参数
	public void sum(int ...sums) {
		int sum = 0;
		//可变参数，把它当成数组
		for(int x : sums) {
			sum +=x;
		}
		System.out.println(sum);
	}
	
	@Test
	public void testAa() {
		aa("hah",12,323,21312,33);
	}
	
	/*
	 * 可变参数需要注意的问题
	 * aa(int ...nums,int x)这样写是不可以的
	 * aa(int x,int ...nums)这样写是可以的
	 * aa(Object obj,int ...nums)不同类型也是可以的
	 * aa(int ...nums,Object obj)但是这样是不可以的
	 * */
	public void aa(String x,int ...nums) {
		System.out.println("x:"+x);
		for(int s : nums) {
			System.out.println(s);
		}
	}
	
	@Test
	public void bb() {
		
		List list = Arrays.asList("1","2","3");
		System.out.println(list);
		
		String []arr = {"1","2","3","4"};
		list = Arrays.asList(arr);
		System.out.println(list);
		
		Integer []int_arr = {1,2,3,4,5,6};
		list = Arrays.asList(int_arr);
		System.out.println(list);
	}
	
}
