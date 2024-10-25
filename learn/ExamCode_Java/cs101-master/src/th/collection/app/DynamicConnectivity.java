package th.collection.app;

import th.collection.DisjointSet;
import th.io.Console;
import th.io.Instream;

/**
 * Use Disjoint-set data structure to solve dynamic connectivity problem.
 * 
 * The problem: Given an input is a sequence of pairs of integers, where each
 * integer represent an object of some type. Interpret pair (x, y) as meaning
 * "x is connected to y". Here, "connected to" is an equivalence relation (i.e.
 * it is reflexive, symmetric and transitive).
 * 
 * Devise a data structure that can remember sufficient information about the
 * pairs it has seen in order to decide whether or not a new pair of objects is
 * connected?
 * 
 * Example: Given the sequence of pairs of below objects 1 2 4 5 5 1 2 4 output:
 * 2, 4 are already connected
 */

public class DynamicConnectivity
{

  // The maximum number of pairs on the sequence stream
  public static final int STREAM_SIZE = 1000;

  public static void main(String args[])
  {

    Instream is = new Instream("/home/td/Dropbox/git/cs101/src/th/collection/app/connected.txt");

    // Assuming the maximum number of pairs on the sequence stream is
    // STREAM_SIZE
    DisjointSet sets = new DisjointSet(STREAM_SIZE);

    int[] pair = new int[2];
    while ((pair = is.read2Ints()) != null)
    {
      int x = pair[0];
      int y = pair[1];
      if (sets.connected(x, y))
      {
        Console.printf("objects %d and %d already connected %n", x, y);
        continue;
      }
      sets.union(x, y); // connect x, y
      Console.printf(" %d %d \n", x, y);
    }

  }

}
