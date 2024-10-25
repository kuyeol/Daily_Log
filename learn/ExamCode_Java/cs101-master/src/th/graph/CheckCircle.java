package th.graph;

import th.io.Console;
import th.io.Instream;

public class CheckCircle
{

  private boolean[] visited;
  private boolean hasCircle;

  public CheckCircle(IGraph g) {
    visited = new boolean[g.NV()];
    for (int x = 0; x < g.NV(); x++)
    {
      if (!visited[x])
      {
        dfs(g, x, x);
      }
    }
  }

  private void dfs(IGraph g, int v, int u)
  {
    visited[v] = true;
    for (int w : g.adj(v))
    {
      if (!visited[w])
      {
        dfs(g, w, v);
      } else if (w != u)
      {
        hasCircle = true;
      }
    }
  }

  public boolean acylic()
  {
    return !hasCircle;
  }

  public static void main(String args[])
  {
    String file_name = "/home/td/Dropbox/git/cs101/src/th/graph/g2.txt";
    Instream in = new Instream(file_name);
    IGraph g = new IGraph(in);

    CheckCircle cc = new CheckCircle(g);
    if (cc.acylic())
    {
      Console.println("graph has cicle  ");
    } else
    {
      Console.println("graph does NOT has cicle  ");
    }
  }
}
