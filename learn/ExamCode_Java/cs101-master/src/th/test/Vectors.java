/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package th.test;

public final class Vectors
{

  private Vectors() {
  }

  /**
   * Checks whether the given vectors are equal.
   */
  public static boolean equal(int[] a, int[] b)
  {
    if ((a == null) || (b == null))
    {
      throw new IllegalArgumentException("null argument");
    }

    if (a.length != b.length)
    {
      return false;
    }

    for (int i = 0; i < a.length; i++)
    {
      if (a[i] != b[i])
      {
        return false;
      }
    }

    return true;
  }

  /**
   * Scalar multiplication of given vectors.
   */
  public static int scalarMultiplication(int[] a, int[] b)
  {
    if ((a == null) || (b == null))
    {
      throw new IllegalArgumentException("null argument");
    }

    if (a.length != b.length)
    {
      throw new IllegalArgumentException("different tuple of the vectors (" + a.length + ", " + b.length + ')');
    }

    int sum = 0;
    for (int i = 0; i < a.length; i++)
    {
      sum += a[i] * b[i];
    }
    return sum;
  }

}
