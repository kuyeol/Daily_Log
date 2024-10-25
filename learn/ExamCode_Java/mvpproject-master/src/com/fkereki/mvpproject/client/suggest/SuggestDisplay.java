package com.fkereki.mvpproject.client.suggest;

import com.fkereki.mvpproject.client.Display;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;

public interface SuggestDisplay
    extends Display {

  String getCityName();

  void setCitiesOracle(MultiWordSuggestOracle oracle);
}
