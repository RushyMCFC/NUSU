package com.example.nusu;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Entry extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entry);
		// TODO Auto-generated method stub
		Button entryb;
		EditText u = (EditText) findViewById(R.id.username);
		EditText p = (EditText) findViewById(R.id.password);
		final String user = u.getText().toString();
		final String pass = p.getText().toString();
		entryb = (Button) findViewById(R.id.entrybutton);
		entryb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ParseUser.logInInBackground(user, pass, new LogInCallback() {
					  public void done(ParseUser user, ParseException e) {
					    if (user != null) {
					    	Intent openStart = new Intent("com.example.nusu.MENU");
							startActivity(openStart);
					    } else {
					      Toast.makeText(getParent(), "Wrong username or password", 1000).show();
					    }
					  }
					});
				//Intent openStart = new Intent("com.example.nusu.MENU");
				//startActivity(openStart);
			}
		});
	}

}
