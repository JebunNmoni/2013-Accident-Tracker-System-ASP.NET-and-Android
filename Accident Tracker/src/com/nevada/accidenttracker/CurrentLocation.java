package com.nevada.accidenttracker;

import java.util.List;
import java.util.Locale;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class CurrentLocation extends MapActivity implements LocationListener {

	MapView map;
	long start, stop;
	MyLocationOverlay compass;
	MapController controller;
	int x, y;
	GeoPoint touchedPoint;
	Drawable d;
	List<Overlay> overlayList;
	LocationManager lm;
	String tower;
	int lat = 0, longi = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_current_location);

		map = (MapView) findViewById(R.id.mapCurrentLocation);
		map.setBuiltInZoomControls(true);

		Touchy t = new Touchy();
		overlayList = map.getOverlays();
		overlayList.add(t);

		compass = new MyLocationOverlay(CurrentLocation.this, map);
		overlayList.add(compass);

		controller = map.getController();
		controller.setZoom(10);
		controller.setCenter(point)

		d = getResources().getDrawable(R.drawable.marker);

		// placing pinpoint
		lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria crit = new Criteria();
		tower = lm.getBestProvider(crit,false);
		Location location = lm.getLastKnownLocation(tower);
		
		if(location != null){
			lat = (int) (location.getLatitude()*1E6);
			longi = (int) (location.getLongitude()*1E6);
			GeoPoint ourlocation = new GeoPoint(lat, longi);
			OverlayItem overlayItem = new OverlayItem(ourlocation,
					"Placed Pinpoint", "2nd String");
			CustomPinPoint custom = new CustomPinPoint(d, CurrentLocation.this);
			custom.insetPinpoint(overlayItem);
			overlayList.add(custom);
		}else{
			Toast.makeText(CurrentLocation.this, "Unable to resolve the address", Toast.LENGTH_SHORT).show();
		}
	}

	class Touchy extends Overlay {
		public boolean onTouchEvent(MotionEvent e, MapView m) {

			if (e.getAction() == MotionEvent.ACTION_DOWN) {
				start = e.getEventTime();
				x = (int) e.getX();
				y = (int) e.getY();
				touchedPoint = map.getProjection().fromPixels(x, y);
			}
			if (e.getAction() == MotionEvent.ACTION_UP) {
				stop = e.getEventTime();
			}
			if (stop - start > 1500) {
				AlertDialog alert = new AlertDialog.Builder(
						CurrentLocation.this).create();
				alert.setTitle("Pick An Option");
				alert.setMessage("Message");
				alert.setButton("Track this point",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						});
				alert.setButton2("AAA", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Geocoder geocoder = new Geocoder(getBaseContext(),
								Locale.getDefault());
						try {
							List<Address> address = geocoder.getFromLocation(
									touchedPoint.getLatitudeE6() / 1E6,
									touchedPoint.getLongitudeE6() / 1E6, 1);
							if (address.size() > 0) {
								String display = "";
								for (int i = 0; i < address.get(0)
										.getMaxAddressLineIndex(); i++) {
									display += address.get(0).getAddressLine(i)
											+ "\n";
								}
								Toast t = Toast.makeText(getBaseContext(),
										display, Toast.LENGTH_LONG);
								t.show();
							}
						} catch (Exception e) {
							e.printStackTrace();

						} finally {

						}
					}
				});
				alert.setButton3("Toggle view",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								if (map.isSatellite()) {
									map.setSatellite(false);
									map.setStreetView(true);
								} else {
									map.setStreetView(false);
									map.setSatellite(true);
								}
							}
						});
				alert.show();
				return true;
			}

			return false;

		}
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		compass.disableCompass();
		super.onPause();
		lm.removeUpdates(this);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		compass.enableCompass();
		super.onResume();
		lm.requestLocationUpdates(tower, 500, 1, this);
	}

	@Override
	public void onLocationChanged(Location l) {
		// TODO Auto-generated method stub
		lat = (int) (l.getLatitude()*1E6);
		longi = (int) (l.getLongitude()*1E6);
		GeoPoint ourlocation = new GeoPoint(lat, longi);
		OverlayItem overlayItem = new OverlayItem(ourlocation,
				"Placed Pinpoint", "2nd String");
		CustomPinPoint custom = new CustomPinPoint(d, CurrentLocation.this);
		custom.insetPinpoint(overlayItem);
		overlayList.add(custom);
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}
