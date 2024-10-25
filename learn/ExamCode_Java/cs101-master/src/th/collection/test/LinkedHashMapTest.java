package th.collection.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import th.io.Console;
import th.io.BigFile;
import th.probability.Rand;
import th.stats.Timer;

public class LinkedHashMapTest
{

  private static class WordCount implements Comparable<WordCount>
  {

    public String word;
    public long count;

    public WordCount(String word, long count) {
      this.word = word;
      this.count = count;
    }

    public WordCount(Map.Entry<String, Integer> entry) {
      this(entry.getKey(), entry.getValue());
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

  // read each word from BigFile (maximum n words)
  // ignoring word whose lentgth < cutoff
  // then build a Map of each word and its frequency
  // then scan the hashtable to get the most frequent word
  private static WordCount getTopWord(Map<String, Integer> table, BigFile file, int n, int cutoff)
  {

    String word;
    file.reset();
    int word_i = 1;
    while (!"".equals(word = file.getNextWord()))
    {
      if (word.length() < cutoff)
      {
        continue;
      }

      if (word_i == n)
      {
        break;
      }

      if (table.containsKey(word))
      {
        table.put(word, table.get(word) + 1);
      } else
      {
        table.put(word, 1);
      }

      ++word_i;
    }

    // find the most frequent word
    WordCount maxWordCount = new WordCount("", 0);
    for (Map.Entry<String, Integer> entry : table.entrySet())
    {
      if (entry.getValue() > maxWordCount.count)
      {
        maxWordCount = new WordCount(entry);
      }
    }

    return maxWordCount;
  }

  // Compare the performance of using TreeMap vs HashMap vs LinkedHashMap
  public static void testPerformance()
  {
    Timer time;
    Map table;

    // read in 124MB text file
    BigFile inFile = new BigFile("/home/td/Dropbox/git/cs101/src/th/collection/test/leipzig1M.txt");

    // keep track the running time using TreeMap, HashMap , LinkedHashMap
    // data structures
    double[] runtime = new double[3];

    for (int n = 1000; n < inFile.numWords(); n = n + n)
    {
      time = new Timer();
      table = new HashMap();
      getTopWord(table, inFile, n, 4);
      runtime[0] = time.elapsed();

      time = new Timer();
      table = new LinkedHashMap();
      getTopWord(table, inFile, n, 4);
      runtime[1] = time.elapsed();

      time = new Timer();
      table = new TreeMap();
      getTopWord(table, inFile, n, 4);
      int m = table.size();
      runtime[2] = time.elapsed();
      Console.printf("Processed %d words, %d distinct, <HashMap, LinkedMap, TreeMap> time= <%5.2f, %5.2f %5.2f> %n", n,
          m, runtime[0], runtime[1], runtime[2]);
    }
  }

  // test ordering of HashMap vs LinkedHashMap vs TreeMap
  public static void testOrdering()
  {
    HashMap<Integer, Double> hmap = new HashMap();
    for (int i = 10; i > 0; --i)
    {
      hmap.put(Rand.uniform(1, 1000000), i * 1.0);
    }
    Console.println("Iterating the Hashmap");
    for (Map.Entry entry : hmap.entrySet())
    {
      Console.printf("%d, %5.2f %n", entry.getKey(), entry.getValue());
    }

    LinkedHashMap<Integer, Double> lhmap = new LinkedHashMap();
    lhmap.putAll(hmap);
    Console.println("Iterating the LinkedHashMap");
    for (Map.Entry entry : lhmap.entrySet())
    {
      Console.printf("%d, %5.2f %n", entry.getKey(), entry.getValue());
    }

    TreeMap<Integer, Double> tmap = new TreeMap(hmap);
    Console.println("Iterating the TreeMap");
    for (Map.Entry entry : tmap.entrySet())
    {
      Console.printf("%d, %5.2f %n", entry.getKey(), entry.getValue());
    }

    LinkedHashMap<Integer, Double> lmap2 = new LinkedHashMap<Integer, Double>(16, 0.75f, true);
    for (int i = 10; i > 0; --i)
    {
      lmap2.put(Rand.uniform(1, 1000000), i * 1.0);
    }

    int key5 = 0;
    Console.println("Iterating the access-order LinkedHashMap");
    for (Map.Entry<Integer, Double> entry : lmap2.entrySet())
    {
      if (entry.getValue() == 5.0)
      {
        key5 = entry.getKey();
      }
      Console.printf("%d, %5.2f %n", entry.getKey(), entry.getValue());
    }

    lmap2.get(key5);
    Console.println("Iterating the access LinkedHashMap after lmap2.get(key5);");
    for (Map.Entry<Integer, Double> entry : lmap2.entrySet())
    {
      Console.printf("%d, %5.2f %n", entry.getKey(), entry.getValue());
    }

  }

  public static void main(String args[])
  {
    // testOrdering();
    testPerformance();
  }
}
