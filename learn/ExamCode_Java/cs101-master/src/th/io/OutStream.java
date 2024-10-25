package th.io;

import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class OutStream
{

  private static final String UTF8 = "UTF-8";
  private PrintWriter out;

  public OutStream() {
    this(System.out);
  }

  public OutStream(OutputStream os) {
    try
    {
      OutputStreamWriter osw = new OutputStreamWriter(os, UTF8);
      out = new PrintWriter(osw, true);
    } catch (IOException e)
    {
    }
  }

  public OutStream(String fname) {
    try
    {
      OutputStream os = new FileOutputStream(fname);
      OutputStreamWriter osw = new OutputStreamWriter(os, UTF8);
      out = new PrintWriter(osw, true);
    } catch (IOException e)
    {
    }
  }

  public void close()
  {
    out.close();
  }

  public void println()
  {
    out.println();
  }

  public void print(char v)
  {
    out.print(v);
    out.flush();
  }

  public void println(char v)
  {
    out.println(v);
  }

  public void print(byte v)
  {
    out.print(v);
    out.flush();
  }

  public void println(byte v)
  {
    out.println(v);
  }

  public void print(int v)
  {
    out.print(v);
    out.flush();
  }

  public void println(int v)
  {
    out.println(v);
  }

  public void print(long v)
  {
    out.print(v);
    out.flush();
  }

  public void println(long v)
  {
    out.println(v);
  }

  public void print(float v)
  {
    out.print(v);
    out.flush();
  }

  public void println(float v)
  {
    out.println(v);
  }

  public void print(boolean v)
  {
    out.print(v);
    out.flush();
  }

  public void println(boolean v)
  {
    out.println(v);
  }

  public void print(double v)
  {
    out.print(v);
    out.flush();
  }

  public void println(double v)
  {
    out.println(v);
  }

  public void print(Object v)
  {
    out.print(v);
    out.flush();
  }

  public void println(Object v)
  {
    out.println(v);
  }

  public void print()
  {
    out.flush();
  }

  public void printf(String format, Object... args)
  {
    out.printf(Locale.US, format, args);
    out.flush();
  }

  public void printf(Locale locale, String format, Object... args)
  {
    out.printf(locale, format, args);
    out.flush();
  }
}
