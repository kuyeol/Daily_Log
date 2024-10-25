package com.fkereki.mvpproject.client.i18n;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;

public class I18nPresenter
    extends Presenter<I18nDisplay> {
  public static String PLACE = "i18n";

  public I18nPresenter(
      final String params, final I18nDisplay I18nDisplay,
      final Environment environment) {

    super(params, I18nDisplay, environment);
  }
}