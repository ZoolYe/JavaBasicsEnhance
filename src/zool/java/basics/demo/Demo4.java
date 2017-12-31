package zool.java.basics.demo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Demo4 {

	
	@Test
	public void testSum() {
		sum(1,2,3,3,3);
	}
	
	//�ɱ����
	public void sum(int ...sums) {
		int sum = 0;
		//�ɱ������������������
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
	 * �ɱ������Ҫע�������
	 * aa(int ...nums,int x)����д�ǲ����Ե�
	 * aa(int x,int ...nums)����д�ǿ��Ե�
	 * aa(Object obj,int ...nums)��ͬ����Ҳ�ǿ��Ե�
	 * aa(int ...nums,Object obj)���������ǲ����Ե�
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
