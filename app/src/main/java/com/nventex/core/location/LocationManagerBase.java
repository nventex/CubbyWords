package com.nventex.core.location;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;

public class LocationManagerBase {
    private final Activity activity;
    private final LocationListenerBase locationListener;
    private final LocationManager locationManager;
    private final String provider;

    public LocationManagerBase(LocationListenerBase locationListener, String provider, Activity activity) {
        this.locationListener = locationListener;
        this.provider = provider;
        this.activity = activity;
        this.locationManager = (LocationManager) this.activity.getSystemService("location");
    }

    public void StartListening() {
        this.locationManager.requestLocationUpdates("gps", 0, 0.0f, this.locationListener);
    }

    public void StopListening() {
        if (this.locationManager != null) {
            this.locationManager.removeUpdates(this.locationListener);
        }
    }

    public Location GetRecentLocation() {
        return this.locationManager.getLastKnownLocation(this.provider);
    }

    public void UpdateSingleRequest() {
        this.locationManager.requestSingleUpdate(this.provider, this.locationListener, null);
    }
}
