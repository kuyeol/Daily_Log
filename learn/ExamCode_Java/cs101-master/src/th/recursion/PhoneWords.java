package th.recursion;

/**
 * Recursive version of printing phone words from a phone number
 */

public class PhoneWords
{

  private static String[] keyMap = { "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY" };

  public static char getKeyChar(int key, int pos)
  {
    char ret = 0;
    if (key == 0 || key == 1)
    {
      ret = Character.forDigit(key, 10);
    } else if (key >= 2 && key <= 9)
    {
      ret = keyMap[key].charAt(pos - 1);
    } else
    {
      throw new IllegalArgumentException();
    }
    return ret;
  }

  public static void printPhoneWords(int phone_num[])
  {
    char[] phone_word = new char[phone_num.length];
    printPhoneWords(phone_num, phone_word, 0);
  }

  public static void printPhoneWords(int phone_num[], char[] phone_word, int ith_digit)
  {
    if (ith_digit == phone_num.length)
    {
      System.out.println(phone_word);
      return;
    }

    for (int k = 1; k <= 3; k++)
    {
      phone_word[ith_digit] = getKeyChar(phone_num[ith_digit], k);
      printPhoneWords(phone_num, phone_word, ith_digit + 1);
      if (phone_num[ith_digit] == 0 || phone_num[ith_digit] == 1)
      {
        return;
      }
    }

  }

  public static void main(String args[])
  {
    int test_num[] = { 0, 4, 6, 1 };
    printPhoneWords(test_num);
  }
}
