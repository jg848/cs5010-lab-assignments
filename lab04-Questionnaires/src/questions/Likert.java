package questions;

/**
 * Likert class which is a type of Question, implements the {@link Question}
 * interface by extending the {@link AbstractQuestion} class. The Likert
 * represents a type of question in which there is no correct answer as it asks
 * for the opinion of the user and the options available for a user to answer it
 * on a fixed 5-point Likert scale (Strongly Agree, Agree, Neither Agree nor
 * Disagree, Disagree, Strongly Disagree). An answer can be entered as one of
 * the option numbers, numbered from 1 in the above order. Any valid option
 * number is a "correct" answer.
 * 
 * @author Jaswin Gumpella
 *
 */
public class Likert extends AbstractQuestion {

  /**
   * Constructor for the Likert class which takes the text of the question and the
   * answer given by the user as arguments and initializes the fields of the
   * class.
   */
  public Likert(String question) {
    super(question);
  }

  @Override
  public String getText() {
    return this.question;
  }

  @Override
  public String answer(String givenAnswer) {
    if (null != givenAnswer && !givenAnswer.isBlank()) {
      try {
        if (Integer.parseInt(givenAnswer) >= 1 && Integer.parseInt(givenAnswer) <= 5) {
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
      if (question instanceof Likert) {
        return this.compareToLikert(question);
      }
      return ((AbstractQuestion) question).compareToLikert(question);
    } else {
      throw new IllegalStateException();
    }
  }

  @Override
  public int compareToLikert(Question question) {
    return this.getText().compareTo(question.getText());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Question: ").append(this.getText()).append(";");
    sb.append("Options: ");
    sb.append("1. Strongly Agree, ");
    sb.append("2. Agree, ");
    sb.append("3. Neither Agree nor Disagree, ");
    sb.append("4. Disagree, ");
    sb.append("5. Strongly Disagree");
    return sb.toString();
  }

}
