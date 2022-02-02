package bignumber;

/**
 * Implementation class for the {@link BigNumber} interface which represents a
 * {@link BigNumber} and its operations.
 * 
 * @author Jaswin Gumpella
 *
 */
public class BigNumberImpl implements BigNumber, BigNumberNode {
  private BigNumber rest;
  private int digit;

  /**
   * Default constructor for the {@link BigNumberImpl} class which constructs a
   * zero number.
   */
  public BigNumberImpl() {
    this.digit = 0;
    this.rest = new BigNumberEmptyNode();
  }

  /**
   * Constructor for the {@link BigNumberImpl} class which constructs a
   * {@link BigNumber} taking input of a series of numbers in a string.
   * 
   * @param numberString which represents a {@link BigNumber} in the form of a
   *                     string of integers.
   * @throws IllegalArgumentException for invalid parameters.
   */
  public BigNumberImpl(String numberString) {
    if (numberString.isBlank()) {
      throw new IllegalArgumentException("Number cannot be empty.");
    }
    StringBuilder builder = new StringBuilder(numberString);
    try {
      if (builder.length() > 1) {
        this.digit = Integer.parseInt(String.valueOf(builder.charAt(0)));
        this.rest = new BigNumberEmptyNode();
        for (int i = 1; i < builder.length(); i++) {
          this.shiftLeft(1);
          this.addDigit(Integer.parseInt(String.valueOf(builder.charAt(i))));
        }
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Cannot be converted to Number.");
    }
  }

  @Override
  public int length() {
    return 1 + this.rest.length();
  }

  @Override
  public void shiftLeft(int num) {
    if (this.length() == 0) {
      BigNumberImpl zeroNode = new BigNumberImpl();
      this.digit = zeroNode.digit;
      this.rest = zeroNode.rest;
    }
    if (this.length() == 1 && this.digit == 0) {
      this.rest = new BigNumberEmptyNode();
    } else {
      if (num >= 0) {
        for (int i = 0; i < num; i++) {
          BigNumberImpl zeroNode = new BigNumberImpl();
          BigNumberImpl prev = new BigNumberImpl();
          prev.digit = this.digit;
          prev.rest = this.rest;
          this.digit = zeroNode.digit;
          this.rest = prev;
        }
      } else {
        shiftRight(-num);
      }
    }
  }

  @Override
  public void shiftRight(int num) {
    if (num >= 0) {
      for (int i = 0; i < num; i++) {
        if (this.length() == 1) {
          this.digit = 0;
          this.rest = new BigNumberEmptyNode();
        } else {
          BigNumberImpl next = (BigNumberImpl) this.rest;
          this.digit = next.digit;
          this.rest = next.rest;
        }
      }
    } else {
      shiftLeft(-num);
    }
  }

  @Override
  public void addDigit(int digit) throws IllegalArgumentException {
    int carry = 0;
    if (digit / 10 != 0 || digit < 0) {
      throw new IllegalArgumentException("Argument should be of a single digit");
    }
    this.digit += digit;
    carry = this.digit / 10;
    this.digit = this.digit % 10;
    this.rest.addDigit(carry);
  }

  @Override
  public int getDigitAt(int position) throws IllegalArgumentException {
    if (position < 0 || position >= this.length()) {
      throw new IllegalArgumentException();
    } else {
      if (position != 0) {
        return this.rest.getDigitAt(position - 1);
      } else {
        return this.digit;
      }
    }
  }

  @Override
  public BigNumber copy() {
    BigNumberImpl copy = new BigNumberImpl();
    copy.digit = this.digit;
    copy.rest = this.rest.copy();
    return copy;
  }

  @Override
  public BigNumber add(BigNumber other) {
    return this.addHelper(0, other);
  }

  @Override
  public BigNumber addHelper(int carry, BigNumber other) {
    if (other == null) {
      throw new IllegalArgumentException("");
    }
    if (other instanceof BigNumberEmptyNode) {
      this.addDigit(carry);
      return this;
    } else {
      BigNumberImpl otherNum = (BigNumberImpl) other;
      int sum = 0;
      sum = carry + this.digit + otherNum.digit;
      carry = sum / 10;
      sum = sum % 10;
      BigNumberImpl result;
      result = new BigNumberImpl(String.valueOf(sum));
      if (this.rest.length() > 0) {
        BigNumberImpl rest = (BigNumberImpl) this.rest;
        result.rest = rest.addHelper(carry, otherNum.rest);
      } else {
        BigNumberEmptyNode emptyNode = (BigNumberEmptyNode) this.rest;
        result.rest = emptyNode.addHelper(carry, otherNum.rest);
      }
      return result;
    }
  }

  /**
   * Method used to compare {@link BigNumber} with other {@link BigNumber} and
   * determine which is greater.
   */
  @Override
  public int compareTo(BigNumber o) {
    if (o == null) {
      return 1;
    }
    if (this.length() > o.length()) {
      return 1;
    } else if (this.length() < o.length()) {
      return -1;
    } else {
      BigNumberImpl other = (BigNumberImpl) o;
      if (String.valueOf(this.digit).compareTo(String.valueOf(other.digit)) == 0) {
        return this.rest.compareTo(other.rest);
      } else {
        return String.valueOf(this.digit).compareTo(String.valueOf(other.digit));
      }
    }
  }

  /**
   * Method to get the string representation of the {@link BigNumber}.
   */
  @Override
  public String toString() {
    StringBuilder digitsString = new StringBuilder();
    digitsString.append(this.rest.toString());
    return digitsString.append(this.digit).toString();
  }
}
