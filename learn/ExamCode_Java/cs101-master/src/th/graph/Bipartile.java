package th.graph;

// Algorithm to check if the graph is bipartile 
// e.g. given G, can the vertices be assigned to one of two colors
// such that no edge connect 2 vertices of the same color? 
public class Bipartile
{

  // is G two colorable?
  private boolean isBipartile;
  private boolean[] visited;
  private boolean[] color;

  public Bipartile(IGraph g) {
    isBipartile = true;
    visited = new boolean[g.NV()];
    color = new boolean[g.NV()];

    for (int v = 0; v < g.NV(); v++)
    {
      if (!visited[v])
      {
        dfs(g, v);
      }
    }

  }

  private void dfs(IGraph g, int v)
  {
    visited[v] = true;
    for (int x : g.adj(v))
    {
      if (!visited[x])
      {
        color[x] = !color[v];
        dfs(g, x);
      } else
      {
        if (color[x] == color[v])
        {
          isBipartile = false;
        }
      }
    }
  }

  public boolean isBipartile()
  {
    return isBipartile;
  }

}
