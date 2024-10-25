package com.fkereki.mvpproject.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface XhrProxyAsync {

  void getFromUrl(
      final String originalUrl,
      final String originalPath,
      final String parameters,
      AsyncCallback<String> callback);

  void postToUrl(
      final String originalUrl,
      final String originalPath,
      final String parameters,
      AsyncCallback<String> callback);
}
