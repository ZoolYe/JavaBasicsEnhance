package zool.java.basics.generic;

import org.junit.jupiter.api.Test;

//�Զ�������͵ķ���
public class Demo3 {

	@Test
	public void test1() {
		
		show("sdw");
		
	}
	
	public <T> T show(T t) {
		t.hashCode();
		return t;
	}
	
	public <T,E,K> void function(T t,E e,K k) {
		System.out.println(t);
	}
	
}
