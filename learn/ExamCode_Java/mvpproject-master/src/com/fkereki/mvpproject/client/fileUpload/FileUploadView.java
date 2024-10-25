package com.fkereki.mvpproject.client.fileUpload;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;

public class FileUploadView
    extends View
    implements FileUploadDisplay {

  @UiTemplate("FileUploadView.ui.xml")
  interface Binder
      extends UiBinder<FormPanel, FileUploadView> {
  }

  @UiField
  FormPanel uploadForm;

  @UiField
  FileUpload fileToUpload;

  @UiField
  Button uploadButton;

  SimpleCallback<SubmitCompleteEvent> onSubmitCompleteCallback;
  SimpleCallback<SubmitEvent> onSubmitCallback;
  SimpleCallback<Object> onUploadClickCallback;

  private static final Binder binder = GWT.create(Binder.class);

  public FileUploadView() {
    final FormPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);

    uploadForm.setAction("/mvpproject/fileprocess");
    uploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
    uploadForm.setMethod(FormPanel.METHOD_POST);
  }

  @Override
  public String getFileToUploadName() {
    return fileToUpload.getFilename();
  }

  @UiHandler("uploadForm")
  public void onSubmitComplete(final SubmitCompleteEvent event) {
    onSubmitCompleteCallback.goBack(event);
  }

  @UiHandler("uploadForm")
  public void onSubmitForm(final SubmitEvent event) {
    onSubmitCallback.goBack(event);
  }

  @Override
  public void setSubmitCallback(final SimpleCallback<SubmitEvent> scb) {
    onSubmitCallback = scb;
  }

  @Override
  public void setSubmitCompleteCallback(
      final SimpleCallback<SubmitCompleteEvent> scb) {

    onSubmitCompleteCallback = scb;
  }

  @Override
  public void setUploadClickCallback(final SimpleCallback<Object> scb) {
    onUploadClickCallback = scb;
  }

  @Override
  public void submitForm() {
    uploadForm.submit();
  }

  @UiHandler("uploadButton")
  void uiOnUploadClick(final ClickEvent event) {
    onUploadClickCallback.goBack(null);
  }
}
