import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import lookandsay.LookAndSayIterator;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.NoSuchElementException;

/**
 * Test class for {@link LookAndSayIterator}.
 * 
 * @author Jaswin Gumpella
 */

public class LookAndSayIteratorTest {
  private LookAndSayIterator lookAndSayIterator;

  /**
   * Method to setup the test class with the required attributes.
   * 
   * @throws IllegalArgumentException for invalid input.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    lookAndSayIterator = new LookAndSayIterator(new BigInteger("11"));
  }

  /**
   * Test method for {@link lookandsay.LookAndSayIterator#LookAndSayIterator()}.
   */
  @Test
  public final void testLookAndSayIterator() {
    lookAndSayIterator = new LookAndSayIterator();
    assertEquals("1", lookAndSayIterator.next().toString());
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger, BigInteger)}.
   */
  @Test
  public final void testLookAndSayIteratorBigIntegerBigInteger() {
    lookAndSayIterator = new LookAndSayIterator(new BigInteger("11"), new BigInteger("100"));
    assertEquals("11", lookAndSayIterator.next().toString());
    assertEquals("21", lookAndSayIterator.next().toString());
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger, BigInteger)}.
   */
  @Test
  public final void testLookAndSayIteratorBigIntegerBigInteger1() {
    lookAndSayIterator = new LookAndSayIterator(new BigInteger("11"), new BigInteger("20"));
    assertEquals("11", lookAndSayIterator.next().toString());
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger, BigInteger)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testLookAndSayIteratorBigIntegerBigIntegerInvalidSeed() {
    new LookAndSayIterator(new BigInteger("-1"), new BigInteger("100"));
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger, BigInteger)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testLookAndSayIteratorBigIntegerBigIntegerInputWithZeroes() {
    new LookAndSayIterator(new BigInteger("1001"), new BigInteger("1002"));
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger, BigInteger)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testLookAndSayIteratorBigIntegerBigIntegerSeedGreaterThanLast() {
    new LookAndSayIterator(new BigInteger("9"), new BigInteger("8"));
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger, BigInteger)}.
   */
  @Test
  public final void testLookAndSayIteratorBigIntegerBigIntegerSeedEqualToLast() {
    lookAndSayIterator = new LookAndSayIterator(new BigInteger("9"), new BigInteger("9"));
    assertEquals("9", lookAndSayIterator.next().toString());
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger)}.
   */
  @Test
  public final void testLookAndSayIteratorBigInteger() {
    lookAndSayIterator = new LookAndSayIterator(new BigInteger("1221"));
    assertEquals("1221", lookAndSayIterator.next().toString());
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger)}.
   */
  @Test
  public final void testLookAndSayIteratorBigInteger1() {
    lookAndSayIterator = new LookAndSayIterator(new BigInteger("11"));
    assertEquals("11", lookAndSayIterator.next().toString());
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testLookAndSayIteratorBigIntegerInvalidSeed() {
    new LookAndSayIterator(new BigInteger("-1"));
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testLookAndSayIteratorBigIntegerInputWithZeroes() {
    new LookAndSayIterator(new BigInteger("1001"));
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testLookAndSayIteratorBigIntegerLastGreaterThanHundred() {
    new LookAndSayIterator(new BigInteger("9".repeat(101)));
  }

  /**
   * Test method for
   * {@link lookandsay.LookAndSayIterator#LookAndSayIterator(BigInteger)}.
   */
  @Test
  public void testLookAndSayIteratorBigIntegerSeedEqualToLast() {
    lookAndSayIterator = new LookAndSayIterator(new BigInteger("9".repeat(100)));
    assertEquals("9".repeat(100), lookAndSayIterator.next().toString());
    assertEquals("1009", lookAndSayIterator.next().toString());
  }

  /**
   * Test method for {@link lookandsay.LookAndSayIterator#prev()}.
   */
  @Test
  public final void testPrev() {
    lookAndSayIterator.next();
    lookAndSayIterator.next();
    assertEquals("1211", lookAndSayIterator.next().toString());
    assertEquals("21", lookAndSayIterator.prev().toString());
    assertEquals("21", lookAndSayIterator.next().toString());
    assertEquals("11", lookAndSayIterator.prev().toString());
    assertEquals("1", lookAndSayIterator.prev().toString());
  }

  /**
   * Test method for {@link lookandsay.LookAndSayIterator#prev()}.
   */
  @Test(expected = NoSuchElementException.class)
  public final void testPrevNoElement() {
    lookAndSayIterator = new LookAndSayIterator();
    lookAndSayIterator.prev();
  }

  /**
   * Test method for {@link lookandsay.LookAndSayIterator#hasPrevious()}.
   */
  @Test
  public final void testHasPreviousTrue() {
    lookAndSayIterator = new LookAndSayIterator();
    lookAndSayIterator.next();
    assertTrue(lookAndSayIterator.hasPrevious());
  }

  /**
   * Test method for {@link lookandsay.LookAndSayIterator#hasPrevious()}.
   */
  @Test
  public final void testHasPreviousFalse() {
    lookAndSayIterator = new LookAndSayIterator();
    assertFalse(lookAndSayIterator.hasPrevious());
  }

  /**
   * Test method for {@link lookandsay.LookAndSayIterator#hasNext()}.
   */
  @Test
  public final void testHasNextTrue() {
    lookAndSayIterator = new LookAndSayIterator(new BigInteger("11"), new BigInteger("100"));
    assertTrue(lookAndSayIterator.hasNext());
  }

  /**
   * Test method for {@link lookandsay.LookAndSayIterator#hasNext()}.
   */
  @Test
  public final void testHasNextFalse() {
    lookAndSayIterator = new LookAndSayIterator(new BigInteger("11"), new BigInteger("100"));
    lookAndSayIterator.next();
    lookAndSayIterator.next();
    assertFalse(lookAndSayIterator.hasNext());
  }

  /**
   * Test method for {@link lookandsay.LookAndSayIterator#next()}.
   */
  @Test
  public final void testNext() {
    assertEquals("11", lookAndSayIterator.next().toString());
  }

  /**
   * Test method for {@link lookandsay.LookAndSayIterator#next()}.
   */
  @Test
  public final void testNext1() {
    lookAndSayIterator.next();
    assertEquals("21", lookAndSayIterator.next().toString());
  }

  /**
   * Test method for {@link lookandsay.LookAndSayIterator#next()}.
   */
  @Test(expected = NoSuchElementException.class)
  public final void testNextNoElement() {
    lookAndSayIterator = new LookAndSayIterator(new BigInteger("11"), new BigInteger("100"));
    lookAndSayIterator.next();
    lookAndSayIterator.next();
    lookAndSayIterator.next();
  }
}