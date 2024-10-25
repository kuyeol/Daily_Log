package th.collection.test;

import th.collection.HashMap;
import th.collection.JDKHash;
import th.collection.SKHash;
import th.io.Console;
import th.io.BigFile;
import th.stats.Stats;
import th.stats.Timer;

public class HashCodeTest
{

  // Read each word from BigFile (maximum n words)
  // ignoring word whose lentgth < cutoff
  // then build a th.collection.HashMap containing each word and its frequency
  // then scan the hashtable to get the most frequent word
  private static WordCount getTopWord(th.collection.HashMap<String, Integer> table, BigFile file, int n, int cutoff)
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

  public static void stats()
  {
    // read in 124MB text file with over 16 millions words
    BigFile inFile = new BigFile("/home/td/Dropbox/git/cs101/src/th/collection/test/leipzig1M.txt");

    JDKHash<String> hash1 = new JDKHash(HashMap.DEFAULT_CAPACITY);
    SKHash<String> hash2 = new SKHash(HashMap.DEFAULT_CAPACITY);

    for (int n = 1000; n < inFile.numWords(); n = n + n)
    {
      HashMap<String, Integer> table1 = new HashMap(hash1);
      getTopWord(table1, inFile, n, 4);
      Stats stat1 = table1.stats();
      Console.printf("Processed %d words, using JDKHash %n", n);
      Console.printf("%s", stat1.toString());

      HashMap<String, Integer> table2 = new HashMap(hash2);
      getTopWord(table2, inFile, n, 4);
      Stats stat2 = table2.stats();
      Console.printf("Processed %d words, using SKHash %n", n);
      Console.printf("%s", stat2.toString());
    }
  }

  // Test the performance of different hash code schemes
  public static void testPerformance()
  {
    Timer time;
    // read in 124MB text file with over 16 millions words
    BigFile inFile = new BigFile("/home/td/Dropbox/git/cs101/src/th/collection/test/leipzig1M.txt");

    // keep track the running time using JDK HashMap , LinkedHashMap data
    // structures
    double[] runtime = new double[2];

    JDKHash<String> hash1 = new JDKHash(HashMap.DEFAULT_CAPACITY);
    SKHash<String> hash2 = new SKHash(HashMap.DEFAULT_CAPACITY);

    for (int n = 1000; n < inFile.numWords(); n = n + n)
    {
      HashMap<String, Integer> table1 = new HashMap(hash1);
      time = new Timer();
      getTopWord(table1, inFile, n, 4);
      runtime[0] = time.elapsed();

      HashMap<String, Integer> table2 = new HashMap(hash2);
      time = new Timer();
      getTopWord(table2, inFile, n, 4);
      runtime[1] = time.elapsed();
      Console.printf("Processed %d words, <JDKHash , SKHash> time= <%5.2f, %5.2f> %n", n, runtime[0], runtime[1]);
    }
  }

  public static void main(String args[])
  {
    testPerformance();
    stats(); // print statistics of the hash table
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
