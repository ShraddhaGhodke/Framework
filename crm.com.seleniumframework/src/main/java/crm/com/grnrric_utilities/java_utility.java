package crm.com.grnrric_utilities;

import java.util.Random;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class java_utility {

	public int getRanDomNum()
	{
		Random ran=new Random();
		int RanNum=ran.nextInt(1000);
		
		return RanNum;
		
	}
}
