package th.linkedlist;

/**
 * A simple impl of a singly linked list
 * 
 * @author td
 * @param <T>
 */
public class SList<T extends Comparable<T>>
{

  private SNode head;
  private int size;

  public SList() {
    head = null;
    size = 0;
  }

  public void insertFront(T item)
  {
    head = new SNode(item, head);
    size++;
  }

  public void appendToTail(T item)
  {
    if (head == null)
    {
      insertFront(item);
    } else
    {
      head.appendToTail(item);
    }
  }

  public void deleteNode(T item)
  {
    if (head != null)
    {
      head.deleteNode(head, item);
    }
  }

  public T nth(int pos)
  {
    if (head == null || pos < 0)
    {
      return null;
    } else
    {
      SNode<T> nth = head.nth(pos - 1);
      return nth.item;
    }
  }

  public T nthToLast(int n)
  {
    SNode<T> nthToLast = head.nthToLast(head, n);
    if (nthToLast == null)
    {
      return null;
    } else
    {
      return nthToLast.item;
    }
  }

  public int size()
  {
    return size;
  }

  @Override
  public String toString()
  {
    StringBuilder buf = new StringBuilder(size);
    SNode n = head;
    while (n != null)
    {
      buf.append(n.toString()).append("->");
      n = n.next;
    }
    return buf.toString();
  }

  public static void main(String args[])
  {
    SList<Integer> integerList = new SList<Integer>();

    for (int i = 11; i <= 20; i++)
    {
      integerList.appendToTail(new Integer(i));
    }
    System.out.printf("appendToTail 11-20. list = %s\n", integerList);

    for (int i = 10; i > 0; i--)
    {
      integerList.insertFront(new Integer(i));
    }
    System.out.printf("insertFront 1-10. list = %s\n", integerList);

    Integer five = integerList.nth(5);
    System.out.printf("integerList.nth(5) = %s \n", five);

    Integer nine = integerList.nthToLast(11);
    System.out.printf("integerList.nthToLast(11) = %s \n", nine);

    integerList.deleteNode(nine);
    System.out.printf("node 9 deleted list = %s \n", integerList);
  }
}
