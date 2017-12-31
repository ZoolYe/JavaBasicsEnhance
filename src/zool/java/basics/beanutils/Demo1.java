package zool.java.basics.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.jupiter.api.Test;

//ʹ��beanUtils����bean������(������)
public class Demo1 {

	@Test
	public void test1() throws Exception {

		Persion p = new Persion();

		// ��������ֵ������1��Bean���󣬲���2��������������3������ֵ
		BeanUtils.setProperty(p, "name", "�������д�");

		System.out.println(p.getName());
	}

	@Test
	public void test2() throws Exception {

		String name = "����";
		String password = "123456";
		double age = 30.99;// ת��ֻ֧��8�ֻ�����������

		String date = "2017-12-22";// ��֧�ֵ���������

		Persion p = new Persion();

		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);

		// BeanUtils�Զ�������ݽ���׼��
		BeanUtils.setProperty(p, "age", age);

		// BeanUtils.setProperty(p, "birthday",date);//������Ч��ת���쳣

		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getPassword());
		System.out.println(p.getBirthday());
	}

	@Test
	public void test3() throws Exception {

		String name = "����";
		String password = "123456";
		double age = 30.99;// ת��ֻ֧��8�ֻ�����������

		// Ϊ���������ܸ�ֵ��Bean��birthday�����ϣ���Ҫ��BeanUtilsע��һ������ת����
		String date = "2017-12-12";// ��֧�ֵ���������
		// ��Ҫ��BeanUtilsע��һ������ת����
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class type, Object value) {
				if (!(value == null) && (value instanceof String)) {
					String strTime = (String) value;
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					try {
						return df.parse(strTime);
					} catch (ParseException e) {
						throw new RuntimeException("����ת��ʧ��");
					}
				} else {
					throw new ConversionException("ת��ʧ�ܣ��������ݸ�ʽ������");
				}
			}
		}, Date.class);

		Persion p = new Persion();

		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);

		// BeanUtils�Զ�������ݽ���׼��
		BeanUtils.setProperty(p, "age", age);

		BeanUtils.setProperty(p, "birthday", date);

		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getPassword());
		System.out.println(p.getBirthday());
	}

	@Test
	public void test4() throws Exception {

		String name = "����";
		String password = "123456";
		double age = 30.99;// ת��ֻ֧��8�ֻ�����������

		// Ϊ���������ܸ�ֵ��Bean��birthday�����ϣ���Ҫ��BeanUtilsע��һ������ת����
		String date = "";// ��֧�ֵ���������
		// ��Ҫ��BeanUtilsע��һ������ת����
		ConvertUtils.register(new DateLocaleConverter(), Date.class);

		Persion p = new Persion();

		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);

		// BeanUtils�Զ�������ݽ���׼��
		BeanUtils.setProperty(p, "age", age);

		BeanUtils.setProperty(p, "birthday", date);

		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getPassword());
		System.out.println(p.getBirthday());
	}

	@Test
	public void test5() throws Exception {

		Map map = new HashMap<>();
		map.put("name", "zool");
		map.put("password", "123");
		map.put("age", "23");
		//��Ҫ�������ַ���ת��������
		map.put("birthday", "2017-12-12");
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		Persion p = new Persion();
		
		//��map�����е����ݣ����Bean������
		BeanUtils.populate(p, map);
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getPassword());
		System.out.println(p.getBirthday());
		
	}
	
}
