package th.collection;

import java.io.Serializable;
import java.util.Iterator;

public class Stack<E> implements Iterable<E>, Serializable
{

  private Node top;
  int size = 0;

  private class Node implements Serializable
  {

    E data;
    Node next;

    public Node(E elem) {
      data = elem;
    }
  }

  private class StackIterator implements Iterator
  {

    private Node node = top;

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

  public E pop()
  {
    if (size > 0)
    {
      E elem = top.data;
      top = top.next;
      size--;
      return elem;
    }
    return null;
  }

  public E peek()
  {
    if (top != null)
    {
      E elem = top.data;
      return elem;
    }
    return null;
  }

  public void push(E elem)
  {
    Node oldtop = top;
    top = new Node(elem);
    top.next = oldtop;
    size++;
  }

  public boolean empty()
  {
    return size == 0;
  }

  public int size()
  {
    return size;
  }

  public Iterator iterator()
  {
    return new StackIterator();
  }
}
