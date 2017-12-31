package zool.java.basics.generic;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

	public static void main(String[] args) {

		List list = new ArrayList<>();
		
		list.add("string");
		
		int i = (int) list.get(0);
		System.out.println(i);
	
		List<String> list1 = new ArrayList<>();
		list1.add("hahah");
		
		String str = list1.get(0);
		
	}

}
