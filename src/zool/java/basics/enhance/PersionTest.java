package zool.java.basics.enhance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersionTest {
	
	private Persion p;
	
	//�ڲ���֮ǰ����,һ��������ʼ����Դ
	@Before
	public void before() {
		p = new Persion();
		System.out.println("ÿ�����Է�������֮ǰ����");
	}
	
	@Test
	public void testRun() {
		p.run();
	}

	@Test
	public void testEat() {
		p.eat();
	}
	
	//�ڲ���֮������,һ�������ͷ���Դ
	@After
	public void after(){
		System.out.println("ÿ�����Է�������֮������");
		p = null;
	}
	
}
