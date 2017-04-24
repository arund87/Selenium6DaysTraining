package trainpack;
import org.testng.annotations.Test;

public class testnggroup {
	
	@Test(groups = { "sanity" })
	public void testngtest() {
		System.out.println("sanity1");
	}

	@Test(groups = { "regression" })
	public void testngtest1() {
		System.out.println("regression1");
	}

	@Test(groups = { "regression" })
	public void testngtest2() {
		System.out.println("regression2");
	}

	@Test(groups = { "sanity" })
	public void testngtest3() {
		System.out.println("sanity2");
	}

}
