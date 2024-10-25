package th.misc;

public class Conversion
{

  // Implement a function to return a number from a string.
  //
  // int atoi (const char* str) {
  // }
  // "1234" => 1234
  private static int atoi(String s) throws Exception
  {
    int result = 0;
    int i = 0;
    int digit = 0;

    if (s == null || s.length() < 1)
    {
      throw new Exception("input string is null or empty");
    }

    for (int j = s.length() - 1; j >= 0; j--)
    {
      char c = s.charAt(j);

      if (!Character.isDigit(c))
      {
        throw new Exception("input string is not an integer string");
      }

      // Assuming radix = 10
      digit = Character.digit(c, 10);
      result += digit * Math.pow(10, i++);
    }

    return result;
  }

}
