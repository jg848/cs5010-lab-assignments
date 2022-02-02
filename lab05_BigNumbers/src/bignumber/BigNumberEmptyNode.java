package bignumber;

/**
 * {@link BigNumberEmptyNode} class which is the implementation of
 * {@link BigNumber} and {@link BigNumberNode}. Represents an empty node of the
 * {@link BigNumber}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class BigNumberEmptyNode implements BigNumber, BigNumberNode {

  @Override
  public int length() {
    return 0;
  }

  @Override
  public void shiftLeft(int num) {
    // Method cannot contain any logic as empty node cannot do shift operation.
  }

  @Override
  public BigNumber addHelper(int carry, BigNumber other) {
    if (other.length() == 0) {
      return new BigNumberImpl(String.valueOf(carry));
    }
    BigNumberImpl otherNum = (BigNumberImpl) other;
    otherNum.addDigit(carry);
    return otherNum;
  }

  @Override
  public void shiftRight(int num) {
    // Method cannot contain any logic as empty node cannot do shift operation.
  }

  @Override
  public void addDigit(int digit) throws IllegalArgumentException {
    // Method cannot contain any logic as empty node cannot do add operation.
  }

  @Override
  public int getDigitAt(int position) throws IllegalArgumentException {
    throw new IllegalArgumentException("Empty node.");
  }

  @Override
  public BigNumber copy() {
    return new BigNumberEmptyNode();
  }

  @Override
  public BigNumber add(BigNumber other) {
    return other;
  }

  @Override
  public int compareTo(BigNumber o) {
    return 0;
  }

  @Override
  public String toString() {
    return "";
  }
}
