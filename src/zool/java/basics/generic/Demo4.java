package zool.java.basics.generic;

import org.junit.jupiter.api.Test;

//�����������ķ����������������ж���Ч������ķ���������������,���Ƕ��ھ�̬��Ա����Ч��
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
	
	//��̬��Ա�ķ�����Ҫ����������
	public static <T> void show1(T t) {
		
	}
	
}
