package com.example.nusu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebView_activity extends Activity {

	WebView view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		Intent i = getIntent();
		String url = i.getStringExtra("link");
		//String url="https://blackboard.ncl.ac.uk/webapps/portal/frameset.jsp";
		view=(WebView) findViewById(R.id.web);
		view.getSettings().setJavaScriptEnabled(true);
		view.getSettings().setBuiltInZoomControls(true);
		view.setWebViewClient(new WebViewClient());
		view.getSettings().setBuiltInZoomControls(true);
		view.loadUrl(url);
	}
	
}
