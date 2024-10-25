package th.graph;

import th.io.Console;
import th.io.Instream;
import th.collection.Queue;
import th.collection.Stack;

//Breadth-first-search to find paths in graph g
public class BFS
{

  // source vertex
  private int s;
  // visited[x] = true mean vertex x has been visted, false otherwise
  private boolean[] visited;
  // last[x] is the last vertex on BSF path before vertex x
  private int[] last;

  public BFS(IGraph g, int s) {
    this.s = s;
    visited = new boolean[g.NV()];
    this.last = new int[g.NV()];
    bfs(g, s);
  }

  // Breadth-first-search to find paths in graph g
  private void bfs(IGraph g, int s)
  {
    Queue<Integer> q = new Queue<Integer>();
    q.enqueue(s);
    visited[s] = true;
    while (!q.empty())
    {
      int u = q.dequeue();
      for (int v : g.adj(u))
      {
        if (!visited[v])
        {
          last[v] = u;
          q.enqueue(v);
          visited[v] = true;
        }
      }
    }
  }

  // is there a path from s to v?
  public boolean connected(int v)
  {
    return visited[v];
  }

  // get path from s to v
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

  public static void main(String args[])
  {
    System.out.println("Usage: java -cp . th.graph.BFS /home/td/Dropbox/git/cs101/src/th/graph/g2.txt 0");
    test();
    // String file_name = args[0];
    // int s = Integer.parseInt(args[1]);
    // run(file_name, s);
  }

  // quick test to print bfs paths from s to all other vertices
  public static void test()
  {
    String file_name = "/home/td/Dropbox/git/cs101/src/th/graph/g2.txt";
    int s = 0;
    run(file_name, s);
  }

  // quick test to print bfs paths from s to all other vertices
  public static void run(String graph_file, int s)
  {
    Instream in = new Instream(graph_file);
    IGraph g = new IGraph(in);

    // debug the graph
    Console.println(g);
    BFS search = new BFS(g, s);
    for (int u = 0; u < g.NV(); u++)
    {
      if (search.connected(u))
      {
        Console.printf("%d to %d: ", s, u);
        for (int v : search.getPath(u))
        {
          Console.printf("%d ", v);
        }
        Console.println();
      }
    }
  }
}
