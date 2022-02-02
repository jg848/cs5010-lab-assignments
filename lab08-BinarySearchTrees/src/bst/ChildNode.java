package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Extends the {@link TreeNodeImpl} class to implement the {@link TreeNode}
 * interface. Represents a child node of the tree which has further children.
 * 
 * @author Jaswin Gumpella
 * 
 * @param <T> the type of element in the tree.
 */
public class ChildNode<T extends Comparable<T>> extends TreeNodeImpl<T> {

  /**
   * Constructor for the {@link ChildNode}. Initializes the node of the tree to
   * the given data.
   * 
   * @param data represents the data of the node of a tree.
   */
  public ChildNode(T data) {
    super(data);
  }

  @Override
  public TreeNode<T> addChild(T child) {
    if (child.compareTo(data) > 0) {
      this.right = this.right.addChild(child);
    } else if (child.compareTo(data) < 0) {
      this.left = this.left.addChild(child);
    }
    return this;
  }

  @Override
  public int count() {
    return 1 + this.left.count() + this.right.count();
  }

  @Override
  public List<T> toList() {
    List<T> result = new ArrayList<>(this.left.toList());
    result.add(this.data);
    result.addAll(this.right.toList());
    return result;
  }

  @Override
  public int height() {
    int height = 1;
    int leftTreeHeight = height + this.left.height();
    int rightTreeHeight = height + this.right.height();
    return Math.max(leftTreeHeight, rightTreeHeight);
  }

  @Override
  public boolean present(T data) {
    if (this.data == data) {
      return true;
    } else {
      if (data.compareTo(this.data) < 0) {
        return this.left.present(data);
      } else {
        return this.right.present(data);
      }
    }
  }

  @Override
  public T minimum() {
    if (this.left.count() != 0) {
      return this.left.minimum();
    } else {
      return this.data;
    }
  }

  @Override
  public T maximum() {
    if (this.right.count() != 0) {
      return this.right.maximum();
    } else {
      return this.data;
    }
  }

  @Override
  public String preOrder() {
    StringBuilder builder = new StringBuilder();
    builder.append(this.data);
    builder.append(" ");
    builder.append(this.left.preOrder());
    builder
        .append((this.right.preOrder().equals("") || this.left.preOrder().equals("")) ? "" : " ");
    builder.append(this.right.preOrder());
    return builder.toString();
  }

  @Override
  public String inOrder() {
    return this.toString();
  }

  @Override
  public String postOrder() {
    StringBuilder builder = new StringBuilder();
    builder.append(this.left.postOrder());
    builder
        .append((this.right.preOrder().equals("") || this.left.preOrder().equals("")) ? "" : " ");
    builder.append(this.right.postOrder());
    builder.append(" ");
    builder.append(this.data);
    return builder.toString();
  }

}