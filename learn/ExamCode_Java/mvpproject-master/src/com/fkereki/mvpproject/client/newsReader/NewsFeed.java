package com.fkereki.mvpproject.client.newsReader;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class NewsFeed
    extends JavaScriptObject {

  protected NewsFeed() {
  }

  // xxxx({"ResultSet":
  // {"totalResultsAvailable":"...a.number...",
  // "totalResultsReturned":"...a.number...",
  // "firstResultPosition":"...a.number...",
  // "Result":[{"Title":"...title...",
  // "Summary":"....subtitle",
  // "Url":"...news.url...",
  // "ClickUrl":"...click.url...",
  // "NewsSource":"...news.source...",
  // "NewsSourceUrl":"...news.source.url...",
  // "Language":"en",
  // "PublishDate":"...a.UNIX.timestamp...",
  // "ModificationDate":"...a.UNIX.timestamp..."},
  // {...another.result...},
  // {...and.another.result...},
  // ...
  // ]
  // }
  // })

  public final long getAge(final int i) {
    final long newsTimeStamp = 0;
    // use a JSNI method to get the PublishDate attribute
    // and store it to newsTimeStamp
    final long currentTimeStamp = new Date().getTime();
    return currentTimeStamp - newsTimeStamp;
  }

  public final native String getClickUrl(int i)
  /*-{
    return this.ResultSet.Result[i].ClickUrl;
  }-*/;

  public final native String getSummary(int i)
  /*-{
    return this.ResultSet.Result[i].Summary;
  }-*/;

  public final native String getTitle(int i)
  /*-{
    return this.ResultSet.Result[i].Title;
  }-*/;

  public final native int getTotalResultsReturned()
  /*-{
    return this.ResultSet.totalResultsReturned;
  }-*/;
}
