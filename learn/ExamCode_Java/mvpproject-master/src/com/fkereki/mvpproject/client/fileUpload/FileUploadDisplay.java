package com.fkereki.mvpproject.client.fileUpload;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.google.gwt.user.client.ui.FormPanel;

public interface FileUploadDisplay
    extends Display {

  String getFileToUploadName();

  void setSubmitCallback(SimpleCallback<FormPanel.SubmitEvent> scb);

  void setSubmitCompleteCallback(
      SimpleCallback<FormPanel.SubmitCompleteEvent> scb);

  void setUploadClickCallback(SimpleCallback<Object> scb);

  void submitForm();
}
