/**
 * 
 */
package com.fkereki.mvpproject.client.feedsListing;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;

/**
 * @author fkereki
 */
public interface FeedsListingDisplay
    extends Display {

  void clearAllCities();

  String getCityNameStart();

  int getCityPopulation(final int i);

  void setCityData(
      final int i,
      final String cityName,
      final String countryName,
      final String stateName,
      final int population);

  void setOnCityNameStartChangeCallback(SimpleCallback<Object> acb);

  void setOnGetCitiesClickCallback(SimpleCallback<Object> acb);

  void setOnUpdateCitiesClickCallback(SimpleCallback<Object> acb);
}
