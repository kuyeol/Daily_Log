package th.collection;

// a sorted map interface 
public interface OrderedMap<Key, Value> extends Map<Key, Value>
{
  Key minKey();

  Key maxKey();

  // greatest key less than key, or null if there is no such key
  Key lowerKey(Key key);

  // greatest key less than or equal key, or null if there is no such key
  Key floorKey(Key key);

  // the least key greater than key, or null if there is no such key
  Key higherKey(Key key);

  // the least key greater than or equal to key, or null if there is no such
  // key
  Key ceilingKey(Key key);

  // number of keys less than key
  int rank(Key key);

  // number of keys in [lo..hi] range
  int size(Key lo, Key hi);

  // keys in [lo..hi] range in sorted order
  Iterable<Key> keys(Key lo, Key hi);

  void deleteMin();

  void deleteMax();

}
