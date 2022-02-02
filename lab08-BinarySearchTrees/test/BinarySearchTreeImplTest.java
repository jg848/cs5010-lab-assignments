import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import bst.BinarySearchTree;
import bst.BinarySearchTreeImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for operations defined in {@link BinarySearchTree} interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class BinarySearchTreeImplTest {
  private BinarySearchTree<Integer> binarySearchTree;

  /**
   * Method to setup the test class with the required attributes.
   */
  @Before
  public void setUp() {
    binarySearchTree = new BinarySearchTreeImpl<>();
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#BinarySearchTreeImpl()}.
   */
  @Test
  public final void testBinarySearchTreeImpl() {
    BinarySearchTree<Integer> tree = new BinarySearchTreeImpl<>();
    tree.add(3);
    tree.add(5);
    tree.add(7);
    assertEquals("[3 5 7]", tree.toString());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#add(java.lang.Comparable)}.
   */
  @Test
  public final void testAdd() {
    binarySearchTree.add(8);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    binarySearchTree.add(9);
    binarySearchTree.add(1);
    binarySearchTree.add(2);
    binarySearchTree.add(4);
    assertEquals("[1 2 3 4 6 8 9]", binarySearchTree.toString());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#add(java.lang.Comparable)}.
   */
  @Test
  public void testAddExistingValue() {
    binarySearchTree.add(6);
    binarySearchTree.add(3);
    binarySearchTree.add(4);
    binarySearchTree.add(8);
    binarySearchTree.add(9);
    binarySearchTree.add(2);
    binarySearchTree.add(1);
    binarySearchTree.add(1);
    assertEquals("[1 2 3 4 6 8 9]", binarySearchTree.toString());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#add(java.lang.Comparable)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddNull() {
    binarySearchTree.add(null);
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#add(java.lang.Comparable)}.
   */
  @Test
  public void testAddZero() {
    binarySearchTree.add(0);
    assertEquals("[0]", binarySearchTree.toString());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#size()}.
   */
  @Test
  public final void testSize() {
    binarySearchTree.add(8);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    binarySearchTree.add(9);
    binarySearchTree.add(1);
    binarySearchTree.add(2);
    binarySearchTree.add(4);
    assertEquals(7, binarySearchTree.size());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#size()}.
   */
  @Test
  public void testSizeEmptyTree() {
    assertEquals(0, binarySearchTree.size());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#height()}.
   */
  @Test
  public final void testHeight() {
    binarySearchTree.add(8);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    binarySearchTree.add(9);
    binarySearchTree.add(1);
    binarySearchTree.add(2);
    binarySearchTree.add(4);
    assertEquals(4, binarySearchTree.height());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#height()}.
   */
  @Test
  public void testHeightEmptyNode() {
    assertEquals(0, binarySearchTree.height());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#height()}.
   */
  @Test
  public void testHeightLeafNode() {
    binarySearchTree.add(4);
    assertEquals(1, binarySearchTree.height());
  }

  /**
   * Test method for
   * {@link bst.BinarySearchTreeImpl#present(java.lang.Comparable)}.
   */
  @Test
  public void testPresentTrue() {
    binarySearchTree.add(8);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    binarySearchTree.add(4);
    assertTrue(binarySearchTree.present(4));
    assertTrue(binarySearchTree.present(6));
  }

  /**
   * Test method for
   * {@link bst.BinarySearchTreeImpl#present(java.lang.Comparable)}.
   */
  @Test
  public void testPresentFalse() {
    binarySearchTree.add(8);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    assertFalse(binarySearchTree.present(11));
  }

  /**
   * Test method for
   * {@link bst.BinarySearchTreeImpl#present(java.lang.Comparable)}.
   */
  @Test
  public void testPresentNull() {
    assertFalse(binarySearchTree.present(null));
  }

  /**
   * Test method for
   * {@link bst.BinarySearchTreeImpl#present(java.lang.Comparable)}.
   */
  @Test
  public void testPresentEmptyTree() {
    assertFalse(binarySearchTree.present(1));
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#minimum()}.
   */
  @Test
  public final void testMinimum() {
    binarySearchTree.add(8);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    assertEquals((Integer) 3, binarySearchTree.minimum());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#minimum()}.
   */
  @Test(expected = IllegalStateException.class)
  public void testMinimumEmptyTree() {
    binarySearchTree.minimum();
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#minimum()}.
   */
  @Test
  public void testMinimumNegative() {
    binarySearchTree.add(-8);
    binarySearchTree.add(-3);
    binarySearchTree.add(-6);
    binarySearchTree.add(-9);
    binarySearchTree.add(-1);
    assertEquals((Integer) (-9), binarySearchTree.minimum());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#maximum()}.
   */
  @Test
  public final void testMaximum() {
    binarySearchTree.add(8);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    binarySearchTree.add(9);
    assertEquals((Integer) 9, binarySearchTree.maximum());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#maximum()}.
   */
  @Test(expected = IllegalStateException.class)
  public void testMaximumEmptyTree() {
    binarySearchTree.maximum();
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#maximum()}.
   */
  @Test
  public void testMaximumNegative() {
    binarySearchTree.add(-8);
    binarySearchTree.add(-3);
    binarySearchTree.add(-6);
    binarySearchTree.add(-9);
    binarySearchTree.add(-1);
    assertEquals((Integer) (-1), binarySearchTree.maximum());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#preOrder()}.
   */
  @Test
  public final void testPreOrder() {
    binarySearchTree.add(8);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    binarySearchTree.add(9);
    binarySearchTree.add(1);
    binarySearchTree.add(2);
    binarySearchTree.add(4);
    assertEquals("[8 3 1 2 6 4 9]", binarySearchTree.preOrder());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#preOrder()}.
   */
  @Test
  public void testPreOrderEmptyTree() {
    assertEquals("[]", binarySearchTree.preOrder());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#preOrder()}.
   */
  @Test
  public void testPreOrderNegative() {
    binarySearchTree.add(-8);
    binarySearchTree.add(-3);
    binarySearchTree.add(-6);
    binarySearchTree.add(-9);
    binarySearchTree.add(-1);
    binarySearchTree.add(-2);
    binarySearchTree.add(-4);
    assertEquals("[-8 -9 -3 -6 -4 -1 -2]", binarySearchTree.preOrder());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#inOrder()}.
   */
  @Test
  public final void testInOrder() {
    binarySearchTree.add(8);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    binarySearchTree.add(9);
    binarySearchTree.add(1);
    binarySearchTree.add(2);
    binarySearchTree.add(4);
    assertEquals("[1 2 3 4 6 8 9]", binarySearchTree.inOrder());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#inOrder()}.
   */
  @Test
  public void testInOrderEmptyTree() {
    assertEquals("", binarySearchTree.inOrder());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#inOrder()}.
   */
  @Test
  public void testInOrderNegative() {
    binarySearchTree.add(-8);
    binarySearchTree.add(-3);
    binarySearchTree.add(-6);
    binarySearchTree.add(-9);
    binarySearchTree.add(-1);
    binarySearchTree.add(-2);
    binarySearchTree.add(-4);
    assertEquals("[-9 -8 -6 -4 -3 -2 -1]", binarySearchTree.inOrder());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#postOrder()}.
   */
  @Test
  public final void testPostOrder() {
    binarySearchTree.add(8);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    binarySearchTree.add(9);
    binarySearchTree.add(1);
    binarySearchTree.add(2);
    binarySearchTree.add(4);
    assertEquals("[2 1 4 6 3 9 8]", binarySearchTree.postOrder());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#postOrder()}.
   */
  @Test
  public void testPostOrderEmptyTree() {
    assertEquals("[]", binarySearchTree.postOrder());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#postOrder()}.
   */
  @Test
  public void testPostOrderNegative() {
    binarySearchTree.add(-8);
    binarySearchTree.add(-3);
    binarySearchTree.add(-6);
    binarySearchTree.add(-9);
    binarySearchTree.add(-1);
    binarySearchTree.add(-2);
    binarySearchTree.add(-4);
    assertEquals("[-9 -4 -6 -2 -1 -3 -8]", binarySearchTree.postOrder());
  }

  /**
   * Test method for {@link bst.BinarySearchTreeImpl#toString()}.
   */
  @Test
  public final void testToString() {
    binarySearchTree.add(8);
    binarySearchTree.add(3);
    binarySearchTree.add(6);
    binarySearchTree.add(9);
    binarySearchTree.add(1);
    binarySearchTree.add(2);
    binarySearchTree.add(4);
    assertEquals("[1 2 3 4 6 8 9]", binarySearchTree.toString());
  }
}