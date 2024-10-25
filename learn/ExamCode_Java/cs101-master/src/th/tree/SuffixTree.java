package th.tree;

import java.util.ArrayList;

/*
 *
 * A suffix tree representation 
 * using a standard trie data structure 
 * no compression 
 * 
 */

public class SuffixTree
{
  SuffixNode root = new SuffixNode();

  // construct a suffix tree from String txt
  public SuffixTree(String txt) {
    for (int i = 0; i < txt.length(); i++)
    {
      String suffix = txt.substring(i);
      root.insertSuffix(suffix, i);
    }
  }

  public ArrayList<Integer> getPositions(String s)
  {
    return root.getPositions(s);
  }

}
