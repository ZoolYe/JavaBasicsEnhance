package zool.java.basics.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class Demo4 {

	// 反射字段：public String name;
	@Test
	public void test1() throws Exception {

		String className = "zool.java.basics.reflect.Persion";

		Class clazz = Class.forName(className);

		// 通过字节码文件获取构造函数，参数：构造函数的参数类型
		Constructor con = clazz.getConstructor(String.class);

		// 通过构造函数来创建对象，并给构造函数传值
		Persion p = (Persion) con.newInstance("杭州新中大");

		// 通过字节码文件获取字段
		Field field = clazz.getField("name");
		// 通过get获取字段的值，参数：传入对象(要获取那个对象的字段的值)
		Object obj = field.get(p);
		// 获取这个字段的类型，因为java中都是以类存在的所以要用class接收
		Class type = field.getType();

		String str = null;
		if (type.equals(String.class)) {
			str = (String) obj;
		}
		System.out.println(str);
	}

	// 反射字段：public String name;
	@Test
	public void test2() throws Exception {

		String className = "zool.java.basics.reflect.Persion";

		Class clazz = Class.forName(className);

		// 通过字节码文件获取构造函数，参数：构造函数的参数类型
		Constructor con = clazz.getConstructor(String.class);

		// 通过构造函数来创建对象，并给构造函数传值
		Persion p = (Persion) con.newInstance("杭州新中大");

		// 通过字节码文件获取字段
		Field field = clazz.getField("name");
		
		//设置字段的值，参数1：要设置值的对象，要设置的值
		field.set(p, "富通天下");
		
		// 通过get获取字段的值，参数：传入对象(要获取那个对象的字段的值)
		Object obj = field.get(p);
		// 获取这个字段的类型，因为java中都是以类存在的所以要用class接收
		Class type = field.getType();

		String str = null;
		if (type.equals(String.class)) {
			str = (String) obj;
		}
		System.out.println(str);
	}

	// 反射字段：private int age;
	@Test
	public void test3() throws Exception {
		
		String className = "zool.java.basics.reflect.Persion";

		Class clazz = Class.forName(className);
		
		Constructor con = clazz.getConstructor(int.class);
		
		Persion p = (Persion) con.newInstance(30);
		
		//获取私有字段 private 获取到了也不能直接访问
		Field field = clazz.getDeclaredField("age");
		
		//将private修饰符去掉
		field.setAccessible(true);
		
		Object obj = field.get(p);
		Class type = field.getType();
		
		if(type.equals(int.class)) {
			int age = (int) obj;
			System.out.println(age);
		}
		
	}
	
}
