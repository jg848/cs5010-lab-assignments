package bst;

/**
 * Implementation class of the {@link BinarySearchTree} interface. Represents
 * the implementations of the operations defined in the interface to provide a
 * tree like data structure of type T.
 * 
 * @author Jaswin Gumpella
 * 
 * @param <T> the type of element in the tree.
 */
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {
  private TreeNode<T> root;

  /**
   * Constructor for the implementation class of {@link BinarySearchTree}.
   * Initializes the root of the tree to an empty node.
   */
  public BinarySearchTreeImpl() {
    this.root = new EmptyNode<>();
  }

  @Override
  public void add(T data) {
    if (data == null) {
      throw new IllegalArgumentException();
    }
    root = root.addChild(data);
  }

  @Override
  public int size() {
    return root.count();
  }

  @Override
  public int height() {
    return root.height();
  }

  @Override
  public boolean present(T data) {
    if (data == null) {
      return false;
    }
    return root.present(data);
  }

  @Override
  public T minimum() {
    if (root.count() == 0) {
      throw new IllegalStateException();
    }
    return root.minimum();
  }

  @Override
  public T maximum() {
    if (root.count() == 0) {
      throw new IllegalStateException();
    }
    return root.maximum();
  }

  @Override
  public String preOrder() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append(root.preOrder());
    builder.append("]");
    return builder.toString();
  }

  @Override
  public String inOrder() {
    return root.inOrder();
  }

  @Override
  public String postOrder() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append(root.postOrder());
    builder.append("]");
    return builder.toString();
  }

  /**
   * Method to get the string representation of a binary search tree.
   */
  @Override
  public String toString() {
    return root.toString();
  }
}
