import static org.junit.Assert.assertEquals;

import listadt.GenericListEmptyNode;
import listadt.ListADT;
import listadt.ListADTImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link ListADT}.
 */
public class ListADTImplTest {
  ListADT<Integer> list;

  /**
   * Method to setup the test class with required attributes.
   */
  @Before
  public void setUp() {
    list = new ListADTImpl<>();
  }

  /**
   * Test method for {@link ListADTImpl#ListADTImpl()}.
   */
  @Test
  public void testListADTWhenEmpty() {
    assertEquals("[]", list.toString());
  }

  /**
   * Test method for {@link ListADTImpl#addFront(Object)}.
   */
  @Test
  public void testListADTImplWhenNodeAddedToFront() {
    list.addFront(1);
    list.addFront(2);
    assertEquals("[2, 1]", list.toString());
  }

  /**
   * Test method for {@link ListADTImpl#addBack(Object)}.
   */
  @Test
  public void testConstructorWhenNodeAddedToBack() {
    list.addBack(1);
    list.addBack(2);
    assertEquals("[1, 2]", list.toString());
  }

  /**
   * Test method for {@link ListADTImpl#addFront(Object)}.
   */
  @Test
  public void addFront() {
    list.addFront(1);
    list.addFront(2);
    assertEquals(2, (int) list.get(0));
    assertEquals(1, (int) list.get(1));
  }

  /**
   * Test method for {@link ListADTImpl#addFront(Object)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void addFrontNullValue() {
    list.addFront(1);
    list.addFront(null);
  }

  /**
   * Test method for {@link ListADTImpl#addFront(Object)}.
   */
  @Test
  public void addFrontDifferentType() {
    ListADT<String> stringList = new ListADTImpl<>();
    stringList.addFront("there");
    stringList.addFront("Hi");
    assertEquals("[Hi, there]", stringList.toString());
  }

  /**
   * Test method for {@link ListADTImpl#addBack(Object)}.
   */
  @Test
  public void addBackDifferentType() {
    ListADT<String> stringList = new ListADTImpl<>();
    stringList.addBack("Hi");
    stringList.addBack("there");
    assertEquals("[Hi, there]", stringList.toString());
  }

  /**
   * Test method for {@link ListADTImpl#addBack(Object)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void addBackNullValue() {
    list.addBack(1);
    list.addBack(null);
  }

  /**
   * Test method for {@link ListADTImpl#addBack(Object)}.
   */
  @Test
  public void addBack() {
    list.addBack(1);
    assertEquals(1, (int) list.get(0));
    list.addBack(2);
    assertEquals(2, (int) list.get(1));
    assertEquals(2, list.getSize());
  }

  /**
   * Test method for {@link ListADTImpl#add(int, Object)}.
   */
  @Test
  public void testAdd() {
    list.addFront(1);
    list.addBack(0);
    list.addFront(2);
    list.add(0, 3);
    list.add(list.getSize(), -1);
    assertEquals(-1, (int) list.get(4));
    assertEquals(0, (int) list.get(3));
    assertEquals(1, (int) list.get(2));
    assertEquals(2, (int) list.get(1));
    assertEquals(3, (int) list.get(0));
  }

  /**
   * Test method for {@link ListADTImpl#add(int, Object)}.
   */
  @Test
  public void testAddIntoEmptyList() {
    list.add(0, 3);
    assertEquals(3, (int) list.get(0));
  }

  /**
   * Test method for {@link ListADTImpl#add(int, Object)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddIntoEmptyListInvalidValue() {
    list.add(0, null);
  }

  /**
   * Test method for {@link ListADTImpl#add(int, Object)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddInvalidPositionNegative() {
    list.addFront(1);
    list.addBack(0);
    list.addFront(2);
    list.add(-1, -1);
  }

  /**
   * Test method for {@link ListADTImpl#add(int, Object)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddInvalidPositionAtLength() {
    list.addFront(1);
    list.addBack(0);
    list.addFront(2);
    list.add(4, -1);
  }

  /**
   * Test method for {@link ListADTImpl#add(int, Object)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddNullValue() {
    list.addFront(1);
    list.addBack(0);
    list.addFront(2);
    list.add(3, null);
  }

  /**
   * Test method for {@link ListADTImpl#getSize()}.
   */
  @Test
  public void getSize() {
    list.addFront(1);
    list.addBack(0);
    list.addFront(2);
    list.add(0, 3);
    list.add(list.getSize(), -1);
    assertEquals(5, list.getSize());
  }

  /**
   * Test method for {@link ListADTImpl#getSize()}.
   */
  @Test
  public void getSizeOnEmptyList() {
    assertEquals(0, list.getSize());
  }

  /**
   * Test method for {@link ListADTImpl#remove(Object)}.
   */
  @Test
  public void remove() {
    list.addFront(1);
    list.addBack(0);
    list.addFront(2);
    list.add(0, 3);
    list.add(list.getSize(), -1);
    list.remove(0);
    assertEquals(4, list.getSize());
    assertEquals(-1, (int) list.get(3));
  }

  /**
   * Test method for {@link ListADTImpl#remove(Object)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void removeNonExistingValue() {
    list.addFront(1);
    list.addBack(0);
    list.addFront(2);
    list.add(0, 3);
    list.add(list.getSize(), -1);
    list.remove(4);
  }

  /**
   * Test method for {@link ListADTImpl#remove(Object)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void removeNullValue() {
    list.add(0, 3);
    list.remove(null);
  }

  /**
   * Test method for {@link ListADTImpl#get(int)}.
   */
  @Test
  public void testGet() {
    list.addFront(1);
    list.addFront(2);
    assertEquals(2, (int) list.get(0));
    assertEquals(1, (int) list.get(1));
  }

  /**
   * Test method for {@link ListADTImpl#get(int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetInvalid() {
    GenericListEmptyNode<Integer> empty = new GenericListEmptyNode<>();
    empty.get(0);
  }

  /**
   * Test method for {@link ListADTImpl#get(int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetInvalidNegativeValue() {
    list.addFront(1);
    list.addFront(2);
    assertEquals(2, (int) list.get(-1));
  }

  /**
   * Test method for {@link ListADTImpl#get(int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetInvalidMaxValue() {
    list.addFront(1);
    list.addFront(2);
    assertEquals(2, (int) list.get(2));
  }

  /**
   * Test method for {@link ListADTImpl#filter(java.util.function.Predicate)}.
   */
  @Test
  public void filter() {
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
   * Test method for {@link ListADTImpl#filter(java.util.function.Predicate)}.
   */
  @Test
  public void filterWithEmptyResult() {
    list.addFront(1);
    list.addFront(2);
    list.addFront(3);
    list.addFront(1);
    ListADT<Integer> newList = list.filter((Integer integer) -> integer == 4);
    assertEquals(0, newList.getSize());
    assertEquals("[]", newList.toString());
  }

  /**
   * Test method for {@link ListADTImpl#map(java.util.function.Function)}.
   */
  @Test
  public void map() {
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
   * Test method for {@link ListADTImpl#map(java.util.function.Function)}.
   */
  @Test
  public void mapStringValues() {
    ListADT<String> stringList = new ListADTImpl<>();
    stringList.addFront("This");
    stringList.addFront("is");
    stringList.addFront("test class");
    stringList.addFront("for");
    stringList.addFront("ListADT");
    ListADT<String> newList = stringList.map((String string) -> string + " ");
    assertEquals("[ListADT , for , test class , is , This ]", newList.toString());
  }

  /**
   * Test method for
   * {@link ListADTImpl#fold(Object, java.util.function.BinaryOperator)}.
   */
  @Test
  public void fold() {
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
   * {@link ListADTImpl#fold(Object, java.util.function.BinaryOperator)}.
   */
  @Test
  public void foldDifferentType() {
    ListADT<String> stringList = new ListADTImpl<>();
    stringList.addBack("This");
    stringList.addBack("is");
    stringList.addBack("test class");
    stringList.addBack("for");
    stringList.addBack("ListADT");
    assertEquals("Hello This is test class for ListADT",
        stringList.fold("Hello", (String a, String b) -> a + " " + b));
  }

  /**
   * Test method for
   * {@link ListADTImpl#fold(Object, java.util.function.BinaryOperator)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void foldInvalidIdentity() {
    ListADT<String> stringList = new ListADTImpl<>();
    stringList.addBack("This");
    stringList.addBack("is");
    stringList.addBack("test class");
    stringList.addBack("for");
    stringList.addBack("ListADT");
    assertEquals("This is test class for ListADT",
        stringList.fold(null, (String a, String b) -> a + " " + b));
  }

  /**
   * Test method for {@link ListADTImpl#hashCode()}.
   */
  @Test()
  public void testEmptyNodeHashCode() {
    ListADT<Integer> list1 = new ListADTImpl<>();
    assertEquals(list.hashCode(), list1.hashCode());
  }

  /**
   * Test method for {@link ListADTImpl#hashCode()}.
   */
  @Test()
  public void testElementNodeHashCode() {
    list.addFront(1);
    list.addFront(2);
    ListADT<Integer> list1 = new ListADTImpl<>();
    list1.addFront(1);
    list1.addFront(2);
    assertEquals(list.hashCode(), list1.hashCode());
  }
}
