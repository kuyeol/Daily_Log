package com.fkereki.mvpproject.client.map1;

import com.fkereki.mvpproject.client.View;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MapView
    extends View
    implements MapDisplay {

  final VerticalPanel vp = new VerticalPanel();
  final HTML div = new HTML(
      "<div id='myveryownmap' style='height:50%;width:75%;'></div>");
  final FlexTable ft = new FlexTable();
  final TextBox lat = new TextBox();
  final TextBox lon = new TextBox();
  JavaScriptObject yahooMap = null;

  /*
   * AMNH= American Museum of Natural History, NYC
   */
  final double AMNHlat = 40.780411;
  final double AMNHlon = -73.974037;
  final String AMNHDescription = "American Museum<br/>of Natural History";

  public MapView() {
    super();

    vp.add(new InlineHTML("<h1>Interactive Map</h1>"));

    ft.setWidget(0, 0, new Label("Latitude:"));
    ft.setWidget(0, 1, lat);
    ft.setWidget(1, 0, new Label("Longitude:"));
    ft.setWidget(1, 1, lon);

    vp.add(div);
    vp.add(ft);

    initWidget(vp);
  }

  @Override
  public final double getLatitude() {
    return Double.parseDouble(lat.getValue());
  }

  @Override
  public final double getLongitude() {
    return Double.parseDouble(lon.getValue());
  }

  @Override
  public final void onAttach() {
    super.onAttach();
    yahooMapInit();
    setCoordinates(AMNHlat, AMNHlon);
    yahooMapDisplay(AMNHlat, AMNHlon, AMNHDescription);
  }

  @Override
  public final void setCoordinates(
      final double latitude,
      final double longitude) {

    lat.setValue("" + latitude);
    lon.setValue("" + longitude);
  }

  private final native void yahooMapDisplay(
      final double lat,
      final double lon,
      final String text) /*-{
    var myself= this;
    var map= myself.@com.fkereki.mvpproject.client.map1.MapView::yahooMap;
    var currentGeoPoint = new $wnd.YGeoPoint(lat, lon);

    map.drawZoomAndCenter(currentGeoPoint, 3);
    map.addMarker(currentGeoPoint,"myveryownmarker");
    map.getMarkerObject("myveryownmarker").addAutoExpand(text);
    map.getMarkerObject("myveryownmarker").openAutoExpand();
    $wnd.YEvent.Capture(map, $wnd.EventsList.MouseUp, moveMarker);

    function moveMarker(_e, _c) {
    map.getMarkerObject("myveryownmarker").setYGeoPoint(_c);
    map.panToLatLon(_c);
    myself.@com.fkereki.mvpproject.client.map1.MapView::setCoordinates(DD)(_c.Lat, _c.Lon);
    }

    //
    // If needed, you could get the current marker coordinates by writing:
    //
    // var myobj= map.getMarkerObject("myveryownmarker");
    // alert("Coords: "+myobj.YGeoPoint.Lat+", "+myobj.YGeoPoint.Lon);
    //
  }-*/
  ;

  private final native void yahooMapInit()
  /*-{
    var map = new $wnd.YMap($doc.getElementById('myveryownmap'));
    map.setMapType($wnd.YAHOO_MAP_REG);
    this.@com.fkereki.mvpproject.client.map1.MapView::yahooMap= map;
    //
    //        You can add controls:
    //
    //        map.addTypeControl();
    //        map.addPanControl();
    //        map.addZoomLong();
    //        map.addZoomShort();
    //
  }-*/
  ;
}
