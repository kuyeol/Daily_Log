package th.sort;

import java.util.Arrays;
import java.util.Comparator;

// reorder the string based on a given alphabet ordering 
// e.g. reorder("bananac", "can") shoud return "caaannb"
public class ReorderString
{

  static class MyComparator implements Comparator<Character>
  {
    // ordering array is indexed by the character ascci code
    // ordering['c'] is the order of the character 'c' in this alphabet

    private int[] ordering = new int[256]; // assume alphabet are ascci

    // letters

    // initialize the ordering of characters
    // assume characters not in the alphabet have highest order 256;

    public MyComparator(String alphabet) {
      for (int i = 0; i < ordering.length; i++)
      {
        ordering[i] = 256;
      }
      for (int i = 0; i < alphabet.length(); i++)
      {
        char c = alphabet.charAt(i);
        ordering[c] = i;
      }
    }

    public int compare(Character c1, Character c2)
    {
      return ordering[c1] - ordering[c2];
    }
  }

  public static String reorder(String s, String alphabet)
  {

    // assumption: if the alphabet order is not defined, dont reorder
    if (s == null || alphabet == null)
    {
      return s;
    }

    char[] chars = s.toCharArray();
    // Arrays.sort() does not work for primitive type char[] and a sepcial
    // Comparator.
    // only work with object array so need to convert to array of Character
    // objects
    Character[] charObjectArr = new Character[chars.length];
    for (int i = 0; i < chars.length; i++)
    {
      charObjectArr[i] = new Character(chars[i]);
    }

    Arrays.sort(charObjectArr, new MyComparator(alphabet));
    return Arrays.toString(charObjectArr);
  }

  /** a quick test */
  public static void test()
  {
    String s = "banana";
    String alphabet = "can";
    System.out.printf("reorder(%s, %s) = %s \n", s, alphabet, reorder(s, alphabet));

    s = "xananadc";
    alphabet = "can";
    System.out.printf("reorder(%s, %s) = %s \n", s, alphabet, reorder(s, alphabet));

    alphabet = "";
    System.out.printf("reorder(%s, %s) = %s \n", s, alphabet, reorder(s, alphabet));

    s = "";
    alphabet = "can";
    System.out.printf("reorder(%s, %s) = %s \n", s, alphabet, reorder(s, alphabet));

    s = null;
    System.out.printf("reorder(%s, %s) = %s \n", s, alphabet, reorder(s, alphabet));
  }

  public static void main(String args[])
  {
    test();
  }
}