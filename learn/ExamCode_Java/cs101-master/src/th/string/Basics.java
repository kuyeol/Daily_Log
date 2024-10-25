package th.string;

// Basic algorithms
public class Basics
{

  /**
   * remove duplicate chars w/o using additional buffer.
   * 
   * @param str
   */
  public static void removeDuplicateChars(char[] str)
  {
    if (str == null)
    {
      return;
    }

    if (str.length <= 1)
    {
      return;
    }

    int tail = 1;

    // For each char, check whether it is a duplicate of already visited
    // chars
    // Skip duplicate chars and update non-duplicate chars
    for (int i = 1; i < str.length; ++i)
    {

      int j;
      for (j = 0; j < tail; ++j)
      {
        if (str[i] == str[j])
        {
          break;
        }
      }

      if (j == tail)
      {
        str[tail] = str[i];
        ++tail;
      }

    }

    str[tail] = 0;
    for (int i = tail; i < str.length; i++)
    {
      str[i] = 0;
    }

  }

  /**
   * Write an O(n) algorithms to determine if a string has all unique chars w/o
   * using any fancy data structure.
   * 
   * @param str
   * @return
   */
  public boolean isUnique(String str)
  {
    boolean[] hit = new boolean[256];
    for (int i = 0; i < str.length(); i++)
    {
      int pos = str.charAt(i);
      if (hit[pos])
      {
        return false;
      } else
      {
        hit[pos] = true;
      }
    }
    return true;
  }

  // Write an O(n) algorithms to determine if a string has all unique chars
  // w/o using any an array
  public boolean isUniqueChars(String str)
  {
    int checkBits = 0;
    for (int i = 0; i < str.length(); i++)
    {
      int val = str.charAt(i) - 'a';
      if ((checkBits & (1 << val)) > 0)
      {
        return false;
      }
      checkBits |= (1 << val);
    }
    return true;
  }

  public static void main(String args[])
  {
    String s = "Google.Facebook.Twitter.Apple";
    char str[] = s.toCharArray();
    removeDuplicateChars(str);
    s = new String(str);
    System.out.println(s);
  }
}
