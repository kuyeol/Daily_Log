package th.collection.test;

import th.io.Console;
import th.io.BigFile;
import th.stats.Timer;

/**
 * Compare the performance of th.collection.map.HashMap vs java.util.HashMap
 */
public class HashMapTest
{

  // read each word from BigFile (maximum n words)
  // ignoring word whose lentgth < cutoff
  // then build a th.collection.HashMap() containg each word and its frequency
  // then scan the hashtable to get the most frequent word
  private static WordCount getTopWord1(BigFile file, int n, int cutoff)
  {
    th.collection.HashMap<String, Integer> table = new th.collection.HashMap();
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

      if (table.contains(word))
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
    for (th.collection.HashMap.Entry<String, Integer> entry : table.entries())
    {
      if (entry.value > maxWordCount.count)
      {
        maxWordCount = new WordCount(entry.key, entry.value);
      }
    }

    return maxWordCount;
  }

  private static WordCount getTopWord2(BigFile file, int n, int cutoff)
  {
    java.util.Map<String, Integer> table = new java.util.HashMap(16, 2.0f);
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
    for (java.util.Map.Entry<String, Integer> entry : table.entrySet())
    {
      if (entry.getValue() > maxWordCount.count)
      {
        maxWordCount = new WordCount(entry.getKey(), entry.getValue());
      }
    }

    return maxWordCount;
  }

  // Compare the performance of java.utl.HashMap vs th.collection.map.HashMap
  public static void testPerformance()
  {
    Timer time;
    // read in 124MB text file with over 16 millions words
    BigFile inFile = new BigFile("/home/td/Dropbox/git/cs101/src/th/collection/test/leipzig1M.txt");

    // keep track the running time using JDK HashMap , LinkedHashMap data
    // structures
    double[] runtime = new double[2];

    for (int n = 1000; n < inFile.numWords(); n = n + n)
    {
      time = new Timer();
      getTopWord1(inFile, n, 4);
      runtime[0] = time.elapsed();

      time = new Timer();
      getTopWord2(inFile, n, 4);
      runtime[1] = time.elapsed();
      Console
          .printf("Processed %d words, <My HashMap, JDK HashMap> time= <%5.2f, %5.2f> %n", n, runtime[0], runtime[1]);
    }
  }

  public static void main(String args[])
  {
    testPerformance();
  }

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
}
