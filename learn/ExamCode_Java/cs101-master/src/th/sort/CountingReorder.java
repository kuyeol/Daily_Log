package th.sort;

// reorder string using a modification of the counting sort idea
public class CountingReorder
{

  // run in O(n) where n is the size of the first parameter
  // assuming the alphabet has constant size
  public static String reorder(String s, String alphabetOrder)
  {

    // assumption: if the alphabet order is not defined, dont reorder
    if (s == null || alphabetOrder == null)
    {
      return s;
    }

    char[] chars = s.toCharArray();
    char[] alphabet = alphabetOrder.toCharArray();

    int[] count = new int[26]; // assume all possible chars in s are a..z
    for (int i = 0; i < chars.length; i++)
    {
      int index = chars[i] - 97;
      count[index]++;
    }

    StringBuilder buf = new StringBuilder();
    // emit letters in the alphabet first, using this alphabet order
    for (int i = 0; i < alphabet.length; i++)
    {
      char c = alphabet[i];
      int index = c - 97;
      while (count[index] > 0)
      {
        buf.append(c);
        count[index]--;
      }
    }

    // then emit the letlers in s but not in the alphabet
    for (int i = 0; i < count.length; i++)
    {
      while (count[i] > 0)
      {
        char c = (char) (97 + i);
        buf.append(c);
        count[i]--;
      }
    }
    return buf.toString();
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