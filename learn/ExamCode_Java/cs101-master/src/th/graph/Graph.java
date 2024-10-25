package th.graph;

import java.util.HashMap;
import java.util.Map;
import th.io.Instream;

// Graph maintains a vertex-indexd array of adjacency-lists 
// Vertex names are strings
public class Graph
{

  // use int-based vertex representation as underlying graph
  private IGraph g;
  // map symbol/string to index
  private Map<String, Integer> table;
  // index to vertex name (string)
  private String[] keys;

  // Build graph specified in inputFile using "delim" to separate vertex names
  // Read in inputFile containing a graph data structure
  // Using "delim" to separate vertex names to allow possible spaces in vertex
  // names.
  // Each line specify a list of edges, connecting first vertex name to other
  // vertices on the line
  public Graph(String inputFile, String delim) {
    table = new HashMap<String, Integer>();
    Instream in = new Instream(inputFile);

    // build the index by reading vertex names and associate each
    // distinct string with an index
    while (in.hasNextLine())
    {
      String[] names = in.readLine().split(delim);
      for (int i = 0; i < names.length; i++)
      {
        if (!table.containsKey(names[i]))
        {
          table.put(names[i], table.size());
        }
      }
    }

    // build the inverted index mapping from vertex id (int) to vertex name
    // (string)
    keys = new String[table.size()];
    for (Map.Entry<String, Integer> entry : table.entrySet())
    {
      keys[entry.getValue()] = entry.getKey();
    }

    // builf the underlying IGraph
    in = new Instream(inputFile);
    g = new IGraph(table.size());
    while (in.hasNextLine())
    {
      String[] names = in.readLine().split(delim);
      int first_v = table.get(names[0]);

      for (int i = 1; i < names.length; i++)
      {
        g.addEdge(first_v, table.get(names[i]));
      }
    }

  }

  // return internal graph
  IGraph iGraph()
  {
    return g;
  }

  // index associated with key
  public int index(String key)
  {
    return table.get(key);
  }

  // key associated with index
  public String name(int index)
  {
    return keys[index];
  }

  // is the string a vertex?
  public boolean contains(String key)
  {
    return table.containsKey(key);
  }

}
