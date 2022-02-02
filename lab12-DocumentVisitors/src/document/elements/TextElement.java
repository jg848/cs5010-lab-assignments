package document.elements;

import document.TextElementVisitor;

/**
 * Representation for any of the text elements of a document.
 */
public interface TextElement {

  /**
   * Returns the text of the element.
   * 
   * @return the text.
   */
  public String getText();

  /**
   * Method to make the elements of the document visitable.
   * 
   * @param <R>     Type of the visitor.
   * @param visitor represents the visitor which has to be visitable.
   * @return instance of Type R.
   */
  public <R> R accept(TextElementVisitor<R> visitor);
}
