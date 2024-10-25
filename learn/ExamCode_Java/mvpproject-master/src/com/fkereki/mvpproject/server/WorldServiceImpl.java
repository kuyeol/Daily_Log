package com.fkereki.mvpproject.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.rpc.ClientCityData;
import com.fkereki.mvpproject.client.rpc.WorldService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class WorldServiceImpl
    extends RemoteServiceServlet
    implements WorldService {
  private static final long serialVersionUID = 1L;

  /*
   * MySQL and JDBC related constants and variables
   */
  static String jdbc_url = "jdbc:mysql://127.0.0.1/gwtdb";
  static String mysql_user = "gwtuser";
  static String mysql_password = "gwtpass";
  private Connection conn = null;

  /**
   * Tries to add a new city to the database.
   * 
   * @return "" if the city was added, or an error message otherwise
   */
  public String addCity(final ClientCityData cd) {
    final ServerCityData scd = new ServerCityData(cd);
    final String svp = scd.validationProblems();
    if (!svp.isEmpty()) {
      return svp;
    } else {
      try {
        connectToDatabase();
        final PreparedStatement ps = conn
            .prepareStatement("INSERT INTO cities (countryCode, stateCode, "
                + "cityName, cityAccentedName, population, latitude, longitude) "
                + "VALUES (?,?,?,?,?,?,?)");

        ps.setString(1, scd.countryCode);
        ps.setString(2, scd.stateCode);
        ps.setString(3, scd.cityName);
        ps.setString(4, scd.cityAccentedName);
        ps.setInt(5, scd.population);
        ps.setFloat(6, scd.latitude);
        ps.setFloat(7, scd.longitude);
        ps.executeUpdate();

        ps.close();
        disconnectFromDatabase();
      } catch (final Exception e) {
        return "Error adding city: " + e.getMessage();
      }
      return "";
    }
  }

  /**
   * Checks whether there already exists a city with a given city name, in a
   * state of a country.
   * 
   * @param pCountryCode
   *          country identifier
   * @param pStateCode
   *          state identifier
   * @param pCityName
   *          A city name
   * @return True if pCity is the name of a city in the given country/region
   */
  public Boolean cityExists(
      final String pCountryCode,
      final String pStateCode,
      final String pCityName) {
    boolean result = false;
    try {
      connectToDatabase();
      final Statement stmt = conn.createStatement();
      final ResultSet rs = stmt
          .executeQuery("SELECT COUNT(*) FROM cities WHERE countryCode='"
              + pCountryCode
              + "' AND stateCode='"
              + pStateCode
              + "' AND cityName='" + pCityName + "'");

      rs.first();
      result = rs.getInt(1) > 0;

      stmt.close();
      disconnectFromDatabase();
    } catch (final Exception e) {
      e.printStackTrace();
    }

    return new Boolean(result);
  }

  /**
   * Establish a connection to the local database and set up a statement
   */
  private void connectToDatabase()
      throws Exception {
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    conn = DriverManager.getConnection(jdbc_url, mysql_user,
        mysql_password);
  }

  /**
   * Disconnect from the database, closing everything
   */
  private void disconnectFromDatabase()
      throws Exception {
    conn.close();
  }

  /**
   * Returns cities from a state of a country.
   * 
   * @param pCountryCode
   *          two letters long string, such as "UY" for "URUGUAY"
   * @param pStateCode
   *          two letters long state identifier
   * @param pFrom
   *          an offset into the list of cities for the given country/state
   * @param pQuantity
   *          how many cities to return at once, starting from the given offset
   * @return A linked hash map with cities from the given country/state, ordered
   *         by city name.
   */
  public LinkedHashMap<String, ClientCityData> getCities(
      final String pCountryCode,
      final String pStateCode,
      final int pFrom,
      final int pQuantity) {

    final LinkedHashMap<String, ClientCityData> citiesList = new LinkedHashMap<String, ClientCityData>();

    try {
      connectToDatabase();
      final Statement stmt = conn.createStatement();
      final ResultSet rs = stmt
          .executeQuery("SELECT * FROM cities WHERE countryCode='"
              + pCountryCode + "' AND stateCode='" + pStateCode
              + "' ORDER BY cityName LIMIT " + pFrom + "," + pQuantity);

      while (rs.next()) {
        citiesList.put(rs.getString("cityName"), new ClientCityData(rs
            .getString("countryCode"), rs.getString("stateCode"), rs
            .getString("cityName"), rs.getString("cityAccentedName"),
            rs.getInt("population"), rs.getFloat("latitude"), rs
                .getFloat("longitude")));
      }

      stmt.close();
      disconnectFromDatabase();
    } catch (final Exception e) {
      e.printStackTrace();
    }

    return citiesList;
  }

  public LinkedHashMap<String, ClientCityData> getCitiesStartingWith(
      String pCountryCode,
      String pStateCode,
      String pStart) {

    final LinkedHashMap<String, ClientCityData> citiesList = new LinkedHashMap<String, ClientCityData>();

    try {
      connectToDatabase();
      final Statement stmt = conn.createStatement();
      final ResultSet rs = stmt
          .executeQuery("SELECT * FROM cities WHERE countryCode='"
              + pCountryCode + "' AND stateCode='" + pStateCode
              + "' AND cityName LIKE '" + pStart
              + "%' ORDER BY cityName");

      while (rs.next()) {
        citiesList.put(rs.getString("cityName"), new ClientCityData(rs
            .getString("countryCode"), rs.getString("stateCode"), rs
            .getString("cityName"), rs.getString("cityAccentedName"),
            rs.getInt("population"), rs.getFloat("latitude"), rs
                .getFloat("longitude")));
      }

      stmt.close();
      disconnectFromDatabase();
    } catch (final Exception e) {
      e.printStackTrace();
    }

    return citiesList;
  }

  /**
   * Returns all countries.
   * 
   * @param None
   * @return A linked hash map with country codes as keys, and country names as
   *         values. The map is ordered by country name, alphabetically.
   */
  public LinkedHashMap<String, String> getCountries() {
    final LinkedHashMap<String, String> countriesList = new LinkedHashMap<String, String>();

    try {
      connectToDatabase();
      final Statement stmt = conn.createStatement();
      final ResultSet rs = stmt
          .executeQuery("SELECT countryCode,countryName "
              + "FROM countries ORDER BY 2");

      while (rs.next()) {
        countriesList.put(rs.getString(1), rs.getString(2));
      }

      stmt.close();
      disconnectFromDatabase();
    } catch (final Exception e) {
      e.printStackTrace();
    }

    return countriesList;
  }

  /**
   * Returns all states from a country.
   * 
   * @param pCountryCode
   *          two letters long string, such as "UY" for "URUGUAY"
   * @return A linked hash map with all the states for the given country; region
   *         codes are used as keys, and state names as values. The map is
   *         ordered by state name, alphabetically.
   */
  public LinkedHashMap<String, String> getStates(
      final String pCountryCode) {
    final LinkedHashMap<String, String> statesList = new LinkedHashMap<String, String>();

    try {
      connectToDatabase();
      final Statement stmt = conn.createStatement();
      final ResultSet rs = stmt
          .executeQuery("SELECT stateCode,stateName FROM states "
              + "WHERE countryCode='" + pCountryCode + "'  ORDER BY 2");

      while (rs.next()) {
        statesList.put(rs.getString(1), rs.getString(2));
      }

      stmt.close();
      disconnectFromDatabase();
    } catch (final Exception e) {
      e.printStackTrace();
    }

    return statesList;
  }
}
