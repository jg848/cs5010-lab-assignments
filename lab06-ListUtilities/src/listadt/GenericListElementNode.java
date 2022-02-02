package listadt;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents a non-empty node in a generic list. It has the object value and
 * the rest of the list.
 * 
 * @author Jaswin Gumpella
 * 
 * @param <T> represents generic data type.
 */
public class GenericListElementNode<T> implements GenericListNode<T> {
  private T value;
  private GenericListNode<T> rest;

  /**
   * Constructs a {@link GenericListElementNode} taking a value and the rest of
   * the list.
   * 
   * @param value represents the value of the node.
   * @param rest  represents the rest of the elements in the list.
   */
  public GenericListElementNode(T value, GenericListNode<T> rest) {
    this.value = value;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + this.rest.count();
  }

  @Override
  public GenericListNode<T> addFront(T b) {
    return new GenericListElementNode<>(b, this);
  }

  @Override
  public GenericListNode<T> addBack(T b) {
    this.rest = this.rest.addBack(b);
    return this;
  }

  @Override
  public GenericListNode<T> add(int index, T b) throws IllegalArgumentException {
    if (b == null) {
      throw new IllegalArgumentException();
    }
    if (index < 0 || index > this.count()) {
      throw new IllegalArgumentException();
    }
    if (index == 0) {
      return this.addFront(b);
    } else {
      this.rest = this.rest.add(index - 1, b);
      return this;
    }
  }

  @Override
  public GenericListNode<T> remove(T b) {
    if (b == null) {
      throw new IllegalArgumentException();
    }
    if (this.value.equals(b)) {
      return this.rest;
    } else {
      this.rest = this.rest.remove(b);
      return this;
    }
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    if (index == 0) {
      return this.value;
    } else {
      return this.rest.get(index - 1);
    }
  }

  @Override
  public <R> GenericListNode<R> map(Function<T, R> converter) {
    return new GenericListElementNode<>(converter.apply(this.value), this.rest.map(converter));
  }

  @Override
  public GenericListNode<T> filter(Predicate<T> predicate) {
    GenericListElementNode<T> filteredNode = new GenericListElementNode<>(this.value, this.rest);
    if (predicate.test(this.value)) {
      return new GenericListElementNode<>(filteredNode.value, filteredNode.rest.filter(predicate));
    } else {
      return filteredNode.rest.filter(predicate);
    }
  }

  @Override
  public T fold(T identity, BinaryOperator<T> accumulator) {
    return accumulator.apply(identity, this.rest.fold(value, accumulator));
  }

  @Override
  public boolean disjoint(GenericListNode<T> two) {
    if (two == null) {
      throw new IllegalArgumentException();
    }
    if (two instanceof GenericListEmptyNode) {
      return two.disjoint(this);
    }
    GenericListElementNode<T> other = (GenericListElementNode<T>) two;
    if (this.value.equals(other.value)) {
      return false;
    } else {
      return this.rest.disjoint(other.rest);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      throw new IllegalArgumentException();
    }
    if (this == o) {
      return true;
    }
    if (o instanceof GenericListNode) {
      GenericListElementNode<?> other = (GenericListElementNode<?>) o;
      return Objects.equals(value, other.value) && Objects.equals(rest, other.rest);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, rest);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (this.rest.count() > 0) {
      builder.append(this.value);
      builder.append(", ");
      builder.append(this.rest.toString());
    } else {
      builder.append(String.valueOf(this.value));
    }
    return builder.toString();
  }
}
