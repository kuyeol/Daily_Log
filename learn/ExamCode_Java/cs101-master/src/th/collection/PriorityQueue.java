package th.collection;

public interface PriorityQueue<E extends Comparable>
{

  public int size();

  public boolean isEmpty();

  public void insert(E entry);

  public E min();

  public E removeMin();
}
