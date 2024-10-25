package th.string.matching;

public class DFA
{

  private int initState;
  private int acceptState;
  private int[][] tranTable;
  private char[] alphabet;

  public static DFA buildAutomaton(String p, char[] alphabet)
  {
    DFA automaton = new DFA();
    automaton.initState = 0;
    automaton.alphabet = alphabet;
    int m = p.length();
    automaton.acceptState = m;
    automaton.tranTable = new int[m + 1][256];

    for (int q = 0; q <= m; q++)
    {
      for (char a : alphabet)
      {
        int k = Math.min(m, q + 1);
        while (k > 0)
        {
          if (isSuffix(p, k, q, a))
          {
            break;
          }
          k = k - 1;
        }
        automaton.tranTable[q][(int) a] = k;
      }
    }
    return automaton;
  }

  private static boolean isSuffix(String p, int k, int q, char a)
  {
    String Pqa = p.substring(0, q) + a;
    int len = Pqa.length();

    if (k > len)
    {
      return false;
    }

    for (int i = 0, j = len - k; i < k; i++, j++)
    {
      if (p.charAt(i) != Pqa.charAt(j))
      {
        return false;
      }
    }
    return true;
  }

  public void print()
  {
    for (int i = 0; i < tranTable.length; i++)
    {
      for (char a : alphabet)
      {
        System.out.printf(" %2d", tranTable[i][a]);
      }
      System.out.println("");
    }
  }

  public static void main(String args[])
  {
    String t = "abababacaba";
    String p = "ababaca";
    char[] alphabet = { 'a', 'b', 'c' };
    int pos = match(t, p, alphabet);
    if (pos >= 0)
    {
      System.out.printf("found \"%s\" in \"%s\" at position %d \n", p, t, pos);
    } else
    {
      System.out.printf("Not found \"%s\" in \"%s\" \n", p, t);
    }
  }

  public static int match(String t, String p, char[] alphabet)
  {
    DFA automat = DFA.buildAutomaton(p, alphabet);
    automat.print();
    int q = 0;
    for (int i = 0; i < t.length(); i++)
    {
      q = automat.tranTable[q][t.charAt(i)];
      if (q == automat.acceptState)
      {
        return i + 1 - p.length();
      }
    }
    return -1;
  }
}
