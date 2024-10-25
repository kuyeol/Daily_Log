package th.java.compiler.escape.analysis;

public class A
{

  final int finalValue;

  public A(B b) {
    super();
    b.doSomething(this); // this escapes!
    finalValue = 23;
  }

  int getTheValue()
  {
    return finalValue;
  }

  public static void main(String args[])
  {
    B b = new B();
    A a = new A(b);
    System.out.println(a.getTheValue());
  }
}

class B
{
  void doSomething(A a)
  {
    System.out.println(a.getTheValue());
  }
}
