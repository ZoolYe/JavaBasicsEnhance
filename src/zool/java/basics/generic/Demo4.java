package zool.java.basics.generic;

import org.junit.jupiter.api.Test;

//类上面声明的泛型作用在整个内中都有效，下面的方法都不用声明了,但是对于静态成员是无效的
public class Demo4<T,E,K> {

	@Test
	public void test1() {
		
		//show("sdw");
		
	}
	
	/*public <T> T show(T t) {
		t.hashCode();
		return t;
	}
	
	public <E,K> void function(E e,K k) {
		System.out.println(e);
	}*/
	
	public T show(T t) {
		t.hashCode();
		return t;
	}
	
	public void function(E e,K k) {
		System.out.println(e);
	}
	
	//静态成员的泛型需要单独来声明
	public static <T> void show1(T t) {
		
	}
	
}
