package th.set;

import th.io.Console;

public class UnionFind
{

  // how many sets in the universe. number of connected compmonents
  private int count;
  // size of each set. s[x] is the size of the set containing x
  int[] s;
  // parent link. p[x] is the parent of x. root is the set itentifier
  private int[] p;

  // initially each point is in its own set
  UnionFind(int n) {
    count = n;
    p = new int[n];
    s = new int[n];
    // initially the parent of x is x. size of each set is 1
    for (int i = 0; i < n; i++)
    {
      p[i] = i;
      s[i] = 1;
    }
  }

  // count number of sets (number of connected components)
  public int size()
  {
    return count;
  }

  // merge x and y into one set. add connection between x and y
  public void union(int x, int y)
  {
    int root_x = find(x);
    int root_y = find(y);
    if (root_x == root_y)
    {
      return;
    }
    if (s[root_x] > s[root_y])
    {
      p[root_y] = root_x;
      s[root_x] += s[root_y];
    } else
    {
      p[root_x] = root_y;
      s[root_y] += s[root_x];
    }
    count--;
  }

  // set identifier for x. what connected component that x is a member of?
  public int find(int x)
  {
    while (x != p[x])
    {
      x = p[x];
    }
    return x;
  }

  // check if x and y are in the same set (in the connected component)
  public boolean connected(int x, int y)
  {
    return (find(x) == find(y));
  }

  // Given a stream of (x,y) numbers. Each pair represent 2 points or a line
  // Write a program to read the stream of (x,y) and output if the reading
  // pair
  // is already connected. Also output the number of connected components
  // sofar
  public static void findConnectedComponents()
  {
    int n = Console.readInt();
    UnionFind sets = new UnionFind(n);
    while (!Console.empty())
    {
      int x = Console.readInt();
      if (x == -1)
      {
        break;
      }
      int y = Console.readInt();
      if (sets.connected(x, y))
      {
        System.out.printf("points %d and %d already connected \n", x, y);
        continue;
      }
      sets.union(x, y); // connect x, y
      System.out.printf(" %d %d \n", x, y);
    }
  }

  // a quick test
  public static void main(String args[])
  {
    findConnectedComponents();
  }
}