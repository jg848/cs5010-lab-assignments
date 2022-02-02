package bst;

/**
 * Implementation class of the {@link TreeNode} interface. Represents the
 * implementations of the operations defined in the interface to provide a tree
 * like data structure of type T.
 * 
 * @author Jaswin Gumpella
 * 
 * @param <T> the type of element in the tree.
 */
public abstract class TreeNodeImpl<T extends Comparable<T>> implements TreeNode<T> {
  protected T data;
  protected TreeNode<T> left;
  protected TreeNode<T> right;

  /**
   * Constructor for the implementation class of {@link TreeNode}. Initializes the
   * node of the tree to the given data and the child nodes to empty nodes.
   * 
   * @param data represents the data of the node of a tree.
   */
  protected TreeNodeImpl(T data) {
    if (data == null) {
      throw new IllegalArgumentException();
    }
    this.data = data;
    this.left = new EmptyNode<>();
    this.right = new EmptyNode<>();
  }

  @Override
  public int count() {
    return 1;
  }

  /**
   * Method to get the string representation of the node of the tree.
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    this.toList().forEach(element -> {
      builder.append(element);
      builder.append(" ");
    });
    builder.setLength(builder.length() - 1);
    builder.append("]");
    return builder.toString();
  }
}
