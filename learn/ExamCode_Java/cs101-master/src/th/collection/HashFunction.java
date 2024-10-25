package th.collection;

/**
 * A hash function, which map from some collection of keys to the indices of the
 * th.collection.HashMap. HashFunctions can be passed to the constructor of the
 * HashMap to allow precise control of how to map from the Key objects to the
 * indices.
 */
public interface HashFunction<Key>
{

  // HashMap size is a power of two and hence it is a potential problem
  // because it only use least significant bits of key.hashCode().
  // To address the problem, HashMap can call this function to "mix up bits"
  // and defend the
  // potential collisions for hashCodes that do not differ in lower bits.
  public int hash(Key key);

  // HashMap call this to update the HashFunction about its new size
  public void updateTableSize(int newSise);

}
