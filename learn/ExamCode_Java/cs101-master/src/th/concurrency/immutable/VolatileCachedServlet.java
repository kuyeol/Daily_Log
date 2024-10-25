package th.concurrency.immutable;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * An incomplete thread-safe servlet illustrate how to cache the last
 * computation using a volatile reference to an immutable holder object.
 */
public class VolatileCachedServlet implements Servlet
{

  // caching the last result using a volatile reference to an immutable holder
  private volatile Cache cache = new Cache(null, null);

  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
  {
    BigInteger n = new BigInteger(req.getParameter("number"));
    BigInteger[] series = cache.getSeries(n);
    if (series == null)
    {
      series = fibonacciSeries(n);
    }
    PrintWriter out = res.getWriter();
    out.println("Series: ");
    for (BigInteger i : series)
    {
      out.println(i);
    }
  }

  private BigInteger[] fibonacciSeries(BigInteger n)
  {
    int i = n.intValue();
    BigInteger[] series = new BigInteger[i];
    BigInteger back2 = BigInteger.ZERO;
    BigInteger back1 = BigInteger.ONE;
    series[0] = back2;
    series[1] = back1;

    for (int k = 2; k <= i; k++)
    {
      BigInteger cur = back1.add(back2);
      back2 = back1;
      back1 = cur;
      series[k] = cur;
    }
    return series;
  }

  public void init(ServletConfig config) throws ServletException
  {
  }

  public ServletConfig getServletConfig()
  {
    return null;
  }

  public String getServletInfo()
  {
    return null;
  }

  public void destroy()
  {
  }
}
