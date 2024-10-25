package com.fkereki.mvpproject.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileProcess
    extends HttpServlet {

  private static final long serialVersionUID = -827342423425954584L;

  @Override
  protected void doGet(
      final HttpServletRequest request,
      final HttpServletResponse response)
      throws ServletException,
        IOException {

    System.out.println("GET RESULTS "
        + (String) request.getSession().getAttribute("processed"));

    response.getOutputStream().print(
        (String) request.getSession().getAttribute("processed"));
  }

  /*
   * http://www.mail-archive.com/user@commons.apache.org/msg04220.html
   */

  @Override
  protected void doPost(
      final HttpServletRequest request,
      final HttpServletResponse response)
      throws ServletException,
        IOException {

    final FileItemFactory factory = new DiskFileItemFactory();
    final ServletFileUpload upload = new ServletFileUpload(factory);

    try {
      final List<FileItem> itemsList = upload.parseRequest(request);
      for (final FileItem item : itemsList) {
        if (!item.isFormField()) {
          System.out.println("processing file " + item.getName());

          final long size = item.getSize();
          final InputStream input = item.getInputStream();
          final FileOutputStream output = new FileOutputStream(
              "/tmp/dummy");

          final byte[] buf = new byte[1024];
          int len;
          int processed = 0;
          while ((len = input.read(buf)) > 0) {
            output.write(buf, 0, len);
            processed += len;
            request.getSession().setAttribute("processed",
                processed + "/" + size);
          }
          output.close();

          input.close();
        }
      }
    } catch (final FileUploadException e) {
      throw new ServletException(e.getMessage());
    }
  }
}