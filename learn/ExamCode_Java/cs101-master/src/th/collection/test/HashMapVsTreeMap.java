package th.collection.test;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;
import th.io.Console;
import th.io.BigFile;
import th.stats.Timer;

public class HashMapVsTreeMap
{

  private static class WordCount implements Comparable<WordCount>
  {

    public String word;
    public long count;

    public WordCount(String word, long count) {
      this.word = word;
      this.count = count;
    }

    public int compareTo(WordCount another)
    {
      return (this.count < another.count ? -1 : (this.count == another.count ? 0 : 1));
    }

    @Override
    public String toString()
    {
      return word + ":" + count;
    }
  }

  private static class TreeMapTest
  {
    public static PriorityQueue<WordCount> topWords(BigFile file, int k)
    {
      file.reset();
      TreeMap<String, Integer> table = new TreeMap();
      String word;
      while (!"".equals(word = file.getNextWord()))
      {
        Integer v = table.get(word);
        if (v == null)
        {
          table.put(word, 1);
        } else
        {
          table.put(word, v + 1);
        }
      }
      return null;
    }
  }

  public static String topWordHashMap(BigFile file)
  {
    file.reset();
    HashMap<String, Integer> table = new HashMap();
    String word;
    while (!"".equals(word = file.getNextWord()))
    {
      Integer v = table.get(word);
      if (v == null)
      {
        table.put(word, 1);
      } else
      {
        table.put(word, v + 1);
      }
    }

    // find the most frequent word
    int max_c = 0;
    String max_w = "";
    for (java.util.Map.Entry<String, Integer> entry : table.entrySet())
    {
      int count = entry.getValue();
      if (count > max_c)
      {
        max_c = count;
        max_w = entry.getKey();
      }
    }
    return max_w;
  }

  // Compare the performance of HashMap vs TreeMap
  // read in 124MB text file with over 21 millions words
  public static void testPerformance()
  {
    Timer time;
    BigFile inFile = new BigFile("/home/td/Dropbox/git/cs101/src/th/collection/test/leipzig1M.txt");

    double[] runtime = { 0.0, 0.0 };
    time = new Timer();
    // String topW1 = topWordTreeMap(inFile);
    String topW1 = "";
    runtime[0] = time.elapsed();

    time = new Timer();
    String topW2 = topWordHashMap(inFile);
    runtime[1] = time.elapsed();
    Console
        .printf("Treemap: time=%5.2f, word=%s. Hashmap: time=%5.2f, word=%s. ", runtime[0], topW1, runtime[1], topW2);
  }

  public static void main(String args[])
  {
    testPerformance();
  }
}
