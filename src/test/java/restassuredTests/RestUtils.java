package restassuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	 public static String getName()
	 {
		 String generateName = RandomStringUtils.randomAlphabetic(1);
		 return ("Zain"+generateName);
	 }
	 
	 public static String getJob()
	 {
		 String generateJob = RandomStringUtils.randomAlphabetic(1);
		 return ("Job"+generateJob);
	 }
	 
	 public static String getEmpSalary()
	 {
		 String generateSalary = RandomStringUtils.randomNumeric(6);
		 return generateSalary;
	 }

}
