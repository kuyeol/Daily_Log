package com.fkereki.mvpproject.client.citiesUpdater;

import java.util.HashMap;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.rpc.ClientCityData;
import com.fkereki.mvpproject.client.rpc.XhrProxyAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.Text;
import com.google.gwt.xml.client.XMLParser;

public class CitiesUpdaterPresenter
    extends Presenter<CitiesUpdaterDisplay> {

  public static String PLACE = "cityupdate";

  HashMap<Integer, ClientCityData> cityList = new HashMap<Integer, ClientCityData>();

  public CitiesUpdaterPresenter(
      final String params,
      final CitiesUpdaterDisplay citiesUpdaterDisplay,
      final Environment environment) {

    super(params, citiesUpdaterDisplay, environment);

    getDisplay().setOnGetCitiesClickCallback(
        new SimpleCallback<Object>() {
          @Override
          public void goBack(Object result) {
            clearCities();
            getCitiesViaRequestBuilder();
          }
        });

    getDisplay().setOnUpdateCitiesClickCallback(
        new SimpleCallback<Object>() {
          @Override
          public void goBack(Object dummy) {
            HashMap<Integer, ClientCityData> newCityList = new HashMap<Integer, ClientCityData>();
            for (Integer i : cityList.keySet()) {
              int gridPop = getDisplay().getCityPopulation(i);
              ClientCityData thisCity = cityList.get(i);
              if (thisCity.population != gridPop) {
                cityList.get(i).population = gridPop;
                newCityList.put(i, cityList.get(i));
              }
            }

            String xmlToSend;
            /*
             * Create the XMl to send via any of the two following calls (but
             * not both!)
             */
            xmlToSend = citiesToXmlViaDom(newCityList);
            xmlToSend = citiesToXmlViaString(newCityList);

            /*
             * ...and then pick one of the two following sentences to send the
             * data to the server
             */
            sendCitiesToServerViaRequestBuilder(xmlToSend);
            sendCitiesToServerViaProxy(xmlToSend);
          }

        });

    getDisplay().setOnCityNameStartChangeCallback(
        new SimpleCallback<Object>() {
          @Override
          public void goBack(Object result) {
            clearCities();
          }
        });
  }

  String citiesToXmlViaDom(HashMap<Integer, ClientCityData> aList) {

    Document xml = XMLParser.createDocument();
    Element cities = xml.createElement("cities");
    xml.appendChild(cities);

    for (int i : aList.keySet()) {
      ClientCityData aCity = aList.get(i);

      Element city = xml.createElement("city");
      city.setAttribute("name", aCity.cityName);

      Element country = xml.createElement("country");
      country.setAttribute("code", aCity.countryCode);
      city.appendChild(country);

      Element region = xml.createElement("state");
      region.setAttribute("code", aCity.stateCode);
      city.appendChild(region);

      String pop = "" + aCity.population;
      Element popEl = xml.createElement("pop");
      Text popText = xml.createTextNode(pop);
      popEl.appendChild(popText);
      city.appendChild(popEl);

      /*
       * We actually don't use the <coords> element, but let's build it up for
       * the sake of it.
       */
      Element coords = xml.createElement("coords");
      Element lat = xml.createElement("lat");
      Text latText = xml.createTextNode("" + aCity.latitude);
      lat.appendChild(latText);
      coords.appendChild(lat);

      /*
       * If you want to write a little less, you can chain "create" commands;
       * check out the differences with the "lat" code above.
       * 
       * Of course, with such brevity, legibility may suffer...
       */
      coords.appendChild(xml.createElement("lon").appendChild(
          xml.createTextNode("" + aCity.longitude)));

      city.appendChild(coords);

      cities.appendChild(city);
    }

    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        + xml.toString();
  }

  String citiesToXmlViaString(HashMap<Integer, ClientCityData> aList) {
    String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

    result += "<cities>\n";
    for (int i : aList.keySet()) {
      ClientCityData thisCity = aList.get(i);

      /*
       * In truth, putting latitude and longitude in the XML string isn't
       * needed; let's do it just for showing how it's done.
       */
      result += "<city>\n";
      result += " <city name=\"" + thisCity.cityName + "\">\n";
      result += "  <country code=\"" + thisCity.countryCode + "\"/>\n";
      result += "  <state code=\"" + thisCity.stateCode + "\"/>\n";
      result += "  <pop>" + thisCity.population + "</pop>\n";
      result += "  <coords>\n";
      result += "   <lat>" + thisCity.latitude + "</lat>\n";
      result += "   <lon>" + thisCity.longitude + "</lon>\n";
      result += "  </coords>\n";
      result += "</city>\n";
    }
    result += "</cities>\n";

    return result;
  }

  void clearCities() {
    cityList.clear();
    getDisplay().clearAllCities();
  }

  void displayCities(String xmlCities) {
    clearCities();

    if (!xmlCities.isEmpty()) {
      final Document xmlDoc = XMLParser.parse(xmlCities);
      final Element root = xmlDoc.getDocumentElement();
      XMLParser.removeWhitespace(xmlDoc);

      final NodeList cities = root.getElementsByTagName("city");
      for (int i = 0; i < cities.getLength(); i++) {

        final Element city = (Element) cities.item(i);
        String cityName = city.getAttributeNode("name").getValue();

        final Element country = (Element) city.getElementsByTagName(
            "country").item(0);
        String countryCode = country.getAttributeNode("code")
            .getValue();
        String countryName = country.getAttributeNode("name")
            .getValue();

        final Element state = (Element) city.getElementsByTagName(
            "state").item(0);
        String stateCode = state.getAttributeNode("code").getValue();
        String stateName = state.getAttributeNode("name").getValue();

        int population = 0;
        Element popElem = (Element) city.getElementsByTagName("pop")
            .item(0);
        if (popElem != null) {
          population = Integer.parseInt(popElem.getFirstChild()
              .getNodeValue());
        }

        Element coords = (Element) city.getElementsByTagName("coords")
            .item(0);
        Element lat = (Element) coords.getElementsByTagName("lat")
            .item(0);
        Element lon = (Element) coords.getElementsByTagName("lon")
            .item(0);
        float latitude = Float.parseFloat(lat.getFirstChild()
            .getNodeValue());
        float longitude = Float.parseFloat(lon.getFirstChild()
            .getNodeValue());

        getDisplay().setCityData(i + 1, cityName, countryName,
            stateName, population);

        /*
         * Given the usage of cityList, we could have set latitude and longitude
         * to 0.0, and it would have worked all the same...
         */
        cityList.put(i + 1, new ClientCityData(countryCode, stateCode,
            cityName, "", population, latitude, longitude));
      }
    }
  }

  void getCitiesViaProxy() {
    /*
     * The HostPageBaseURL looks like http://yourServer:8888/somePath and we
     * want to rebuild it into http://yourServer:80/otherPath
     */
    final String baseUrl = "http:"
        + GWT.getHostPageBaseURL().split(":")[1];
    final String realUrl = baseUrl + ":80";
    final String realPath = "bookphp/getcities1.php";
    final String params = URL.encode("city="
        + getDisplay().getCityNameStart());

    XhrProxyAsync xhrProxy = getEnvironment().getModel()
        .getRemoteXhrProxy();
    xhrProxy.getFromUrl(realUrl, realPath, params,
        new AsyncCallback<String>() {

          @Override
          public void onFailure(Throwable caught) {
            getEnvironment()
                .showAlert("failure " + caught.getMessage());
          }

          @Override
          public void onSuccess(String result) {
            displayCities(result);
          }
        });
  }

  void getCitiesViaRequestBuilder() {
    String baseUrl = "http:" + GWT.getHostPageBaseURL().split(":")[1];
    final RequestBuilder rb = new RequestBuilder(RequestBuilder.GET,
        URL.encode(baseUrl + ":80/bookphp/getcities1.php?city="
            + getDisplay().getCityNameStart()));

    try {
      rb.sendRequest(null, new RequestCallback() {
        @Override
        public void onError(Request request, Throwable exception) {
          getEnvironment().showAlert(exception.getMessage());
        }

        @Override
        public void onResponseReceived(
            Request request,
            Response response) {
          displayCities(response.getText());
        }
      });
    } catch (Exception e) {
      getEnvironment().showAlert(e.getMessage());
    }
  }

  void sendCitiesToServerViaProxy(String xmlToSend) {
    /*
     * The HostPageBaseURL looks like http://yourServer:8888/somePath and we
     * want to rebuild it into http://yourServer:80/otherPath
     */
    final String baseUrl = "http:"
        + GWT.getHostPageBaseURL().split(":")[1];
    final String realUrl = URL.encode(baseUrl);
    final String realPath = URL.encode("bookphp/setc2.php");
    final String params = URL.encode("xmldata=" + xmlToSend);

    XhrProxyAsync xhrProxy = getEnvironment().getModel()
        .getRemoteXhrProxy();
    xhrProxy.postToUrl(realUrl, realPath, params,
        new AsyncCallback<String>() {

          @Override
          public void onFailure(Throwable caught) {
            getEnvironment()
                .showAlert("failure " + caught.getMessage());
          }

          @Override
          public void onSuccess(String result) {
            Window.alert(result);
          }
        });

  }

  void sendCitiesToServerViaRequestBuilder(String xmlToSend) {
    /*
     * The HostPageBaseURL looks like http://yourServer:8888/somePath and we
     * want to rebuild it into http://yourServer:80/otherPath
     */
    String baseUrl = "http:" + GWT.getHostPageBaseURL().split(":")[1];
    final RequestBuilder rb = new RequestBuilder(RequestBuilder.POST,
        URL.encode(baseUrl + ":80/bookphp/setc2.php?" + "xmldata="
            + xmlToSend));

    try {
      rb.sendRequest(null, new RequestCallback() {
        @Override
        public void onError(Request request, Throwable exception) {
          getEnvironment().showAlert(exception.getMessage());
        }

        @Override
        public void onResponseReceived(
            Request request,
            Response response) {
          Window.alert("received..." + response.getText());
        }
      });
    } catch (Exception e) {
      getEnvironment().showAlert(e.getMessage());
    }

  }
}