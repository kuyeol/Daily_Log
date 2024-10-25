package th.design.strategy;

import java.util.Arrays;
import java.util.Comparator;
import th.io.Console;

// an example of the Strategy pattern 
// Comparator function represents a strategy for sorting elements
// java.util.Comparator is the strategy interface
public class StrategyExample
{

  // Implements the strategy interface
  static class CaseInsensitiveComparator implements Comparator<String>
  {

    public int compare(String s1, String s2)
    {
      return s1.toLowerCase().compareTo(s2.toLowerCase());
    }
  }

  // Implements the strategy interface
  static class ReverseOrderComparator implements Comparator<String>
  {

    public int compare(String s1, String s2)
    {
      int naturalOrder = s1.compareTo(s2);
      return -naturalOrder;
    }
  }

  // Configured with a Concrete Comparator object
  // I.e. Maintains a reference to a Strategy object
  static class Context
  {

    private Comparator strategy;

    public Context(Comparator strategy) {
      this.strategy = strategy;
    }

    public void sort(String[] a)
    {
      Arrays.sort(a, strategy);
    }
  }

  // Client to want to use diffferent strategies indepedently
  public static void main(String[] args)
  {

    String[] arr = { "Ac", "ab", "xy", "yx" };

    // following different strategies
    Context context = new Context(new CaseInsensitiveComparator());
    context.sort(arr);
    Console.printf("CaseInsensitiveComparator sorting: %s %n", Arrays.toString(arr));

    context = new Context(new ReverseOrderComparator());
    context.sort(arr);
    Console.printf("ReverseOrderComparator sorting: %s %n", Arrays.toString(arr));
  }
}
