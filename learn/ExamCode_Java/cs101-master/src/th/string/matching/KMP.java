package th.string.matching;

import java.util.ArrayList;
import java.util.Arrays;

public class KMP
{

  private String pat;
  private int[] o;

  // building overlap function
  public KMP(String pat) {
    this.pat = pat;
    int m = pat.length();
    o = new int[m];
    o[0] = -1;
    for (int i = 1; i < m; i++)
    {
      int z = o[i - 1];
      while (z >= 0 && pat.charAt(i) != pat.charAt(z))
      {
        z = o[z];
      }
      o[i] = z + 1;
    }
    System.out.println("overlap: " + Arrays.toString(o));
  }

  // another version of building overlap function
  public KMP(String pat, int v2) {
    this.pat = pat;
    int m = pat.length();
    o = new int[m];
    o[0] = -1;
    int z = -1;
    for (int i = 1; i < m; i++)
    {
      while (z >= 0 && pat.charAt(i) != pat.charAt(z + 1))
      {
        z = o[z];
      }
      if (pat.charAt(i) == pat.charAt(z + 1))
      {
        z = z + 1;
      }
      o[i] = z;
    }
    System.out.println("overlap: " + Arrays.toString(o));
  }

  public ArrayList<Integer> search(String s)
  {
    ArrayList<Integer> positions = new ArrayList<Integer>();
    int z = -1;
    for (int i = 0; i < s.length(); i++)
    {
      while (z >= 0 && s.charAt(i) != pat.charAt(z + 1))
      {
        z = o[z];
      }
      if (s.charAt(i) == pat.charAt(z + 1))
      {
        z = z + 1;
      }
      if (z == pat.length() - 1)
      {
        positions.add(i - z);
        z = o[z - 1];
      }
    }
    return positions;
  }

  /** a quick test */
  public static void main(String args[])
  {
    String s = "banananobanonananona";

    // use Huy version of building overlap
    KMP searcher = new KMP("nano");
    System.out.printf("search \"%s\" in \"%s\". Found at: %s\n ", searcher.pat, s, searcher.search(s).toString());

    // use CRL version of building overlap
    searcher = new KMP("nano", 2);
    System.out.printf("search \"%s\" in \"%s\". Found at: %s\n ", searcher.pat, s, searcher.search(s).toString());
  }
}