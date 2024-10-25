package th.io;

// Give simplified API to read each word from a an input steam 
// e.g. from a file input stream or an stream of words randomly made on the fly
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import th.probability.Rand;

public class BigFile
{

  private final boolean simulation;
  private Iterator<String> itr;
  private ArrayList<String> simfile_content;
  private String[] file_content;
  private int size;

  // get simple access to a file from a file name
  private class FileIterator implements Iterator
  {

    private int index;

    public FileIterator() {
      index = 0;
    }

    public boolean hasNext()
    {
      if (index >= file_content.length)
      {
        return false;
      } else
      {
        return true;
      }
    }

    public String next()
    {
      String word = file_content[index];
      index++;
      return word;
    }

    // not impl

    public void remove()
    {
    }
  }

  public BigFile(String fname) {
    simulation = false;
    file_content = Instream.readStrings(fname);
    size = file_content.length;
    itr = new FileIterator();
  }

  // simulate a file with n words made up from m distinct words
  // each word has length from lo to hi characters
  // made up from the below alphabet
  public BigFile(int m, int n, int lo, int hi) {
    simulation = true;
    String alphabet = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ0123456789";
    Set<String> distint_words = new HashSet<String>();
    while (true)
    {
      int wordlen = Rand.uniform(lo, hi);
      int start = Rand.uniform(0, alphabet.length() - wordlen);
      String word = alphabet.substring(start, start + wordlen);
      distint_words.add(word);

      // got enough m distint words
      if (distint_words.size() >= m)
      {
        break;
      }
    }

    String[] m_word_arr = distint_words.toArray(new String[0]);
    simfile_content = new ArrayList<String>(n);
    for (int i = 0; i < n; i++)
    {
      int k = Rand.uniform(0, m_word_arr.length);
      String random_word = m_word_arr[k];
      simfile_content.add(random_word);
    }
    size = simfile_content.size();
    itr = simfile_content.listIterator();
  }

  public String getNextWord()
  {
    if (itr.hasNext())
    {
      return itr.next();
    } else
    {
      return "";
    }
  }

  public void reset()
  {
    if (simulation)
    {
      itr = simfile_content.listIterator();
    } else
    {
      itr = new FileIterator();
    }
    return;
  }

  public int numWords()
  {
    return size;
  }

  // test gen a file with over 100 words
  public static void main(String args[])
  {
    BigFile f = new BigFile(1000, 1000, 2, 8);
  }
}
