package th.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Instream
{

  private String charset = "UTF-8";
  private Scanner in;

  // get an input stream for standard input.
  public Instream() {
    in = new Scanner(new BufferedInputStream(System.in), charset);
    in.useLocale(Locale.US);
  }

  // get an input stream from a file with name s
  public Instream(String s) {
    try
    {
      // first try to read file from local file system
      File file = new File(s);
      if (file.exists())
      {
        in = new Scanner(file, charset);
        in.useLocale(Locale.US);
        return;
      }
    } catch (IOException ioe)
    {
      System.err.println("Could not open " + s);
    }
  }

  public String readString()
  {
    return in.next();
  }

  public int readInt()
  {
    return in.nextInt();
  }

  public boolean empty()
  {
    return !in.hasNext();
  }

  public boolean hasNextLine()
  {
    return in.hasNextLine();
  }

  public String readLine()
  {
    return in.nextLine();
  }

  public int[] read2Ints()
  {
    if (!hasNextLine())
    {
      return null;
    }
    String[] inputs = readLine().trim().split("\\s+");
    if (inputs.length != 2)
    {
      return null;
    }
    int[] pair = new int[2];
    for (int i = 0; i < 2; i++)
    {
      pair[i] = Integer.parseInt(inputs[i]);
    }
    return pair;
  }

  public void close()
  {
    in.close();
  }

  public static String[] readStrings(String fname)
  {
    Instream in = new Instream(fname);
    String[] fields = in.readEverything().trim().split("\\s+");
    return fields;
  }

  private String readEverything()
  {
    if (!in.hasNext())
    {
      return null;
    }
    return in.useDelimiter("\\A").next();
  }
}
