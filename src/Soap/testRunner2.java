package Soap;
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

public class testRunner2 {
	
	/**
	 * Running a SINGLE SOAP test from the test suite
	 * @throws XmlException
	 * @throws IOException
	 * @throws SoapUIException
	 */
	
	
	@Test
	public void singleTest() throws XmlException, IOException, SoapUIException {
		
		WsdlProject wsdl = new WsdlProject("C:\\Users\\User\\Desktop\\WebServices\\Employeeagain-soapui-project.xml");

		// Step 2. Accessing test suite level accessing the test suite and storing in
		// variable

		WsdlTestSuite testsuite = wsdl.getTestSuiteByName("Testing");
		
		
		//running just a single test case from test suite and bringing in wsdl test case functionality
		
		WsdlTestCase testCase=testsuite.getTestCaseByName("GetEmployee");
		
		// properties can be driven from the Java but not recommended to do this- better
		// to do this in Soap UI so importing the properties from TestRunner SOAP UI into this variable and running
		
		TestRunner runner=testCase.run(new PropertiesMap(), false);

		
		//validating that the expected status of finished/passed matches the runner get status of passed
		//but assertequals has been deprecated in Java so will need TestNG
		Assert.assertEquals(Status.FINISHED, runner.getStatus());

	}
	}


