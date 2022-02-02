import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questions.Likert;
import questions.Question;
import questions.TrueFalse;

/**
 * Test class for {@link Likert}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class LikertTest {

  Question likertQuestion;
  Question trueFalseQuestion;

  /**
   * Setup method for the test class.
   * 
   * @throws java.lang.IllegalArgumentException for invalid parameters.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    trueFalseQuestion = new TrueFalse("This class is to test Likert class", "TRUE");
    likertQuestion = new Likert("The class has test methods for Likert class");
  }

  /**
   * Test method for {@link questions.Likert#compareTo(questions.Question)}.
   */
  @Test
  public final void testCompareTo() {
    assertEquals(-1, likertQuestion.compareTo(trueFalseQuestion));
  }

  /**
   * Test method for {@link questions.Likert#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerTrue() {
    assertEquals("Correct", likertQuestion.answer("3"));
  }

  /**
   * Test method for {@link questions.Likert#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerFalse() {
    assertEquals("Incorrect", likertQuestion.answer("J"));
  }

  /**
   * Test method for {@link questions.Likert#Likert(java.lang.String)}.
   */
  @Test
  public final void testLikert() {
    likertQuestion = new Likert("The class has test methods for Likert class");
    assertEquals(Likert.class, likertQuestion.getClass());
  }

  /**
   * Test method for {@link questions.Likert#Likert(java.lang.String)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testLikertInvalidQuestionText() {
    new Likert("");
  }

  /**
   * Test method for {@link questions.Likert#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "Question: The class has test methods for Likert class;"
        + "Options: 1. Strongly Agree, 2. Agree, 3. Neither Agree nor Disagree, "
        + "4. Disagree, 5. Strongly Disagree";
    assertEquals(expected, likertQuestion.toString());
  }

}
