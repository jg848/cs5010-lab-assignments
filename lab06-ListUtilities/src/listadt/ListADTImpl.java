package listadt;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Implementation class of the {@link ListADT} interface. Contains the
 * implementations of the operations defined in the {@link ListADT} interface.
 * It has an instance of {@link GenericListNode} that is mutated when the
 * operations are performed on it.
 * 
 * @author Jaswin Gumpella
 * 
 * @param <T> represents the generic data type.
 */
public class ListADTImpl<T> implements ListADT<T> {
  private GenericListNode<T> head;

  /**
   * Default constructor for the {@link ListADTImpl} class which initializes the
   * instance of {@link GenericListNode} with an empty node.
   */
  public ListADTImpl() {
    this.head = new GenericListEmptyNode<>();
  }

  /**
   * A private constructor that is used internally.
   * 
   * @param head the head of this list.
   */
  private ListADTImpl(GenericListNode<T> head) {
    this.head = head;
  }

  @Override
  public void addFront(T b) {
    if (b == null) {
      throw new IllegalArgumentException();
    }
    this.head = head.addFront(b);
  }

  @Override
  public void addBack(T b) {
    if (b == null) {
      throw new IllegalArgumentException();
    }
    this.head = head.addBack(b);
  }

  @Override
  public void add(int index, T b) {
    this.head = head.add(index, b);
  }

  @Override
  public int getSize() {
    return head.count();
  }

  @Override
  public void remove(T b) {
    this.head = head.remove(b);
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    if (index < 0 || index >= head.count()) {
      throw new IllegalArgumentException();
    }
    return head.get(index);
  }

  @Override
  public ListADT<T> filter(Predicate<T> predicate) {
    return new ListADTImpl<>(head.filter(predicate));
  }

  @Override
  public <R> ListADT<R> map(Function<T, R> converter) {
    return new ListADTImpl<>(head.map(converter));
  }

  @Override
  public T fold(T identity, BinaryOperator<T> accumulator) {
    if (identity == null) {
      throw new IllegalArgumentException();
    }
    return head.fold(identity, accumulator);
  }

  @Override
  public boolean disjoint(ListADT<T> two) {
    if (two instanceof ListADTImpl) {
      ListADTImpl<T> other = (ListADTImpl<T>) two;
      return this.head.disjoint(other.head);
    } else {
      return true;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof ListADTImpl) {
      return this.head.equals(((ListADTImpl<?>) o).head);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(head.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append(head.toString());
    builder.append("]");
    return builder.toString();
  }
}
