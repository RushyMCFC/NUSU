package com.example.nusu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Contact extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		Button button = (Button) findViewById(R.id.sendButton);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String message = "Name :- "+((EditText)(findViewById(R.id.name))).getText().toString();
				message+="\n\nEmail :- "+((EditText)(findViewById(R.id.email))).getText().toString();
				message+="\n\nEnquiry :- "+((EditText)(findViewById(R.id.enquiry))).getText().toString()+"\n\n";
				Intent email = new Intent(Intent.ACTION_SEND);
				email.putExtra(Intent.EXTRA_EMAIL, new String[]{"rushymcfc@gmail.com"});		  
				email.putExtra(Intent.EXTRA_SUBJECT, "Enquiry");
				email.putExtra(Intent.EXTRA_TEXT, message);
				email.setType("message/rfc822");
				startActivity(Intent.createChooser(email, "Choose an Email client :"));
			}
		});
	}
}
