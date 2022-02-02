import static org.junit.Assert.assertEquals;

import bignumber.BigNumber;
import bignumber.BigNumberEmptyNode;
import bignumber.BigNumberImpl;
import org.junit.Test;

/**
 * Test class for {@link BigNumberImpl}.
 */
public class BigNumberImplTest {
  BigNumber bigNumber;

  /**
   * Method to setup the test class.
   */
  @org.junit.Before
  public void setUp() {
    bigNumber = new BigNumberImpl("123456");
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#BigNumberImpl()}.
   */
  @Test
  public void testBigNumberImpl() {
    bigNumber = new BigNumberImpl();
    assertEquals(BigNumberImpl.class, bigNumber.getClass());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#BigNumberImpl(String)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorEmptyString() {
    new BigNumberImpl("");
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#BigNumberImpl(String)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorInvalidNumber() {
    new BigNumberImpl("abc");
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#BigNumberImpl()}.
   */
  @Test
  public void testBigNumberImplString() {
    bigNumber = new BigNumberImpl("123456");
    assertEquals(BigNumberImpl.class, bigNumber.getClass());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#addDigit(int)}.
   */
  @Test
  public void testAddShift() {
    bigNumber.shiftLeft(1);
    bigNumber.addDigit(9);
    assertEquals("1234569", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#getDigitAt(int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetDigitAtInvalidLength() {
    bigNumber.getDigitAt(6);
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#getDigitAt(int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetDigitAtInvalidGreaterLength() {
    bigNumber.getDigitAt(9);
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#getDigitAt(int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetDigitAtInvalid() {
    bigNumber.getDigitAt(-1);
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftLeft(int)}.
   */
  @Test
  public void testShiftLeftByOne() {
    bigNumber.shiftLeft(1);
    assertEquals(0, bigNumber.getDigitAt(0));
    assertEquals(7, bigNumber.length());
    assertEquals("1234560", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftLeft(int)}.
   */
  @Test
  public void testShiftLeftByZero() {
    bigNumber.shiftLeft(0);
    assertEquals(6, bigNumber.getDigitAt(0));
    assertEquals(6, bigNumber.length());
    assertEquals("123456", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftLeft(int)}.
   */
  @Test
  public void testShiftLeftByNegativeThree() {
    bigNumber.shiftLeft(-3);
    assertEquals(3, bigNumber.getDigitAt(0));
    assertEquals(3, bigNumber.length());
    assertEquals("123", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftLeft(int)}.
   */
  @Test
  public void testShiftLeftByThree() {
    bigNumber.shiftLeft(3);
    assertEquals(0, bigNumber.getDigitAt(0));
    assertEquals(0, bigNumber.getDigitAt(1));
    assertEquals(0, bigNumber.getDigitAt(2));
    assertEquals(6, bigNumber.getDigitAt(3));
    assertEquals(9, bigNumber.length());
    assertEquals("123456000", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftLeft(int)}.
   */
  @Test
  public void testShiftLeftOnZero() {
    BigNumber bigNumber = new BigNumberImpl();
    bigNumber.shiftLeft(1);
    assertEquals(0, bigNumber.getDigitAt(0));
    assertEquals(1, bigNumber.length());
    assertEquals("0", bigNumber.toString());
    bigNumber.shiftLeft(3);
    assertEquals(1, bigNumber.length());
    assertEquals("0", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftLeft(int)}.
   */
  @Test
  public void testShiftLeftByTwo() {
    bigNumber.shiftLeft(2);
    assertEquals(0, bigNumber.getDigitAt(0));
    assertEquals(0, bigNumber.getDigitAt(1));
    assertEquals(6, bigNumber.getDigitAt(2));
    assertEquals(5, bigNumber.getDigitAt(3));
    assertEquals(4, bigNumber.getDigitAt(4));
    assertEquals(3, bigNumber.getDigitAt(5));
    assertEquals(2, bigNumber.getDigitAt(6));
    assertEquals(1, bigNumber.getDigitAt(7));
    assertEquals(8, bigNumber.length());
    assertEquals("12345600", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftRight(int)}.
   */
  @Test
  public void testShiftRightByOne() {
    bigNumber.shiftRight(1);
    assertEquals(5, bigNumber.getDigitAt(0));
    assertEquals(5, bigNumber.length());
    assertEquals("12345", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftRight(int)}.
   */
  @Test
  public void testShiftRightByTwo() {
    bigNumber.shiftRight(2);
    assertEquals(4, bigNumber.getDigitAt(0));
    assertEquals(4, bigNumber.length());
    assertEquals("1234", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftRight(int)}.
   */
  @Test
  public void testShiftRightByNegativeTwo() {
    bigNumber.shiftRight(-2);
    assertEquals(0, bigNumber.getDigitAt(0));
    assertEquals(8, bigNumber.length());
    assertEquals("12345600", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftRight(int)}.
   */
  @Test
  public void testShiftRightByThree() {
    bigNumber.shiftRight(3);
    assertEquals(3, bigNumber.getDigitAt(0));
    assertEquals(3, bigNumber.length());
    assertEquals("123", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftRight(int)}.
   */
  @Test
  public void testShiftRightByFour() {
    bigNumber.shiftLeft(4);
    bigNumber.shiftRight(4);
    assertEquals(6, bigNumber.getDigitAt(0));
    assertEquals(6, bigNumber.length());
    assertEquals("123456", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftRight(int)}.
   */
  @Test
  public void testShiftRightByFive() {
    bigNumber.shiftRight(5);
    assertEquals(1, bigNumber.getDigitAt(0));
    assertEquals(1, bigNumber.length());
    assertEquals("1", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftRight(int)}.
   */
  @Test
  public void testShiftRightBySix() {
    bigNumber.shiftRight(6);
    assertEquals(0, bigNumber.getDigitAt(0));
    assertEquals(1, bigNumber.length());
    assertEquals("0", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#shiftRight(int)}.
   */
  @Test
  public void testShiftRightBySeven() {
    bigNumber.shiftRight(7);
    assertEquals(0, bigNumber.getDigitAt(0));
    assertEquals(1, bigNumber.length());
    assertEquals("0", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#toString()}.
   */
  @Test
  public void testToString() {
    assertEquals("123456", bigNumber.toString());
    BigNumber number1 = new BigNumberImpl(
        "7412904016829" + "24075205841007277699295091749941282081428940696065796"
            + "955768681282962093600948989714686524180325441302349677"
            + "4043011787847176719087654995431371265295513122426440573"
            + "39951253805186734143768471336132966607231156710543984386"
            + "127731104916400359276706449399444683621733119295172683386"
            + "6691081780524956104075277386207113695721913329525199409405"
            + "97296474818644553668570405804716816550614557769478551807827" + "8196159043410");
    BigNumber number = new BigNumberImpl("233454565466");
    assertEquals("233454565466", number.toString());
    assertEquals(
        "74129040168292407520584100727" + "76992950917499412820814289406960657969557686"
            + "812829620936009489897146865241803254413023496"
            + "7740430117878471767190876549954313712652955131"
            + "22426440573399512538051867341437684713361329666"
            + "072311567105439843861277311049164003592767064493"
            + "9944468362173311929517268338666910817805249561040"
            + "75277386207113695721913329525199409405972964748186"
            + "445536685704058047168165506145577694785518078278196" + "159043410",
        number1.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#add(BigNumber)}.
   */
  @Test
  public void testAddEmptyNodes() {
    BigNumber bigNumber1 = new BigNumberEmptyNode();
    BigNumber bigNumber2 = new BigNumberEmptyNode();
    assertEquals("", bigNumber1.add(bigNumber2).toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#add(BigNumber)}.
   */
  @Test
  public void testAddEmptyNodeToBigNumber() {
    BigNumber bigNumber1 = new BigNumberEmptyNode();
    assertEquals("123456", bigNumber.add(bigNumber1).toString());
    assertEquals("123456", bigNumber1.add(bigNumber).toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#copy()}.
   */
  @Test
  public void testCopy() {
    BigNumber clone = bigNumber.copy();
    assertEquals(6, clone.length());
    assertEquals("123456", clone.toString());
    assertEquals(6, clone.getDigitAt(0));
    BigNumber number = new BigNumberImpl("2364276381364858325381638145871638196432233333333");
    BigNumber clone2 = number.copy();
    assertEquals(49, clone2.length());
    assertEquals("2364276381364858325381638145871638196432233333333", clone2.toString());
    assertEquals(3, clone2.getDigitAt(0));
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#add(BigNumber)}.
   */
  @Test
  public void testAdd() {
    BigNumber other = new BigNumberImpl("368566678");
    assertEquals("368690134", bigNumber.add(other).toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#add(BigNumber)}.
   */
  @Test
  public void testAddBigNumberWithBigNumber() {
    BigNumber bigNumber = new BigNumberImpl("74129040168292407520584100727769929509"
        + "1749941282081428940696065796955768681282" + "9620936009489897146865241803254413023496"
        + "77404301178784717671908765499543137126529" + "55131224264405733995125380518673414376847"
        + "13361329666072311567105439843861277311049" + "16400359276706449399444683621733119295172"
        + "683386669108178052495610407527738620711369"
        + "572191332952519940940597296474818644553668"
        + "5704058047168165506145577694785518078278196" + "159043410");
    BigNumber other = new BigNumberImpl(
        "5431480344049023748" + "8792672708130748244495505573617968946066890630208160487543"
            + "5419981317707941891059108656497213067333648874690234599604"
            + "7912056523121635956935523300307604947022318813414230583716"
            + "16619034209033084606584617077806398488849433515146031775075"
            + "36684049705937314848037373230748517317");
    assertEquals(
        "7412904016829240752058410072776992950" + "91749941282081428940696065796955768681282962093"
            + "600948989714686524180325441302349677404301184216"
            + "1980159577892484224043973426261366921946147017481"
            + "4841187579716458452009048716642040823612945457547"
            + "2692703235589736848023608795395492595678256240931"
            + "129618909969415782999517929220941969204427535762"
            + "53342328336600678676807453880353304800372186612246"
            + "75702190195283632100366115651426907560727",
        bigNumber.add(other).toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#compareTo(BigNumber)}.
   */
  @Test
  public void testCompareTo() {
    BigNumber other = new BigNumberImpl("123457");
    assertEquals(-1, bigNumber.compareTo(other));
    BigNumber other1 = new BigNumberImpl("234");
    assertEquals(1, bigNumber.compareTo(other1));
    BigNumber other2 = new BigNumberImpl("12345678");
    assertEquals(-1, bigNumber.compareTo(other2));
    BigNumber other4 = new BigNumberImpl("123446");
    assertEquals(1, bigNumber.compareTo(other4));
    BigNumber equalNumber = new BigNumberImpl("123456");
    assertEquals(0, bigNumber.compareTo(equalNumber));
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#addDigit(int)}.
   */
  @Test
  public void testAddDigit() {
    bigNumber.addDigit(9);
    assertEquals("123465", bigNumber.toString());
    bigNumber.addDigit(9);
    assertEquals("123474", bigNumber.toString());
    bigNumber.addDigit(9);
    assertEquals("123483", bigNumber.toString());
    bigNumber.addDigit(9);
    assertEquals("123492", bigNumber.toString());
    bigNumber.addDigit(9);
    assertEquals("123501", bigNumber.toString());
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#addDigit(int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddDigitInvalidNegativeValue() {
    bigNumber.addDigit(-9);
  }

  /**
   * Test method for {@link bignumber.BigNumberImpl#addDigit(int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddDigitInvalidTwoDigitsValue() {
    bigNumber.addDigit(11);
  }
}