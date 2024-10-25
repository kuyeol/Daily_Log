package th.collection;

/**
 * Another hash code for Strings, attributed to one P. J. Weinberger, which
 * designed for String Key type
 */
public class WeinbergerHash<K> implements HashFunction<K>
{

  private int m; // size of the Hashtable

  public WeinbergerHash(int m) {
    this.m = m;
  }

  public void updateTableSize(int newSise)
  {
    this.m = newSise;
  }

  public int hash(K key)
  {
    if (key instanceof String)
    {
      String s = (String) key;
      int code = 0;
      for (int i = 0; i < s.length(); i++)
      {
        code = (code << 4) + s.charAt(i);
        code = (code & 0x0fffffff) ^ ((code & 0xf0000000) >> 24);
      }
      return code % (m - 1);
    }
    throw new RuntimeException("Invalid Key type");
  }
}
