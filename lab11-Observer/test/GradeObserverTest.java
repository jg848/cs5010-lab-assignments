import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import observer.CoopEligible;
import observer.GoodStanding;
import observer.Grade;
import observer.GradeObserver;
import observer.GradeRecord;
import observer.GraduationEligible;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link GradeObserver}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class GradeObserverTest {
  GradeObserver coopObserver;
  GradeObserver goodStandingObserver;
  GradeObserver graduationEligible;
  GradeRecord cS5010;
  GradeRecord cS5800;
  GradeRecord cS5500;
  GradeRecord cS5600;
  GradeRecord cS5004;

  /**
   * Method to setup the test class.
   */
  @Before
  public void setUp() {
    coopObserver = new CoopEligible();
    goodStandingObserver = new GoodStanding();
    graduationEligible = new GraduationEligible();
    cS5010 = new GradeRecord("CS5010", Grade.A, 4);
    cS5800 = new GradeRecord("CS5800", Grade.A_MINUS, 4);
    cS5500 = new GradeRecord("CS5500", Grade.A, 4);
    cS5600 = new GradeRecord("CS5600", Grade.A_MINUS, 4);
    cS5004 = new GradeRecord("CS5004", Grade.A, 4);
  }

  /**
   * Test method for {@link observer.GradeObserver#update(observer.GradeRecord)}.
   */
  @Test
  public void testUpdateCoop() {
    coopObserver.update(cS5004);
    assertEquals("hours=4, goodStanding=4.0", coopObserver.toString());
    coopObserver.update(cS5010);
    assertEquals("hours=8, goodStanding=4.0", coopObserver.toString());
    coopObserver.update(cS5800);
    assertEquals("hours=12, goodStanding=3.889", coopObserver.toString());
  }

  /**
   * Test method for {@link observer.GradeObserver#update(observer.GradeRecord)}.
   */
  @Test
  public void testUpdateGoodStanding() {
    goodStandingObserver.update(cS5004);
    assertEquals("4.0", goodStandingObserver.toString());
    goodStandingObserver.update(cS5010);
    assertEquals("4.0", goodStandingObserver.toString());
    goodStandingObserver.update(cS5800);
    assertEquals("3.889", goodStandingObserver.toString());
  }

  /**
   * Test method for {@link observer.GradeObserver#update(observer.GradeRecord)}.
   */
  @Test
  public void testUpdateGraduationEligible() {
    graduationEligible.update(cS5004);
    assertEquals("4.0", graduationEligible.toString());
    graduationEligible.update(cS5010);
    assertEquals("4.0", graduationEligible.toString());
    graduationEligible.update(cS5800);
    assertEquals("3.889", graduationEligible.toString());
  }

  /**
   * Test method for {@link observer.GradeObserver#update(observer.GradeRecord)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUpdateRecordNull() {
    coopObserver.update(null);
  }

  /**
   * Test method for {@link observer.GradeObserver#isSatisfied()}.
   */
  @Test
  public void testIsSatisfiedTrueCoop() {
    coopObserver.update(cS5004);
    coopObserver.update(cS5010);
    coopObserver.update(cS5600);
    coopObserver.update(cS5500);
    assertTrue(coopObserver.isSatisfied());
  }

  /**
   * Test method for {@link observer.GradeObserver#isSatisfied()}.
   */
  @Test
  public void testIsSatisfiedFalseCoopCredits() {
    coopObserver.update(cS5004);
    coopObserver.update(cS5010);
    coopObserver.update(cS5600);
    assertFalse(coopObserver.isSatisfied());
  }

  /**
   * Test method for {@link observer.GradeObserver#isSatisfied()}.
   */
  @Test
  public void testIsSatisfiedFalseCoopLessGrade() {
    cS5004 = new GradeRecord("CS5004", Grade.F, 4);
    cS5600 = new GradeRecord("CS5600", Grade.F, 4);
    coopObserver.update(cS5004);
    coopObserver.update(cS5010);
    coopObserver.update(cS5600);
    coopObserver.update(cS5500);
    assertFalse(coopObserver.isSatisfied());
  }

  /**
   * Test method for {@link observer.GradeObserver#isSatisfied()}.
   */
  @Test
  public void testIsSatisfiedTrueGoodStanding() {
    goodStandingObserver.update(cS5004);
    goodStandingObserver.update(cS5010);
    goodStandingObserver.update(cS5600);
    goodStandingObserver.update(cS5600);
    assertTrue(goodStandingObserver.isSatisfied());
  }

  /**
   * Test method for {@link observer.GradeObserver#isSatisfied()}.
   */
  @Test
  public void testIsSatisfiedFalseGoodStandingLessGrade() {
    cS5004 = new GradeRecord("CS5004", Grade.F, 4);
    cS5600 = new GradeRecord("CS5600", Grade.B_MINUS, 4);
    goodStandingObserver.update(cS5004);
    goodStandingObserver.update(cS5010);
    goodStandingObserver.update(cS5600);
    assertEquals("2.2223333333333333", goodStandingObserver.toString());
    assertFalse(goodStandingObserver.isSatisfied());
  }

  /**
   * Test method for {@link observer.GradeObserver#isSatisfied()}.
   */
  @Test
  public void testIsSatisfiedTrueGraduationEligible() {
    graduationEligible.update(cS5010);
    graduationEligible.update(cS5800);
    graduationEligible.update(cS5500);
    assertTrue(graduationEligible.isSatisfied());
  }

  /**
   * Test method for {@link observer.GradeObserver#isSatisfied()}.
   */
  @Test
  public void testIsSatisfiedFalseNoCoreCourses() {
    graduationEligible.update(cS5010);
    graduationEligible.update(cS5600);
    graduationEligible.update(cS5500);
    assertFalse(graduationEligible.isSatisfied());
  }

  /**
   * Test method for {@link observer.GradeObserver#isSatisfied()}.
   */
  @Test
  public void testIsSatisfiedFalseGraduationEligibleLessGrade() {
    cS5004 = new GradeRecord("CS5004", Grade.F, 4);
    cS5600 = new GradeRecord("CS5600", Grade.F, 4);
    graduationEligible.update(cS5004);
    graduationEligible.update(cS5800);
    graduationEligible.update(cS5600);
    assertFalse(graduationEligible.isSatisfied());
  }

  /**
   * Test method for {@link observer.GradeObserver#isSatisfied()}.
   */
  @Test
  public void testIsSatisfiedTrueCoopEligibleIsSatisfiedFalseGraduationEligible() {
    coopObserver.update(cS5004);
    coopObserver.update(cS5010);
    coopObserver.update(cS5600);
    coopObserver.update(cS5500);
    graduationEligible.update(cS5004);
    graduationEligible.update(cS5010);
    graduationEligible.update(cS5600);
    graduationEligible.update(cS5500);
    assertTrue(coopObserver.isSatisfied());
    assertFalse(graduationEligible.isSatisfied());
  }

  /**
   * Test method for {@link GradeRecord#toString()}.
   */
  @Test
  public void testGradeRecordToString() {
    assertEquals("GradeRecord[course=CS5004, grade=A, credits=4]", cS5004.toString());
    assertEquals("GradeRecord[course=CS5010, grade=A, credits=4]", cS5010.toString());
    assertEquals("GradeRecord[course=CS5500, grade=A, credits=4]", cS5500.toString());
    assertEquals("GradeRecord[course=CS5600, grade=A_MINUS, credits=4]", cS5600.toString());
    assertEquals("GradeRecord[course=CS5800, grade=A_MINUS, credits=4]", cS5800.toString());
  }

  /**
   * Test method for {@link GradeRecord#equals(Object)}.
   */
  @Test
  public void testGradeRecordEqualsTrue() {
    GradeRecord cs5010 = new GradeRecord("CS5010", Grade.A, 4);
    assertTrue(cS5010.equals(cs5010));
  }

  /**
   * Test method for {@link GradeRecord#equals(Object)}.
   */
  @Test
  public void testGradeRecordEqualsFalse() {
    assertFalse(cS5010.equals(cS5004));
  }

  /**
   * Test method for {@link GradeRecord#equals(Object)}.
   */
  @Test
  public void testGradeRecordEqualsNull() {
    GradeRecord cs5000 = null;
    assertFalse(cS5010.equals(cs5000));
  }

  /**
   * Test method for {@link GradeRecord#hashCode()}.
   */
  @Test
  public void testGradeRecordHashCode() {
    GradeRecord cs5010temp = new GradeRecord("CS5010", Grade.A, 4);
    assertEquals(cs5010temp.hashCode(), cS5010.hashCode());
  }

  /**
   * Test method for {@link GradeRecord#GradeRecord(String, Grade, int)}.
   */
  @Test
  public void testGradeRecord() {
    GradeRecord cS5010 = new GradeRecord("CS5010", Grade.A, 4);
    assertEquals("GradeRecord[course=CS5010, grade=A, credits=4]", cS5010.toString());
  }

  /**
   * Test method for {@link GradeRecord#GradeRecord(String, Grade, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGradeRecordInvalidString() {
    new GradeRecord("", Grade.A, 4);
  }

  /**
   * Test method for {@link GradeRecord#GradeRecord(String, Grade, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGradeRecordInvalidGrade() {
    new GradeRecord("cs5010", null, 4);
  }

  /**
   * Test method for {@link GradeRecord#GradeRecord(String, Grade, int)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGradeRecordInvalidCredits() {
    new GradeRecord("cs5010", Grade.A, 0);
  }

}