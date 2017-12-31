package zool.java.basics.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

//使用内省api操作bean的属性
public class Demo1 {

	@Test
	public void test1() throws Exception {

		// 获取Persion属性，并去掉从Object中继承过来的属性
		BeanInfo beanInfo = Introspector.getBeanInfo(Persion.class, Object.class);

		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}

	}

	// 操作bean的指定属性：aeg
	@Test
	public void test2() throws Exception {

		Persion p = new Persion();

		PropertyDescriptor pd = new PropertyDescriptor("age", Persion.class);

		// 得到属性的写方法，为属性赋值
		Method methodSet = pd.getWriteMethod();// setAge(int age)

		// 得到属性的读取方法，获取属性的值
		Method methodGet = pd.getReadMethod();// getAge()

		// 运行方法，并传入值
		methodSet.invoke(p, 22);

		System.out.println(methodGet.invoke(p));

	}

	@Test
	public void test3() throws Exception {
		
		PropertyDescriptor pd = new PropertyDescriptor("age",Persion.class);
		
		Class clazz = pd.getPropertyType();
		System.out.println(clazz);
		
	}

}
