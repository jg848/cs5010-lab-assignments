import static org.junit.Assert.assertEquals;

import bignumber.BigNumber;
import bignumber.BigNumberEmptyNode;
import bignumber.BigNumberImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the {@link BigNumberEmptyNode} class.
 * 
 * @author Jaswin Gumpella
 *
 */
public class BigNumberEmptyNodeTest {

  BigNumberEmptyNode emptyNode;

  /**
   * Method to setup the test class.
   * 
   * @throws java.lang.Exception for invalid parameters.
   */
  @Before
  public void setUp() throws Exception {
    emptyNode = new BigNumberEmptyNode();
  }

  /**
   * Test method for {@link bignumber.BigNumberEmptyNode#length()}.
   */
  @Test
  public final void testLength() {
    assertEquals(0, emptyNode.length());
  }

  /**
   * Test method for {@link bignumber.BigNumberEmptyNode#shiftLeft(int)}.
   */
  @Test
  public final void testShiftLeft() {
    emptyNode.shiftLeft(10);
    assertEquals("", emptyNode.toString());
  }

  /**
   * Test method for
   * {@link bignumber.BigNumberEmptyNode#addHelper(int, bignumber.BigNumber)}.
   */
  @Test
  public final void testAddHelper() {
    emptyNode.addHelper(2, new BigNumberImpl("123"));
    assertEquals("", emptyNode.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberEmptyNode#shiftRight(int)}.
   */
  @Test
  public final void testShiftRight() {
    emptyNode.shiftRight(10);
    assertEquals("", emptyNode.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberEmptyNode#addDigit(int)}.
   */
  @Test
  public final void testAddDigit() {
    emptyNode.addDigit(3);
    assertEquals("", emptyNode.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberEmptyNode#getDigitAt(int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testGetDigitAt() {
    emptyNode.getDigitAt(0);
  }

  /**
   * Test method for {@link bignumber.BigNumberEmptyNode#copy()}.
   */
  @Test
  public final void testCopy() {
    BigNumber empty = emptyNode.copy();
    assertEquals(empty.toString(), emptyNode.toString());
  }

  /**
   * Test method for
   * {@link bignumber.BigNumberEmptyNode#add(bignumber.BigNumber)}.
   */
  @Test
  public final void testAdd() {
    emptyNode.add(new BigNumberImpl("123"));
    assertEquals("", emptyNode.toString());
  }

  /**
   * Test method for
   * {@link bignumber.BigNumberEmptyNode#compareTo(bignumber.BigNumber)}.
   */
  @Test
  public final void testCompareTo() {
    assertEquals(0, emptyNode.compareTo(new BigNumberImpl("123")));
  }

  /**
   * Test method for
   * {@link bignumber.BigNumberEmptyNode#compareTo(bignumber.BigNumber)}.
   */
  @Test
  public final void testCompareToZero() {
    BigNumber empty = emptyNode.copy();
    assertEquals(0, emptyNode.compareTo(empty));
  }

  /**
   * Test method for
   * {@link bignumber.BigNumberEmptyNode#compareTo(bignumber.BigNumber)}.
   */
  @Test
  public final void testCompareToLess() {
    BigNumber empty = emptyNode.copy();
    empty.addDigit(9);
    assertEquals(0, emptyNode.compareTo(empty));
  }

  /**
   * Test method for {@link bignumber.BigNumberEmptyNode#toString()}.
   */
  @Test
  public final void testToString() {
    assertEquals("", emptyNode.toString());
  }

}
