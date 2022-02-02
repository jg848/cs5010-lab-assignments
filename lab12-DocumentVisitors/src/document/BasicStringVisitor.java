package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

/**
 * Implementation class of the {@link TextElementVisitor} interface. It
 * represents a simple string representation of the document.
 * 
 * @author Jaswin Gumpella
 *
 */
public class BasicStringVisitor implements TextElementVisitor<String> {
  private String textElement;

  /**
   * Default constructor for the {@link BasicStringVisitor} class.
   */
  public BasicStringVisitor() {
    textElement = "";
  }

  @Override
  public String visitBasicText(BasicText text) {
    return combineText(text.getText());
  }

  @Override
  public String visitBoldText(BoldText text) {
    return combineText(text.getText());
  }

  @Override
  public String visitHeading(Heading text) {
    return combineText(text.getText());
  }

  @Override
  public String visitHyperText(HyperText text) {
    return combineText(text.getText());
  }

  @Override
  public String visitItalicText(ItalicText text) {
    return combineText(text.getText());
  }

  @Override
  public String visitParagraph(Paragraph text) {
    return combineText(text.getText());
  }

  private String combineText(String element) {
    if (textElement.isEmpty()) {
      textElement = element;
    } else {
      textElement += " " + element;
    }
    return textElement;
  }

  @Override
  public String toString() {
    return textElement;
  }
}
