package com.fkereki.mvpproject.client.fileUpload;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;

public class FileUploadPresenter
    extends Presenter<FileUploadDisplay> {
  public static String PLACE = "upload";

  public FileUploadPresenter(
      final String params, final FileUploadDisplay fileUploadDisplay,
      final Environment environment) {

    super(params, fileUploadDisplay, environment);

    fileUploadDisplay
        .setUploadClickCallback(new SimpleCallback<Object>() {

          @Override
          public void goBack(final Object result) {
            if (getDisplay().getFileToUploadName().isEmpty()) {
              getEnvironment().showAlert(
                  "You must pick a file to upload.");
            } else {
              getDisplay().submitForm();
            }
          }
        });

    fileUploadDisplay
        .setSubmitCallback(new SimpleCallback<SubmitEvent>() {

          @Override
          public void goBack(final SubmitEvent result) {
            Window.alert("event!");
            // result.cancel();
          }
        });

    fileUploadDisplay
        .setSubmitCompleteCallback(new SimpleCallback<SubmitCompleteEvent>() {

          @Override
          public void goBack(final SubmitCompleteEvent result) {
            Window.alert("complete!" + result.getResults());

            final RequestBuilder builder = new RequestBuilder(
                RequestBuilder.GET, "/mvpproject/fileprocess");
            builder.setCallback(new RequestCallback() {

              @Override
              public void onError(
                  final Request request,
                  final Throwable exception) {
                Window.alert("error ");
              }

              @Override
              public void onResponseReceived(
                  final Request request,
                  final Response response) {
                Window.alert("ok " + response.getText());
              }
            });

            try {
              builder.send();
            } catch (final RequestException e) {
              Window.alert("An error occurred while connecting +"
                  + e.getMessage());
            }

          }
        });
  }
}
