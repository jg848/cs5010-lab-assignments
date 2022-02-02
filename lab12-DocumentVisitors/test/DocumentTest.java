import static org.junit.Assert.assertEquals;

import document.BasicStringVisitor;
import document.Document;
import document.elements.BasicText;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Document}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class DocumentTest {
  private Document document;

  /**
   * Method to setup the test class with the required attributes.
   */
  @Before
  public void setUp() {
    document = new Document();
  }

  /**
   * Test method for {@link document.Document#Document()}.
   */
  @Test
  public final void testDocument() {
    assertEquals(0, document.countWords());
    assertEquals("", document.toText(new BasicStringVisitor()));
  }

  /**
   * Test method for {@link document.Document#add(document.elements.TextElement)}.
   */
  @Test
  public final void testAdd() {
    document.add(new BasicText("Basic String Visitor"));
    assertEquals(3, document.countWords());
    assertEquals("Basic String Visitor", document.toText(new BasicStringVisitor()));
  }

  /**
   * Test method for {@link document.Document#add(document.elements.TextElement)}.
   */
  @Test
  public final void testAddMultiple() {
    document.add(new BasicText("Basic String"));
    assertEquals(2, document.countWords());
    assertEquals("Basic String", document.toText(new BasicStringVisitor()));
    document.add(new BasicText("Visitor"));
    assertEquals(3, document.countWords());
    assertEquals("Basic String Visitor", document.toText(new BasicStringVisitor()));
  }

  /**
   * Test method for {@link document.Document#countWords()}.
   */
  @Test
  public final void testCountWords() {
    assertEquals(0, document.countWords());
    document.add(new BasicText("Basic String Visitor"));
    assertEquals(3, document.countWords());
  }

  /**
   * Test method for
   * {@link document.Document#toText(document.TextElementVisitor)}.
   */
  @Test
  public final void testToText() {
    assertEquals("", document.toText(new BasicStringVisitor()));
    document.add(new BasicText("Basic String Visitor"));
    assertEquals("Basic String Visitor", document.toText(new BasicStringVisitor()));
  }
}