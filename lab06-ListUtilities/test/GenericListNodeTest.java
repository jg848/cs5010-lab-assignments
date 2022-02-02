import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import listadt.GenericListElementNode;
import listadt.GenericListEmptyNode;
import listadt.GenericListNode;
import listadt.ListADT;
import listadt.ListADTImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link GenericListElementNode}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class GenericListNodeTest {

  GenericListNode<Integer> list;
  GenericListNode<Integer> list1;

  /**
   * Method to setup the test class with required attributes.
   */
  @Before
  public void setUp() {
    list = new GenericListEmptyNode<>();
    list.addFront(1);
    list1 = new GenericListElementNode<>(1, list);
  }

  /**
   * Test method for {@link listadt.GenericListElementNode#hashCode()}.
   */
  @Test
  public final void testHashCode() {
    list.add(0, 3);
    GenericListNode<Integer> list1 = list;
    assertEquals(list.hashCode(), list1.hashCode());
  }

  /**
   * Test method for
   * {@link listadt.GenericListElementNode#GenericListElementNode(Object, GenericListNode)}.
   */
  @Test
  public final void testGenericListElementNode() {
    assertEquals("1", list1.toString());
  }

  /**
   * Test method for {@link listadt.GenericListElementNode#count()}.
   */
  @Test
  public final void testCount() {
    assertEquals(1, list1.count());
  }

  /**
   * Test method for
   * {@link listadt.GenericListElementNode#addFront(java.lang.Object)}.
   */
  @Test
  public final void testAddFront() {
    GenericListNode<Integer> testList = new GenericListElementNode<>(1, list);
    testList.addFront(1);
    assertEquals(1, testList.count());
  }

  /**
   * Test method for
   * {@link listadt.GenericListElementNode#addBack(java.lang.Object)}.
   */
  @Test
  public final void testAddBack() {
    GenericListNode<Integer> testList = new GenericListElementNode<>(1, list);
    testList.addFront(1);
    testList.addBack(2);
    assertEquals("1, 2", testList.toString());
  }

  /**
   * Test method for
   * {@link listadt.GenericListElementNode#add(int, java.lang.Object)}.
   */
  @Test
  public final void testAdd() {
    GenericListNode<Integer> testList = new GenericListElementNode<>(1, list);
    testList.addFront(1);
    testList.addBack(2);
    testList.add(1, 3);
    assertEquals("1, 3, 2", testList.toString());
  }

  /**
   * Test method for
   * {@link listadt.GenericListElementNode#remove(java.lang.Object)}.
   */
  @Test
  public final void testRemove() {
    GenericListNode<Integer> testList = new GenericListElementNode<>(1, list);
    testList.addFront(1);
    testList.addBack(2);
    testList.add(1, 3);
    testList = testList.remove(1);
    assertEquals("3, 2", testList.toString());
  }

  /**
   * Test method for {@link listadt.GenericListElementNode#get(int)}.
   */
  @Test
  public final void testGet() {
    GenericListNode<Integer> testList = new GenericListElementNode<>(1, list);
    testList.addFront(1);
    testList.addBack(2);
    testList.add(1, 3);
    assertEquals((int) 1, (int) testList.get(0));
  }

  /**
   * Test method for
   * {@link listadt.GenericListElementNode#map(java.util.function.Function)}.
   */
  @Test
  public final void testMap() {
    ListADT<Integer> list = new ListADTImpl<>();
    list.addFront(1);
    list.addFront(2);
    list.addFront(3);
    list.addFront(1);
    ListADT<Integer> newList = list.map((Integer integer) -> integer + 1);
    assertEquals(4, newList.getSize());
    assertEquals(2, (int) newList.get(3));
    assertEquals(3, (int) newList.get(2));
    assertEquals(4, (int) newList.get(1));
    assertEquals(2, (int) newList.get(0));
    assertEquals(1, (int) list.get(3));
    assertEquals(2, (int) list.get(2));
    assertEquals(3, (int) list.get(1));
    assertEquals(1, (int) list.get(0));
  }

  /**
   * Test method for
   * {@link listadt.GenericListElementNode#filter(java.util.function.Predicate)}.
   */
  @Test
  public final void testFilter() {
    ListADT<Integer> list = new ListADTImpl<>();
    list.addFront(1);
    list.addFront(2);
    list.addFront(3);
    list.addFront(1);
    ListADT<Integer> newList = list.filter((Integer integer) -> integer == 1);
    assertEquals(2, newList.getSize());
    assertEquals(1, (int) newList.get(0));
    assertEquals(1, (int) newList.get(1));
    assertEquals(4, list.getSize());

  }

  /**
   * Test method for
   * {@link listadt.GenericListElementNode#fold(Object, BinaryOperator)}.
   */
  @Test
  public final void testFold() {
    ListADT<Integer> list = new ListADTImpl<>();
    list.addFront(1);
    list.addFront(2);
    list.addFront(3);
    list.addFront(1);
    assertEquals(7, (int) list.fold(0, (Integer a, Integer b) -> (int) a + b));
    assertEquals(8, (int) list.fold(1, (Integer a, Integer b) -> (int) a + b));
    assertEquals(6, (int) list.fold(-1, (Integer a, Integer b) -> (int) a + b));
  }

  /**
   * Test method for
   * {@link listadt.GenericListElementNode#disjoint(listadt.GenericListNode)}.
   */
  @Test
  public final void testDisjoint() {
    assertTrue(list1.disjoint(list));
  }

  /**
   * Test method for
   * {@link listadt.GenericListElementNode#disjoint(listadt.GenericListNode)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testDisjointNull() {
    assertTrue(list1.disjoint(null));
  }

  /**
   * Test method for
   * {@link listadt.GenericListElementNode#equals(java.lang.Object)}.
   */
  @Test
  public final void testEqualsObject() {
    assertFalse(list.equals(list1));
  }

  /**
   * Test method for {@link listadt.GenericListElementNode#toString()}.
   */
  @Test
  public final void testToString() {
    assertEquals("", list.toString());
  }

}
