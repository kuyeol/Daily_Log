package com.fkereki.mvpproject.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileProduce
    extends HttpServlet {

  private static final long serialVersionUID = -1735407235929394380L;

  @Override
  protected void doGet(
      final HttpServletRequest request,
      final HttpServletResponse response)
      throws ServletException,
        IOException {

    // media type (or, more modern, content type)
    // RFC 2046 at http://www.ietf.org/rfc/rfc2046.txt
    // text/plain application/msexcel

    final ServletOutputStream output = response.getOutputStream();
    response.setContentType("text/plain");
    response.setHeader("Content-Disposition",
        "attachment; filename=somefile.txt");
    output.println("Received parameters:");
    output.println(request.getParameter("parameter1"));
    output.println(request.getParameter("parameter2"));
    output.println(request.getParameter("parameter3"));
    output.close();
  }

  @Override
  protected void doPost(
      final HttpServletRequest request,
      final HttpServletResponse response)
      throws ServletException,
        IOException {
    doGet(request, response);
  }
}