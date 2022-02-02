package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link GradeSubjectImpl} class is the implementation class of
 * {@link GradeSubject} interface and contains the implementations of the
 * operations defined in the interface. It is responsible to keep track of the
 * list of observers and notify when there is a change in the record.
 *
 * @author Jaswin Gumpella
 *
 */
public class GradeSubjectImpl implements GradeSubject {

  private final List<GradeObserver> listOfObservers;
  private final List<GradeRecord> listOfCourses;

  /**
   * Default constructor for the {@link GradeSubjectImpl} class which initializes
   * the attributes of the class.
   */
  public GradeSubjectImpl() {
    this.listOfCourses = new ArrayList<>();
    this.listOfObservers = new ArrayList<>();
  }

  @Override
  public void attach(GradeObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException("Observer cannot be null.");
    }
    this.listOfObservers.add(observer);
  }

  @Override
  public void detach(GradeObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException("Observer cannot be null.");
    }
    this.listOfObservers.remove(observer);
  }

  @Override
  public void notify(GradeRecord record) {
    if (record == null) {
      throw new IllegalArgumentException("Record cannot be null.");
    }
    listOfCourses.removeIf(recordTemp -> recordTemp.getCourse().equals(record.getCourse()));
    listOfCourses.add(record);
    for (GradeObserver observer : listOfObservers) {
      observer.update(record);
    }
  }

  @Override
  public String toString() {
    return listOfObservers.toString();
  }
}
