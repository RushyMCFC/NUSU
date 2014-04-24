package com.example.nusu;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class News extends Activity{

	private News local_obj;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);
		local_obj=this;
		RSS rsstask =new RSS();
		rsstask.execute("http://www.nusu.co.uk/rss/newsfeed.php");
		
		
	}
	
	private class RSS extends AsyncTask<String,Void,List<RssObject>>{

		@Override
		protected List<RssObject> doInBackground(String... params) {
			// TODO Auto-generated method stub
			try{
				RssReader r=new RssReader(params[0]);
				
				return r.items();
				
			}catch(Exception e){
				
			}
			return null;
		}

		@Override
		protected void onPostExecute(List<RssObject> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			ListView lst=(ListView)findViewById(R.id.listView1);
			ArrayAdapter<RssObject> adap=new ArrayAdapter<RssObject>(local_obj,android.R.layout.simple_list_item_1,result);
			lst.setAdapter(adap);
			lst.setOnItemClickListener(new ListAdapter(result,local_obj));
		}
		
	}
}
