package th.graph;

// Algorithm to find degrees of connections for each/all pairs of vertices
import th.io.Console;

// i.e. degrees of separation between person A and B in a social network 
// i.e. degrees of relation between 2 actors in a movie-actor network 
// i.e. shortest path between 2 cities in transportation network
public class ConnectionDegree
{

  private Graph graph;

  public void readGraph(String graphFile, String delim)
  {
    graph = new Graph(graphFile, delim);
  }

  public void degreeOfSeparation(String source)
  {
    IGraph g = graph.iGraph();

    if (!graph.contains(source))
    {
      Console.printf("%s not exist", source);
      return;
    }

    int s = graph.index(source);

    // use bsf to find shortest paths from s to other vertices
    BFS search = new BFS(g, s);

    // read vertex name from console (std in)
    while (!Console.empty())
    {
      String sink = Console.readLine();
      if (!graph.contains(sink))
      {
        Console.printf("%s not exist", sink);
      } else
      {
        int b = graph.index(sink);
        if (!search.connected(b))
        {
          Console.printf("%s and %s not connected.", source, sink);
        } else
        {
          for (int x : search.getPath(b))
          {
            Console.printf("  %s", graph.name(x));
          }
        }
      }
    }
  }

  // quick test to find degree of separation between 2 airports in a fly
  // network
  public static void main(String args[])
  {
    String graphDatabase = "/home/td/Dropbox/git/cs101/src/th/graph/g4.txt";
    String delim = " ";
    String source = "JFK";
    ConnectionDegree compute = new ConnectionDegree();
    compute.readGraph(graphDatabase, delim);
    compute.degreeOfSeparation(source);
  }
}
