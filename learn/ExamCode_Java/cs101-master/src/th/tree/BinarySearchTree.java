package th.tree;

public class BinarySearchTree<E extends Comparable>
{

  private BinaryTreeNode<E> root;

  /**
   * Find 3 entries using key k. return an array of 3 Entry objects.
   * 
   * Entry[0] hold largest key less than k or null if there is no such value
   * Entry[1] hold the entry matching k, or null if there is no such value
   * Entry[2] hold smallest key greater than k or null if there is no such value
   * 
   * @param key
   * @return
   */
  public Object find(E key)
  {
    BinaryTreeNode<E> node = root;

    // found hold the entry if exact matching k, otherwise found is null
    Object found = null;

    // prev hold largest key less than k
    Object prev = null;

    // next hold smallest key greater than k
    Object next = null;

    while (node != null)
    {
      Comparable current = (Comparable) node.entry;
      if (key.compareTo(node.entry) == 0)
      {
        found = node.entry;
        if (node.left != null)
        {
          prev = node.left.max();
        }

        if (node.right != null)
        {
          next = node.right.min();
        }
        break;
      } else if (key.compareTo(node.entry) > 0)
      {
        if (prev == null)
        {
          prev = node.entry;
        } else if (current.compareTo(prev) > 0)
        {
          prev = node.entry;
        }
        node = node.right;
      } else
      {
        if (next == null)
        {
          next = node.entry;
        } else if (current.compareTo(next) < 0)
        {
          next = node.entry;
        }
        node = node.left;
      }
    }

    Object[] ret = { prev, found, next };
    return ret;
  }

  public void insert(E entry)
  {
    if (root == null)
    {
      root = new BinaryTreeNode(entry);
      return;
    }

    BinaryTreeNode n = root;
    BinaryTreeNode p = root;
    E key = entry;
    String lastAction = "";

    while (n != null)
    {
      if (key.compareTo(n.entry) <= 0)
      {
        lastAction = "moveLeft";
        p = n;
        n = n.left;
      } else
      {
        p = n;
        n = n.right;
        lastAction = "moveRight";
      }
    }

    BinaryTreeNode newNode = new BinaryTreeNode(entry);
    newNode.parent = p;
    if (lastAction.compareTo("moveLeft") == 0)
    {
      p.left = newNode;
    } else
    {
      p.right = newNode;
    }
  }

  public void remove(E entry)
  {
    BinaryTreeNode n = root;
    E key = entry;
    while (n != null)
    {
      if (key.compareTo(n.entry) == 0)
      {
        break;
      } else if (key.compareTo(n.entry) < 0)
      {
        n = n.right;
      } else
      {
        n = n.left;
      }
    }

    if (n == null)
    {
      return;
    } else
    {

      // no child
      if (n.left == null && n.right == null)
      {

        // is n a left child of its parent
        if (n.parent.left == n)
        {
          n.parent.left = null;

          // n is right child
        } else if (n.parent.right == n)
        {
          n.parent.right = null;
        }
        n.parent = null;

      } else if (n.left != null && n.right != null)
      {
        // 2 child

        // find x in n's right subtree with the smallest key
        BinaryTreeNode x = n.right;
        while (x.left != null)
        {
          x = x.left;
        }

        // remove x
        BinaryTreeNode<E> child = x.right;
        if (child != null)
        {
          child.parent = x.parent;
        }
        x.parent.left = child;

        n.entry = x.entry;

        // replace n.key by x's key
      } else
      {
        // 1 child
        BinaryTreeNode<E> child = null;
        if (n.left != null)
        {
          child = n.left;
        } else
        {
          child = n.right;
        }

        // is n a left child of its parent
        if (n.parent.left == n)
        {
          child.parent = n.parent;
          n.parent.left = child;
          // n is right child
        } else if (n.parent.right == n)
        {
          child.parent = n.parent;
          n.parent.right = child;
        }
      }
    }
  }

  public Object first()
  {
    return min();
  }

  public Object min()
  {

    if (root == null)
    {
      return null;
    }

    BinaryTreeNode n = root;
    while (n.left != null)
    {
      n = n.left;
    }
    return n.entry;
  }

  public Object last()
  {
    return max();
  }

  public Object max()
  {
    if (root == null)
    {
      return null;
    }

    BinaryTreeNode n = root;
    while (n.right != null)
    {
      n = n.right;
    }
    return n.entry;
  }

  public void preorder()
  {
    root.preorder();
  }

  public void inordoer()
  {
    root.inorder();
  }

  public void postorder()
  {
    root.postorder();
  }

  private BinaryTreeNode<E> addToNode(E[] arr, int left, int right)
  {
    if (right < left)
    {
      return null;
    }

    int mid = (left + right) / 2;
    BinaryTreeNode node = new BinaryTreeNode(arr[mid]);
    node.left = addToNode(arr, left, mid - 1);
    node.right = addToNode(arr, mid + 1, right);
    return node;
  }

  /**
   * Given a sorted array, create a BST with minimum height
   * 
   * @param array
   * @return
   */
  public BinarySearchTree<E> buildMinimumBST(E[] arr)
  {
    BinarySearchTree tree = new BinarySearchTree();
    tree.root = addToNode(arr, 0, arr.length - 1);
    return tree;
  }

  public void print()
  {
    root.printNode("");
  }
}
