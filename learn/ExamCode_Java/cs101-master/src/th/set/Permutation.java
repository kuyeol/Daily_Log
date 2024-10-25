package th.set;

import java.util.ArrayList;
import java.util.List;

public class Permutation
{

  /**
   * Recursive algorithm to permute a string
   * 
   * @param sofar
   * @param remaining
   */
  public static void permute(String half1, String half2)
  {
    if (half2.compareTo("") == 0)
    {
      System.out.println(half1);
    } else
    {
      for (int i = 0; i < half2.length(); i++)
      {
        String sofar = half1.concat(String.valueOf(half2.charAt(i)));
        String remaining = half2.substring(0, i) + half2.substring(i + 1);
        permute(sofar, remaining);
      }
    }
  }

  /**
   * Another version of permutation
   * 
   * @param input
   * @return
   */
  public static List<String> permute2(String input)
  {
    List<String> collection = null;
    if (input.length() == 1)
    {
      collection = new ArrayList<String>();
      collection.add(input);
      return collection;
    } else
    {
      collection = permute2(input.substring(1));
      Character first = input.charAt(0);
      List<String> result = new ArrayList<String>();

      for (String str : collection)
      {
        for (int i = 0; i < str.length(); i++)
        {
          String item = str.substring(0, i) + first + str.substring(i);
          result.add(item);
        }
        String item = str.concat(first.toString());
        result.add(item);
      }
      return result;
    }

  }

  /**
   * Recursive algorithm to permute a string
   * 
   * @param s
   */
  public static void permuteString(String s)
  {
    permute("", s);
  }

  public static void main(String args[])
  {

    // Run Recursive version to permute a string
    permuteString("ABCD");

    // Run another versiopn of permutation
    permute2("abcd");

  }
}
