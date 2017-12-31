package zool.java.basics.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class Demo3 {

	// 反射类的方法：public void run()
	@Test
	public void test1() throws Exception {

		String className = "zool.java.basics.reflect.Persion";
		// 获取字节码文件
		Class clazz = Class.forName(className);
		// 通过字节码文件获取方法，参数1：方法名，参数2：方法的参数类型
		Method method = clazz.getMethod("run", null);
		//通过字节码文件创建对象，调用的是空参数的构造函数
		Persion p = (Persion) clazz.newInstance();
		//运行方法，参数1：要运行这个方法的对象，参数2：这个方法的参数
		method.invoke(p, null);
	}

	// 反射类的方法：public void run(String mesg,int index)
	@Test
	public void test2() throws Exception {

		String className = "zool.java.basics.reflect.Persion";
		// 获取字节码文件
		Class clazz = Class.forName(className);
		// 通过字节码文件获取方法，参数1：方法名，参数2：方法的参数类型
		Method method = clazz.getMethod("run", String.class, int.class);
		//通过字节码文件创建对象，调用的是空参数的构造函数
		Persion p = (Persion) clazz.newInstance();
		//运行方法，参数1：要运行这个方法的对象，参数2：这个方法的参数
		method.invoke(p, "zhangsan", 20);
	}

	// 反射类的方法：public Class[] run(String mesg,int[] arr)
	@Test
	public void test3() throws Exception {

		String className = "zool.java.basics.reflect.Persion";
		// 获取字节码文件
		Class clazz = Class.forName(className);
		// 通过字节码文件获取方法，参数1：方法名，参数2：方法的参数类型
		Method method = clazz.getMethod("run", String.class, int[].class);
		//通过字节码文件创建对象，调用的是空参数的构造函数
		Persion p = (Persion) clazz.newInstance();
		//运行方法，参数1：要运行这个方法的对象，参数2：这个方法的参数
		//返回值是Object类型 
		Class cl[] = (Class[]) method.invoke(p, "xixixi", new int[] {1,2,3});
		System.out.println(cl[0]);
	}

	// 反射类的方法：private void show(InputStream is)
	@Test
	public void test4() throws Exception {
		
		String className = "zool.java.basics.reflect.Persion";
		// 获取字节码文件
		Class clazz = Class.forName(className);
		
		Persion p = (Persion) clazz.newInstance();
		// 通过字节码文件获取方法，参数1：方法名，参数2：方法的参数类型  获取的是private的方法，不能直接运行
		Method method = clazz.getDeclaredMethod("show",InputStream.class);
		//需要将方法的private修饰符去掉，才能运行此方法
		method.setAccessible(true);
		method.invoke(p, new FileInputStream("C:\\Users\\ZOOL\\Desktop\\邮件地址.txt"));
		
	}
	
	// 反射类的方法：public static void function(int num)
	@Test
	public void test5() throws Exception {
		String className = "zool.java.basics.reflect.Persion";
		// 获取字节码文件
		Class clazz = Class.forName(className);
		
		Method method = clazz.getMethod("function", int.class);
		method.invoke(null,12);
	}
	
	// 反射类的方法：public static void main(String[] args)
	@Test
	public void test6() throws Exception {
		
		String className = "zool.java.basics.reflect.Persion";
		// 获取字节码文件
		Class clazz = Class.forName(className);
		
		Method method = clazz.getMethod("main", String[].class);
		
		method.invoke(null, new Object [] { new String[] {"22","33"}});
		
	}
	
	
	
}
