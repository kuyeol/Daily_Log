package th.graph;

//Depth-first-search to find paths in graph g
import th.collection.Stack;

public class DFS
{

  private int s; // source vertex
  private boolean[] visited;
  private int[] last; // last[x] vertex in the dfs search path to x

  public DFS(IGraph g, int s) {
    this.s = s;
    visited = new boolean[g.NV()];
  }

  private void dfs(IGraph g, int u)
  {
    visited[u] = true;
    for (int v : g.adj(u))
    {
      if (!visited[v])
      {
        last[v] = u;
        dfs(g, v);
      }
    }
  }

  // is there a path from s to v?
  public boolean connected(int v)
  {
    return visited[v];
  }

  // path from s to v
  public Iterable<Integer> getPath(int v)
  {
    if (!connected(v))
    {
      return null;
    }

    Stack<Integer> path = new Stack<Integer>();
    for (int x = v; x != s; x = last[x])
    {
      path.push(x);
    }
    path.push(s);
    return path;
  }
}
