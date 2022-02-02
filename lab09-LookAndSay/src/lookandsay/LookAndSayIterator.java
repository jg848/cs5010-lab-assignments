package lookandsay;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation class of the {@link RIterator} interface that represents an
 * {@link Iterator} object having methods to iterate through the look and say
 * sequence and tracks the current state of the sequence.
 * 
 * @author Jaswin Gumpella
 *
 */
public class LookAndSayIterator implements RIterator<BigInteger> {
  private BigInteger current;
  private final BigInteger lastBigInteger = new BigInteger("9".repeat(100));
  private final BigInteger last;
  private boolean next;

  /**
   * Default constructor of the {@link LookAndSayIterator} class which initializes
   * the sequence to "1" and the last value to the largest hundred digit number.
   */
  public LookAndSayIterator() {
    this.current = new BigInteger("1");
    this.last = lastBigInteger;
    this.next = false;
  }

  /**
   * Constructor for the {@link LookAndSayIterator} when given starting seed and
   * last values as input. Initializes the starting and ending of the sequence.
   * 
   * @param seed represents the start of the sequence.
   * @param last represents the last of the sequence.
   */
  public LookAndSayIterator(BigInteger seed, BigInteger last) {
    if (seed == null || last == null || seed.toString().contains("0") || seed.compareTo(last) > 0
        || seed.signum() < 0) {
      throw new IllegalArgumentException("Invalid input to the constructor.");
    }
    this.current = seed;
    this.last = last;
    this.next = false;
  }

  /**
   * Constructor for the {@link LookAndSayIterator} when given starting seed as
   * input. Initializes the starting of the sequence to the given value and ending
   * of the sequence to the largest hundred digit number.
   * 
   * @param seed represents the start of the sequence.
   */
  public LookAndSayIterator(BigInteger seed) {
    if (seed == null || seed.toString().contains("0") || seed.compareTo(lastBigInteger) > 0
        || seed.signum() < 0) {
      throw new IllegalArgumentException("Invalid input to the constructor.");
    }
    this.current = seed;
    this.last = lastBigInteger;
    this.next = false;
  }

  private String lookAndSayForward(BigInteger bigInteger) {
    StringBuilder result = new StringBuilder();
    String currentString = bigInteger.toString();
    char repeat = currentString.charAt(0);
    currentString = currentString.substring(1) + " ";
    int count = 1;

    for (char actual : currentString.toCharArray()) {
      if (actual != repeat) {
        result.append(count).append(repeat);
        count = 1;
        repeat = actual;
      } else {
        count += 1;
      }
    }
    return result.toString();
  }

  private String lookAndSayBackward(BigInteger bigInteger) {
    StringBuilder result = new StringBuilder();
    String currentBigInteger = bigInteger.toString();
    if (!currentBigInteger.isEmpty() && currentBigInteger.length() % 2 == 0) {
      result.append(String.valueOf(currentBigInteger.charAt(1))
          .repeat(Integer.parseInt(String.valueOf(currentBigInteger.charAt(0)))));
      if (!currentBigInteger.substring(2).isEmpty()) {
        result.append(lookAndSayBackward(new BigInteger(currentBigInteger.substring(2))));
      }
    }
    return result.toString();
  }

  @Override
  public BigInteger prev() throws NoSuchElementException {
    if (!this.hasPrevious()) {
      throw new NoSuchElementException();
    }
    this.current = new BigInteger(lookAndSayBackward(this.current));
    if (next) {
      next = false;
      this.current = new BigInteger(lookAndSayBackward(this.current));
      return this.current;
    }
    return this.current;
  }

  @Override
  public boolean hasPrevious() {
    return this.current.toString().length() % 2 == 0;
  }

  @Override
  public boolean hasNext() {
    return this.current.compareTo(this.last) <= 0;
  }

  @Override
  public BigInteger next() {
    if (!this.hasNext()) {
      throw new NoSuchElementException("No element found.");
    }
    BigInteger currentBigInteger = current;
    this.current = new BigInteger(lookAndSayForward(this.current));
    this.next = true;
    return currentBigInteger;
  }
}
