package th.simulation.probability;

import java.util.LinkedList;
import java.util.Random;

public class Jar
{

  private LinkedList<Candy> red_candies;
  private LinkedList<Candy> white_candies;
  private Random rand = new Random();

  /**
   * setup a new jar with n_red_candies and n_white_candies
   * 
   * @param n_red_candies
   * @param n_white_candies
   */
  public Jar(int n_red_candies, int n_white_candies) {
    red_candies = new LinkedList<Candy>();
    for (int i = 0; i < n_red_candies; i++)
    {
      red_candies.add(new Candy(Candy.Color.Red));
    }

    white_candies = new LinkedList<Candy>();
    for (int j = 0; j < n_white_candies; j++)
    {
      white_candies.add(new Candy(Candy.Color.White));
    }
  }

  /**
   * simulate taking a candy out of jar
   * 
   * @return
   */
  public Candy draw()
  {
    int n = red_candies.size() + white_candies.size();
    int randCandy = rand.nextInt(n);
    if (randCandy < red_candies.size())
    {
      return red_candies.removeLast();
    } else
    {
      return white_candies.removeLast();
    }
  }

  public void putWhiteBack()
  {
    white_candies.add(new Candy(Candy.Color.White));
  }

  public int size()
  {
    return red_candies.size() + white_candies.size();
  }

}
