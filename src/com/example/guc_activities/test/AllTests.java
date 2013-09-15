package com.example.guc_activities.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(ActivitiesTest.class);
		suite.addTestSuite(Activity1Test.class);
		suite.addTestSuite(RegActivityTest.class);
		suite.addTestSuite(RegisterStdTest.class);
		suite.addTestSuite(ViewStdTest.class);
		suite.addTestSuite(WebImageTest.class);
		//$JUnit-END$
		return suite;
	}

}
