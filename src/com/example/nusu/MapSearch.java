package com.example.nusu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MapSearch extends Activity {
	static final LatLng NUSU = new LatLng(54.978962, -1.614938);
	static final LatLng KINGSGATE = new LatLng(54.979015, -1.613600);
	static final LatLng SPORTSCENTRE = new LatLng(54.982607, -1.624711);
	private boolean nusub = false;
	private boolean kingsgateb = false;
	private boolean sportscentreb = false;
	private GoogleMap map;

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mapsearch);
	    
	    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
	        .getMap();
	    
	    //String x1 = getIntent().getStringExtra("positioning");
	    //int x = Integer.parseInt(x1);
	    int x = getIntent().getFlags();
	    if(x == 0)
	    	nusub = true;
	    else if(x == 1)
	    	kingsgateb = true;
	    else if(x == 2)
	    	sportscentreb = true;
	    
	      Marker nusuMarker = map.addMarker(new MarkerOptions().position(NUSU)
	          .title("Newcastle University Students' Union")
	          .visible(nusub));
	      Marker kingsgateMarker = map.addMarker(new MarkerOptions().position(KINGSGATE)
		          .title("King's Gate")
		          .visible(kingsgateb));
	      Marker sportscentreMarker = map.addMarker(new MarkerOptions().position(SPORTSCENTRE)
		          .title("Newcastle University Sports Centre")
		          .visible(sportscentreb));
	      
	      if(x == 0)
	    	  map.moveCamera(CameraUpdateFactory.newLatLngZoom(NUSU, 5));
	      else if(x == 1)
	    	  map.moveCamera(CameraUpdateFactory.newLatLngZoom(KINGSGATE, 5));
	      else if(x == 2)
	    	  map.moveCamera(CameraUpdateFactory.newLatLngZoom(SPORTSCENTRE, 5));
	      
	      map.animateCamera(CameraUpdateFactory.zoomTo(17),2000,null);
	      
	      /**Location x = map.getMyLocation();
	      LatLng newLatLng = new LatLng(x.getLatitude(), x.getLongitude());
	      map.moveCamera(CameraUpdateFactory.newLatLngZoom(newLatLng, 15));
	      map.animateCamera(CameraUpdateFactory.zoomTo(10),2000,null);*/
	      
	      map.setMyLocationEnabled(true);
	      
	  }
}
