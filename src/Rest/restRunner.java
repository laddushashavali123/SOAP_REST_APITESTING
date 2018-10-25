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

public class restRunner {
	
	/**
	 * This is the code to run all tests in a REST test suite. It is the same code as for running a test suite in SOAP
	 * @throws XmlException
	 * @throws IOException
	 * @throws SoapUIException
	 * @throws InterruptedException
	 */

	@Test // Runs all tests from TestSuite which are REST
	public void RestTest() throws XmlException, IOException, SoapUIException, InterruptedException {

		// TODO Auto-generated method stub

		// Step 1. Go to project level. creating wsdl project class object- the heart of
		// any test case relating to soap ui java

		WsdlProject wsdl = new WsdlProject("C:\\Users\\User\\Desktop\\WebServices\\LibraryAPI.xml");

		// Step 2. Accessing test suite level accessing the test suite and storing in
		// variable

		WsdlTestSuite testsuite = wsdl.getTestSuiteByName("Testing");

		// Step 3. Executing all test cases by looping through all the test cases in the
		// test suite "Testing"
		// So this for loop will help to execute and validate
		// all the test cases in this test suite

		for (int i = 0; i < testsuite.getTestCaseCount(); i++) {

			// get the first test case at 0th index and on second loop will go to second
			// test case as we are incrementing by writing i++

			WsdlTestCase testCase = testsuite.getTestCaseAt(i);

			// properties can be driven from the Java but not recommended to do this- better
			// to do this in Soap UI so importing the properties from TestRunner SOAP UI
			// into this variable and running

			TestRunner runner = testCase.run(new PropertiesMap(), false);

			// validating that the expected status of finished/passed matches the runner get
			// status of passed
			// but assertequals has been deprecated in Java so will need TestNG
			Assert.assertEquals(Status.FINISHED, runner.getStatus());

		}

	}

}
