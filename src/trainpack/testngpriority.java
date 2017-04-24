package trainpack;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testngpriority {
	
	


	@BeforeTest
	public void test2() {
		System.out.println("p2");
	}

	@BeforeClass
	public void test3() {
		System.out.println("p3");
	}

	

	@Test(priority=0)
	public void test5() {
		System.out.println("p5");
	}
	@Test(priority=1)
	public void test10() {
		System.out.println("10");
	}
	@Test(priority=2)
	public void test11() {
		System.out.println("11");
	}
    
	@BeforeSuite
	public void test1() {
		System.out.println("p1");
	}
	
	@AfterMethod
	public void test6() {
		System.out.println("p6");
	}

	@AfterClass
	public void test7() {
		System.out.println("p7");
	}

	@AfterTest
	public void test8() {
		System.out.println("p8");
	}
	
	@BeforeMethod
	public void test4() {
		System.out.println("p4");
	}

	@AfterSuite
	public void test9() {
		System.out.println("p9");
	}
	

}
