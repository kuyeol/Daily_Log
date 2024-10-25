package th.test;

import java.lang.reflect.Method;
import java.math.BigInteger;

public class Utils
{

  private Utils() {
  }

  public static String concatWords(String... words)
  {
    StringBuilder buf = new StringBuilder();
    for (String word : words)
    {
      buf.append(word);
    }
    return buf.toString();
  }

  public static String computeFactorial(int number) throws IllegalArgumentException
  {
    if (number < 1)
    {
      throw new IllegalArgumentException("zero or negative parameter (" + number + ')');
    }

    BigInteger factorial = new BigInteger("1");
    for (int i = 2; i <= number; i++)
    {
      factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
    }
    return factorial.toString();
  }

  public static String normalizeWord(String word)
  {
    try
    {
      int i;
      Class<?> normalizerClass = Class.forName("java.text.Normalizer");
      Class<?> normalizerFormClass = null;
      Class<?>[] nestedClasses = normalizerClass.getDeclaredClasses();
      for (i = 0; i < nestedClasses.length; i++)
      {
        Class<?> nestedClass = nestedClasses[i];
        if (nestedClass.getName().equals("java.text.Normalizer$Form"))
        {
          normalizerFormClass = nestedClass;
        }
      }
      assert normalizerFormClass.isEnum();
      Method methodNormalize = normalizerClass.getDeclaredMethod("normalize", CharSequence.class, normalizerFormClass);
      Object nfcNormalization = null;
      Object[] constants = normalizerFormClass.getEnumConstants();
      for (i = 0; i < constants.length; i++)
      {
        Object constant = constants[i];
        if (constant.toString().equals("NFC"))
        {
          nfcNormalization = constant;
        }
      }
      return (String) methodNormalize.invoke(null, word, nfcNormalization);
    } catch (Exception ex)
    {
      return null;
    }
  }

}
