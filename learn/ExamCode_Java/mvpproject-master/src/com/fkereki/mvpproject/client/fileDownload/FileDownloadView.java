package com.fkereki.mvpproject.client.fileDownload;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;

public class FileDownloadView
    extends View
    implements FileDownloadDisplay {

  @UiTemplate("FileDownloadView.ui.xml")
  interface Binder
      extends UiBinder<FormPanel, FileDownloadView> {
  }

  @UiField
  FormPanel downloadForm;

  @UiField
  TextBox parameter1;

  @UiField
  TextBox parameter2;

  @UiField
  TextBox parameter3;

  @UiField
  Button downloadButton;

  @UiField
  Anchor downloadLink;

  SimpleCallback<SubmitCompleteEvent> onSubmitCompleteCallback;
  SimpleCallback<SubmitEvent> onSubmitCallback;
  SimpleCallback<Object> onDownloadClickCallback;
  SimpleCallback<Object> onDownloadLinkCallback;

  private static final Binder binder = GWT.create(Binder.class);

  public FileDownloadView() {
    final FormPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);

    downloadForm.setAction("/mvpproject/fileproduce");
    downloadForm.setMethod(FormPanel.METHOD_GET);
  }

  @Override
  public String getParameter1() {
    return parameter1.getValue();
  }

  @Override
  public String getParameter2() {
    return parameter2.getValue();
  }

  @Override
  public String getParameter3() {
    return parameter3.getValue();
  }

  @UiHandler("downloadForm")
  public void onSubmitComplete(final SubmitCompleteEvent event) {
    onSubmitCompleteCallback.goBack(event);
  }

  @UiHandler("downloadForm")
  public void onSubmitForm(final SubmitEvent event) {
    onSubmitCallback.goBack(event);
  }

  @Override
  public void setDownloadClickCallback(final SimpleCallback<Object> scb) {
    onDownloadClickCallback = scb;
  }

  @Override
  public void setDownloadLinkClickCallback(
      final SimpleCallback<Object> scb) {
    onDownloadLinkCallback = scb;
  }

  @Override
  public void setLinkHref(final String href) {
    downloadLink.setHref(href);
  }

  @Override
  public void setSubmitCallback(final SimpleCallback<SubmitEvent> scb) {
    onSubmitCallback = scb;
  }

  @Override
  public void submitForm() {
    downloadForm.submit();
  }

  @UiHandler("downloadLink")
  void uiOnLinkClick(final ClickEvent event) {
    onDownloadLinkCallback.goBack(null);
  }

  @UiHandler("downloadButton")
  void uiOnUploadClick(final ClickEvent event) {
    onDownloadClickCallback.goBack(null);
  }
}