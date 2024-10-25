package th.collection;

public class MinHeap<E extends Comparable> implements PriorityQueue
{
  private E[] array;
  private int size;

  public MinHeap(int max) {
    array = (E[]) new Object[max];
    size = 0;
  }

  int minChildIndex(int index)
  {
    int minChildIndex = 0;
    int leftChild = 2 * index;
    if (leftChild <= size && array[leftChild] != null)
    {
      if (array[leftChild].compareTo(array[index]) < 0)
      {
        minChildIndex = leftChild;
      }
    }

    int rightChild = leftChild + 1;
    if (rightChild <= size && array[rightChild] != null)
    {
      if (array[rightChild].compareTo(array[leftChild]) < 0)
      {
        minChildIndex = rightChild;
      }
    }

    return minChildIndex;

  }

  void bubbleDown(int index)
  {
    E parent = array[index];
    int minChildIndex = minChildIndex(index);

    if (minChildIndex > 0 && parent.compareTo(array[minChildIndex]) > 0)
    {
      swap(array, index, minChildIndex);
      bubbleDown(minChildIndex);
    }

  }

  void bubbleUp(int index)
  {
    int parent = index / 2;
    if (parent <= 1)
    {
      return;
    }

    if (array[index].compareTo(array[parent]) < 0)
    {
      swap(array, index, parent);
      bubbleUp(parent);
    }
    return;
  }

  @Override
  public int size()
  {
    return size;
  }

  @Override
  public boolean isEmpty()
  {
    return size == 0;
  }

  public void insert(Comparable entry)
  {
    if (size == array.length - 1)
    {
      return;
    }

    size = size + 1;
    int pos = size;
    array[pos] = (E) entry;
    bubbleUp(pos);
  }

  @Override
  public E removeMin()
  {
    E root = array[1];

    array[1] = array[size];
    array[size--] = null;
    bubbleDown(1);

    return root;

  }

  @Override
  public E min()
  {
    if (size < 1)
    {
      return null;
    }

    return array[1];
  }

  public void displayArray()
  {
    for (int j = 1; j <= size; j++)
    {
      System.out.print(array[j] + " ");
    }
    System.out.println();
  }

  private void swap(E[] a, int i, int j)
  {
    E tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}