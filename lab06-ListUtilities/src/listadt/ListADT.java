package listadt;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This interface represents a generic abstract data type list.
 *
 * @author Jaswin Gumpella
 * 
 * @param <T> the type of data that will work with this list as a generic
 *            parameter.
 */
public interface ListADT<T> {
  /**
   * Add an object to the front of this list.
   * 
   * @param b the object to be added to the front of this list
   */
  void addFront(T b);

  /**
   * Add an object to the back of this list (so it is the last object in the list.
   * 
   * @param b the object to be added to the back of this list
   */
  void addBack(T b);

  /**
   * Add an object to this list so that it occupies the provided index. Index
   * begins with 0.
   * 
   * @param index the index to be occupied by this object, beginning at 0
   * @param b     the object to be added to the list
   */
  void add(int index, T b);

  /**
   * Return the number of objects currently in this list.
   * 
   * @return the size of the list
   */
  int getSize();

  /**
   * Remove the first instance of this object from this list.
   * 
   * @param b the object to be removed
   */
  void remove(T b);

  /**
   * Get the (index)th object in this list.
   * 
   * @param index the index of the object to be returned
   * @return the object at the given index
   * @throws IllegalArgumentException if an invalid index is passed
   */
  T get(int index) throws IllegalArgumentException;

  /**
   * Filters a list with the given predicate and returns the filtered list.
   * 
   * @param predicate represents the predicate to apply the filter.
   * @return ListADT which is the filtered list.
   */
  ListADT<T> filter(Predicate<T> predicate);

  /**
   * Returns a new list of different type that is manipulated using the converter.
   * 
   * @param converter represents the function to be called.
   * @param <R>       represents the returned type.
   * @return ListADT of type R.
   */
  <R> ListADT<R> map(Function<T, R> converter);

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
  boolean disjoint(ListADT<T> two);
}
