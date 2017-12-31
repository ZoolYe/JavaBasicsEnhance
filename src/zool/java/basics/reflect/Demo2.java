package zool.java.basics.reflect;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

//������Ĺ��캯����������Ķ���
public class Demo2 {

	// ���乹�캯����public Persion()
	@Test
	public void test1() throws Exception {
		String className = "zool.java.basics.reflect.Persion";
		// ��ȡ����ֽ����ļ�
		Class clazz = Class.forName(className);
		// ��ȡ�����Ĺ��췽��
		Constructor con = clazz.getConstructor(null);
		// ͨ���ղ����Ĺ��캯��������Ķ���
		Persion p = (Persion) con.newInstance(null);
	}

	// ���乹�캯����public Persion(String name)
	@Test
	public void test2() throws Exception {
		String className = "zool.java.basics.reflect.Persion";
		// ��ȡ����ֽ����ļ�
		Class clazz = Class.forName(className);

		// ��ȡ��������������һ��String�Ĺ��췽��
		Constructor con = clazz.getConstructor(String.class);

		// ͨ�������ȡ���Ĺ��캯�����������������Ķ���
		Persion p = (Persion) con.newInstance("Hello");
	}

	// ���乹�캯����public Persion(String name ,int age)
	@Test
	public void test3() throws Exception {

		String className = "zool.java.basics.reflect.Persion";
		// ��ȡ����ֽ����ļ�
		Class clazz = Class.forName(className);

		// ��ȡ��������������һ��String�Ĺ��췽��
		Constructor con = clazz.getConstructor(String.class, int.class);

		// ͨ�������ȡ���Ĺ��캯�����������������Ķ���
		Persion p = (Persion) con.newInstance("Hello", 20);
	}

	// ���乹�캯����private Persion(List list) ˽�е�
	@Test
	public void test4() throws Exception {

		String className = "zool.java.basics.reflect.Persion";
		// ��ȡ����ֽ����ļ�
		Class clazz = Class.forName(className);
		//��ȡ˽�еĹ��캯��
		Constructor con = clazz.getDeclaredConstructor(List.class);
		//��������
		con.setAccessible(true);
		Persion p = (Persion) con.newInstance(new ArrayList<>());
	}

	//�����ղ����Ĺ��캯����д��ʽ
	@Test
	public void test5() throws Exception {
		String className = "zool.java.basics.reflect.Persion";
		Class clazz = Class.forName(className);
		//���õ����޲εĹ��캯��
		Persion p = (Persion) clazz.newInstance();
	}
	
}
