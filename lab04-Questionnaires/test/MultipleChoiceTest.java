import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questions.Likert;
import questions.MultipleChoice;
import questions.Question;

/**
 * Test class for {@link MultipleChoice}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class MultipleChoiceTest {

  Question multipleChoice;
  Question likertQuestion;

  /**
   * Setup method for the test class.
   * 
   * @throws java.lang.IllegalArgumentException when invalid parameters are given.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    multipleChoice = new MultipleChoice("How many days is one year?", "4", "100", "200", "300",
        "365", "400");
    likertQuestion = new Likert("The class has test methods for TrueFalse class");
  }

  /**
   * Test method for
   * {@link questions.MultipleChoice#compareTo(questions.Question)}.
   */
  @Test
  public final void testCompareTo() {
    assertEquals(1, multipleChoice.compareTo(likertQuestion));
  }

  /**
   * Test method for {@link questions.MultipleChoice#answer(String)}.
   */
  @Test
  public final void testAnswerTrue() {
    assertEquals("Correct", multipleChoice.answer("4"));
  }

  /**
   * Test method for {@link questions.MultipleChoice#answer(String)}.
   */
  @Test
  public final void testAnswerFalse() {
    assertEquals("Incorrect", multipleChoice.answer("3"));
  }

  /**
   * Test method for {@link questions.MultipleChoice#answer(String)}.
   */
  @Test
  public final void testAnswerFalseMultiple() {
    assertEquals("Incorrect", multipleChoice.answer("3 4"));
  }

  /**
   * Test method for
   * {@link questions.MultipleChoice#MultipleChoice(String, String, String[])}.
   */
  @Test
  public final void testMultipleChoice() {
    multipleChoice = new MultipleChoice("How many days is one year?", "4", "100", "200", "300",
        "365", "400");
    assertEquals(MultipleChoice.class, multipleChoice.getClass());
  }

  /**
   * Test method for
   * {@link questions.MultipleChoice#MultipleChoice(String, String, String[])}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testMultipleChoiceInvalidQuestion() {
    new MultipleChoice("", "4", "100", "200", "300", "365", "400");
  }

  /**
   * Test method for
   * {@link questions.MultipleChoice#MultipleChoice(String, String, String[])}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testMultipleChoiceInvalidCorrectAnswer() {
    new MultipleChoice("How many days is one year?", "D", "100", "200", "300", "365", "400");
  }

  /**
   * Test method for
   * {@link questions.MultipleChoice#MultipleChoice(String, String, String[])}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testMultipleChoiceInvalidOptions() {
    new MultipleChoice("How many days is one year?", "4", "100", "200", "300", "", "400");
  }

  /**
   * Test method for {@link questions.MultipleChoice#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "Question: How many days is one year?;"
        + "Options: 100, 200, 300, 365, 400, ;Correct Answer: 4";
    assertEquals(expected, multipleChoice.toString());
  }

}
