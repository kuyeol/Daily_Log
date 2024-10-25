package th.string.matching;

import java.util.ArrayList;
import th.tree.SuffixTree;

public class SuffixMatching
{
  public static void main(String args[])
  {
    String s = "banana";
    String[] pattens = { "na", "a" };
    SuffixTree t = new SuffixTree(s);

    for (String p : pattens)
    {
      ArrayList<Integer> positions = t.getPositions(p);
      if (positions != null)
      {
        System.out.println(p + ":" + positions.toString());
      }
    }
  }
}
