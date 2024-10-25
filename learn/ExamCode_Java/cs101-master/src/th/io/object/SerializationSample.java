package th.io.object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import th.io.Console;
import th.collection.LinkedList;

public class SerializationSample
{

  // a sample Serializable class containing static and transient variables
  static class Sample implements Serializable
  {
    public String name;
    public int id;
    transient double transientField;

    // id2 is not Serializable?
    public static int id2;

    public BigDecimal amount;
  }

  public static void main(String args[]) throws IOException, ClassNotFoundException
  {
    LinkedList<Sample> list = new LinkedList();
    for (int i = 0; i < 10; i++)
    {
      Sample s = new Sample();
      s.id = i;
      s.name = "name" + i;
      s.id2 = i * 10;
      s.amount = new BigDecimal(i * 10.1);
      s.transientField = i * 100;
      list.add(s);
    }

    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sample_list.ser"));
    out.writeObject(list);

    ObjectInputStream in = new ObjectInputStream(new FileInputStream("sample_list.ser"));
    LinkedList<Sample> list2 = (LinkedList<Sample>) in.readObject();
    for (Sample s : list2)
    {
      Console.printf("Sample %d, name = %6s, id2= %2d, amount = %5.2f, transientField= \n", s.id, s.name, s.id2,
          s.amount, s.transientField);
    }
  }
}
