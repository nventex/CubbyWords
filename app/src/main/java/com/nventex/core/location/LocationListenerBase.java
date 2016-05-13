package com.nventex.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public abstract class LocationListenerBase implements LocationListener {
    public abstract void onLocationChanged(Location location);

    public abstract void onProviderDisabled(String str);

    public abstract void onProviderEnabled(String str);

    public abstract void onStatusChanged(String str, int i, Bundle bundle);
}
