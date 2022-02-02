import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questions.Likert;
import questions.Question;
import questions.TrueFalse;

/**
 * Test class for {@link TrueFalse}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class TrueFalseTest {

  Question trueFalseQuestion;
  Question likertQuestion;

  /**
   * Setup method for the test class.
   * 
   * @throws java.lang.IllegalArgumentException for invalid parameters
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    trueFalseQuestion = new TrueFalse("This class is to test TrueFalse class", "TRUE");
    likertQuestion = new Likert("The class has test methods for TrueFalse class");
  }

  /**
   * Test method for {@link questions.TrueFalse#compareTo(questions.Question)}.
   */
  @Test
  public final void testCompareTo() {
    assertEquals(1, trueFalseQuestion.compareTo(likertQuestion));
  }

  /**
   * Test method for {@link questions.TrueFalse#compareTo(questions.Question)}.
   */
  @Test(expected = IllegalStateException.class)
  public final void testCompareToNull() {
    trueFalseQuestion.compareTo(null);
  }

  /**
   * Test method for {@link questions.TrueFalse#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerTrue() {
    assertEquals("Correct", trueFalseQuestion.answer("TRUE"));
  }

  /**
   * Test method for {@link questions.TrueFalse#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerFalse() {
    assertEquals("Incorrect", trueFalseQuestion.answer("FALSE"));
  }

  /**
   * Test method for
   * {@link questions.TrueFalse#TrueFalse(java.lang.String, java.lang.String)}.
   */
  @Test
  public final void testTrueFalse() {
    trueFalseQuestion = new TrueFalse("This class is to test TrueFalse class", "TRUE");
    assertEquals(TrueFalse.class, trueFalseQuestion.getClass());
  }

  /**
   * Test method for
   * {@link questions.TrueFalse#TrueFalse(java.lang.String, java.lang.String)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testTrueFalseInvalidQuestionText() {
    new TrueFalse("", "TRUE");
  }

  /**
   * Test method for
   * {@link questions.TrueFalse#TrueFalse(java.lang.String, java.lang.String)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testTrueFalseInvalidCorrectAnswer() {
    new TrueFalse("This class is to test TrueFalse class", "");
  }

  /**
   * Test method for {@link questions.TrueFalse#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "Question: This class is to test TrueFalse class;Correct Answer: TRUE";
    assertEquals(expected, trueFalseQuestion.toString());
  }

}
