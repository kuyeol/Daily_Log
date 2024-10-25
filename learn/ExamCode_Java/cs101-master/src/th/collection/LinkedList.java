package th.collection;

import java.io.Serializable;
import java.util.Iterator;

public class LinkedList<E> implements Iterable<E>, Serializable
{

  private Node front;

  private class Node implements Serializable
  {
    E data;
    Node next;

    public Node(E elem) {
      data = elem;
    }
  }

  public void add(E elem)
  {
    Node old_front = front;
    front = new Node(elem);
    front.next = old_front;
  }

  public Iterator<E> iterator()
  {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<E>
  {
    private Node node = front;

    public boolean hasNext()
    {
      if (node == null)
      {
        return false;
      } else
      {
        return true;
      }
    }

    public E next()
    {
      E item = node.data;
      node = node.next;
      return item;
    }

    public void remove()
    {

    }
  }

}
