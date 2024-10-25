package th.collection;

/**
 * Addition hash function apply to a key by mask off the sign bit of
 * key.hashCode() then mod to a larger prime to defend against collisions for
 * hashCodes that do not differ in lower bits. This implementation is adapting
 * from Sedgewick and Wayne algorithms book
 */
public class SKHash<K> implements HashFunction<K>
{

  private int m; // size of the Hashtable
  int log_m; // cache logM instead of computing each time hash function is
  // invoked
  private final int[] primes = { 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381, 32749, 65521, 131071,
      262139, 524287, 1048573, 2097143, 4194301, 8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
      536870909, 1073741789, 2147483647 };

  public SKHash(int m) {
    this.m = m;
    log_m = binLog(m);
  }

  public int hash(K key)
  {
    // mask off the sign bit
    int code = key.hashCode() & 0x7fffffff;
    if (log_m < 26)
    {
      code = code % primes[log_m + 5];
    }
    return code % m;
  }

  public void updateTableSize(int m)
  {
    this.m = m;
    this.log_m = binLog(m);
  }

  private static int binLog(int n)
  {
    for (int i = 1; i < 32; i++)
    {
      if ((n >> i) == 1)
      {
        return i;
      }
    }
    String msg = String.format("%d is not a power of 2 number", n);
    throw new RuntimeException(msg);
  }
}
