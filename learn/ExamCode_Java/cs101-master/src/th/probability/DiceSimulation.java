package th.probability;

// code to simulate rolling dices
public class DiceSimulation
{
  private static int n = 6; // for 6 sided dice
  private static double[] twodice_density = new double[2 * n + 1];

  public static void roll2Dice()
  {
    for (int dice1 = 1; dice1 <= n; dice1++)
    {
      for (int dice2 = 1; dice2 <= n; dice2++)
      {
        twodice_density[dice1 + dice2] += 1.00;
      }
    }
    for (int i = 2; i <= 2 * n; i++)
    {
      twodice_density[i] = twodice_density[i] / 36;
    }
  }

  // return the probability distibution for the sum of 2 dice
  public double[] sum2DiceDist()
  {
    return twodice_density;
  }

  // return the probability for the sum of 2 dice
  public double sum2DiceProbability(int k)
  {
    if (k > 1 && k <= 2 * n)
    {
      return twodice_density[k];
    } else
    {
      return 0.00;
    }
  }

}
