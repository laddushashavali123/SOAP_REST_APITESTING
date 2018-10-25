package Rest;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class restRunner2 {
	
	/**
	 * IF YOU HAVE MULTIPLE TEST SUITES THIS NESTED FOR LOOP WILL HELP YOU TRIGGER ALL TEST SUITES AND TEST CASES
	 * 
	 * 
	 * This rest test tests a soap ui project which has two test suites. The test class uses an outer loop to go through to the first
	 *  test suite -within this there is an inner for loop which runs through all the test cases in this first test suite. When that executes
	 *  control returns to the next test suite and then goes inside inner for loop to execute all the test cases within that
	 * 
	 * @throws XmlException
	 * @throws IOException
	 * @throws SoapUIException
	 * @throws InterruptedException
	 */
	
	@Test // Runs all tests from TestSuite
	public void RestTest2() throws XmlException, IOException, SoapUIException, InterruptedException {

		// TODO Auto-generated method stub

		// Step 1. Go to project level. creating wsdl project class object- the heart of
		// any test case relating to soap ui java

		WsdlProject project = new WsdlProject("C:\\Users\\User\\Desktop\\WebServices\\LibraryAPI.xml");
		
		
		
            //2. outside for loop to grab the  test suites and put them in test suite object
			for(int j=0;j<project.getTestSuiteCount();j++)
			{
				WsdlTestSuite testsuite=	project.getTestSuiteAt(j);
			
				//3. inside for loop to get the testsuite object and loop through the test cases
				for(int i=0;i<testsuite.getTestCaseCount();i++)
				{
					WsdlTestCase testCase =testsuite.getTestCaseAt(i);
					
					//Run the testcase
					TestRunner runner=testCase.run(new PropertiesMap(), false);
					Assert.assertEquals(Status.FINISHED, runner.getStatus());
					
					
					
				}
			}
		}
	}

			
			
		
