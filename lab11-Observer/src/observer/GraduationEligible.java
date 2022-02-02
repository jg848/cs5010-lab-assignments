package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link GraduationEligible} is the implementation class of the
 * {@link GradeObserver} interface. It is responsible to keep track of the
 * records and to check if the subject is eligible for graduation or not.
 *
 * @author Jaswin Gumpella
 *
 */
public class GraduationEligible implements GradeObserver {

  private double coreGpa;
  private List<GradeRecord> listOfCourses;

  /**
   * Default constructor for the {@link GraduationEligible} class which
   * initializes the attributes of the class.
   */
  public GraduationEligible() {
    this.coreGpa = 0.0;
    this.listOfCourses = new ArrayList<>();
  }

  private double calculateGpa(List<GradeRecord> records) {
    if (null == records || records.isEmpty()) {
      throw new IllegalArgumentException("Records cannot be empty.");
    }
    double qualityPointNumber = 0.0;
    double totalHours = 0.0;
    for (GradeRecord record : records) {
      int currentHours = record.getCredits();
      if (record.getCourse().equals("CS5800") || record.getCourse().equals("CS5500")
          || record.getCourse().equals("CS5600") || record.getCourse().equals("CS5010")
          || record.getCourse().equals("CS5004")) {
        qualityPointNumber += record.getGrade().getGradeValue() * currentHours;
        totalHours += currentHours;
        if (!listOfCourses.contains(record)) {
          listOfCourses.add(record);
        }
      }
    }
    return qualityPointNumber / totalHours;
  }

  @Override
  public void update(GradeRecord record) {
    if (record == null) {
      throw new IllegalArgumentException("Record cannot be empty.");
    }
    listOfCourses.removeIf(recordTemp -> recordTemp.getCourse().equals(record.getCourse()));
    listOfCourses.add(record);
    this.coreGpa = calculateGpa(listOfCourses);
  }

  @Override
  public boolean isSatisfied() {

    boolean cS50105004 = false;
    boolean cS5800 = false;
    boolean cS56005500 = false;
    boolean coreGpaTemp = (this.coreGpa - 3.0 >= .0001);
    for (GradeRecord record : this.listOfCourses) {
      if (record.getCourse().equals("CS5010") || record.getCourse().equals("CS5004")) {
        cS50105004 = true;
        continue;
      }
      if (record.getCourse().equals("CS5500") || record.getCourse().equals("CS5600")) {
        cS56005500 = true;
        continue;
      }
      if (record.getCourse().equals("CS5800")) {
        cS5800 = true;
      }
    }
    return (cS56005500 && cS50105004 && cS5800 && coreGpaTemp);
  }

  @Override
  public String toString() {
    return String.valueOf(coreGpa);
  }
}