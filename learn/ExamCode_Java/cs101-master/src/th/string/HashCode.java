package th.string;

// Experiment with different hash code functions 

import java.util.HashMap;
import java.util.Map;
import th.io.Console;

public class HashCode
{

  // Rationale for this hash code function:
  // Multiplying by 127 prior to adding new character to ensure that each
  // character has
  // different weight on the the final hash code. Hence hashCode("ab") !=
  // hashCode("ba")
  // The mod operator with this prime number is used to mix up the bits of the
  // hash code
  // The prime is chosen to be large. But still ensure 127 * hashVal +
  // key.charAt(i)
  // will not exceed Integer.MAX
  private static int hashCode(String key)
  {
    int hashVal = 0;
    for (int i = 0; i < key.length(); i++)
    {
      hashVal = (127 * hashVal + key.charAt(i)) % 16908799;
    }
    return hashVal;
  }

  // Another Hash code function for String
  private static int hashCode(String key, int v2)
  {
    int code = 0;
    for (int i = 0; i < key.length(); i++)
    {
      code = (code << 4) + key.charAt(i);
      code = (code & 0x0fffffff) ^ ((code & 0xf0000000) >> 24);
    }
    return code;
  }

  private static void experiment1()
  {
    String s = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
    int N = 25;
    Console.printf("%3s, %3s, %10s, %10s, %10s, %8s, %8s, %8s %n", "N", "S", "hashCode 1 ", "hashCode2", "hashCode3",
        "index 1", "index 2", "index 3");
    for (int i = 0; i < s.length(); i++)
    {
      String str = new String(s.substring(i, i + 1));
      int hashCode1 = hashCode(str);
      int hashCode2 = hashCode(str, 2);
      int hashCode3 = str.hashCode();
      Console.printf("%3d, %3s, %10d, %10d, %10d, %8d, %8d, %8d %n", N, str, hashCode1, hashCode2, hashCode3, hashCode1
          % N, hashCode2 % N, hashCode3 % N);
    }

    Console.printf("%3s, %3s, %10s, %10s, %10s, %8s, %8s, %8s %n", "N", "S", "hashCode 1 ", "hashCode2", "hashCode3",
        "index 1", "index 2", "index 3");
    for (int i = 0; i < s.length() - 1; i++)
    {
      String str = new String(s.substring(i, i + 2));
      int hashCode1 = hashCode(str);
      int hashCode2 = hashCode(str, 2);
      int hashCode3 = str.hashCode();
      Console.printf("%3d, %3s, %10d, %10d, %10d, %8d, %8d, %8d %n", N, str, hashCode1, hashCode2, hashCode3, hashCode1
          % N, hashCode2 % N, hashCode3 % N);
    }

    Console.printf("%3s, %3s, %10s, %10s, %10s, %8s, %8s, %8s %n", "N", "S", "hashCode 1 ", "hashCode2", "hashCode3",
        "index 1", "index 2", "index 3");
    for (int i = 0; i < s.length() - 2; i++)
    {
      String str = new String(s.substring(i, i + 3));
      int hashCode1 = hashCode(str);
      int hashCode2 = hashCode(str, 3);
      int hashCode3 = str.hashCode();
      Console.printf("%3d, %3s, %10d, %10d, %10d, %8d, %8d, %8d %n", N, str, hashCode1, hashCode2, hashCode3, hashCode1
          % N, hashCode2 % N, hashCode3 % N);
    }

  }

  public static void experiment2()
  {
    Map<String, Integer> hashCodeMap = new HashMap(7);
    hashCodeMap.put("Aa", "Aa".hashCode());
    hashCodeMap.put("BB", "BB".hashCode());
    for (Map.Entry<String, Integer> entry : hashCodeMap.entrySet())
    {
      Console.println(entry.getKey() + " " + entry.getValue());
    }

  }

  public static void main(String args[])
  {
    // experiment1();
    experiment2();
  }
}
