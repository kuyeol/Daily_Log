package com.fkereki.mvpproject.client.clientSearch;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;

public class ClientSearchPresenter
    extends Presenter<ClientSearchDisplay> {

  public static String PLACE = "clientsearch";

  public ClientSearchPresenter(
      final String params,
      final ClientSearchDisplay clientSearchDisplay,
      final Environment environment) {

    super(params, clientSearchDisplay, environment);

    // clientSearchDisplay
    // .setSearchClickCallback(new SimpleCallback<Object>()
    // {
    // @Override
    // public void goBack(Object result) {
    // Window.alert("search");
    // ((ClientDisplay) (ClientSearchPresenter.this
    // .getDisplay())).showPopupPanel();
    // }
    // });

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