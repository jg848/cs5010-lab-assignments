package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class used to store the questions so that they can be picked quickly to
 * assemble a questionnaire. Represents a Question Bank containing the questions
 * in an order.The order is that all true/false questions are before any
 * multiple-choice questions. All multiple-choice questions are before any
 * multiple-select questions. All multiple-select questions are before any
 * Likert questions. Within a question type, they are ordered in the
 * lexicographical (dictionary) order of their question text.
 * 
 * @author Jaswin Gumpella
 *
 */
public class QuestionBank {

  private final List<Question> questionsList;

  /**
   * Constructor for the QuestionBank to construct a question bank and intialize
   * the class.
   */
  public QuestionBank() {
    this.questionsList = new ArrayList<>();
  }

  /**
   * Method used to retrieve the questions stored in the question bank.
   * 
   * @return the list of questions stored in the question bank.
   */
  public List<Question> getQuestionsList() {
    return questionsList;
  }

  /**
   * Method used to add a {@link Question} into the question bank by checking the
   * order in which it has to be added.
   * 
   * @param question which is the {@link Question} to be added into the question
   *                 bank.
   */
  public void addQuestion(Question question) {
    questionsList.add(question);
    Collections.sort(questionsList);
  }

}
