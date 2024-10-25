package th.graph;

import th.io.Console;
import th.io.Instream;
import th.collection.LinkedList;

// A basic implementation of Graph data structure 
// using adjacency-list data structure 
// Graph maintains a vertex-indexd array of adjacency-lists 
// Limitation: vertex is an int, not a symbol. 
// Need a graph representation with String vetix name? See Graph.java class in the same package 
public class IGraph
{

  // number of vertices
  private final int NV;

  // number of edges
  private int NE;

  // adjacency lists
  public LinkedList<Integer>[] adj;

  // set up an empty graph with NV vertices
  public IGraph(int nv) {
    this.NV = nv;
    this.NE = 0;
    adj = new LinkedList[nv];
    for (int v = 0; v < NV; v++)
    {
      adj[v] = new LinkedList<Integer>();
    }
  }

  // set up a graph from input stream (file, socket, etc)
  public IGraph(Instream in) {
    // setup G with NV reading from input stream
    this(in.readInt());
    // set ne (number of edges) with the value read from input stream
    int ne = in.readInt();
    for (int edge = 0; edge < ne; edge++)
    {
      int u = in.readInt();
      int v = in.readInt();
      addEdge(u, v);
    }
  }

  void addEdge(int u, int v)
  {
    adj[u].add(v);
    adj[v].add(u);
    NE++;
  }

  public Iterable<Integer> adj(int v)
  {
    return adj[v];
  }

  public int NV()
  {
    return NV;
  }

  public int NE()
  {
    return NE;
  }

  public void findSelfLoop()
  {
    for (int u = 0; u < NV; u++)
    {
      for (int v : adj(u))
      {
        if (u == v)
        {
          Console.println("self loop at : " + v);
        }
      }
    }
  }

  public int degree(int u)
  {
    int degree = 0;
    for (int v : adj[u])
    {
      degree++;
    }
    return degree;
  }

  public int maxDegree()
  {
    int max = 0;
    for (int u = 0; u < NV; u++)
    {
      int degree = this.degree(u);
      if (degree > max)
      {
        max = degree;
      }
    }
    return max;
  }

  @Override
  public String toString()
  {
    StringBuilder buf = new StringBuilder();
    buf.append("NV: ").append(NV).append("\n");
    buf.append("NE: ").append(NE).append("\n");
    for (int u = 0; u < NV; u++)
    {
      buf.append(u).append(": ");
      for (int v : adj(u))
      {
        buf.append(v).append(" ");
      }
      buf.append("\n");
    }
    return buf.toString();
  }
}
