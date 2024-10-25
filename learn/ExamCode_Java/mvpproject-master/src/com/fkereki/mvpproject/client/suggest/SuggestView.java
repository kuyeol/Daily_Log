package com.fkereki.mvpproject.client.suggest;

import com.fkereki.mvpproject.client.View;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;

public class SuggestView
    extends View
    implements SuggestDisplay {

  FlexTable ft = new FlexTable();
  SuggestBox sb;

  public SuggestView() {
    ft.setWidget(0, 0, new Label("Pick a New York city:"));
    ft.setWidget(0, 1, new SuggestBox());
    initWidget(ft);
  }

  @Override
  public String getCityName() {
    return sb.getValue();
  }

  @Override
  public void setCitiesOracle(MultiWordSuggestOracle oracle) {
    sb = new SuggestBox(oracle);
    ft.setWidget(0, 1, sb);
  }
}