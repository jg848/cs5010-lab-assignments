import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

/**
 * Test class for implementation of {@link Question} interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class AbstractQuestionTest {

  Question likert;
  Question multipleChoice;
  Question multipleSelect;
  Question trueFalse;
  Question likert1;
  Question multipleChoice1;
  Question multipleSelect1;
  Question trueFalse1;

  /**
   * Setup method for the test class.
   * 
   * @throws java.lang.IllegalArgumentException for invalid parameters.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    likert = new Likert("The class has test methods for Question implementation");
    multipleChoice = new MultipleChoice("How many days is one year?", "4", "100", "200", "300",
        "365", "400");
    multipleSelect = new MultipleSelect("What is one year equal to?", "1 2", "365 days", "52 weeks",
        "100 days");
    trueFalse = new TrueFalse("This class is to test AbstractQuestion class", "TRUE");
    likert1 = new Likert("The class has test methods for AbstractQuestion class");
    multipleChoice1 = new MultipleChoice("How many months is one year?", "4", "10", "8", "4", "12",
        "20");
    multipleSelect1 = new MultipleSelect("What is one month equal to?", "3 4", "365 days",
        "52 weeks", "30 days", "4 weeks");
    trueFalse1 = new TrueFalse("This class is to test Question implementation", "TRUE");
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#AbstractQuestion(java.lang.String)}.
   */
  @Test
  public final void testAbstractQuestion() {
    likert = new Likert("The class has test methods for Question implementation");
    assertEquals(Likert.class, likert.getClass());
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#AbstractQuestion(java.lang.String)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAbstractQuestionInvalidQuestionText() {
    new Likert("");
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testLikertCompareToMultipleChoice() {
    assertEquals(-1, likert.compareTo(multipleChoice));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testLikertCompareToMultipleSelect() {
    assertEquals(-1, likert.compareTo(multipleSelect));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testLikertCompareToTrueFalse() {
    assertEquals(-1, likert.compareTo(trueFalse));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testMultipleChoiceCompareToLikert() {
    assertEquals(1, multipleChoice.compareTo(likert));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testMultipleChoiceCompareToMultipleSelect() {
    assertEquals(1, multipleChoice.compareTo(multipleSelect));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testMultipleChoiceCompareToTrueFalse() {
    assertEquals(-1, multipleChoice.compareTo(trueFalse));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testMultipleSelectCompareToLikert() {
    assertEquals(1, multipleSelect.compareTo(likert));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testMultipleSelectCompareToMultipleChoice() {
    assertEquals(-1, multipleSelect.compareTo(multipleChoice));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testMultipleSelectCompareToTrueFalse() {
    assertEquals(-1, multipleSelect.compareTo(trueFalse));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testTrueFalseCompareToLikert() {
    assertEquals(1, trueFalse.compareTo(likert));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testTrueFalseCompareToMultipleChoice() {
    assertEquals(1, trueFalse.compareTo(multipleChoice));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testTrueFalseCompareToMultipleSelect() {
    assertEquals(1, trueFalse.compareTo(multipleSelect));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testLikertCompareToLikert() {
    assertEquals(-16, likert.compareTo(likert1));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testMultipleChoiceCompareToMultipleChoice() {
    assertEquals(9, multipleChoice.compareTo(multipleChoice1));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testMultipleSelectCompareToMultipleSelect() {
    assertEquals(-12, multipleSelect.compareTo(multipleSelect1));
  }

  /**
   * Test method for
   * {@link questions.AbstractQuestion#compareTo(questions.Question)}.
   */
  @Test
  public final void testTrueFalseCompareToTrueFalse() {
    assertEquals(16, trueFalse.compareTo(trueFalse1));
  }

  /**
   * Test method for {@link questions.AbstractQuestion#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerLikert() {
    assertEquals("Correct", likert.answer("1"));
  }

  /**
   * Test method for {@link questions.AbstractQuestion#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerMultipleSelect() {
    assertEquals("Correct", multipleSelect.answer("1 2"));
  }

  /**
   * Test method for {@link questions.AbstractQuestion#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerMultipleChoice() {
    assertEquals("Correct", multipleChoice.answer("4"));
  }

  /**
   * Test method for {@link questions.AbstractQuestion#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerTrueFalse() {
    assertEquals("Correct", trueFalse.answer("TRUE"));
  }

  /**
   * Test method for {@link questions.AbstractQuestion#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerLikertFalse() {
    assertEquals("Incorrect", likert.answer(""));
  }

  /**
   * Test method for {@link questions.AbstractQuestion#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerMultipleSelectFalse() {
    assertEquals("Incorrect", multipleSelect.answer(""));
  }

  /**
   * Test method for {@link questions.AbstractQuestion#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerMultipleChoiceFalse() {
    assertEquals("Incorrect", multipleChoice.answer(""));
  }

  /**
   * Test method for {@link questions.AbstractQuestion#answer(java.lang.String)}.
   */
  @Test
  public final void testAnswerTrueFalseFalse() {
    assertEquals("Incorrect", trueFalse.answer(""));
  }

  /**
   * Test method for {@link questions.AbstractQuestion#getText()}.
   */
  @Test
  public final void testGetTextLikert() {
    assertEquals("The class has test methods for Question implementation", likert.getText());
  }

  /**
   * Test method for {@link questions.AbstractQuestion#getText()}.
   */
  @Test
  public final void testGetTextMultipleChoice() {
    assertEquals("How many days is one year?", multipleChoice.getText());
  }

  /**
   * Test method for {@link questions.AbstractQuestion#getText()}.
   */
  @Test
  public final void testGetTextMultipleSelect() {
    assertEquals("What is one year equal to?", multipleSelect.getText());
  }

  /**
   * Test method for {@link questions.AbstractQuestion#getText()}.
   */
  @Test
  public final void testGetTextTrueFalse() {
    assertEquals("This class is to test AbstractQuestion class", trueFalse.getText());
  }

}
