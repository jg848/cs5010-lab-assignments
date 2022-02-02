import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.QuestionBank;
import questions.TrueFalse;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for {@link QuestionBank}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class QuestionBankTest {

  QuestionBank bank;
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
    bank = new QuestionBank();
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
   * Test method for {@link questions.QuestionBank#QuestionBank()}.
   */
  @Test
  public final void testQuestionBank() {
    bank = new QuestionBank();
    assertEquals(QuestionBank.class, bank.getClass());
  }

  /**
   * Test method for {@link questions.QuestionBank#getQuestionsList()}.
   */
  @Test
  public final void testGetQuestionsList() {
    bank.addQuestion(likert);
    bank.addQuestion(likert1);
    bank.addQuestion(multipleChoice);
    bank.addQuestion(multipleChoice1);
    bank.addQuestion(multipleSelect);
    bank.addQuestion(multipleSelect1);
    bank.addQuestion(trueFalse);
    bank.addQuestion(trueFalse1);
    List<Question> expected = new ArrayList<>();
    expected.add(trueFalse);
    expected.add(trueFalse1);
    expected.add(multipleChoice);
    expected.add(multipleChoice1);
    expected.add(multipleSelect1);
    expected.add(multipleSelect);
    expected.add(likert1);
    expected.add(likert);
    System.out.println(expected);
    System.out.println(bank.getQuestionsList());
    assertEquals(expected, bank.getQuestionsList());
  }

  /**
   * Test method for
   * {@link questions.QuestionBank#addQuestion(questions.Question)}.
   */
  @Test
  public final void testAddQuestion() {
    Question likertQuestion = new Likert("This is a test class for Question Bank.");
    bank.addQuestion(likertQuestion);
    List<Question> expected = new ArrayList<>();
    expected.add(likertQuestion);
    assertEquals(expected, bank.getQuestionsList());
  }

}
