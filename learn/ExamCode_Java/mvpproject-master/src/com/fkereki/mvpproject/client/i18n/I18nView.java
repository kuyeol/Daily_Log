/**
 * 
 */
package com.fkereki.mvpproject.client.i18n;

import com.fkereki.mvpproject.client.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;

public class I18nView
    extends View
    implements I18nDisplay {
  @UiTemplate("I18nView.ui.xml")
  interface Binder
      extends UiBinder<HTMLPanel, I18nView> {
  }

  private static final Binder binder = GWT.create(Binder.class);

  @UiField
  Button aButton;

  public I18nView() {
    super();
    final HTMLPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);
  }
}