package com.example.nusu;

import java.util.Locale;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Entry extends Activity{
	
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	EditText u;
	EditText p;
	String user;
	String pass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entry);
		onCreateParse();
		ParseAnalytics.trackAppOpened(getIntent());
		cd = new ConnectionDetector(getApplicationContext());
		// TODO Auto-generated method stub
		Button entryb;
		u = (EditText) findViewById(R.id.username);
		p = (EditText) findViewById(R.id.password);
		entryb = (Button) findViewById(R.id.entrybutton);
		entryb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				isInternetPresent = cd.isConnectingToInternet();
				
				if(isInternetPresent)
					attemptLogin();
				else
					showAlertDialog(Entry.this, "No Internet Connection",
							"You don't have internet connection.", false);
				
				
				
				
				
				/**ParseUser.logInInBackground(user, pass, new LogInCallback() {
					  public void done(ParseUser user, ParseException e) {
					    if (user != null) {
					    	Intent openStart = new Intent(Entry.this, Menu.class);
							startActivity(openStart);
					    } else {
					      Toast.makeText(getParent(), "Wrong username or password", 1000).show();
					    }
					  }
					});*/
				//Intent openStart = new Intent("com.example.nusu.MENU");
				//startActivity(openStart);
			}

		});
	}
	
	public void showAlertDialog(Entry entry, String string,
			String string2, boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void attemptLogin() {
		clearErrors();
		// TODO Auto-generated method stub
		
		user = u.getText().toString();
		pass = p.getText().toString();
		
		boolean cancel = false;
		View focusView = null;
		if (TextUtils.isEmpty(pass)) {
			p.setError(getString(R.string.error_field_required));
			focusView = p;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(user)) {
			u.setError(getString(R.string.error_field_required));
			focusView = u;
			cancel = true;
		}
		
		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			// perform the user login attempt.
			login(user.toLowerCase(Locale.getDefault()), pass);
		}

	}
	
	private void login(String lowerCase, String pass2) {
		// TODO Auto-generated method stub
		ParseUser.logInInBackground(user, pass, new LogInCallback() {
			@Override
			public void done(ParseUser user, ParseException e) {
				// TODO Auto-generated method stub
				if(e == null)
					loginSuccessful();
				else
					loginUnSuccessful();
			}
		});
	}
	protected void loginSuccessful() {
		// TODO Auto-generated method stub
		Intent in =  new Intent(Entry.this,Menu.class);
		startActivity(in);
	}
	protected void loginUnSuccessful() {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "Username or Password is invalid, Try Again!", Toast.LENGTH_SHORT).show();
		//showAlertDialog(Entry.this,"Login", "Username or Password is invalid.", false);
	}
	
	private void clearErrors(){
		u.setError(null);
		p.setError(null);
	}

	public void onCreateParse() { 
		Parse.initialize(this, "4sBrHygjOI6X0zmbhoVA0AIuTwH22039INo2NbKb", "y5lCUAXPz72Te4wUV7mtLXQcVdLge2KuKrHIXYv5"); 
	}

}
