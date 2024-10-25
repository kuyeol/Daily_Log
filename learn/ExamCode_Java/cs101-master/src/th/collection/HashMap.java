package th.collection;

import th.io.Console;
import th.stats.Stats;

/**
 * Basic implementation of a Hash table using separate chaining for collision
 * resolution Clients can initiate its own HashFunction object and create Hash
 * tables using its supplied hash implementation. This HashMap implements
 * chiSquare() to compute the chisquare statistic to check if the hash function
 * produce uniformly random values between 0..table.size-1. This implementation
 * use a fix size load factor. I.e. table resize whenever the average bucket
 * size > MAX_BUCKET_SIZE. or whenever the average bucket size <
 * MIN_BUCKET_SIZE.
 * 
 * This implementation does not allow null key nor null value.
 */
public class HashMap<K, V> implements Map<K, V>
{

  /* initial default capacity */
  public static final int DEFAULT_CAPACITY = 16;
  static final int MAX_CAPACITY = 1 << 30;
  static final double MAX_BUCKET_SIZE = 2;
  static final double MIN_BUCKET_SIZE = 0.5;
  private int n; // number of <K, V> pairs in the map
  private int m; // hash table size 16, 32, 64, etc
  Entry<K, V>[] table; // resized when needed
  HashFunction<K> hashfunction;

  public HashMap() {
    this(new JDKHash<K>(DEFAULT_CAPACITY));
  }

  public HashMap(HashFunction<K> hashfunction) {
    this(hashfunction, DEFAULT_CAPACITY);
  }

  public HashMap(HashFunction<K> hashfunction, int capacity) {
    if (capacity < 0)
    {
      throw new RuntimeException("Illegal capacity: " + capacity);
    }
    if (capacity > MAX_CAPACITY)
    {
      capacity = MAX_CAPACITY;
    }

    // Find a power of 2 >= capacity
    m = 1;
    while (m < capacity)
    {
      m <<= 1;
    }
    hashfunction.updateTableSize(m);
    table = new Entry[m];
    n = 0;
    this.hashfunction = hashfunction;
  }

  int hash(K key)
  {
    return hashfunction.hash(key);
  }

  // put a pair of (key,value) into the hash table
  // both key and value must be not null
  public void put(K key, V value)
  {
    if (value == null)
    {
      delete(key);
      return;
    }

    // double table size if average length of chain > MAX_BUCKET_SIZE
    if (n > m * MAX_BUCKET_SIZE)
    {
      resize(2 * m);
    }

    int hash = hash(key);
    Entry<K, V> first = table[hash];
    for (Entry<K, V> x = first; x != null; x = x.next)
    {
      if (key.equals(x.key))
      {
        x.value = value;
        return;
      }
    }
    table[hash] = new Entry<K, V>(key, value, table[hash]);
    ++n;
  }

  public V get(K key)
  {
    int hash = hash(key);
    Entry<K, V> first = table[hash];
    for (Entry<K, V> x = first; x != null; x = x.next)
    {
      if (key.equals(x.key))
      {
        return x.value;
      }
    }
    return null;
  }

  public boolean contains(K key)
  {
    return get(key) != null;
  }

  // resize the hash table to have the given number of chains by rehashing all
  // of the keys
  private void resize(int num_chains)
  {
    HashMap<K, V> tmp = new HashMap<K, V>(this.hashfunction, num_chains);
    for (Entry<K, V> entry : entries())
    {
      tmp.put(entry.key, entry.value);
    }
    this.m = tmp.m;
    this.n = tmp.n;
    this.table = tmp.table;
  }

  public void delete(K key)
  {
    int i = hash(key);
    Entry<K, V> first = table[i];
    if (first == null)
    {
      return;
    }

    if (key.equals(first.key))
    {
      --n;
      table[i] = first.next;
      if (m > DEFAULT_CAPACITY && n < MIN_BUCKET_SIZE * m)
      {
        resize(m / 2);
      }
      return;
    }
    Entry<K, V> prev = first;
    Entry<K, V> node = first.next;
    while (node != null)
    {
      if (key.equals(node.key))
      {
        --n;
        prev.next = node.next;
        if (m > DEFAULT_CAPACITY && n < MIN_BUCKET_SIZE * m)
        {
          resize(m / 2);
        }
        return;
      } else
      {
        prev = node;
        node = node.next;
      }
    }
  }

  public Iterable<K> keys()
  {
    Queue<K> queue = new Queue<K>();
    for (Entry<K, V> x : table)
    {
      for (Entry<K, V> node = x; node != null; node = node.next)
      {
        queue.enqueue(node.key);
      }
    }
    return queue;
  }

  public Iterable<V> values()
  {
    Queue<V> queue = new Queue<V>();
    for (Entry<K, V> x : table)
    {
      for (Entry<K, V> node = x; node != null; node = node.next)
      {
        queue.enqueue(node.value);
      }
    }
    return queue;
  }

  public Iterable<Entry<K, V>> entries()
  {
    Queue<Entry<K, V>> queue = new Queue<Entry<K, V>>();
    for (Entry<K, V> x : table)
    {
      for (Entry<K, V> node = x; node != null; node = node.next)
      {
        queue.enqueue(node);
      }
    }
    return queue;
  }

  // Compute basic statistics such as min, max, mean, standard deviation, and
  // variance
  // of the size of each chain (linked list) in the HashMap
  public Stats stats()
  {
    Stats stat = new Stats(m);
    for (int i = 0; i < m; i++)
    {
      int fi = 0;
      for (Entry<K, V> node = table[i]; node != null; node = node.next)
      {
        ++fi;
      }
      stat.seen(fi);
    }
    return stat;
  }

  // Compute chisquare statistic to check
  // if the hash function produce uniformly random values
  public double chiSquare()
  {
    double chi2 = 0;
    for (int i = 0; i < m; i++)
    {

      int fi = 0;
      for (Entry<K, V> node = table[i]; node != null; node = node.next)
      {
        ++fi;
      }
      chi2 = chi2 + (fi - (1.0 * n) / m) * (fi - (1.0 * n) / m);
    }
    chi2 = (chi2 * m) / (n * 1.0);
    return chi2;
  }

  public boolean empty()
  {
    return size() == 0;
  }

  public int size()
  {
    return n;
  }

  // linked-list node class
  public static class Entry<K, V>
  {

    public final K key;
    public V value;
    Entry<K, V> next;

    public Entry(K key, V val) {
      this.key = key;
      this.value = val;
    }

    public Entry(K key, V val, Entry<K, V> next) {
      this.key = key;
      this.value = val;
      this.next = next;
    }

    @Override
    public String toString()
    {
      return "<" + key + "," + value + ">";
    }
  }

  // a quick test to read a sequence of strings
  // and output the String and the position of the String in the sequence
  public static void main(String args[])
  {
    HashMap<String, Integer> table = new HashMap<String, Integer>();

    String[] a = { "H", "E", "L", "L", "O", "W", "O", "R", "L", "D" };
    for (int i = 0; i < a.length; i++)
    {
      String key = a[i];
      table.put(key, i);
    }

    Console.println("Iterating the key set");
    for (String s : table.keys())
    {
      Console.println(s + " " + table.get(s));
    }

    Console.println("Iterating the entry set");
    for (Entry<String, Integer> x : table.entries())
    {
      Console.println(x.key + " " + x.value);
    }

  }
}
