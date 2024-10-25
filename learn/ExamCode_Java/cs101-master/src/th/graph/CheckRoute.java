package th.graph;

import th.io.Console;
import th.io.Instream;
import th.collection.Queue;

// Given graph g, check if there is a route between 2 nodes start and end 
public class CheckRoute
{

  private boolean[] visited;

  // start with first node, use bfs to traverse the graph and check if
  // the other node is found
  public boolean check(IGraph g, int start, int end)
  {
    Queue<Integer> q = new Queue<Integer>();
    visited = new boolean[g.NV()];
    q.enqueue(start);
    visited[start] = true;
    while (!q.empty())
    {
      int u = q.dequeue();
      for (int v : g.adj[u])
      {
        if (visited[v] == false)
        {
          if (v == end)
          {
            return true;
          } else
          {
            q.enqueue(v);
            visited[v] = true;
          }
        }
      }
    }
    return false;
  }

  // quick test
  public static void main(String args[])
  {
    String file_name = "/home/td/Dropbox/git/cs101/src/th/graph/g2.txt";
    Instream in = new Instream(file_name);
    IGraph g = new IGraph(in);

    // debug the graph
    Console.println(g);

    int start = 2;
    int end = 4;
    CheckRoute search = new CheckRoute();
    if (search.check(g, start, end))
    {
      System.out.format("There is a route between %d and %d \n:  ", start, end);
    } else
    {
      System.out.format("There is no route between %d and %d \n:  ", start, end);
    }
  }
}
