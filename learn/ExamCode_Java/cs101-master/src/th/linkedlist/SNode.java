package th.linkedlist;

/**
 * A simple impl of a singly linked list node
 * 
 * @author td
 * @param <T>
 */
public class SNode<T extends Comparable<T>>
{

  T item;
  SNode<T> next;

  public SNode(T item, SNode<T> next) {
    this.item = item;
    this.next = next;
  }

  public SNode(T item) {
    this(item, null);
  }

  public SNode insertAfter(T item)
  {
    next = new SNode(item, next);
    return next;
  }

  public void appendToTail(T item)
  {
    SNode end = new SNode(item);
    SNode<T> n = this;
    while (n.next != null)
    {
      n = n.next;
    }
    n.next = end;
  }

  public SNode<T> deleteNode(SNode<T> head, T item)
  {
    SNode<T> n = head;
    if (n.item.compareTo(item) == 0)
    {
      return head.next;
    }

    while (n.next != null)
    {
      if (n.next.item.compareTo(item) == 0)
      {
        n.next = n.next.next;
        return head;
      }
      n = n.next;
    }

    return head;
  }

  /**
   * delete node n given by the parameter
   * 
   * @param n
   * @return
   */
  public boolean deleteNode(SNode<T> n)
  {
    if (n == null || n.next == null)
    {
      return false;
    }

    n.item = n.next.item;
    n.next = n.next.next;
    return true;
  }

  public boolean deleteCurrentNode()
  {
    SNode<T> n = this;
    return deleteNode(n);
  }

  public SNode nth(int pos)
  {
    if (pos == 0)
    {
      return this;
    } else if (pos < 0)
    {
      return null;
    } else
    {
      SNode n = this;
      for (int i = 1; i <= pos; i++)
      {
        if (n.next == null)
        {
          return null;
        } else
        {
          n = n.next;
        }
      }
      return n;
    }
  }

  public SNode nthToLast(SNode head, int n)
  {

    if (head == null || n < 0)
    {
      return null;
    }

    SNode p1 = head;
    SNode p2 = head;

    for (int i = 0; i < n; i++)
    {
      if (p2 == null)
      {
        return null;
      }
      p2 = p2.next;
    }

    if (p2 != null)
    {
      while (p2.next != null)
      {
        p2 = p2.next;
        p1 = p1.next;
      }
    }
    return p1;
  }

  @Override
  public String toString()
  {
    return item.toString();
  }

  public static void main(String args[])
  {

    SNode<Integer> current = null;
    for (int i = 10; i >= 1; i--)
    {
      current = new SNode<Integer>(i, current);
    }

    System.out.printf("inserted 1 to 10. current should be 1. current = %s \n", current);

    current = current.nth(9);
    System.out.printf("current = current.nth(9). current = %s  \n", current);

    for (int i = 20; i >= 11; i--)
    {
      current.insertAfter(i);
    }

    System.out.printf("inserted 11 to 20. current should be 10. current = %s  \n", current);

    current = current.nth(5);
    System.out.printf("current = current.nth(5). next = %s  \n", current);

  }
}
