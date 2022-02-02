package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

/**
 * Class representing the operations on visiting the elements of the document.
 * 
 * @author Jaswin Gumpella
 *
 * @param <R> Type of the element of the document.
 */
public interface TextElementVisitor<R> {

  /**
   * Visits the {@link BasicText}.
   * 
   * @param text which represents the basic text element of the document.
   * @return an instance of type R representing the type of the element.
   */
  public R visitBasicText(BasicText text);

  /**
   * Visits the {@link BoldText}.
   * 
   * @param text which represents the bold text element of the document.
   * @return an instance of type R representing the type of the element.
   */
  public R visitBoldText(BoldText text);

  /**
   * Visits the {@link Heading}.
   * 
   * @param text which represents the heading element of the document.
   * @return an instance of type R representing the type of the element.
   */
  public R visitHeading(Heading text);

  /**
   * Visits the {@link HyperText}.
   * 
   * @param text which represents the hyper text element of the document.
   * @return an instance of type R representing the type of the element.
   */
  public R visitHyperText(HyperText text);

  /**
   * Visits the {@link ItalicText}.
   * 
   * @param text which represents the italic text element of the document.
   * @return an instance of type R representing the type of the element.
   */
  public R visitItalicText(ItalicText text);

  /**
   * Visits the {@link Paragraph}.
   * 
   * @param text which represents the paragraph of the document.
   * @return an instance of type R representing the type of the element.
   */
  public R visitParagraph(Paragraph text);
}
