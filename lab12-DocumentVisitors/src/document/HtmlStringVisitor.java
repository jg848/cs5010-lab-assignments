package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

/**
 * Extension of the {@link AbstractStringVisitor} class to implement the
 * {@link TextElementVisitor}. Represents the HTML version of the document.
 * 
 * @author Jaswin Gumpella
 *
 */
public class HtmlStringVisitor extends AbstractStringVisitor {

  /**
   * Default constructor for the {@link HtmlStringVisitor}.
   */
  public HtmlStringVisitor() {
    super();
  }

  @Override
  public String visitBasicText(BasicText text) {
    textElementBuilder.append(text.getText()).append("\n");
    return textElementBuilder.toString();
  }

  @Override
  public String visitBoldText(BoldText text) {
    textElementBuilder.append("<b>").append(text.getText()).append("</b>").append("\n");
    return textElementBuilder.toString();
  }

  @Override
  public String visitHeading(Heading text) {
    textElementBuilder.append("<h").append(text.getLevel()).append(">").append(text.getText())
        .append("</h").append(text.getLevel()).append(">").append("\n");
    return textElementBuilder.toString();
  }

  @Override
  public String visitHyperText(HyperText text) {
    textElementBuilder.append("<a href=\"").append(text.getUrl()).append("\">")
        .append(text.getText()).append("</a>").append("\n");
    return textElementBuilder.toString();
  }

  @Override
  public String visitItalicText(ItalicText text) {
    textElementBuilder.append("<i>").append(text.getText()).append("</i>").append("\n");
    return textElementBuilder.toString();
  }

  @Override
  public String visitParagraph(Paragraph text) {
    textElementBuilder.append("<p>");
    for (BasicText element : text.getContent()) {
      textElementBuilder.append(element.accept(new HtmlStringVisitor()));
    }
    textElementBuilder.append("</p>").append("\n");
    return textElementBuilder.toString();
  }

}
