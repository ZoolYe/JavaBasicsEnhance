package zool.java.basics.enhance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersionTest2 {
	
	private Persion p;
	
	@BeforeClass
	public void beforeClass() {
		//ֻ����һ��
		System.out.println("����ص�ʱ������beforeClass");
		p = new Persion();
	}
	
	@Test
	public void testRun() {
		p.run();
	}

	@Test
	public void testEat() {
		p.eat();
	}
	
	@AfterClass
	public void atferClass() {
		//ֻ����һ��
		System.out.println("����ص�ʱ������atferClass");
		p = null;
	}
	
}
