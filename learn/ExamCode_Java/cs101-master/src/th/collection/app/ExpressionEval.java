package th.collection.app;

import th.collection.Stack;
import th.io.Console;

// Evaluate math expressions using 2 stacks
// enter:  ( ( ( 3 + 7 ) / 2 ) * 6 ) 
public class ExpressionEval
{

  public static void eval()
  {
    Stack<Double> operands = new Stack<Double>();
    Stack<String> operators = new Stack<String>();
    while (!Console.empty())
    {
      String s = Console.readStr();
      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
      {
        operators.push(s);
      } else if (s.equals("("))
      {
      } else if (s.equals(")"))
      {
        // evaluate
        String op = operators.pop();
        if (op.equals("+"))
        {
          operands.push(operands.pop() + operands.pop());
        } else if (op.equals("-"))
        {
          operands.push(-operands.pop() + operands.pop());
        }
        if (op.equals("*"))
        {
          operands.push(operands.pop() * operands.pop());
        }
        if (op.equals("/"))
        {
          operands.push((1 / operands.pop()) * operands.pop());
        }
      } else
      { // assuming the rest are numbers
        operands.push(Double.parseDouble(s));
      }
    }
    System.out.println(operands.pop());
  }

  /** a quick test */
  public static void main(String args[])
  {
    eval();
  }
}
