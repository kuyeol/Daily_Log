package th.tree;

/**
 * A Tree node representation adapting from Paul Hilfinger
 */
public class TreeNode<T>
{

  private TreeNode[] children;
  private T label;

  public TreeNode() {
  }

  // leaf node with given label
  public TreeNode(T label) {
    this.label = label;
  }

  // internal node with k empty children
  public TreeNode(T label, int k) {
    this.label = label;
    children = new TreeNode[k];
  }

  public T label()
  {
    return label;
  }

  public int numChildren()
  {
    if (children == null)
    {
      return 0;
    } else
    {
      return children.length;
    }
  }

  // number of non-empty children of this node
  public int degree()
  {
    int degree = 0;
    if (children != null)
    {
      for (TreeNode child : children)
      {
        if (child != null)
        {
          degree += 1;
        }
      }
    }
    return degree;
  }

  public TreeNode<T> child(int k)
  {
    return children[k];
  }

  public void setChild(int k, TreeNode<T> C)
  {
    children[k] = C;
  }

}
