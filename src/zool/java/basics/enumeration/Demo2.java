package zool.java.basics.enumeration;

import org.junit.Test;


public class Demo2 {

	
	@Test
	public void test() {
		
		String name = Grade.A.name();//获取枚举对象的名字
		int index = Grade.A.ordinal();//获取枚举对象的位置
		String str = "A";
		
		Grade g = Grade.valueOf(str);//将字符串转成枚举类型
		
		System.out.println(g.name());
		
		Grade []gr = Grade.values();//获取枚举的所有值
		for(Grade gra : gr) {
			System.out.println(gra);
		}
	}
	
	@Test
	public void testPrint() {
		print(Grade.C);
	}
	
	public void print(Grade g) {
		//System.out.println(g.getValue());
		System.out.println(g.locatValue());
	}
	
}

//枚举
enum Grade{
	
	A("100-90"){
		@Override
		public String locatValue() {
			return "好";
		}
	}
	,B("89-80"){
		@Override
		public String locatValue() {
			return "良";
		}
	}
	,C("79-70"){
		@Override
		public String locatValue() {
			return "一般";
		}
	}
	,D("69-60"){
		@Override
		public String locatValue() {
			return "差";
		}
	}
	
	,E("59-0"){
		@Override
		public String locatValue() {
			return "未及格";
		}
	};
	
	private String value;
	
	private Grade(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public abstract String locatValue();
	
}

//相当于用单列设计模式定义出来了一个类
enum A{
	A;
}

enum Demo1{
	Demo1;
}
