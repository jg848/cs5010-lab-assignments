import static org.junit.Assert.assertEquals;

import cs5010.lab00.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Person class.
 */
public class PersonTest {

  private Person john;

  /**
   * Method to instantiate object of Person class.
   */
  @Before
  public void setUp() {

    john = new Person("John", "Doe", 1945);
  }

  /**
   * Method to test the first name of person.
   */
  @Test
  public void testFirst() {
    assertEquals("John", john.getFirstName());

  }

  /**
   * Method to test the last name of person.
   */
  @Test
  public void testSecond() {
    assertEquals("Doe", john.getLastName());
  }

  /**
   * Method to test the year of birth of person.
   */
  @Test
  public void testYearOfBirth() {
    assertEquals(1945, john.getYearOfBirth());
  }

}
