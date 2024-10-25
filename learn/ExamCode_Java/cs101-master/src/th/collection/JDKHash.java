package th.collection;

/**
 * Addition hash function apply to a key by "mixing up bits" to defend against
 * collisions for hashCodes that do not differ in lower bits. Adapting from Sun
 * JDK HashMap implementation
 */
public class JDKHash<K> implements HashFunction<K>
{

  private int m; // size of the Hashtable

  public JDKHash(int m) {
    this.m = m;
  }

  // This function ensures that hashCodes that differ only by
  // constant multiples at each bit position have a bounded
  // number of collisions.
  public int hash(K key)
  {
    int h = key.hashCode();
    h ^= (h >>> 20) ^ (h >>> 12);
    h = h ^ (h >>> 7) ^ (h >>> 4);
    return h & (m - 1);
  }

  public void updateTableSize(int newSise)
  {
    this.m = newSise;
  }
}
