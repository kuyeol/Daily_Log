package th.io;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.util.Scanner;

public final class Console
{

  private static final String charset = "UTF-8";
  private static Scanner in;
  private static PrintWriter out;

  static
  {
    try
    {
      in = new Scanner(new BufferedInputStream(System.in), charset);
      out = new PrintWriter(new OutputStreamWriter(System.out, charset), true);
    } catch (UnsupportedEncodingException ex)
    {
      throw new RuntimeException(ex);
    }
  }

  public static int readInt()
  {
    return in.nextInt();
  }

  public static double readDouble()
  {
    return in.nextDouble();
  }

  public static String readStr()
  {
    return in.next();
  }

  public static String readLine()
  {
    return in.nextLine();
  }

  public static boolean empty()
  {
    return !in.hasNext();
  }

  public static void println(Object x)
  {
    out.println(x);
  }

  public static void printf(String format, Object... args)
  {
    out.printf(format, args);
    out.flush();
  }

  // log with current thread name
  public static void tprintf(String format, Object... args)
  {
    String fmt = Thread.currentThread().getName() + ": " + format;
    out.printf(fmt, args);
    out.flush();
  }
  
  public static void println()
  {
    out.println();
  }
}
