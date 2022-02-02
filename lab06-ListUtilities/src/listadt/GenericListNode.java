package listadt;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Generic interface which represents all the operations to be supported by a
 * list of objects of type T.
 * 
 * @author Jaswin Gumpella
 * 
 * @param <T> represents generic data type.
 */
public interface GenericListNode<T> {
  /**
   * Return the number of objects in this list.
   *
   * @return the size of this list
   */
  int count();

  /**
   * Add the given object to the front of this list and return this modified list.
   *
   * @param b the object to be added
   * @return the resulting list
   */
  GenericListNode<T> addFront(T b);

  /**
   * Add the given object to the back of this list and return this modified list.
   *
   * @param b the object to be added
   * @return the resulting list
   */
  GenericListNode<T> addBack(T b);

  /**
   * A method that adds the given object at the given index in this list . If
   * index is 0, it means this object should be added to the front of this list
   *
   * @param index the position to be occupied by this object, starting at 0
   * @param b     the object to be added
   * @return the resulting list
   * @throws IllegalArgumentException if an invalid index is passed
   */
  GenericListNode<T> add(int index, T b) throws IllegalArgumentException;

  /**
   * Remove the first instance of this object from the list.
   *
   * @param b the object to be removed
   * @return the node that was removed
   */
  GenericListNode<T> remove(T b);

  /**
   * Get the object at the specified index, with 0 meaning the first object in
   * this list.
   *
   * @param index the specified index
   * @return the object at the specified index
   * @throws IllegalArgumentException if an invalid index is passed
   */
  T get(int index) throws IllegalArgumentException;

  /**
   * A general map higher order function on nodes. This returns a list of
   * identical structure, but each data item of type T converted into R using the
   * provided converter method.
   *
   * @param converter the function needed to convert T into R
   * @param <R>       the type of the data in the returned list
   * @return the head of a list that is structurally identical to this list, but
   *         contains data of type R
   */
  <R> GenericListNode<R> map(Function<T, R> converter);

  /**
   * Filters a list with the given predicate and returns the filtered list.
   * 
   * @param predicate represents the predicate to apply the filter.
   * @return ListAdt which is the filtered list.
   */
  GenericListNode<T> filter(Predicate<T> predicate);

  /**
   * Reduces the list to a single value using the accumulator.
   * 
   * @param identity    represents the initial value.
   * @param accumulator represents the accumulator.
   * @return T which is the single value result.
   */
  T fold(T identity, BinaryOperator<T> accumulator);

  /**
   * Returns true if the two lists have no elements in common.
   *
   * @param two the second list
   * @return if the two lists have no elements in common
   * @throws IllegalArgumentException if either list is null or if either list
   *                                  contains a null element
   */
  boolean disjoint(GenericListNode<T> two);
}
