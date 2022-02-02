package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

/**
 * Extension of the {@link AbstractStringVisitor} class to implement the
 * {@link TextElementVisitor}. Represents the Markdown version of the document.
 * 
 * @author Jaswin Gumpella
 *
 */
public class MarkdownStringVisitor extends AbstractStringVisitor {

  /**
   * Default constructor for the {@link MarkdownStringVisitor}.
   */
  public MarkdownStringVisitor() {
    super();
  }

  @Override
  public String visitBasicText(BasicText text) {
    textElementBuilder.append(text.getText()).append("\n");
    return textElementBuilder.toString();
  }

  @Override
  public String visitBoldText(BoldText text) {
    textElementBuilder.append("**").append(text.getText()).append("**").append("\n");
    return textElementBuilder.toString();
  }

  @Override
  public String visitHeading(Heading text) {
    textElementBuilder.append("#".repeat(Math.max(0, text.getLevel()))).append(" ")
        .append(text.getText()).append("\n");
    return textElementBuilder.toString();
  }

  @Override
  public String visitHyperText(HyperText text) {
    textElementBuilder.append("[").append(text.getText()).append("](").append(text.getUrl())
        .append(")").append("\n");
    return textElementBuilder.toString();
  }

  @Override
  public String visitItalicText(ItalicText text) {
    textElementBuilder.append("*").append(text.getText()).append("*").append("\n");
    return textElementBuilder.toString();
  }

  @Override
  public String visitParagraph(Paragraph text) {
    textElementBuilder.append("\n");
    for (BasicText element : text.getContent()) {
      textElementBuilder.append(element.accept(new MarkdownStringVisitor()));
    }
    return textElementBuilder.toString();
  }

}
