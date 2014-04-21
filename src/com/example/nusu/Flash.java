package com.example.nusu;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Flash extends Activity {

	@Override
	protected void onCreate(Bundle image) {
		// TODO Auto-generated method stub
		super.onCreate(image);
		setContentView(R.layout.flashfirst);
		
		Parse.initialize(this, "4sBrHygjOI6X0zmbhoVA0AIuTwH22039INo2NbKb", "y5lCUAXPz72Te4wUV7mtLXQcVdLge2KuKrHIXYv5");
		ParseObject testObject = new ParseObject("TestObject");
		testObject.put("foo", "bar");
		testObject.saveInBackground();
		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(2000);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					Intent openStart = new Intent("com.example.nusu.STARTINGPOINT");
					startActivity(openStart);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
