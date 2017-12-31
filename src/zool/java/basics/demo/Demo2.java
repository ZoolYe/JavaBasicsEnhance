package zool.java.basics.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo2 {

	public static void main(String[] args) {
		
		//装箱,jvm 1.5之后才支持
		Integer i = 1;
		
		//拆箱
		int j = i;
		
		//自动装箱的典型应用,加进集合的是对象123，不是整数
		List list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			int s = (int) it.next();//拆箱
		}
	}

}
