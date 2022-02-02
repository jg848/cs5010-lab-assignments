package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Extends the {@link TreeNodeImpl} class to implement the {@link TreeNode}
 * interface. Represents the last child node with no branches in a tree.
 * 
 * @author Jaswin Gumpella
 * 
 * @param <T> the type of element in the tree.
 */
public class LeafNode<T extends Comparable<T>> extends TreeNodeImpl<T> {

  /**
   * Constructor for the {@link LeafNode}. Initializes the node of the tree to the
   * given data.
   * 
   * @param data represents the data of the node of a tree.
   */
  public LeafNode(T data) {
    super(data);
  }

  @Override
  public TreeNode<T> addChild(T child) {
    ChildNode<T> newNode = new ChildNode<>(this.data);
    newNode.addChild(child);
    return newNode;
  }

  @Override
  public List<T> toList() {
    List<T> result = new ArrayList<>();
    result.add(this.data);
    return result;
  }

  @Override
  public int height() {
    return 1;
  }

  @Override
  public boolean present(T data) {
    return this.data == data;
  }

  @Override
  public T minimum() {
    return this.data;
  }

  @Override
  public T maximum() {
    return this.data;
  }

  @Override
  public String preOrder() {
    return String.valueOf(this.data);
  }

  @Override
  public String inOrder() {
    return String.valueOf(this.data);
  }

  @Override
  public String postOrder() {
    return String.valueOf(this.data);
  }
}
