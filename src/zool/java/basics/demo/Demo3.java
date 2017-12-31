package zool.java.basics.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class Demo3 {

	@Test
	public void test1() {
		// 增强for循环
		int arr[] = { 1, 2, 3 };
		for (int x : arr) {
			System.out.println(x);
		}
	}

	@Test
	public void test2() {
		
		List list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		for(Object obj : list) {
			int i = (int) obj;
			System.out.println(i);
		}
		
	}
	
	@Test
	public void test3() {
		Map map = new LinkedHashMap<>();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		
		/*//通过keySet方法，将map集合中的键存储到set集合中
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			String key = (String) it.next();
			String value = (String) map.get(key);
			System.out.println(key+" : "+value);
		}*/
		
		//将map集合中的键值对映射关系存储到set集合中
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry en = (Entry) it.next();
			String value = (String) en.getValue();
			String key = (String) en.getKey();
			System.out.println(value+" : "+key);
		}
	}
	
	@Test
	public void test4() {
		
		Map map = new LinkedHashMap<>();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		
		/*//增强for循环
		for( Object obj : map.keySet()) {
			String key = (String) obj;
			String value = (String) map.get(key);
			System.out.println(key+" : "+value);
		}*/
		
		
		//增强for循环
		for(Object obj : map.entrySet()) {
			Map.Entry en = (Entry) obj;
			String key = (String) en.getKey();
			String value = (String) en.getValue();
			System.out.println(value+" : "+key);
		}
		
	}
	
	@Test
	public void test5() {
		
		//使用增强for循环需要注意的问题:增强for循环只适合取数据
		int []arr = {1,2,3,4,5,6};
		for(int x : arr) {
			x = 10;
		}
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		
	}
	
}
