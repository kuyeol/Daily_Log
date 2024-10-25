package th.linkedlist;

/**
 * A simple impl of a double linked list
 * 
 * @author td
 * @param <T>
 */
public class DList<T extends Object>
{
  private DNode<T> head;
  private int size;

  // construct an empty DList
  public DList() {
    size = 0;
    head = new DNode(null);
    head.data = null;
    head.next = head;
    head.prev = head;
  }

  public void insertFront(T item)
  {
    DNode<T> node = new DNode<T>(item);
    node.prev = head;
    node.next = head.next;

    head.next.prev = node;
    head.next = node;
    size++;
  }

  public void appendToTail(T item)
  {
    DNode<T> n = new DNode<T>(item);
    n.prev = head.prev;
    n.next = head;

    head.prev.next = n;
    head.prev = n;
    size++;
  }

  @Override
  public String toString()
  {
    StringBuilder buf = new StringBuilder(size);
    DNode n = head.next;
    while (n.data != null)
    {
      buf.append(n.toString()).append("<=>");
      n = n.next;
    }
    return buf.toString();
  }

  public static void main(String args[])
  {
    DList integerList = new DList<Integer>();

    for (int i = 10; i > 0; i--)
    {
      integerList.insertFront(new Integer(i));
    }
    System.out.printf("insertFront 1-10. list = %s\n", integerList);

    for (int i = 11; i <= 20; i++)
    {
      integerList.appendToTail(new Integer(i));
    }
    System.out.printf("appendToTail 11-20. list = %s\n", integerList);

  }
}
