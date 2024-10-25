package th.probability;

/**
 * This program solve the following question: I have a jar with R red candies
 * and W white candies. I eat the candies as follows: draw a random candy. If
 * it's red, eat it. If it's white, place the candy back and draw another random
 * candy, eating that one regardless of color. What is the probability that the
 * final candy I eat is white?
 */
public class BoxModel
{

  /**
   * P(R,W) compute the probability that the last candy is white, given a jar
   * with R red candies and W white candies. Recurrence P(R,W) =
   * R/(R+W)*P(R-1,W) + W/(R+W)*[R/(R+W)*P(R-1,W) + W/(R+W)*P(R,W-1)] Base
   * cases: P(0,W)=1 for all W and P(R,0)=0 for all R
   * 
   * @param R
   * @param W
   * @return double
   */
  public static double P(double R, double W)
  {
    if (R == 0)
    {
      return 1;
    }

    if (W == 0)
    {
      return 0;
    }

    return (R / (R + W)) * P(R - 1, W) + W / (R + W) * (R / (R + W) * P(R - 1, W) + W / (R + W) * P(R, W - 1));
  }

  public static void printP(int R, int W)
  {
    System.out.printf("Start with a jar that has %d red candies and %d white candies \n", R, W);
    System.out.printf("Probability that the last candy I eat is white: %5.2f \n", P(R, W));
  }

  public static void main(String args[])
  {
    System.out.println("=============== 1============");
    printP(5, 5);

    System.out.println("=============== 2============");
    printP(9, 10);

    System.out.println("=============== 3 ============");
    printP(9, 5);

    System.out.println("=============== 3 ============");
    printP(15, 1);

  }
}
