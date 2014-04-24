package com.example.nusu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activities extends ListActivity {

	String names[] = {"Athletic Union", "Societies", "Give It A Go", "Go Play!"};
	String links[] = {"http://www.nusu.co.uk/au", "http://www.nusu.co.uk/soc", "http://www.nusu.co.uk/giag", "http://www.nusu.co.uk/goplay"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Activities.this, android.R.layout.simple_list_item_1 ,names));
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent openStart = new Intent(Activities.this, WebView_activity.class);
		openStart.putExtra("link", links[position]);
		startActivity(openStart);
	}

}
