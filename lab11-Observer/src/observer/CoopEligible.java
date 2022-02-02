package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link CoopEligible} class which implements the {@link GradeObserver}
 * interface and is responsible to keep track of the records and to check if the
 * subject is eligible for coop.
 * 
 * @author Jaswin Gumpella
 *
 */
public class CoopEligible implements GradeObserver {
  private int hours;
  private final GoodStanding goodStanding;
  private final List<GradeRecord> listOfCourses;

  /**
   * Default constructor for the {@link CoopEligible} class which initializes the
   * attributes of the class.
   */
  public CoopEligible() {
    this.hours = 0;
    this.goodStanding = new GoodStanding();
    listOfCourses = new ArrayList<>();
  }

  private int calculateCredits(List<GradeRecord> records) {
    int hours = 0;
    for (GradeRecord record : records) {
      hours += record.getCredits();
    }
    return hours;
  }

  @Override
  public void update(GradeRecord record) {
    if (record == null) {
      throw new IllegalArgumentException("GradeRecord is empty.");
    }
    listOfCourses.removeIf(record1 -> record1.getCourse().equals(record.getCourse()));
    listOfCourses.add(record);
    goodStanding.update(record);
    this.hours = calculateCredits(listOfCourses);
  }

  @Override
  public boolean isSatisfied() {
    return this.hours >= 16 && this.goodStanding.isSatisfied();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("hours=").append(hours).append(", ").append("goodStanding=")
        .append(goodStanding);
    return builder.toString();
  }
}
