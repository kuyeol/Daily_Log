package com.fkereki.mvpproject.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.fkereki.mvpproject.client.rpc.XhrProxy;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class XhrProxyImpl
    extends RemoteServiceServlet
    implements XhrProxy {

  @Override
  public String getFromUrl(
      final String originalUrl,
      final String originalPath,
      final String parameters) {
    String result = "";

    try {
      final String urlToGet = originalUrl + "/" + originalPath
          + (parameters.isEmpty() ? "" : "?" + parameters);

      final URL url = new URL(urlToGet);

      final BufferedReader in = new BufferedReader(
          new InputStreamReader(url.openStream()));

      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        result += inputLine;
      }

      in.close();
      return result;

    } catch (final Exception e) {
      return "";
    }
  }

  @Override
  public String postToUrl(
      final String originalUrl,
      final String originalPath,
      final String parameters) {

    String result = "";

    try {
      final String EOL = "\r\n";

      final URL url = new URL(originalUrl);
      final URLConnection connection = url.openConnection();
      connection.setDoOutput(true);

      final BufferedReader in = new BufferedReader(
          new InputStreamReader(connection.getInputStream()));
      final OutputStreamWriter out = new OutputStreamWriter(connection
          .getOutputStream());

      out.write("POST " + originalPath + EOL);
      out.write("Host: " + originalUrl + ":80" + EOL);
      out.write("Accept-Encoding: identity" + EOL);
      out.write("Connection: close" + EOL);
      out
          .write("Content-Type: application/x-www-form-urlencoded"
              + EOL);
      out.write("Content-Length: " + parameters.length() + EOL);
      out.write(EOL);
      out.write(parameters);
      out.write(EOL);

      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        result += inputLine;
      }

      in.close();
      out.close();

      return result;
    } catch (Exception e) {
      return "";
    }
  }
}
