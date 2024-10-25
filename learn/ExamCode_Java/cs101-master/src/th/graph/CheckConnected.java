package th.graph;

/// given a graph check if every vertices are connected
import th.io.Console;
import th.io.Instream;

public class CheckConnected
{

  public static void check(IGraph g)
  {
    int s = 0;
    DepthFirstSearch search = new DepthFirstSearch(g, s);
    Console.printf("%s ", "vertices got visited by DFS:");
    for (int v = 0; v < g.NV(); v++)
    {
      if (search.visited(v))
      {
        Console.printf(" %d", v);
      }
    }
    Console.println();

    if (search.numVisited() != g.NV())
    {
      Console.printf("%s ", "NOT");
    }
    Console.printf("%s", "connected \n");
  }

  public static void main(String args[])
  {
    String file_name = "/home/td/Dropbox/git/cs101/src/th/graph/g2.txt";
    Instream in = new Instream(file_name);
    IGraph g = new IGraph(in);

    // debug the graph
    Console.println(g);
    check(g);
  }
}
