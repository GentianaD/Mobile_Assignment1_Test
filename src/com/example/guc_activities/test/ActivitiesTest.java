package com.example.guc_activities.test;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import com.example.guc_activities.Activities;
import com.example.guc_activities.RegActivity;
import com.example.guc_activities.ViewHangout;

public class ActivitiesTest extends ActivityInstrumentationTestCase2<Activities> {

	Activity objActivity;
	public ActivitiesTest() {
		super("com.example.guc_activities",Activities.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		objActivity=getActivity();
	}
	
	
	
	public void testViewHangout() {
		  // register next activity that need to be monitored.
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ViewHangout.class.getName(), null, false);

		  // open current activity.
		  // myActivity = getActivity();
		  final Button button = (Button) objActivity.findViewById(com.example.guc_activities.R.id.btnViewHangouts);
		  objActivity.runOnUiThread(new Runnable() {
		    @Override
		    public void run() {
		      // click button and open next activity.
		      button.performClick();
		    }
		  });

		  Activity viewhangout = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 500);
		  // next activity is opened and captured.
		  assertNotNull(viewhangout);
		  viewhangout .finish();
		}
	
	public void testRegActivity() {
		  // register next activity that need to be monitored.
		
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(RegActivity.class.getName(), null, false);

		  // open current activity.
		  // myActivity = getActivity();
		  final Button button = (Button) objActivity.findViewById(com.example.guc_activities.R.id.btnCreateHangouts);
		  objActivity.runOnUiThread(new Runnable() {
		    @Override
		    public void run() {
		      // click button and open next activity.
		      button.performClick();
		    }
		  });

		  Activity createhangout = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 500);
		  // next activity is opened and captured.
		  assertNotNull(createhangout);
		  createhangout.finish();
		}
	

}
