package questions;

/**
 * Abstract class implementing the {@link Question} interface which is used to
 * represent the common features of different classes implementing the
 * {@link Question} interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public abstract class AbstractQuestion implements Question {

  protected String question;

  /**
   * Constructor for the abstract class to initialize the required fields of the
   * class.
   */
  protected AbstractQuestion(String text) {
    this.validateQuestionText(text);
    this.question = text;
  }

  @Override
  public abstract int compareTo(Question o);

  @Override
  public abstract String answer(String answer);

  @Override
  public String getText() {
    return this.question;
  }

  /**
   * Helper method used to validate the question text for a {@link Question}.
   * 
   * @param text is the text to be validated.
   * @throws IllegalArgumentException when the text is blank.
   */
  private void validateQuestionText(String text) {
    if (null != text && !text.isBlank()) {
      this.question = text;
    } else {
      throw new IllegalArgumentException("Question text cannot be blank.");
    }
  }

  /**
   * Method used to compare the given question with {@link TrueFalse}.
   * 
   * @param question is the {@link Question} to compare.
   * @return an integer which represents if it has to be above or below to
   *         {@link TrueFalse} type.
   */
  public int compareToTrueFalse(Question question) {
    return -1;
  }

  /**
   * Method used to compare the given question with {@link MultipleChoice}.
   * 
   * @param question is the {@link Question} to compare.
   * @return an integer which represents if it has to be above or below to
   *         {@link MultipleChoice} type.
   */
  public int compareToMultipleChoice(Question question) {
    if (question instanceof TrueFalse) {
      return 1;
    } else {
      return -1;
    }
  }

  /**
   * Method used to compare the given question with {@link MultipleSelect}.
   * 
   * @param question is the {@link Question} to compare.
   * @return an integer which represents if it has to be above or below to
   *         {@link MultipleSelect} type.
   */
  public int compareToMultipleSelect(Question question) {
    if (question instanceof TrueFalse || question instanceof MultipleChoice) {
      return 1;
    } else {
      return -1;
    }
  }

  /**
   * Method used to compare the given question with {@link Likert}.
   * 
   * @param question is the {@link Question} to compare.
   * @return an integer which represents if it has to be above or below to
   *         {@link Likert} type.
   */
  public int compareToLikert(Question question) {
    return 1;
  }
}
