package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation class of the {@link TreeNode} interface. Represents an empty
 * node in the tree and implements all the operations defined in the interface.
 * 
 * @author Jaswin Gumpella
 * 
 * @param <T> the type of element in the tree.
 */
public class EmptyNode<T extends Comparable<T>> implements TreeNode<T> {

  @Override
  public TreeNode<T> addChild(T child) {
    return new LeafNode<>(child);
  }

  @Override
  public int count() {
    return 0;
  }

  @Override
  public List<T> toList() {
    return new ArrayList<>();
  }

  @Override
  public int height() {
    return 0;
  }

  @Override
  public boolean present(T data) {
    return false;
  }

  @Override
  public T minimum() {
    return null;
  }

  @Override
  public T maximum() {
    return null;
  }

  @Override
  public String preOrder() {
    return "";
  }

  @Override
  public String inOrder() {
    return "";
  }

  @Override
  public String postOrder() {
    return "";
  }

}
