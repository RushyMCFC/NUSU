package com.example.nusu;

import java.net.URL;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class ListAdapter implements OnItemClickListener{

	List<RssObject> l;
	Activity a;
	
	public ListAdapter(List<RssObject> l, Activity a){
		this.l = l;
		this.a = a;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Intent openStart = new Intent(Intent.ACTION_VIEW);
		openStart.setData(Uri.parse(l.get(position).getLink()));
		a.startActivity(openStart);
	}
}
