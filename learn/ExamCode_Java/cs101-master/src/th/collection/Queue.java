package th.collection;

import java.io.Serializable;
import java.util.Iterator;

public class Queue<E> implements Iterable<E>, Serializable
{

  private Node back;
  private Node front;
  int size = 0;

  private class Node implements Serializable
  {

    E data;
    Node next;

    public Node(E elem) {
      data = elem;
    }
  }

  private class QueueIterator implements Iterator<E>
  {

    private Node node = front;

    public boolean hasNext()
    {
      if (node != null)
      {
        return true;
      } else
      {
        return false;
      }
    }

    public E next()
    {
      E elem = node.data;
      node = node.next;
      return elem;
    }

    public void remove()
    {
    }
  }

  public void enqueue(E elem)
  {
    Node old_back = back;
    back = new Node(elem);
    if (size == 0)
    {
      front = back;
    } else
    {
      old_back.next = back;
    }
    size++;
  }

  public E dequeue()
  {
    if (size > 0)
    {
      E elem = front.data;
      front = front.next;
      size--;
      if (front == null)
      {
        back = null;
      }
      return elem;
    }
    return null;
  }

  public boolean empty()
  {
    return size == 0;
  }

  public int size()
  {
    return size;
  }

  public Iterator<E> iterator()
  {
    return new QueueIterator();
  }

  /* should move to junit test */
  public static void test()
  {

    // setup a queue
    Queue<Integer> q = new Queue<Integer>();

    // add 1..10 to the queue
    for (int i = 1; i <= 10; i++)
    {
      q.enqueue(i);
    }

    // iterate the queue and print out item by item
    Iterator it = q.iterator();
    while (it.hasNext())
    {
      System.out.printf("%d ", it.next());
    }
    System.out.println();

    // dequeue 1..5
    for (int i = 1; i <= 5; i++)
    {
      q.dequeue();
    }

    // iterate the queue and print out item by item from 6..10
    it = q.iterator();
    while (it.hasNext())
    {
      System.out.printf("%d ", it.next());
    }
    System.out.println();

  }

  public static void main(String args[])
  {
    test();
  }
}
