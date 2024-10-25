package th.linkedlist;

/**
 * A simple impl of a double linked list node
 * 
 * @author td
 * @param <T>
 */
public class DNode<T extends Object>
{
  T data;
  DNode<T> prev;
  DNode<T> next;

  public DNode(T item) {
    this.data = item;
  }

  @Override
  public String toString()
  {
    return data.toString();
  }

}
