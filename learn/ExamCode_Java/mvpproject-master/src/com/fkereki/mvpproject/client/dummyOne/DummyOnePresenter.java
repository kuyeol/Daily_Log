package com.fkereki.mvpproject.client.dummyOne;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;

public class DummyOnePresenter
    extends Presenter<DummyOneDisplay> {
  public static String PLACE = "foo";

  public DummyOnePresenter(
      String params, DummyOneDisplay dummyOneDisplay,
      Environment environment) {

    super(params, dummyOneDisplay, environment);
    dummyOneDisplay.setPepeValue(getKvm().get("pepe"));
    dummyOneDisplay.setClickCallback(new SimpleCallback<Object>() {

      @Override
      public void goBack(Object result) {
        DummyOnePresenter.this.getDisplay().showPopupPanel();
        DummyOnePresenter.this.getEnvironment().launch("baz",
            DummyOnePresenter.this.getDisplay().getPopupPanel());
      }
    });
  }
}
