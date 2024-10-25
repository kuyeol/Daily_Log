package com.fkereki.mvpproject.client.clientData;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.clientSearch.ClientSearchPresenter;
import com.fkereki.mvpproject.client.rpc.XhrProxyAsync;

public class ClientDataPresenter
    extends Presenter<ClientDataDisplay> {

  public static String PLACE = "client";

  public ClientDataPresenter(
      final String params, final ClientDataDisplay clientDisplay,
      final Environment environment) {

    super(params, clientDisplay, environment);

    final XhrProxyAsync xhrProxy = environment.getModel()
        .getRemoteXhrProxy();

    // final String YAHOOID =
    // "aasJBXDV34FUcgc.WTwpYWlbhWme9l1xJtF8juZYjwZOTXEwawx5lbzAIKJtgII-";
    // final double AMNHlat = 40.780411;
    // final double AMNHlon = -73.974037;
    //
    // xhrProxy.getFromUrl("http://local.yahooapis.com",
    // "MapsService/V1/mapImage", "appid=" + YAHOOID + "&latitude="
    // + AMNHlat + "&longitude=" + AMNHlon,
    // new AsyncCallback<String>() {
    //
    // @Override
    // public void onFailure(final Throwable caught) {
    // environment.showAlert("Couldn't connect to Yahoo Maps");
    // }
    //
    // @Override
    // public void onSuccess(final String result) {
    // final Document xmlDoc = XMLParser.parse(result);
    // final Element root = xmlDoc.getDocumentElement();
    // XMLParser.removeWhitespace(xmlDoc);
    // final String actualUrl = root.getFirstChild()
    // .getNodeValue();
    //
    // // now you can create new Image(actualUrl)
    // // or use setUrl(actualUrl) on an already existing widget
    // }
    // });

    clientDisplay.setSearchClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(final Object result) {
        ClientDataPresenter.this.getDisplay().showPopupPanel();
        ClientDataPresenter.this.getEnvironment().launch(
            ClientSearchPresenter.PLACE,
            ClientDataPresenter.this.getDisplay().getPopupPanel());
      }
    });

    // dummyOneDisplay.setPepeValue(getKvm().get("pepe"));
    // dummyOneDisplay
    // .setClickCallback(new SimpleCallback<Object>() {
    //
    // @Override
    // public void goBack(Object result) {
    // ((DummyOneDisplay) ClientPresenter.this
    // .getDisplay()).showPopupPanel();
    // ClientPresenter.this.environment.launch("baz",
    // ((DummyOneDisplay) ClientPresenter.this
    // .getDisplay()).getPopupPanel());
    // }
    // });
  }
}
