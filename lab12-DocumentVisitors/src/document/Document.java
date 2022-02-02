package document;

import document.elements.TextElement;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a document. It contains a list of the elements of the
 * document in the order that they appear in the document. This class is
 * provided as a starting point for the Visitor lab in CS 5010.
 */
public class Document {

  private List<TextElement> content;

  /** Default constructor initializes the fields of the class. */
  public Document() {
    content = new ArrayList<>();
  }

  /**
   * Add an element to the document. Elements are added in order.
   * 
   * @param e the element to add
   */
  public void add(TextElement e) {
    content.add(e);
  }

  /**
   * Method to return the number of words in a document.
   * 
   * @return an integer which represents the number of words in a document.
   */
  public int countWords() {
    if (content.size() == 0) {
      return 0;
    } else {
      int count = 0;
      for (TextElement element : content) {
        count += element.accept(new WordCountVisitor());
      }
      return count;
    }
  }

  /**
   * Method to return the string representation of the visitor given.
   * 
   * @param visitor which represents the visitor of the document.
   * @return a string representation of the given visitor.
   */
  public String toText(TextElementVisitor<String> visitor) {
    for (TextElement element : content) {
      element.accept(visitor);
    }
    return visitor.toString();
  }
}
