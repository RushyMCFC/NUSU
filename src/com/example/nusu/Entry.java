package com.example.nusu;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Entry extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Button entryb;
		EditText u = (EditText) findViewById(R.id.username);
		EditText p = (EditText) findViewById(R.id.password);
		final String user = u.getText().toString();
		final String pass = p.getText().toString();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entry);
		entryb = (Button) findViewById(R.id.entrybutton);
		entryb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openStart = new Intent("com.example.nusu.MENU");
				startActivity(openStart);
			}
		});
	}

}
