package th.set;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet
{

  public static <T extends Object> ArrayList<ArrayList<T>> getSubsets(ArrayList<T> set, int index)
  {

    ArrayList<ArrayList<T>> allsubsets;
    if (set.size() == index)
    {
      allsubsets = new ArrayList<ArrayList<T>>();
      allsubsets.add(new ArrayList<T>());
    } else
    {
      T item = set.get(index);
      allsubsets = getSubsets(set, index + 1);

      ArrayList<ArrayList<T>> moresubsets = new ArrayList<ArrayList<T>>();

      for (ArrayList<T> subset : allsubsets)
      {
        ArrayList<T> newsubset = new ArrayList<T>();
        newsubset.addAll(subset);
        subset.add(item);
        moresubsets.add(newsubset);
      }

      allsubsets.addAll(moresubsets);
    }

    return allsubsets;
  }

  public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set)
  {
    int powerset_size = 1 << set.size();
    ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
    for (int count = 0; count < powerset_size; count++)
    {
      ArrayList<Integer> subset = new ArrayList<Integer>();
      for (int idx = 0; idx < set.size(); idx++)
      {
        if ((count & (1 << idx)) != 0)
        {
          subset.add(set.get(idx));
        }
      }
      allsubsets.add(subset);
    }
    return allsubsets;
  }

  public static void main(String args[])
  {
    ArrayList<Integer> set = new ArrayList<Integer>();
    set.add(1);
    set.add(2);
    set.add(3);
    ArrayList<ArrayList<Integer>> powerset = getSubsets(set);
    for (ArrayList<Integer> subset : powerset)
    {
      System.out.println(Arrays.toString(subset.toArray()));
    }

    ArrayList<Character> set2 = new ArrayList<Character>();
    set2.add('A');
    set2.add('B');
    set2.add('C');
    ArrayList<ArrayList<Character>> powerset2 = getSubsets(set2, 0);
    for (ArrayList<Character> subset : powerset2)
    {
      System.out.println(Arrays.toString(subset.toArray()));
    }

    powerSet("abc");
  }

  public static void powerSet(String s)
  {
    int set_size = (int) Math.pow(2, s.length());
    for (int counter = 0; counter < set_size; counter++)
    {
      for (int i = 0; i < s.length(); i++)
      {
        if ((counter & (1 << i)) != 0)
        {
          System.out.printf("%c", s.charAt(i));
        }
      }

      System.out.println();
    }
  }
}
