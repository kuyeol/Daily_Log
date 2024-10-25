package th.collection;

/**
 * An array based implementation of Disjoint-set (aka UnionFind) data structure.
 * Each member of a set is identified by an int. Each set is also identified by
 * an int.
 */
public class DisjointSet
{

  private int count; // number of sets (aka connected components)
  int[] s; // s[i] size of set i. initially set i has only member i (size = 1)
  private int[] p; // p[x] is the parent of x

  public DisjointSet(int n) {
    count = n;
    p = new int[n];
    s = new int[n];
    for (int i = 0; i < n; i++)
    {
      p[i] = i;
      s[i] = 1;
    }
  }

  public int find(int x)
  {
    while (x != p[x])
    {
      x = p[x];
    }
    return x;
  }

  // put x and y in the same set
  public void union(int x, int y)
  {
    int root_x = find(x);
    int root_y = find(y);
    if (root_x == root_y)
    {
      return;
    }

    // think of this as merging 2 trees.
    // make smaller's root point to larger's one
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

  public boolean connected(int x, int y)
  {
    return (find(x) == find(y));
  }

  public int size()
  {
    return count;
  }

}
