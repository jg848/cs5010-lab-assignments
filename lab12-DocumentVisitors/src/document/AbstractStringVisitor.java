package document;

/**
 * Abstract class which is the implementation of {@link TextElementVisitor} and
 * contains the common features of the implementations of
 * {@link TextElementVisitor}.
 * 
 * @author Jaswin Gumpella
 *
 */
public abstract class AbstractStringVisitor implements TextElementVisitor<String> {

  protected StringBuilder textElementBuilder;

  /**
   * Default constructor of the {@link AbstractStringVisitor} which is to be
   * called by the child classes to initialize the text of the document.
   */
  protected AbstractStringVisitor() {
    textElementBuilder = new StringBuilder();
  }

  @Override
  public String toString() {
    if (textElementBuilder.length() > 1) {
      textElementBuilder.setLength(textElementBuilder.length() - 1);
    }
    return textElementBuilder.toString();
  }
}
