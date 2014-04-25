package com.example.nusu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MapSearchMenu extends ListActivity {
	
	String names[] = {"Newcastle University Students' Union", "King's Gate", "Newcastle University Sports Centre"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(MapSearchMenu.this, android.R.layout.simple_list_item_1 ,names));
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent openStart = new Intent(MapSearchMenu.this, MapSearch.class);
		//openStart.putExtra("positioning", position);
		openStart.addFlags(position);
		startActivity(openStart);
	}
	
}
