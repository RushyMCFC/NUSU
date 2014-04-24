package com.example.nusu;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class Menu extends Activity{

	ImageButton news;
	ImageButton blackboard;
	ImageButton email;
	ImageButton contact;
	ImageButton events;
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
				Intent openStart = new Intent("com.example.nusu.MAPSEARCH");
				startActivity(openStart);
			}
		});
        
        blackboard = (ImageButton) findViewById(R.id.blackboard);
        blackboard.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/**Uri uri = Uri.parse("https://blackboard.ncl.ac.uk/webapps/portal/frameset.jsp");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);*/
				Intent openStart = new Intent(Menu.this, WebView_activity.class);
				openStart.putExtra("link", "https://blackboard.ncl.ac.uk/webapps/portal/frameset.jsp");
				startActivity(openStart);
			}
		});
        
        email = (ImageButton) findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/**Uri uri = Uri.parse("https://adfs.ncl.ac.uk/adfs/ls/?wa=wsignin1.0&wtrealm=urn:federation:MicrosoftOnline&wctx=wa%3Dwsignin1.0%26rpsnv%3D3%26ct%3D1398115288%26rver%3D6.1.6206.0%26wp%3DMBI_KEY%26wreply%3Dhttps:%252F%252Fwww.outlook.com%252Fowa%252F%26id%3D260563%26whr%3Dnewcastle.ac.uk%26CBCXT%3Dout%26vv%3D2000");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);*/
				Intent openStart = new Intent(Menu.this, WebView_activity.class);
				openStart.putExtra("link", "https://adfs.ncl.ac.uk/adfs/ls/?wa=wsignin1.0&wtrealm=urn:federation:MicrosoftOnline&wctx=wa%3Dwsignin1.0%26rpsnv%3D3%26ct%3D1398115288%26rver%3D6.1.6206.0%26wp%3DMBI_KEY%26wreply%3Dhttps:%252F%252Fwww.outlook.com%252Fowa%252F%26id%3D260563%26whr%3Dnewcastle.ac.uk%26CBCXT%3Dout%26vv%3D2000");
				startActivity(openStart);
			}
		});
        
        contact = (ImageButton) findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openStart = new Intent("com.example.nusu.CONTACT");
				startActivity(openStart);
			}
		});
        
        events = (ImageButton) findViewById(R.id.events);
        events.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openStart = new Intent("com.example.nusu.EVENTS");
				startActivity(openStart);
			}
		});
    }
}
