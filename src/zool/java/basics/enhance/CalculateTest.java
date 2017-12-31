package zool.java.basics.enhance;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalculateTest {

	@Test
	public void add() {
		//断言	参数1，期望的值,参数2方法运行完返回的值，如果和期望的值相同，就测试成功
		//assertEquals(5, new Calculate().divide(10, 2));
		//assertArrayEquals(new int[] {1,2,3}, new int [] {1,2,3});
		
		assertTrue("错误测试不通过",new Calculate().junit5());
	}
	
}
