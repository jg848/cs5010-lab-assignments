import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import listadt.GenericListElementNode;
import listadt.GenericListEmptyNode;
import listadt.ListADT;
import listadt.ListADTImpl;
import listadt.ListADTUtilities;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link ListADTUtilities}.
 */
public class ListADTUtilitiesTest {
  ListADT<Integer> list;

  /**
   * Method to setup the test class with the required attributes.
   */
  @Before
  public void setUp() {
    list = new ListADTImpl<>();
  }

  /**
   * Test method for {@link ListADTUtilities#toList(Object[])}.
   */
  @Test
  public void toList() {
    list = ListADTUtilities.toList(new Integer[] { 1, 2, 3, 4 });
    assertEquals(4, list.getSize());
    assertEquals(1, (int) list.get(0));
    assertEquals(2, (int) list.get(1));
    assertEquals(3, (int) list.get(2));
    assertEquals(4, (int) list.get(3));
  }

  /**
   * Test method for {@link ListADTUtilities#toList(Object[])}.
   */
  @Test
  public void toListEmpty() {
    list = ListADTUtilities.toList(new Integer[] {});
    assertEquals(0, list.getSize());
    assertEquals("[]", list.toString());
  }

  /**
   * Test method for {@link ListADTUtilities#toList(Object[])}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void toListNullValues() {
    list = ListADTUtilities.toList(new Integer[] { 1, null, 2 });
  }

  /**
   * Test method for {@link ListADTUtilities#addAll(ListADT, Object...)}.
   */
  @Test
  public void addAll() {
    ListADTUtilities.addAll(list, 1, 2, 3, 4, 6, 8, 9);
    assertEquals(7, list.getSize());
    assertEquals(1, (int) list.get(0));
    assertEquals(2, (int) list.get(1));
    assertEquals(3, (int) list.get(2));
    assertEquals(4, (int) list.get(3));
    assertEquals(6, (int) list.get(4));
    assertEquals(8, (int) list.get(5));
    assertEquals(9, (int) list.get(6));
  }

  /**
   * Test method for {@link ListADTUtilities#addAll(ListADT, Object...)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void addAllNull() {
    ListADTUtilities.addAll(list, (Integer) null);
  }

  /**
   * Test method for {@link ListADTUtilities#addAll(ListADT, Object...)}.
   */
  @Test
  public void addAllOneElement() {
    ListADTUtilities.addAll(list, 1);
    assertEquals("[1]", list.toString());
  }

  /**
   * Test method for {@link ListADTUtilities#addAll(ListADT, Object...)}.
   */
  @Test
  public void addAllUsingArray() {
    ListADTUtilities.addAll(list, new Integer[] { 1 });
    assertEquals("[1]", list.toString());
  }

  /**
   * Test method for {@link ListADTUtilities#addAll(ListADT, Object...)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void addAllNullValues() {
    ListADTUtilities.addAll(list, 1, null);
  }

  /**
   * Test method for {@link ListADTUtilities#frequency(ListADT, Object)}.
   */
  @Test
  public void frequency() {
    ListADTUtilities.addAll(list, 1, 2, 3, 4, 1, 2, 1, 3, 6, 8, 9);
    assertEquals(11, list.getSize());
    assertEquals(3, ListADTUtilities.frequency(list, 1));
    assertEquals(2, ListADTUtilities.frequency(list, 2));
    assertEquals(1, ListADTUtilities.frequency(list, 6));
    assertEquals(2, ListADTUtilities.frequency(list, 3));
  }

  /**
   * Test method for {@link ListADTUtilities#frequency(ListADT, Object)}.
   */
  @Test
  public void zeroFrequencyNonExistingElement() {
    ListADTUtilities.addAll(list, 1, 2, 3, 4, 1, 2, 1, 3, 6, 8, 9);
    assertEquals(11, list.getSize());
    assertEquals(0, ListADTUtilities.frequency(list, 10));
  }

  /**
   * Test method for {@link ListADTUtilities#disjoint(ListADT, ListADT)}.
   */
  @Test
  public void notDisjoint() {
    ListADTUtilities.addAll(list, 1, 2, 3, 4, 6, 8, 9);
    ListADT<Integer> otherList = new ListADTImpl<>();
    ListADTUtilities.addAll(otherList, 1, 2, 3, 4, 6, 8, 9);
    assertFalse(ListADTUtilities.disjoint(list, otherList));
  }

  /**
   * Test method for {@link ListADTUtilities#disjoint(ListADT, ListADT)}.
   */
  @Test
  public void disjoint() {
    ListADTUtilities.addAll(list, 1, 2, 3, 4, 6, 8, 9);
    ListADT<Integer> otherList = new ListADTImpl<>();
    ListADTUtilities.addAll(otherList, 3, 4, 2, 1, 7, 6, 3);
    assertTrue(ListADTUtilities.disjoint(list, otherList));
  }

  /**
   * Test method for {@link ListADTUtilities#disjoint(ListADT, ListADT)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void disjointList1Null() {
    ListADT<Integer> otherList = new ListADTImpl<>();
    ListADTUtilities.addAll(otherList, 3, 4, 2, 1, 7, 6, 3);
    ListADTUtilities.disjoint(null, otherList);
  }

  /**
   * Test method for {@link ListADTUtilities#disjoint(ListADT, ListADT)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void disjointList2Null() {
    ListADT<Integer> otherList = new ListADTImpl<>();
    ListADTUtilities.addAll(otherList, 3, 4, 2, 1, 7, 6, 3);
    ListADTUtilities.disjoint(null, otherList);
  }

  /**
   * Test method for {@link ListADTUtilities#disjoint(ListADT, ListADT)}.
   */
  @Test
  public void notDisjointPartialValues() {
    ListADTUtilities.addAll(list, 1, 2, 3, 4, 6, 8, 9);
    ListADT<Integer> otherList = new ListADTImpl<>();
    ListADTUtilities.addAll(otherList, 1, 2, 3, 1, 7, 6, 3);
    assertFalse(ListADTUtilities.disjoint(list, otherList));
  }

  /**
   * Test method for {@link ListADTUtilities#disjoint(ListADT, ListADT)}.
   */
  @Test
  public void notDisjointOneValue() {
    ListADTUtilities.addAll(list, 1, 2, 3, 4, 6, 8, 9);
    ListADT<Integer> otherList = new ListADTImpl<>();
    ListADTUtilities.addAll(otherList, 1, 2, 3, 4, 6, 8, 3);
    assertFalse(ListADTUtilities.disjoint(list, otherList));
  }

  /**
   * Test method for {@link ListADTUtilities#disjoint(ListADT, ListADT)}.
   */
  @Test
  public void notDisjointNoValues() {
    ListADT<Integer> otherList = new ListADTImpl<>();
    assertTrue(list.disjoint(otherList));
  }

  /**
   * Test method for {@link ListADTUtilities#disjoint(ListADT, ListADT)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void notDisjointNoValuesNull1() {
    GenericListEmptyNode<Integer> empty = new GenericListEmptyNode<>();
    empty.disjoint(null);
  }

  /**
   * Test method for {@link ListADTUtilities#disjoint(ListADT, ListADT)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void notDisjointValuesNull1() {
    GenericListElementNode<Integer> empty = new GenericListElementNode<Integer>(null, null);
    empty.disjoint(null);
  }

  /**
   * Test method for {@link ListADTUtilities#equals(ListADT, ListADT)}.
   */
  @Test
  public void testEquals() {
    ListADTUtilities.addAll(list, 1, 2, 3, 4, 6, 8, 9);
    ListADT<Integer> otherList = new ListADTImpl<>();
    ListADTUtilities.addAll(otherList, 1, 2, 3, 4, 6, 8, 9);
    assertTrue(ListADTUtilities.equals(list, otherList));
  }

  /**
   * Test method for {@link ListADTUtilities#equals(ListADT, ListADT)}.
   */
  @Test
  public void testNotEquals() {
    ListADTUtilities.addAll(list, 1, 2, 3, 4, 5, 8, 9);
    ListADT<Integer> otherList = new ListADTImpl<>();
    ListADTUtilities.addAll(otherList, 1, 2, 3, 4, 6, 8, 9);
    assertFalse(ListADTUtilities.equals(list, otherList));
  }

  /**
   * Test method for {@link ListADTUtilities#equals(ListADT, ListADT)}.
   */
  @Test
  public void testEqualsDifferentSize() {
    ListADTUtilities.addAll(list, 1, 2, 3, 4, 5);
    ListADT<Integer> otherList = new ListADTImpl<>();
    ListADTUtilities.addAll(otherList, 1, 2, 3, 4, 6, 8, 9);
    assertFalse(ListADTUtilities.equals(list, otherList));
  }

  /**
   * Test method for {@link ListADTUtilities#equals(ListADT, ListADT)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEqualsList1Null() {
    ListADT<Integer> otherList = new ListADTImpl<>();
    ListADTUtilities.addAll(otherList, 1, 2, 3, 4, 6, 8, 9);
    ListADTUtilities.equals(null, otherList);
  }

  /**
   * Test method for {@link ListADTUtilities#equals(ListADT, ListADT)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEqualsList2Null() {
    ListADTUtilities.addAll(list, 1, 2, 3, 4, 6, 8, 9);
    ListADTUtilities.equals(list, null);
  }
}