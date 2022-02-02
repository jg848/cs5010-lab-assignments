package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link GoodStanding} class which implements the {@link GradeObserver}
 * interface and is responsible to keep track of the records and to check if the
 * subject is in a good standing or not.
 * 
 * @author Jaswin Gumpella
 *
 */
public class GoodStanding implements GradeObserver {
  private double goodStanding;
  private final List<GradeRecord> listOfCourses;

  /**
   * Default constructor for the {@link GoodStanding} class which initializes the
   * attributes of the class.
   */
  public GoodStanding() {
    this.goodStanding = 0.0;
    listOfCourses = new ArrayList<>();
  }

  private double calculateGpa(List<GradeRecord> records) {
    if (null == records || records.isEmpty()) {
      throw new IllegalArgumentException("Records cannot be empty.");
    }
    double hours = 0.0;
    double goodStandingTemp = 0.0;
    for (GradeRecord record : records) {
      int currentHours = record.getCredits();
      hours += currentHours;
      goodStandingTemp += record.getGrade().getGradeValue() * currentHours;
    }
    return goodStandingTemp / hours;
  }

  @Override
  public void update(GradeRecord record) {
    if (record == null) {
      throw new IllegalArgumentException("Record cannot be empty.");
    }
    listOfCourses.removeIf(recordTemp -> recordTemp.getCourse().equals(record.getCourse()));
    listOfCourses.add(record);
    this.goodStanding = calculateGpa(listOfCourses);
  }

  @Override
  public boolean isSatisfied() {
    return this.goodStanding > 3.0;
  }

  @Override
  public String toString() {
    return String.valueOf(goodStanding);
  }
}
