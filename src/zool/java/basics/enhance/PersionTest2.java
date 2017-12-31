package zool.java.basics.enhance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersionTest2 {
	
	private Persion p;
	
	@BeforeClass
	public void beforeClass() {
		//只运行一次
		System.out.println("类加载的时候运行beforeClass");
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
		//只运行一次
		System.out.println("类加载的时候运行atferClass");
		p = null;
	}
	
}
