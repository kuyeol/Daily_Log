/**
 * 
 */
package com.fkereki.mvpproject.client.newsReader;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;

/**
 * @author fkereki
 */
public interface NewsReaderDisplay
    extends Display {
  String getTextToSearchFor();

  void setNews(String htmlNews);

  void setOnGetNewsCallback(SimpleCallback<Object> acb);
}
