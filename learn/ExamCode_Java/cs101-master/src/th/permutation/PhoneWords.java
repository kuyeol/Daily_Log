package th.permutation;

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
    int len = phone_num.length;
    char[] phone_word = new char[len];

    for (int i = 0; i < len; i++)
    {
      phone_word[i] = getKeyChar(phone_num[i], 1);
    }

    while (true)
    {
      System.out.println(phone_word);
      for (int j = len - 1; j >= -1; j--)
      {
        if (j == -1)
        {
          return;
        }

        if (phone_num[j] == 0 || phone_num[j] == 1 || getKeyChar(phone_num[j], 3) == phone_word[j])
        {
          phone_word[j] = getKeyChar(phone_num[j], 1);
        } else if (getKeyChar(phone_num[j], 1) == phone_word[j])
        {
          phone_word[j] = getKeyChar(phone_num[j], 2);
          break;
        } else if (getKeyChar(phone_num[j], 2) == phone_word[j])
        {
          phone_word[j] = getKeyChar(phone_num[j], 3);
          break;
        }

      }
    }
  }

  public static void main(String args[])
  {
    int test_num[] = { 7, 1, 3, 8, 8, 4, 0, 5, 7, 6 };
    printPhoneWords(test_num);
  }
}