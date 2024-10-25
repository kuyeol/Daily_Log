package th.design.prototype;

abstract class PrototypeFactory implements Cloneable
{

  @Override
  public Object clone() throws CloneNotSupportedException
  {
    // call Object.clone()
    PrototypeFactory copy = (PrototypeFactory) super.clone();
    // In an actual implementation of this pattern you might now change
    // references to
    // the expensive to produce parts from the copies that are held inside
    // the prototype.
    return copy;
  }

  abstract void prototypeFactory(int x);

  abstract void printValue();
}

/**
 * Concrete Prototypes to clone
 */
class PrototypeImpl extends PrototypeFactory
{

  int x;

  public PrototypeImpl(int x) {
    this.x = x;
  }

  @Override
  void prototypeFactory(int x)
  {
    this.x = x;
  }

  @Override
  public void printValue()
  {
    System.out.println("Value :" + x);
  }
}
