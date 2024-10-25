package com.fkereki.mvpproject.client.map1;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;

public class MapPresenter
    extends Presenter<MapDisplay> {

  public static String PLACE = "map";

  public MapPresenter(
      final String params, final MapDisplay mapDisplay,
      final Environment environment) {

    super(params, mapDisplay, environment);
  }
}
