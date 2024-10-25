package th.graph;

//Depth-First-Search algorithm on undirected graph
public class DepthFirstSearch
{

  // number of vertices get visited using dfs search
  private int num_visited;
  private boolean[] visited;

  public DepthFirstSearch(IGraph g, int s) {
    visited = new boolean[g.NV()];
    dfs(g, s);
  }

  private void dfs(IGraph g, int u)
  {
    visited[u] = true;
    num_visited++;
    for (int v : g.adj(u))
    {
      if (!visited[v])
      {
        dfs(g, v);
      }
    }
  }

  public int numVisited()
  {
    return num_visited;
  }

  public boolean visited(int v)
  {
    return visited[v];
  }

}
