package th.bits;

public class BitSet
{

  private int[] bits;

  public BitSet(int size) {
    size = size >> 5;
    bits = new int[size];
  }

  boolean isVisited(int pos)
  {
    int wordnum = pos >> 5; // div by 32 bits
    int bitnum = pos & 0x1F; // mod 32
    return ((bits[wordnum] & (1 << bitnum)) != 0);
  }

  void set(int pos)
  {
    int wordnum = pos >> 5; // div by 32 bits
    int bitnum = pos & 0x1F; // mod 32
    bits[wordnum] |= 1 << bitnum;
  }
}
