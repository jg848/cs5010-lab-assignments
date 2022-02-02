package listadt;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents an empty node of the generic list implementation.
 * 
 * @author Jaswin Gumpella
 * 
 * @param <T> represents a generic data type.
 */
public class GenericListEmptyNode<T> implements GenericListNode<T> {

  @Override
  public int count() {
    return 0;
  }

  @Override
  public GenericListNode<T> addFront(T b) {
    return new GenericListElementNode<>(b, this);
  }

  @Override
  public GenericListNode<T> addBack(T b) {
    return this.addFront(b);
  }

  @Override
  public GenericListNode<T> add(int index, T b) throws IllegalArgumentException {
    if (index == 0 && null != b) {
      return addFront(b);
    }
    throw new IllegalArgumentException();
  }

  @Override
  public GenericListNode<T> remove(T b) {
    throw new IllegalArgumentException();
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    throw new IllegalArgumentException();
  }

  @Override
  public <R> GenericListNode<R> map(Function<T, R> converter) {
    return new GenericListEmptyNode<>();
  }

  @Override
  public GenericListNode<T> filter(Predicate<T> predicate) {
    return new GenericListEmptyNode<>();
  }

  @Override
  public T fold(T identity, BinaryOperator<T> accumulator) {
    return identity;
  }

  @Override
  public boolean disjoint(GenericListNode<T> two) {
    if (two == null) {
      throw new IllegalArgumentException();
    }
    return true;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      throw new IllegalArgumentException();
    }
    return obj instanceof GenericListEmptyNode;
  }

  @Override
  public int hashCode() {
    return Objects.hash(0);
  }

  @Override
  public String toString() {
    return "";
  }
}
