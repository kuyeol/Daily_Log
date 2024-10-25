package th.collection;

// basic impl of the Map/Hashtable interface
public interface Map<Key, Value>
{

  void put(Key key, Value value);

  Value get(Key key);

  boolean contains(Key key);

  void delete(Key key);

  Iterable<Key> keys();

  Iterable<Value> values();

  boolean empty();

  int size();

}
