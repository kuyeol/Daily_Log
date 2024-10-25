package th.mem;

import java.lang.ref.SoftReference;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class OrderSignature
{

  private SoftReference<Map<Integer, byte[]>> cache;
  private Connection conn;

  public synchronized int computeHash(int orderId)
  {
    byte[] bytes = cache.get().get(orderId);
    if (bytes == null)
    {
      try
      {
        Statement stmt = conn.createStatement();
        String query = "SELECT ord FROM Order where id = " + orderId;
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next())
        {
          bytes = (byte[]) rs.getObject(1);
        } else
        {
          throw new IllegalArgumentException();
        }
      } catch (SQLException ex)
      {
        throw new RuntimeException(ex);
      }
    }
    int hash = hash(bytes);
    return hash;
  }

  private int hash(byte[] byteArray)
  {
    return 1;
  }
}
