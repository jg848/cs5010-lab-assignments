package bignumber;

/**
 * Node class for a {@link BigNumber} which represents a node of the
 * {@link BigNumber}.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface BigNumberNode {
  /**
   * Helper method for the nodes to add a {@link BigNumber} to other.
   * 
   * @param carry which is the carry over from the previous node.
   * @param other which is the {@link BigNumber} to be added.
   * @return an instance of the {@link BigNumber}.
   */
  BigNumber addHelper(int carry, BigNumber other);

}
