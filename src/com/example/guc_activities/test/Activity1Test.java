package com.example.guc_activities.test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import com.example.guc_activities.Activities;
import com.example.guc_activities.Activity1;
import com.example.guc_activities.RegisterStd;
import com.example.guc_activities.WebImage;

public class Activity1Test extends ActivityInstrumentationTestCase2<Activity1> {

	public Activity1Test() {
		super("com.example.guc_activities",Activity1.class);
	}
	Activity objActivity;
	protected void setUp() throws Exception {
		super.setUp();
		objActivity=getActivity();
	}
	
	public void testRegStudents() {
		objActivity=getActivity();
		//Activity1Test();
		// register next activity that need to be monitored.
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(RegisterStd.class.getName(), null, false);

		  // open current activity.
		  // myActivity = getActivity();
		  final Button button = (Button) objActivity.findViewById(com.example.guc_activities.R.id.btnStudentss);
		  objActivity.runOnUiThread(new Runnable() {
		    @Override
		    public void run() {
		      // click button and open next activity.
		      button.performClick();
		    }
		  });

		  Activity regstd = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 500);
		  // next activity is opened and captured.
		  assertNotNull(regstd);
		  regstd.finish();
		}

	public void testHangouts() {
		  // register next activity that need to be monitored.
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(Activities.class.getName(), null, false);

		  // open current activity.

		  final Button button = (Button) objActivity.findViewById(com.example.guc_activities.R.id.btnHangouts);
		  objActivity.runOnUiThread(new Runnable() {
		    @Override
		    public void run() {
		      // click button and open next activity.
		      button.performClick();
		    }
		  });

		  Activity hangout = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  // next activity is opened and captured.
		  assertNotNull(hangout);
		  hangout.finish();
		}

	public void testDownload() {
		  // register next activity that need to be monitored.
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(WebImage.class.getName(), null, false);

		  // open current activity.
		 
		  final Button button = (Button) objActivity.findViewById(com.example.guc_activities.R.id.btnHIGFoto);
		  objActivity.runOnUiThread(new Runnable() {
		    @Override
		    public void run() {
		      // click button and open next activity.
		      button.performClick();
		    }
		  });

		  Activity down = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		  // next activity is opened and captured.
		  assertNotNull(down);
		 down.finish();
		
		}

}
