
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Book class.
 */
public class BookTest {

  private Book java;

  /**
   * Method to instantiate objects of Book and Person classes.
   */
  @Before
  public void setUp() {
    Person joshua = new Person("Joshua", "Bloch", 1961);
    java = new Book("Effective Java", joshua, (float) 50);
  }

  /**
   * Method to test the title of the book.
   */
  @Test
  public void testTitle() {
    String expected = "Effective Java";
    assertEquals(expected, java.getTitle());
  }

  /**
   * Method to test the price of the book.
   */
  @Test
  public void testPrice() {
    float expected = 50;
    assertEquals(expected, java.getPrice(), (float) 0);
  }

  /**
   * Method to test the first name of the author.
   */
  @Test
  public void testPersonFirst() {
    String expected = "Joshua";
    assertEquals(expected, java.getAuthor().getFirstName());
  }

  /**
   * Method to test the last name of the author.
   */
  @Test
  public void testPersonLast() {
    String expected = "Bloch";
    assertEquals(expected, java.getAuthor().getLastName());
  }

  /**
   * Method to test the year of birth of the author.
   */
  @Test
  public void testPersonYearOfBirth() {
    int expected = 1961;
    assertEquals(expected, java.getAuthor().getYearOfBirth());
  }
}
