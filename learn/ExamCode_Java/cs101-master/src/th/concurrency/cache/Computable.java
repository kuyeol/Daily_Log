package th.concurrency.cache;

// describe a function with input of type X
// and the result of type Y
public interface Computable<Y, X>
{
  Y compute(X arg) throws InterruptedException;
}
