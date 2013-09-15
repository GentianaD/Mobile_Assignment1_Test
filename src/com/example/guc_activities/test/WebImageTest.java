package com.example.guc_activities.test;

import junit.framework.Assert;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;

import com.example.guc_activities.WebImage;

public class WebImageTest extends ActivityInstrumentationTestCase2<WebImage> {

	public WebImageTest() {
		super("com.example.guc_activities",WebImage.class);
	}
		Activity objActivity;
	protected void setUp() throws Exception {
		super.setUp();
		objActivity=getActivity();
	}
	public void testImage()
	{
		ImageView img=(ImageView)objActivity.findViewById(com.example.guc_activities.R.id.imageView1);
		Assert.assertNotNull(img);
	}

}
