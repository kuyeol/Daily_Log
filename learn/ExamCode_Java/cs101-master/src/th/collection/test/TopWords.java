package th.collection.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import th.io.BigFile;
import th.io.Console;
import th.stats.Timer;

// get k most frequent words in a big file
public class TopWords
{

  static boolean quiet = false;

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

  // get topK words from first n words in file
  public static PriorityQueue getTopWords(Map<String, Integer> table, BigFile file, int n, int topK)
  {
    String word;
    file.reset();
    int word_i = 1;
    while (!"".equals(word = file.getNextWord()))
    {
      if (word_i >= n)
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
      word_i++;
    }

    PriorityQueue<WordCount> topWordsQueue = new PriorityQueue(topK);
    for (int i = 1; i <= topK; i++)
    {
      topWordsQueue.add(new WordCount(null, 0));
    }

    for (Map.Entry<String, Integer> entry : table.entrySet())
    {
      if (entry.getValue() > topWordsQueue.peek().count)
      {
        topWordsQueue.add(new WordCount(entry));
        topWordsQueue.remove();
      }
    }
    return topWordsQueue;
  }

  public static void printTopWords(Map<String, Integer> table, BigFile file, int n, int topK)
  {
    PriorityQueue<WordCount> topTenQueue = getTopWords(table, file, n, topK);
    WordCount[] arr = topTenQueue.toArray(new WordCount[0]);
    Arrays.sort(arr);
    if (!quiet)
    {
      for (WordCount wc : arr)
      {
        Console.println(wc);
      }
    }
  }

  // a quick test
  public static void test1()
  {
    BigFile file = new BigFile("/home/td/Dropbox/git/cs101/src/th/collection/test/leipzig1M.txt");
    Timer timer = new Timer();
    int k = 10;

    // make the hashtable work like a linked list
    Map<String, Integer> table = new HashMap(1, 10000000.0f);
    printTopWords(table, file, 1000, k);
    Console.printf("Compute top %d words took %d secs", k, timer.elapsed());
  }

  // test the hash map performance
  // what if different initialCapacity and loadFactor factor into the
  // performance of a hashMap
  public static void configMap()
  {
    BigFile file = new BigFile(100, 100000, 2, 8);
    float[] loadFactors = new float[8];
    for (int i = 0; i < loadFactors.length; i++)
    {
      loadFactors[i] = (float) ((i + 1) * 0.25);
    }

    int x = 10;
    int[] capacity = new int[24];
    for (int i = 0; i < capacity.length; i++)
    {
      x = x + x;
      capacity[i] = x;
    }
    int k = 10;

    Timer timer;
    Map<String, Integer> table;
    int m = capacity.length;
    int n = loadFactors.length;

    double[][] perf = new double[m][n];
    for (int i = 0; i < m; i++)
    {
      for (int j = 0; j < n; j++)
      {
        int initialCapacity = capacity[i];
        float load = loadFactors[j];
        timer = new Timer();
        table = new HashMap(initialCapacity, load);
        printTopWords(table, file, 100000, k);
        perf[i][j] = timer.elapsed();
        Console.printf("capacity %d, load %f, time %8.2f %n", capacity[i], loadFactors[j], perf[i][j]);
      }
    }
    print2DArray(perf, "%8.2f");
  }

  // test to compare the performance of using TreeMap vs HashMap
  public static void performanceTest(String fname)
  {
    Timer time;
    Map table;
    int topK = 10;
    BigFile inFile = new BigFile(fname);
    double[] runtime = new double[2];

    for (int n = 1000; n < inFile.numWords(); n = n + n)
    {
      time = new Timer();
      table = new HashMap();
      printTopWords(table, inFile, n, topK);
      runtime[0] = time.elapsed();

      int m = table.size();

      time = new Timer();
      table = new TreeMap();
      printTopWords(table, inFile, n, topK);
      runtime[1] = time.elapsed();
      Console.printf("%d distinct words, %d total words, using treemap, time for <HashMap, TreeMap>=<%5.2f, %5.2f> %n",
          m, n, runtime[0], runtime[1]);
    }
  }

  public static void main(String args[])
  {
    performanceTest("/home/td/Dropbox/git/cs101/src/th/collection/test/leipzig1M.txt");
  }

  private static void print2DArray(double d[][], String format)
  {
    for (int i = 0; i < d.length; i++)
    {
      for (int j = 0; j < d[i].length; j++)
      {
        System.out.printf(format, d[i][j]);
      }
      System.out.println("");
    }
  }
}