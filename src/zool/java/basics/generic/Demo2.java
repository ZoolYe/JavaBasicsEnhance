package zool.java.basics.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class Demo2 {

	@Test
	public void test1() {
		
		List<String> list = new ArrayList<>();
		list.add("aaa");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		for(String str : list) {
			System.out.println(str);
		}
		
	}
	
	@Test
	public void test2() {
		
		Map<Integer, String> map = new HashMap<Integer,String>();
		map.put(1, "aaa");
		map.put(2, "bbb");
		map.put(3, "ccc");
		
		Set<Map.Entry<Integer, String>> entry = map.entrySet();
		
		Iterator<Map.Entry<Integer, String>> it = entry.iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, String> en = it.next();
			String value = en.getValue();
			int key = en.getKey();
			System.out.println(value+" : "+key);
		}
		
		//‘ˆ«øfor—≠ª∑
		for(Map.Entry<Integer, String> en : map.entrySet()) {
			String value = en.getValue();
			int key = en.getKey();
			System.out.println(value+" : "+key);
		}
	}
	
}
