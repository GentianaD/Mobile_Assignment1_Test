package com.example.guc_activities.test;

import junit.framework.Assert;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.GridView;

//import com.example.guc_activities.RegisterStd;
import com.example.guc_activities.ViewStd;

public class ViewStdTest extends ActivityInstrumentationTestCase2<ViewStd> {

	public ViewStdTest() {
		super("com.example.guc_activities",ViewStd.class);
	}
	Activity objActivity;
	
	protected void setUp() throws Exception {
		super.setUp();
		objActivity=getActivity();
	}
	
	public void testRead()
	{
		objActivity.runOnUiThread(new Runnable() 
		{          
			public void run() 
			{              
				((ViewStd)objActivity).Read();  
				
			}      
		});
		Assert.assertEquals(8, 8);
		GridView gv=(GridView)objActivity.findViewById(com.example.guc_activities.R.id.grid1);
		//GridView gv1=((ViewStd)objActivity).DataGrid
		int i=gv.getChildCount();
		Assert.assertNotSame(0, i);
		
	}

}
