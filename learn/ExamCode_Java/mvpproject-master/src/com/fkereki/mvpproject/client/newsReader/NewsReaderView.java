/**
 * 
 */
package com.fkereki.mvpproject.client.newsReader;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;

public class NewsReaderView
    extends View
    implements NewsReaderDisplay {
  @UiTemplate("NewsReaderView.ui.xml")
  interface Binder
      extends UiBinder<HTMLPanel, NewsReaderView> {
  }

  private static final Binder binder = GWT.create(Binder.class);

  @UiField
  TextBox searchFor;

  @UiField
  Button getNews;

  @UiField
  HTML newsResult;

  SimpleCallback<Object> onGetNewsCallback;

  public NewsReaderView() {
    super();
    HTMLPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);
  }

  @Override
  public String getTextToSearchFor() {
    return searchFor.getValue();
  }

  @Override
  public void setNews(String htmlNews) {
    newsResult.setHTML(htmlNews);
  }

  @Override
  public void setOnGetNewsCallback(SimpleCallback<Object> acb) {
    onGetNewsCallback = acb;
  }

  @UiHandler("getNews")
  void uiOnGetNewsClick(ClickEvent event) {
    onGetNewsCallback.onSuccess(null);
  }
}