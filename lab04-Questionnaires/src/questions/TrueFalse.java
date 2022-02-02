package questions;

/**
 * TrueFalse class which is a type of Question, implements the {@link Question}
 * interface by extending the {@link AbstractQuestion} class. The TrueFalse
 * represents a type of question which has only 2 options 'True' or 'False'. An
 * answer can be entered as one of the option numbers in a string. There is only
 * one answer from the options provided which is either 'True' or 'False'.
 * 
 * @author Jaswin Gumpella
 *
 */
public class TrueFalse extends AbstractQuestion {

  private String correctAnswer;

  /**
   * Constructor for the TrueFalse class which takes the text of the question, the
   * correct answer which is 'True' or 'False' and the answer provided for the
   * question and initializes the fields of the class.
   */
  public TrueFalse(String question, String correctAnswer) {
    super(question);
    if (null != correctAnswer && !correctAnswer.isBlank()
        && (correctAnswer.equalsIgnoreCase("TRUE") || correctAnswer.equalsIgnoreCase("FALSE"))) {
      this.correctAnswer = correctAnswer;
    } else {
      throw new IllegalArgumentException("The correct answer has to be either TRUE or FALSE.");
    }
  }

  @Override
  public String answer(String answer) {
    if (null != answer && !answer.isBlank() && (answer.equalsIgnoreCase(this.correctAnswer))) {
      return CORRECT;
    } else {
      return INCORRECT;
    }
  }

  @Override
  public int compareTo(Question question) {
    if (question instanceof AbstractQuestion) {
      if (question instanceof TrueFalse) {
        return this.compareToTrueFalse(question);
      }
      return ((AbstractQuestion) question).compareToTrueFalse(question);
    } else {
      throw new IllegalStateException();
    }
  }

  @Override
  public int compareToTrueFalse(Question question) {
    return this.getText().compareTo(question.getText());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Question: ").append(this.getText()).append(";");
    sb.append("Correct Answer: ").append(this.correctAnswer);
    return sb.toString();
  }
}
