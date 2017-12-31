package zool.java.basics.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

//ʹ����ʡapi����bean������
public class Demo1 {

	@Test
	public void test1() throws Exception {

		// ��ȡPersion���ԣ���ȥ����Object�м̳й���������
		BeanInfo beanInfo = Introspector.getBeanInfo(Persion.class, Object.class);

		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}

	}

	// ����bean��ָ�����ԣ�aeg
	@Test
	public void test2() throws Exception {

		Persion p = new Persion();

		PropertyDescriptor pd = new PropertyDescriptor("age", Persion.class);

		// �õ����Ե�д������Ϊ���Ը�ֵ
		Method methodSet = pd.getWriteMethod();// setAge(int age)

		// �õ����ԵĶ�ȡ��������ȡ���Ե�ֵ
		Method methodGet = pd.getReadMethod();// getAge()

		// ���з�����������ֵ
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
