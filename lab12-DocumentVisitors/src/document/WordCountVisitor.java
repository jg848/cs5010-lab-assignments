package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

/**
 * Implementation class of the {@link TextElementVisitor}. Represents the class
 * which counts the number of words that are in a document.
 * 
 * @author Jaswin Gumpella
 *
 */
public class WordCountVisitor implements TextElementVisitor<Integer> {

  @Override
  public Integer visitBasicText(BasicText text) {
    return countWords(text.getText());
  }

  @Override
  public Integer visitBoldText(BoldText text) {
    return countWords(text.getText());
  }

  @Override
  public Integer visitHeading(Heading text) {
    return countWords(text.getText());
  }

  @Override
  public Integer visitHyperText(HyperText text) {
    return countWords(text.getText());
  }

  @Override
  public Integer visitItalicText(ItalicText text) {
    return countWords(text.getText());
  }

  @Override
  public Integer visitParagraph(Paragraph text) {
    return countWords(text.getText());
  }

  private int countWords(String text) {
    String[] words = text.split(" ");
    return words.length;
  }
}
