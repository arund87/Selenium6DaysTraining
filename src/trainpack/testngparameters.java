package trainpack;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testngparameters {
	@Test
	@Parameters("Name")
	public void testngtest(String Name)
	{
		System.out.println(Name);
	}

}
