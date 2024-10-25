package th.graph;

// find all connected components in G using DFS idea

import th.io.Console;
import th.io.Instream;
import th.collection.LinkedList;

public class ConnectedComponents
{

  private boolean[] visited;
  private int component_count; // how many connected conponents in G
  private int[] component_id; // component_id[x] is the component identifier

  // for x

  public ConnectedComponents(IGraph g) {
    visited = new boolean[g.NV()];
    component_id = new int[g.NV()];

    for (int v = 0; v < g.NV(); v++)
    {
      if (!visited[v])
      {
        dfs(g, v);
        component_count++;
      }
    }
  }

  private void dfs(IGraph g, int v)
  {
    visited[v] = true;
    component_id[v] = component_count;
    for (int w : g.adj(v))
    {
      if (!visited[w])
      {
        dfs(g, w);
      }
    }
  }

  public boolean connected(int x, int y)
  {
    return (component_id[x] == component_id[y]);
  }

  public int componentCount()
  {
    return component_count;
  }

  public int id(int x)
  {
    return component_id[x];
  }

  public static void main(String args[])
  {
    String file_name = "/home/td/Dropbox/git/cs101/src/th/graph/g2.txt";
    Instream in = new Instream(file_name);
    IGraph g = new IGraph(in);

    ConnectedComponents cc = new ConnectedComponents(g);

    int count = cc.componentCount();
    Console.printf("%d connnected components \n", count);

    LinkedList<Integer>[] components = new LinkedList[count];
    for (int i = 0; i < count; i++)
    {
      components[i] = new LinkedList<Integer>();
    }

    for (int v = 0; v < g.NV(); v++)
    {
      components[cc.id(v)].add(v);
    }

    for (int i = 0; i < count; i++)
    {
      Console.printf("component %d: ", i);
      for (int v : components[i])
      {
        Console.printf("%d ", v);
      }
      Console.println();
    }
  }

}
