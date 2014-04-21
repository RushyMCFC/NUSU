package com.example.nusu;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class Menu extends Activity{

	ImageButton news;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
        news = (ImageButton) findViewById(R.id.news);
        news.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openStart = new Intent("com.example.nusu.NEWS");
				startActivity(openStart);
			}
		});
    }
}
