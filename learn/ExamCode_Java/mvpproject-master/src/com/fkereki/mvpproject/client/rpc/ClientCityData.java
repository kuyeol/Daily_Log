package com.fkereki.mvpproject.client.rpc;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ClientCityData
    implements IsSerializable {
  public String countryCode;
  public String stateCode;
  public String cityName;
  public String cityAccentedName;
  public int population;
  public float latitude;
  public float longitude;

  /**
   * An empty constructor method is required for serializable classes... see
   * <a>http://blog.js-development.com/2008/08/strange-gwt-compiler-error-when-
   * trying.html</a >
   * <a>http://code.google.com/p/google-web-toolkit/issues/detail?id=540</a>
   */
  public ClientCityData() {
  }

  /**
   * A standard constructor
   * 
   * @param pCountryCode
   *          country code
   * @param pStateCode
   *          state code
   * @param pCityName
   *          city name
   * @param pCityAccentedName
   *          city accented name
   * @param pPopulation
   *          population
   * @param pLatitude
   *          latitude
   * @param pLongitude
   *          longitude
   */
  public ClientCityData(
      final String pCountryCode, final String pStateCode,
      final String pCityName, final String pCityAccentedName,
      final int pPopulation, final float pLatitude,
      final float pLongitude) {

    countryCode = pCountryCode;
    stateCode = pStateCode;
    cityName = pCityName;
    cityAccentedName = pCityAccentedName;
    population = pPopulation;
    latitude = pLatitude;
    longitude = pLongitude;
  }

  /**
   * Perform client-side validations. The code here is limited to the GWT
   * client-side available packages.
   * 
   * @return "" if the client data is OK, or an error description otherwise
   */
  public String validationProblems() {
    if (countryCode.isEmpty()) {
      return "No country specified";
    } else if (stateCode.isEmpty()) {
      return "No region specified";
    } else if (cityName.isEmpty()) {
      return "No city name specified";
    } else if (cityAccentedName.isEmpty()) {
      return "No accented city name specified";
    } else if (population < 0) {
      return "Negative population";
    } else if (latitude < -90 || latitude > 90) {
      return "Latitude outside -90..+90";
    } else if (longitude < -180 || longitude > 180) {
      return "Longitude outside -180..+180";
    } else {
      return "";
    }
  }
}
