package zool.java.basics.reflect;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

//解剖类的构造函数，创建类的对象
public class Demo2 {

	// 反射构造函数：public Persion()
	@Test
	public void test1() throws Exception {
		String className = "zool.java.basics.reflect.Persion";
		// 获取类的字节码文件
		Class clazz = Class.forName(className);
		// 获取这个类的构造方法
		Constructor con = clazz.getConstructor(null);
		// 通过空参数的构造函数创建类的对象
		Persion p = (Persion) con.newInstance(null);
	}

	// 反射构造函数：public Persion(String name)
	@Test
	public void test2() throws Exception {
		String className = "zool.java.basics.reflect.Persion";
		// 获取类的字节码文件
		Class clazz = Class.forName(className);

		// 获取这个类参数类型是一个String的构造方法
		Constructor con = clazz.getConstructor(String.class);

		// 通过上面获取到的构造函数，来创建带参数的对象
		Persion p = (Persion) con.newInstance("Hello");
	}

	// 反射构造函数：public Persion(String name ,int age)
	@Test
	public void test3() throws Exception {

		String className = "zool.java.basics.reflect.Persion";
		// 获取类的字节码文件
		Class clazz = Class.forName(className);

		// 获取这个类参数类型是一个String的构造方法
		Constructor con = clazz.getConstructor(String.class, int.class);

		// 通过上面获取到的构造函数，来创建带参数的对象
		Persion p = (Persion) con.newInstance("Hello", 20);
	}

	// 反射构造函数：private Persion(List list) 私有的
	@Test
	public void test4() throws Exception {

		String className = "zool.java.basics.reflect.Persion";
		// 获取类的字节码文件
		Class clazz = Class.forName(className);
		//获取私有的构造函数
		Constructor con = clazz.getDeclaredConstructor(List.class);
		//暴力反射
		con.setAccessible(true);
		Persion p = (Persion) con.newInstance(new ArrayList<>());
	}

	//创建空参数的构造函数简写格式
	@Test
	public void test5() throws Exception {
		String className = "zool.java.basics.reflect.Persion";
		Class clazz = Class.forName(className);
		//调用的是无参的构造函数
		Persion p = (Persion) clazz.newInstance();
	}
	
}
