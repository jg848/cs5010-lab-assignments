package bst;

import java.util.List;

/**
 * Interface representing a tree like data structure. The tree structure
 * contains child nodes which contain further branches, leaf nodes which are the
 * last nodes of the tree and empty nodes which represent the end of the tree.
 * Contains all the operations which are to be supported by the nodes of a tree.
 * 
 * @author Jaswin Gumpella
 * 
 * @param <T> the type of element in the tree.
 */
public interface TreeNode<T extends Comparable<T>> {
  /**
   * Method to add a child to the tree.
   *
   * @param child the child node to be added into the tree.
   */
  TreeNode<T> addChild(T child);

  /**
   * Method to get the number of elements in the tree.
   *
   * @return an integer representing the number of elements in the tree.
   */
  int count();

  /**
   * Method to convert the tree into a list representation.
   * 
   * @return the list representation of tree in order.
   */
  List<T> toList();

  /**
   * Method to get the height of the tree.
   *
   * @return an integer representing the height of the tree.
   */
  int height();

  /**
   * Method to find if the given data is present in the tree.
   *
   * @param data the data of type T to be searched in the tree.
   * @return true if the data is present, false otherwise.
   */
  boolean present(T data);

  /**
   * Method to determine the minimum of the data in the tree as defined by its
   * ordering.
   *
   * @return the minimum data if it exists, null otherwise.
   */
  T minimum();

  /**
   * Method to determine the maximum of the data in the tree as defined by its
   * ordering.
   *
   * @return the maximum data if it exists, null otherwise.
   */
  T maximum();

  /**
   * Returns a string that present all the data in the tree, sorted in ascending
   * order. The string is formatted as [d1 d2 ... dn].
   *
   * @return a string containing the preorder traversal.
   */
  String preOrder();

  /**
   * Returns a string that present all the data in the tree in pre-order. sorted
   * in ascending order. The string is formatted as [d1 d2 ... dn].
   *
   * @return a string containing the inorder traversal.
   */
  String inOrder();

  /**
   * Returns a string that present all the data in the tree, sorted in ascending
   * order. The string is formatted as [d1 d2 ... dn].
   *
   * @return a string containing the postorder traversal.
   */
  String postOrder();
}