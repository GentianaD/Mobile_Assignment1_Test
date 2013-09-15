package com.example.guc_activities.test;

import java.util.Random;

import junit.framework.Assert;
import android.app.Activity;
import android.database.Cursor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import com.example.guc_activities.RegActivity;

public class RegActivityTest extends ActivityInstrumentationTestCase2<RegActivity> {

	public RegActivityTest() {
		super("com.example.guc_activities",RegActivity.class);
	}
	Activity objActivity;
	protected void setUp() throws Exception {
		super.setUp();
		objActivity=getActivity();
	}

	public void testSend()
	{
		final Button button=(Button)objActivity.findViewById(com.example.guc_activities.R.id.btnRegisterHangout);
		String sql="Select count () as COUNT from Hangouts";
		Cursor cr=((RegActivity)objActivity).db.rawQuery(sql, null);
		
        		

		cr.moveToNext();
		int res=cr.getInt(cr.getColumnIndex("COUNT"));
		
		objActivity.runOnUiThread(new Runnable() 
		{          
			public void run() 
			{              
				button.performClick();  
				
			}      
		});
		getInstrumentation().waitForIdleSync();
		Cursor cr2;
		
		cr2=((RegActivity)objActivity).db.rawQuery(sql, null);
		cr2.moveToNext();
		int res2=cr2.getInt(cr2.getColumnIndex("COUNT"));
		
		Assert.assertEquals(res+1, res2);
	}
}
