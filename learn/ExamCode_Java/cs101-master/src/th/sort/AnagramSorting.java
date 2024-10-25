package th.sort;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramSorting
{

  static class AnagramComparator implements Comparator<String>
  {
    private String sortChars(String s)
    {
      char[] contents = s.toCharArray();
      Arrays.sort(contents);
      return new String(contents);
    }

    public int compare(String s1, String s2)
    {
      return sortChars(s1).compareTo(sortChars(s2));
    }

  }

  public static void sort(String[] s_arr)
  {
    Arrays.sort(s_arr, new AnagramComparator());
  }

  public static void main(String args[])
  {
    String[] arr = new String[3];
    arr[0] = "bca";
    arr[1] = "ade";
    arr[2] = "ace";

    sort(arr);

    for (int i = 0; i < arr.length; i++)
    {
      System.out.println(arr[i]);
    }

  }

}
