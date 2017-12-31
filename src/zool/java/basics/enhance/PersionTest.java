package zool.java.basics.enhance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersionTest {
	
	private Persion p;
	
	//在测试之前运行,一般用来初始化资源
	@Before
	public void before() {
		p = new Persion();
		System.out.println("每个测试方法运行之前运行");
	}
	
	@Test
	public void testRun() {
		p.run();
	}

	@Test
	public void testEat() {
		p.eat();
	}
	
	//在测试之后运行,一般用来释放资源
	@After
	public void after(){
		System.out.println("每个测试方法运行之后运行");
		p = null;
	}
	
}
