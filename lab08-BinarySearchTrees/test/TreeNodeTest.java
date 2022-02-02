import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import bst.LeafNode;
import bst.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for the implementation of {@link TreeNode}.
 * 
 * @author Jaswin Gumpella
 * 
 */
public class TreeNodeTest {
  private TreeNode<Integer> treeNode;

  /**
   * Method to setup the test class with required attributes.
   */
  @Before
  public void setUp() {
    treeNode = new LeafNode<>(5);
  }

  /**
   * Test method for {@link bst.TreeNode#addChild(java.lang.Comparable)}.
   */
  @Test
  public final void testAddChild() {
    treeNode = treeNode.addChild(4);
    assertEquals("[4 5]", treeNode.toString());
  }

  /**
   * Test method for {@link bst.TreeNode#count()}.
   */
  @Test
  public final void testCount() {
    treeNode = treeNode.addChild(4);
    assertEquals("[4 5]", treeNode.toString());
    assertEquals(2, treeNode.count());
  }

  /**
   * Test method for {@link bst.TreeNode#toList()}.
   */
  @Test
  public final void testToList() {
    treeNode = treeNode.addChild(4);
    List<Integer> list = new ArrayList<>();
    list.add(4);
    list.add(5);
    assertEquals(list, treeNode.toList());
  }

  /**
   * Test method for {@link bst.TreeNode#height()}.
   */
  @Test
  public final void testHeight() {
    treeNode = treeNode.addChild(2);
    assertEquals(2, treeNode.height());
  }

  /**
   * Test method for {@link bst.TreeNode#present(java.lang.Comparable)}.
   */
  @Test
  public final void testPresent() {
    assertTrue(treeNode.present(5));
    assertFalse(treeNode.present(8));
  }

  /**
   * Test method for {@link bst.TreeNode#minimum()}.
   */
  @Test
  public final void testMinimum() {
    treeNode = treeNode.addChild(2);
    assertEquals((Integer) 2, treeNode.minimum());
  }

  /**
   * Test method for {@link bst.TreeNode#maximum()}.
   */
  @Test
  public final void testMaximum() {
    treeNode = treeNode.addChild(2);
    assertEquals((Integer) 5, treeNode.maximum());
  }

  /**
   * Test method for {@link bst.TreeNode#preOrder()}.
   */
  @Test
  public final void testPreOrder() {
    treeNode = treeNode.addChild(4).addChild(2).addChild(9);
    assertEquals("5 4 2 9", treeNode.preOrder());
  }

  /**
   * Test method for {@link bst.TreeNode#inOrder()}.
   */
  @Test
  public final void testInOrder() {
    treeNode = treeNode.addChild(6).addChild(2).addChild(9).addChild(3);
    assertEquals("[2 3 5 6 9]", treeNode.inOrder());
  }

  /**
   * Test method for {@link bst.TreeNode#postOrder()}.
   */
  @Test
  public final void testPostOrder() {
    treeNode = treeNode.addChild(4).addChild(9).addChild(8).addChild(1);
    assertEquals("1 4 8 9 5", treeNode.postOrder());
  }
}