import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questions.Likert;
import questions.MultipleSelect;
import questions.Question;

/**
 * Test class for {@link MultipleSelect}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class MultipleSelectTest {

  Question likertQuestion;
  Question multipleSelect;

  /**
   * Setup method for test class.
   * 
   * @throws java.lang.IllegalArgumentException for invalid parameters.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    likertQuestion = new Likert("The class has test methods for TrueFalse class");
    multipleSelect = new MultipleSelect("What is one year equal to?", "1 2", "365 days", "52 weeks",
        "100 days");
  }

  /**
   * Test method for
   * {@link questions.MultipleSelect#compareTo(questions.Question)}.
   */
  @Test
  public final void testCompareTo() {
    assertEquals(1, multipleSelect.compareTo(likertQuestion));
  }

  /**
   * Test method for {@link questions.MultipleSelect#answer(String)}.
   */
  @Test
  public final void testAnswerTrue() {
    assertEquals("Correct", multipleSelect.answer("1 2"));
  }

  /**
   * Test method for {@link questions.MultipleSelect#answer(String)}.
   */
  @Test
  public final void testAnswerFalse() {
    assertEquals("Incorrect", multipleSelect.answer("1 4"));
  }

  /**
   * Test method for
   * {@link questions.MultipleSelect#MultipleSelect(String, String, String[])}.
   */
  @Test
  public final void testMultipleSelect() {
    multipleSelect = new MultipleSelect("What is one year equal to?", "1 2", "365 days", "52 weeks",
        "100 days");
    assertEquals(MultipleSelect.class, multipleSelect.getClass());
  }

  /**
   * Test method for
   * {@link questions.MultipleSelect#MultipleSelect(String, String, String[])}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testMultipleSelectInvalidQuestionText() {
    new MultipleSelect("", "1 2", "365 days", "52 weeks", "100 days");
  }

  /**
   * Test method for
   * {@link questions.MultipleSelect#MultipleSelect(String, String, String[])}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testMultipleSelectInvalidCorrectAnswer() {
    new MultipleSelect("What is one year equal to?", "", "365 days", "52 weeks", "100 days");
  }

  /**
   * Test method for
   * {@link questions.MultipleSelect#MultipleSelect(String, String, String[])}.
   */
  @Test(expected = NumberFormatException.class)
  public final void testMultipleSelectInvalidCorrectAnswerNumberFormat() {
    new MultipleSelect("What is one year equal to?", "a b", "365 days", "52 weeks", "100 days");
  }

  /**
   * Test method for {@link questions.MultipleSelect#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "Question: What is one year equal to?;"
        + "Options: 365 days,52 weeks,100 days,;Correct Answer: 1 2";
    assertEquals(expected, multipleSelect.toString());
  }

}
