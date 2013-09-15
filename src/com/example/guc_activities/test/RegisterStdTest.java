package com.example.guc_activities.test;

import java.util.Random;

import junit.framework.Assert;
import android.app.Activity;
import android.database.Cursor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

import com.example.guc_activities.RegisterStd;

public class RegisterStdTest extends ActivityInstrumentationTestCase2<RegisterStd> {

	Activity objActivity;
	public RegisterStdTest() {
		super("com.example.guc_activities",RegisterStd.class);
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		objActivity=getActivity();
	}
	
	public void testSend()
	{
		Random r=new Random();
		int i=r.nextInt(180-10)+10;
		 
		final Button button=(Button)objActivity.findViewById(com.example.guc_activities.R.id.btnRegisterStudents);
		String sql="Select count () as COUNT from Students";
		Cursor cr=((RegisterStd)objActivity).db.rawQuery(sql, null);
		String query1="Insert into  Students (StudentID, StudentName, Age,Nat,Game)  values ('"+i+"','Test','123','Test','Test');";
        		

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
		((RegisterStd)objActivity).db.execSQL(query1);
		cr2=((RegisterStd)objActivity).db.rawQuery(sql, null);
		cr2.moveToNext();
		int res2=cr2.getInt(cr2.getColumnIndex("COUNT"));
		
		Assert.assertEquals((res+1),res2);
	}
	
	public void testDelete()
	{
		final EditText et=(EditText)objActivity.findViewById(com.example.guc_activities.R.id.StdID);
		objActivity.runOnUiThread(new Runnable() 
		{          
			public void run() 
			{              
				((RegisterStd)objActivity).Delete(); 
				
			}      
		});
		
		String str_et=et.getText().toString();
		
		Assert.assertEquals("", str_et);
		
	}
	


}
