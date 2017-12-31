package zool.java.basics.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class Demo3 {

	// ������ķ�����public void run()
	@Test
	public void test1() throws Exception {

		String className = "zool.java.basics.reflect.Persion";
		// ��ȡ�ֽ����ļ�
		Class clazz = Class.forName(className);
		// ͨ���ֽ����ļ���ȡ����������1��������������2�������Ĳ�������
		Method method = clazz.getMethod("run", null);
		//ͨ���ֽ����ļ��������󣬵��õ��ǿղ����Ĺ��캯��
		Persion p = (Persion) clazz.newInstance();
		//���з���������1��Ҫ������������Ķ��󣬲���2����������Ĳ���
		method.invoke(p, null);
	}

	// ������ķ�����public void run(String mesg,int index)
	@Test
	public void test2() throws Exception {

		String className = "zool.java.basics.reflect.Persion";
		// ��ȡ�ֽ����ļ�
		Class clazz = Class.forName(className);
		// ͨ���ֽ����ļ���ȡ����������1��������������2�������Ĳ�������
		Method method = clazz.getMethod("run", String.class, int.class);
		//ͨ���ֽ����ļ��������󣬵��õ��ǿղ����Ĺ��캯��
		Persion p = (Persion) clazz.newInstance();
		//���з���������1��Ҫ������������Ķ��󣬲���2����������Ĳ���
		method.invoke(p, "zhangsan", 20);
	}

	// ������ķ�����public Class[] run(String mesg,int[] arr)
	@Test
	public void test3() throws Exception {

		String className = "zool.java.basics.reflect.Persion";
		// ��ȡ�ֽ����ļ�
		Class clazz = Class.forName(className);
		// ͨ���ֽ����ļ���ȡ����������1��������������2�������Ĳ�������
		Method method = clazz.getMethod("run", String.class, int[].class);
		//ͨ���ֽ����ļ��������󣬵��õ��ǿղ����Ĺ��캯��
		Persion p = (Persion) clazz.newInstance();
		//���з���������1��Ҫ������������Ķ��󣬲���2����������Ĳ���
		//����ֵ��Object���� 
		Class cl[] = (Class[]) method.invoke(p, "xixixi", new int[] {1,2,3});
		System.out.println(cl[0]);
	}

	// ������ķ�����private void show(InputStream is)
	@Test
	public void test4() throws Exception {
		
		String className = "zool.java.basics.reflect.Persion";
		// ��ȡ�ֽ����ļ�
		Class clazz = Class.forName(className);
		
		Persion p = (Persion) clazz.newInstance();
		// ͨ���ֽ����ļ���ȡ����������1��������������2�������Ĳ�������  ��ȡ����private�ķ���������ֱ������
		Method method = clazz.getDeclaredMethod("show",InputStream.class);
		//��Ҫ��������private���η�ȥ�����������д˷���
		method.setAccessible(true);
		method.invoke(p, new FileInputStream("C:\\Users\\ZOOL\\Desktop\\�ʼ���ַ.txt"));
		
	}
	
	// ������ķ�����public static void function(int num)
	@Test
	public void test5() throws Exception {
		String className = "zool.java.basics.reflect.Persion";
		// ��ȡ�ֽ����ļ�
		Class clazz = Class.forName(className);
		
		Method method = clazz.getMethod("function", int.class);
		method.invoke(null,12);
	}
	
	// ������ķ�����public static void main(String[] args)
	@Test
	public void test6() throws Exception {
		
		String className = "zool.java.basics.reflect.Persion";
		// ��ȡ�ֽ����ļ�
		Class clazz = Class.forName(className);
		
		Method method = clazz.getMethod("main", String[].class);
		
		method.invoke(null, new Object [] { new String[] {"22","33"}});
		
	}
	
	
	
}
