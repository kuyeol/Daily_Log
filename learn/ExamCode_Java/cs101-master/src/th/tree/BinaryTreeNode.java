package th.tree;

import java.util.ArrayList;

/**
 * A simple representation of a BinaryTreeNode
 */
public class BinaryTreeNode<E>
{
  Object entry;
  BinaryTreeNode parent;
  BinaryTreeNode left;
  BinaryTreeNode right;

  BinaryTreeNode(Comparable entry) {
    this.entry = entry;
  }

  public Object max()
  {
    BinaryTreeNode node = this;
    while (node.right != null)
    {
      node = node.right;
    }
    return node.entry;
  }

  public Object min()
  {
    BinaryTreeNode node = this;
    while (node.left != null)
    {
      node = node.left;
    }
    return node.entry;
  }

  public void preorder()
  {

    this.visit();

    if (left != null)
    {
      left.preorder();
    }

    if (right != null)
    {
      right.preorder();
    }

  }

  public void postorder()
  {

    if (left != null)
    {
      left.postorder();
    }

    if (right != null)
    {
      right.postorder();
    }

    this.visit();

  }

  public void inorder()
  {
    if (left != null)
    {
      left.inorder();
    }

    this.visit();

    if (right != null)
    {
      right.inorder();
    }

  }

  public void visit()
  {
    System.out.printf("visiting node %s ", this);
  }

  @Override
  public String toString()
  {
    return entry.toString();
  }

  public void printNode(String prefix)
  {
    String nodeType = "";
    if (this.parent == null)
    {
      nodeType = "root";
    } else
    {
      if (this.parent.left == this)
      {
        nodeType = "L";
      } else
      {
        nodeType = "R";
      }
    }

    System.out.printf("%s + %s : %s \n", prefix, this.entry, nodeType);
    ArrayList<BinaryTreeNode> childList = new ArrayList<BinaryTreeNode>();
    if (this.left != null)
    {
      childList.add(this.left);
    }

    if (this.right != null)
    {
      childList.add(this.right);
    }

    for (int i = 0; i < childList.size(); i++)
    {
      BinaryTreeNode node = childList.get(i);
      if (i == childList.size() - 1)
      {
        node.printNode(prefix + "    ");
      } else
      {
        node.printNode(prefix + "   |");
      }
    }
  }
}
