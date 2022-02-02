import static org.junit.Assert.assertEquals;

import document.BasicStringVisitor;
import document.HtmlStringVisitor;
import document.MarkdownStringVisitor;
import document.WordCountVisitor;
import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElement;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link TextElement}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class TextElementTest {
  private BasicText basicText;
  private BoldText boldText;
  private ItalicText italicText;
  private Heading heading;
  private HyperText hyperText;
  private Paragraph paragraph;

  /**
   * Method to setup the test class with required attributes.
   */
  @Before
  public void setUp() {
    basicText = new BasicText("Basic Text Test");
    boldText = new BoldText("Bold Text Test");
    italicText = new ItalicText("Italic Text Test");
    heading = new Heading("Heading Text Test", 4);
    hyperText = new HyperText("Hyper Text Test", "www.google.com");
    paragraph = new Paragraph();
    paragraph.add(new BasicText("Paragraph Test"));
  }

  /**
   * Test method for {@link document.elements.TextElement#getText()}.
   */
  @Test
  public final void testGetTextBasicText() {
    assertEquals("Basic Text Test", basicText.getText());
  }

  /**
   * Test method for {@link document.elements.TextElement#getText()}.
   */
  @Test
  public final void testGetTextBoldText() {
    assertEquals("Bold Text Test", boldText.getText());
  }

  /**
   * Test method for {@link document.elements.TextElement#getText()}.
   */
  @Test
  public final void testGetTextItalicText() {
    assertEquals("Italic Text Test", italicText.getText());
  }

  /**
   * Test method for {@link document.elements.TextElement#getText()}.
   */
  @Test
  public final void testGetTextHeading() {
    assertEquals("Heading Text Test", heading.getText());
  }

  /**
   * Test method for {@link document.elements.TextElement#getText()}.
   */
  @Test
  public final void testGetTextHyperText() {
    assertEquals("Hyper Text Test", hyperText.getText());
  }

  /**
   * Test method for {@link document.elements.TextElement#getText()}.
   */
  @Test
  public final void testGetTextParagraph() {
    assertEquals("Paragraph Test", paragraph.getText());
  }

  /**
   * Test method for
   * {@link document.elements.TextElement#accept(document.TextElementVisitor)}.
   */
  @Test
  public final void testAcceptBasicText() {
    assertEquals("Basic Text Test", basicText.accept(new BasicStringVisitor()));
    assertEquals("Basic Text Test\n", basicText.accept(new HtmlStringVisitor()));
    assertEquals("Basic Text Test\n", basicText.accept(new MarkdownStringVisitor()));
    assertEquals((Integer) 3, basicText.accept(new WordCountVisitor()));
  }

  /**
   * Test method for
   * {@link document.elements.TextElement#accept(document.TextElementVisitor)}.
   */
  @Test
  public final void testAcceptBoldText() {
    assertEquals("Bold Text Test", boldText.getText());
    assertEquals("<b>Bold Text Test</b>\n", boldText.accept(new HtmlStringVisitor()));
    assertEquals("**Bold Text Test**\n", boldText.accept(new MarkdownStringVisitor()));
    assertEquals((Integer) 3, boldText.accept(new WordCountVisitor()));
  }

  /**
   * Test method for
   * {@link document.elements.TextElement#accept(document.TextElementVisitor)}.
   */
  @Test
  public final void testAcceptItalicText() {
    assertEquals("Italic Text Test", italicText.getText());
    assertEquals("<i>Italic Text Test</i>\n", italicText.accept(new HtmlStringVisitor()));
    assertEquals("*Italic Text Test*\n", italicText.accept(new MarkdownStringVisitor()));
    assertEquals((Integer) 3, italicText.accept(new WordCountVisitor()));
  }

  /**
   * Test method for
   * {@link document.elements.TextElement#accept(document.TextElementVisitor)}.
   */
  @Test
  public final void testAcceptHeading() {
    assertEquals("Heading Text Test", heading.getText());
    assertEquals("<h4>Heading Text Test</h4>\n", heading.accept(new HtmlStringVisitor()));
    assertEquals("#### Heading Text Test\n", heading.accept(new MarkdownStringVisitor()));
    assertEquals((Integer) 3, heading.accept(new WordCountVisitor()));
  }

  /**
   * Test method for
   * {@link document.elements.TextElement#accept(document.TextElementVisitor)}.
   */
  @Test
  public final void testAcceptHyperText() {
    assertEquals("Hyper Text Test", hyperText.getText());
    assertEquals("<a href=\"www.google.com\">Hyper Text Test</a>\n",
        hyperText.accept(new HtmlStringVisitor()));
    assertEquals("[Hyper Text Test](www.google.com)\n",
        hyperText.accept(new MarkdownStringVisitor()));
    assertEquals((Integer) 3, hyperText.accept(new WordCountVisitor()));
  }

  /**
   * Test method for
   * {@link document.elements.TextElement#accept(document.TextElementVisitor)}.
   */
  @Test
  public final void testAcceptParagraph() {
    assertEquals("Paragraph Test", paragraph.getText());
    assertEquals("<p>Paragraph Test\n</p>\n", paragraph.accept(new HtmlStringVisitor()));
    assertEquals("\nParagraph Test\n", paragraph.accept(new MarkdownStringVisitor()));
    assertEquals((Integer) 2, paragraph.accept(new WordCountVisitor()));
  }
}