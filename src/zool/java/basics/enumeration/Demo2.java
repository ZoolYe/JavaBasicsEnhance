package zool.java.basics.enumeration;

import org.junit.Test;


public class Demo2 {

	
	@Test
	public void test() {
		
		String name = Grade.A.name();//��ȡö�ٶ��������
		int index = Grade.A.ordinal();//��ȡö�ٶ����λ��
		String str = "A";
		
		Grade g = Grade.valueOf(str);//���ַ���ת��ö������
		
		System.out.println(g.name());
		
		Grade []gr = Grade.values();//��ȡö�ٵ�����ֵ
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

//ö��
enum Grade{
	
	A("100-90"){
		@Override
		public String locatValue() {
			return "��";
		}
	}
	,B("89-80"){
		@Override
		public String locatValue() {
			return "��";
		}
	}
	,C("79-70"){
		@Override
		public String locatValue() {
			return "һ��";
		}
	}
	,D("69-60"){
		@Override
		public String locatValue() {
			return "��";
		}
	}
	
	,E("59-0"){
		@Override
		public String locatValue() {
			return "δ����";
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

//�൱���õ������ģʽ���������һ����
enum A{
	A;
}

enum Demo1{
	Demo1;
}
