package questions;

import java.util.Arrays;

/**
 * MultipleSelect class which is a type of Question, implements the
 * {@link Question} interface by extending the {@link AbstractQuestion} class.
 * The MultipleSelect represents a type of question which may have at least 3
 * options, but no more than 8. An answer can be entered as a list of the option
 * numbers inside a string. There can be more than one answer from the options
 * provided.
 * 
 * @author Jaswin Gumpella
 *
 */
public class MultipleSelect extends AbstractQuestion {

  private final String correctAnswer;
  private final String[] options;

  /**
   * Constructor for the MultipleSelect class which takes the text of the
   * question, the correct answer containing a string with the list of correct
   * answers and the options provided for the question as answers and initializes
   * the fields of the class.
   */
  public MultipleSelect(String question, String correctAnswer, String... strings) {
    super(question);
    if (null != correctAnswer && !correctAnswer.isBlank()) {
      try {
        String[] answers = correctAnswer.split(" ");
        for (String answer : answers) {
          Integer.parseInt(answer);
        }
      } catch (NumberFormatException e) {
        throw new NumberFormatException(
            "Correct answer provided is of invalid format. Numeric input expected.");
      }
      this.correctAnswer = correctAnswer;
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
    String[] answers;
    String[] correctAnswers;
    correctAnswers = correctAnswer.split(" ");
    answers = answer.split(" ");
    Arrays.sort(answers);
    Arrays.sort(correctAnswers);
    for (String s : answers) {
      try {
        if (Integer.parseInt(s) < 1 || Integer.parseInt(s) > options.length) {
          return INCORRECT;
        }
      } catch (NumberFormatException e) {
        return INCORRECT;
      }
    }
    if (Arrays.equals(answers, correctAnswers)) {
      return CORRECT;
    } else {
      return INCORRECT;
    }
  }

  @Override
  public int compareTo(Question question) {
    if (question instanceof AbstractQuestion) {
      if (question instanceof MultipleSelect) {
        return this.compareToMultipleSelect(question);
      }
      return ((AbstractQuestion) question).compareToMultipleSelect(question);
    } else {
      throw new IllegalStateException();
    }
  }

  @Override
  public int compareToMultipleSelect(Question question) {
    return this.getText().compareTo(question.getText());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Question: ").append(this.getText()).append(";");
    sb.append("Options: ");
    for (int i = 0; i < options.length; i++) {
      sb.append(this.options[i]).append(",");
    }
    sb.append(";");
    sb.append("Correct Answer: ").append(this.correctAnswer);
    return sb.toString();
  }
}
