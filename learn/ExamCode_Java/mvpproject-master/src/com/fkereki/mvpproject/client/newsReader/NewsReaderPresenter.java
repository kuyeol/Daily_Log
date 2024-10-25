package com.fkereki.mvpproject.client.newsReader;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.rpc.XhrProxyAsync;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.URL;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class NewsReaderPresenter
    extends Presenter<NewsReaderDisplay> {
  public static String PLACE = "newsReader";

  public NewsReaderPresenter(
      final String params, final NewsReaderDisplay newsReaderDisplay,
      final Environment environment) {

    super(params, newsReaderDisplay, environment);

    getDisplay().setOnGetNewsCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(final Object result) {
        getNewsViaJsonp();
      }
    });
  }

  void displayNews(final NewsFeed data) {
    String show = "";
    final int news = data.getTotalResultsReturned();
    for (int i = 0; i < news; i++) {
      show += "<a href='" + data.getClickUrl(i) + "' target='_blank'>"
          + data.getTitle(i) + "</a><br/>" + data.getSummary(i)
          + "<br/><br/";
    }
    getDisplay().setNews(show);
  }

  void getNewsViaJsonp() {
    final String newsUrl = "http://search.yahooapis.com/"
        + "NewsSearchService/V1/newsSearch?appid=YahooDemo&query="
        + URL.encode(getDisplay().getTextToSearchFor())
        + "&results=5&language=en&output=json";

    final JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
    jsonp.requestObject(newsUrl, new AsyncCallback<NewsFeed>() {

      @Override
      public void onFailure(final Throwable caught) {
        getEnvironment().showAlert("failed...");
      }

      @Override
      public void onSuccess(final NewsFeed result) {
        displayNews(result);
      }
    });
  }

  void getNewsViaXhr() {
    final String newsUrl = "http://search.yahooapis.com";
    final String newsPath = "NewsSearchService/V1/newsSearch";
    final String newsParams = "appid=YahooDemo&query="
        + URL.encode(getDisplay().getTextToSearchFor())
        + "&results=5&language=en&output=json";

    final XhrProxyAsync xhrProxy = getEnvironment().getModel()
        .getRemoteXhrProxy();

    xhrProxy.getFromUrl(newsUrl, newsPath, newsParams,
        new AsyncCallback<String>() {

          @Override
          public void onFailure(final Throwable caught) {
            getEnvironment().showAlert("failed...");
          }

          @Override
          public void onSuccess(final String result) {
            final NewsFeed data = JsonUtils.unsafeEval(result);
            displayNews(data);
          }
        });
  }
}