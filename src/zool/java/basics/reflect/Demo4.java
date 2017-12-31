package zool.java.basics.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class Demo4 {

	// �����ֶΣ�public String name;
	@Test
	public void test1() throws Exception {

		String className = "zool.java.basics.reflect.Persion";

		Class clazz = Class.forName(className);

		// ͨ���ֽ����ļ���ȡ���캯�������������캯���Ĳ�������
		Constructor con = clazz.getConstructor(String.class);

		// ͨ�����캯�����������󣬲������캯����ֵ
		Persion p = (Persion) con.newInstance("�������д�");

		// ͨ���ֽ����ļ���ȡ�ֶ�
		Field field = clazz.getField("name");
		// ͨ��get��ȡ�ֶε�ֵ���������������(Ҫ��ȡ�Ǹ�������ֶε�ֵ)
		Object obj = field.get(p);
		// ��ȡ����ֶε����ͣ���Ϊjava�ж���������ڵ�����Ҫ��class����
		Class type = field.getType();

		String str = null;
		if (type.equals(String.class)) {
			str = (String) obj;
		}
		System.out.println(str);
	}

	// �����ֶΣ�public String name;
	@Test
	public void test2() throws Exception {

		String className = "zool.java.basics.reflect.Persion";

		Class clazz = Class.forName(className);

		// ͨ���ֽ����ļ���ȡ���캯�������������캯���Ĳ�������
		Constructor con = clazz.getConstructor(String.class);

		// ͨ�����캯�����������󣬲������캯����ֵ
		Persion p = (Persion) con.newInstance("�������д�");

		// ͨ���ֽ����ļ���ȡ�ֶ�
		Field field = clazz.getField("name");
		
		//�����ֶε�ֵ������1��Ҫ����ֵ�Ķ���Ҫ���õ�ֵ
		field.set(p, "��ͨ����");
		
		// ͨ��get��ȡ�ֶε�ֵ���������������(Ҫ��ȡ�Ǹ�������ֶε�ֵ)
		Object obj = field.get(p);
		// ��ȡ����ֶε����ͣ���Ϊjava�ж���������ڵ�����Ҫ��class����
		Class type = field.getType();

		String str = null;
		if (type.equals(String.class)) {
			str = (String) obj;
		}
		System.out.println(str);
	}

	// �����ֶΣ�private int age;
	@Test
	public void test3() throws Exception {
		
		String className = "zool.java.basics.reflect.Persion";

		Class clazz = Class.forName(className);
		
		Constructor con = clazz.getConstructor(int.class);
		
		Persion p = (Persion) con.newInstance(30);
		
		//��ȡ˽���ֶ� private ��ȡ����Ҳ����ֱ�ӷ���
		Field field = clazz.getDeclaredField("age");
		
		//��private���η�ȥ��
		field.setAccessible(true);
		
		Object obj = field.get(p);
		Class type = field.getType();
		
		if(type.equals(int.class)) {
			int age = (int) obj;
			System.out.println(age);
		}
		
	}
	
}
