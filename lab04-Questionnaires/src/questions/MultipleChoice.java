package questions;

/**
 * MultipleChoice class which is a type of Question, implements the
 * {@link Question} interface by extending the {@link AbstractQuestion} class.
 * The MultipleChoice represents a type of question which may have at least 3
 * options, but no more than 8. An answer can be entered as one of the option
 * numbers in a string. There is only one answer from the options provided.
 * 
 * @author Jaswin Gumpella
 *
 */
public class MultipleChoice extends AbstractQuestion {

  private final int correctAnswer;
  private final String[] options;

  /**
   * Constructor for the MultipleChoice class which takes the text of the
   * question, the correct answer and the options provided for the question as
   * answer and initializes the fields of the class.
   */
  public MultipleChoice(String question, String correctAnswer, String... strings) {
    super(question);

    if (null != correctAnswer && !correctAnswer.isBlank()) {
      try {
        this.correctAnswer = Integer.parseInt(correctAnswer);
      } catch (NumberFormatException e) {
        throw new NumberFormatException(
            "Correct answer provided is of invalid format. Numeric input expected.");
      }
    } else {
      throw new IllegalArgumentException("Correct answer cannot be blank.");
    }

    if (strings.length >= 3 && strings.length <= 8) {
      for (String option : strings) {
        if (null == option || option.isBlank()) {
          throw new IllegalArgumentException("Invalid option format");
        }
      }
    } else {
      throw new IllegalArgumentException(
          "Invalid number of options provided. The number of options should be between 3 and 8.");
    }
    this.options = strings;
  }

  @Override
  public String answer(String answer) {
    if (null != answer && !answer.isBlank()) {
      try {
        if (this.correctAnswer == Integer.parseInt(answer)) {
          return CORRECT;
        } else {
          return INCORRECT;
        }
      } catch (NumberFormatException e) {
        return INCORRECT;
      }
    } else {
      return INCORRECT;
    }
  }

  @Override
  public int compareTo(Question question) {
    if (question instanceof AbstractQuestion) {
      if (question instanceof MultipleChoice) {
        return this.compareToMultipleChoice(question);
      }
      return ((AbstractQuestion) question).compareToMultipleChoice(question);
    } else {
      throw new IllegalStateException();
    }
  }

  @Override
  public int compareToMultipleChoice(Question question) {
    return this.getText().compareTo(question.getText());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Question: ").append(this.getText()).append(";");
    sb.append("Options: ");
    for (int i = 0; i < options.length; i++) {
      sb.append(this.options[i]).append(", ");
    }
    sb.append(";");
    sb.append("Correct Answer: ").append(this.correctAnswer);
    return sb.toString();
  }

}
