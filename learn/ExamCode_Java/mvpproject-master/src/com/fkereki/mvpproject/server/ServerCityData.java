package com.fkereki.mvpproject.server;

import com.fkereki.mvpproject.client.rpc.ClientCityData;

public class ServerCityData
    extends ClientCityData {
  /**
   * Given a client-side object, we need to be able to construct a server-side
   * one; server side methods are not likely to be programmed based on the
   * restricted client-side objects. Usually (but not in this example) the
   * server-side object will have a few more attributes than the client-side
   * one.
   * 
   * @param pObject
   *          A ClientCityData object
   */
  public ServerCityData(final ClientCityData pObject) {
    /*
     * The common fields are easily loaded, and you'd add extra logic for other
     * fields.
     */
    countryCode = pObject.countryCode;
    stateCode = pObject.stateCode;
    cityName = pObject.cityName;
    cityAccentedName = pObject.cityAccentedName;
    population = pObject.population;
    latitude = pObject.latitude;
    longitude = pObject.longitude;
  }

  /**
   * We need to be able to produce a client-side object from a server-side one,
   * in case we have to return such an object to the client. Usually this just
   * entails creating the new object from selected attributes of the current
   * object, and discarding other ones.
   * 
   * @return A client-side object
   */
  public ClientCityData asCityData() {
    return new ClientCityData(countryCode, stateCode, cityName,
        cityAccentedName, population, latitude, longitude);
  }

  /**
   * Methods can be redefined and "amplified" for the server, use all kind of
   * functions, etc. Of course, the original client-side functions are still
   * available; check the usage of super.validationProblems().
   */
  @Override
  public String validationProblems() {
    final String svp = super.validationProblems();
    if (!svp.isEmpty()) {
      return svp;
    } else {
      final WorldServiceImpl wsi = new WorldServiceImpl();
      if (wsi.cityExists(countryCode, stateCode, cityName)) {
        return "City exists.";
      } else {
        return "";
      }
    }
  }
}
