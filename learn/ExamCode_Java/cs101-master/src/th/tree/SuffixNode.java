package th.tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * A suffix tree node representation using a standard trie data structure no
 * compression
 * 
 */
public class SuffixNode
{

  // the chracter associated with the node
  char label;

  // the starting position of the suffix (that this node present) in the text
  ArrayList<Integer> positions = new ArrayList<Integer>();
  HashMap<Character, SuffixNode> children = new HashMap<Character, SuffixNode>();

  // empty constructor
  public SuffixNode() {
  }

  public void insertSuffix(String suffix, int pos)
  {
    positions.add(pos);
    if (suffix != null && suffix.length() > 0)
    {
      label = suffix.charAt(0);

      SuffixNode child = new SuffixNode();
      if (children.containsKey(label))
      {
        child = children.get(label);
      } else
      {
        children.put(label, child);
      }

      String remaining = suffix.substring(1);
      child.insertSuffix(remaining, pos);
    }
  }

  public ArrayList<Integer> getPositions(String s)
  {
    if (s == null || s.length() == 0)
    {
      return positions;
    } else
    {
      char prefix = s.charAt(0);
      if (children.containsKey(prefix))
      {
        String remaining = s.substring(1);
        return children.get(prefix).getPositions(remaining);
      }
    }
    return null;
  }
}
