package th.tree;

/**
 * Tree traversal algorithms
 */
public class Traversal
{

  // preorder traversal
  public static String toPrefix(TreeNode<String> node)
  {
    if (node == null)
    {
      return "";
    } else if (node.degree() == 0)
    {
      return node.label();
    } else
    {
      String R = "";
      for (int i = 0; i < node.numChildren(); i++)
      {
        R = R + " " + toPrefix(node.child(i));
      }
      return String.format("(%s %s)", node.label(), R);
    }
  }

  public static void main(String args[])
  {

  }

}
