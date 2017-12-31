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

//使用beanUtils操纵bean的属性(第三方)
public class Demo1 {

	@Test
	public void test1() throws Exception {

		Persion p = new Persion();

		// 设置属性值，参数1：Bean对象，参数2：属性名，参数3：属性值
		BeanUtils.setProperty(p, "name", "杭州新中大");

		System.out.println(p.getName());
	}

	@Test
	public void test2() throws Exception {

		String name = "张三";
		String password = "123456";
		double age = 30.99;// 转换只支持8种基本数据类型

		String date = "2017-12-22";// 不支持的数据类型

		Persion p = new Persion();

		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);

		// BeanUtils自动会把数据进行准换
		BeanUtils.setProperty(p, "age", age);

		// BeanUtils.setProperty(p, "birthday",date);//报错，无效的转换异常

		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getPassword());
		System.out.println(p.getBirthday());
	}

	@Test
	public void test3() throws Exception {

		String name = "张三";
		String password = "123456";
		double age = 30.99;// 转换只支持8种基本数据类型

		// 为了让日期能赋值到Bean的birthday属性上，需要给BeanUtils注册一个日期转换器
		String date = "2017-12-12";// 不支持的数据类型
		// 需要给BeanUtils注册一个日期转换器
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class type, Object value) {
				if (!(value == null) && (value instanceof String)) {
					String strTime = (String) value;
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					try {
						return df.parse(strTime);
					} catch (ParseException e) {
						throw new RuntimeException("日期转换失败");
					}
				} else {
					throw new ConversionException("转换失败，日期数据格式不正常");
				}
			}
		}, Date.class);

		Persion p = new Persion();

		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);

		// BeanUtils自动会把数据进行准换
		BeanUtils.setProperty(p, "age", age);

		BeanUtils.setProperty(p, "birthday", date);

		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getPassword());
		System.out.println(p.getBirthday());
	}

	@Test
	public void test4() throws Exception {

		String name = "张三";
		String password = "123456";
		double age = 30.99;// 转换只支持8种基本数据类型

		// 为了让日期能赋值到Bean的birthday属性上，需要给BeanUtils注册一个日期转换器
		String date = "";// 不支持的数据类型
		// 需要给BeanUtils注册一个日期转换器
		ConvertUtils.register(new DateLocaleConverter(), Date.class);

		Persion p = new Persion();

		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);

		// BeanUtils自动会把数据进行准换
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
		//需要将日期字符串转换成日期
		map.put("birthday", "2017-12-12");
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		Persion p = new Persion();
		
		//将map集合中的数据，填充Bean的属性
		BeanUtils.populate(p, map);
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getPassword());
		System.out.println(p.getBirthday());
		
	}
	
}
