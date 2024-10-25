package th.simulation.probability;

/**
 * Use simulation to solve the following probability question.
 * 
 * I have a jar with R red candies and W white candies. I eat the candies as
 * follows: draw a random candy. If it's red, eat it. If it's white, place the
 * candy back and draw another random candy, eating that one regardless of
 * color. What is the probability that the final candy I eat is white?
 */
public class Simulation
{

  /**
   * 
   * @param R
   *          number of red candies in the jar
   * @param W
   *          number of white candies in the jar
   * @param sim_num
   *          - number of simulation times
   */
  public static void simulate(int R, int W, int sim_num)
  {

    int red_count = 0;
    int white_count = 0;

    for (int sim = 0; sim < sim_num; sim++)
    {
      Jar jar = new Jar(R, W);

      while (jar.size() > 1)
      {
        Candy c = jar.draw();
        if (c.color == Candy.Color.Red)
        {
          // eat;
        } else
        {
          jar.putWhiteBack();
          c = jar.draw();
          // eat
        }
      }

      // draw the last candy in the jar
      Candy lastone = jar.draw();
      if (lastone.color == Candy.Color.Red)
      {
        red_count++;
      } else
      {
        white_count++;
      }
    }
    System.out.printf("Number of simulations: %d. Start with a jar that has %d red candies and %d white candies \n",
        sim_num, R, W);
    System.out.printf(
        "Number of times we end up with last red candy:  %d. Number of times we end up with last white candy: %d \n",
        red_count, white_count);
    System.out.printf("Probability that the final candy I eat is white: %5.2f \n", ((double) white_count)
        / (red_count + white_count));
  }

  public static void main(String[] args)
  {
    System.out.println("===============Simulation 1============");
    simulate(5, 5, 100000);
    System.out.println("===============Simulation 2============");
    simulate(9, 10, 100000);
    System.out.println("===============Simulation 3============");
    simulate(9, 5, 100000);
  }
}
