package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hardassert {

@Test
public void createcustomerTest()
{
	System.out.println("step1");
	System.out.println("step2");
	Assert.assertEquals("A","B");
	System.out.println("step3");
	System.out.println("step4");
	}
@Test
public void modifyTest()
{
	System.out.println("step1");
	System.out.println("step2");
	System.out.println("step3");
	System.out.println("step4");
}
}
