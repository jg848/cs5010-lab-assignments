import static org.junit.Assert.assertEquals;

import document.BasicStringVisitor;
import document.Document;
import document.HtmlStringVisitor;
import document.MarkdownStringVisitor;
import document.TextElementVisitor;
import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import org.junit.Test;

/**
 * Test class for {@link TextElementVisitor}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class TextElementVisitorTest {
  private Document document;
  private TextElementVisitor<String> htmlVisitor;
  private TextElementVisitor<String> basicStringVisitor;
  private TextElementVisitor<String> markdownVisitor;

  /**
   * Method to setup the test class with the required attributes.
   */
  @org.junit.Before
  public void setUp() {
    markdownVisitor = new MarkdownStringVisitor();
    basicStringVisitor = new BasicStringVisitor();
    htmlVisitor = new HtmlStringVisitor();
    document = new Document();
  }

  /**
   * Test method for
   * {@link document.TextElementVisitor#visitBasicText(document.elements.BasicText)}.
   */
  @Test
  public final void testVisitBasicText() {
    document.add(new BasicText("Basic Text Visitor Test"));
    assertEquals(4, document.countWords());
    assertEquals("Basic Text Visitor Test", document.toText(basicStringVisitor));
    assertEquals("Basic Text Visitor Test", document.toText(htmlVisitor));
    assertEquals("Basic Text Visitor Test", document.toText(markdownVisitor));
  }

  /**
   * Test method for
   * {@link document.TextElementVisitor#visitBoldText(document.elements.BoldText)}.
   */
  @Test
  public final void testVisitBoldText() {
    document.add(new BoldText("Bold Text Visitor Test"));
    assertEquals(4, document.countWords());
    assertEquals("Bold Text Visitor Test", document.toText(basicStringVisitor));
    assertEquals("<b>Bold Text Visitor Test</b>", document.toText(htmlVisitor));
    assertEquals("**Bold Text Visitor Test**", document.toText(markdownVisitor));
  }

  /**
   * Test method for
   * {@link document.TextElementVisitor#visitHeading(document.elements.Heading)}.
   */
  @Test
  public final void testVisitHeading() {
    document.add(new Heading("Heading Text Visitor Test", 3));
    assertEquals(4, document.countWords());
    assertEquals("Heading Text Visitor Test", document.toText(basicStringVisitor));
    assertEquals("<h3>Heading Text Visitor Test</h3>", document.toText(htmlVisitor));
    assertEquals("### Heading Text Visitor Test", document.toText(markdownVisitor));
  }

  /**
   * Test method for
   * {@link document.TextElementVisitor#visitHyperText(document.elements.HyperText)}.
   */
  @Test
  public final void testVisitHyperText() {
    document.add(new HyperText("Hyper Text Visitor Test", "www.google.com"));
    assertEquals(4, document.countWords());
    assertEquals("Hyper Text Visitor Test", document.toText(basicStringVisitor));
    assertEquals("<a href=\"www.google.com\">Hyper Text Visitor Test</a>",
        document.toText(htmlVisitor));
    assertEquals("[Hyper Text Visitor Test](www.google.com)", document.toText(markdownVisitor));
  }

  /**
   * Test method for
   * {@link document.TextElementVisitor#visitItalicText(document.elements.ItalicText)}.
   */
  @Test
  public final void testVisitItalicText() {
    document.add(new ItalicText("Italic Text Visitor Test"));
    assertEquals(4, document.countWords());
    assertEquals("Italic Text Visitor Test", document.toText(basicStringVisitor));
    assertEquals("<i>Italic Text Visitor Test</i>", document.toText(htmlVisitor));
    assertEquals("*Italic Text Visitor Test*", document.toText(markdownVisitor));
  }

  /**
   * Test method for
   * {@link document.TextElementVisitor#visitParagraph(document.elements.Paragraph)}.
   */
  @Test
  public final void testVisitParagraph() {
    Paragraph paragraph = new Paragraph();
    paragraph.add(new BoldText("Paragraph Visitor Test"));
    document.add(paragraph);
    assertEquals(3, document.countWords());
    assertEquals("Paragraph Visitor Test", document.toText(basicStringVisitor));
    assertEquals("<p><b>Paragraph Visitor Test</b>\n</p>", document.toText(htmlVisitor));
    assertEquals("\n**Paragraph Visitor Test**", document.toText(markdownVisitor));
  }

}