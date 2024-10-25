package com.fkereki.mvpproject.client.map1;

import com.fkereki.mvpproject.client.Display;

public interface MapDisplay
    extends Display {

  double getLatitude();

  double getLongitude();

  void setCoordinates(double latitude, double longitude);
}
