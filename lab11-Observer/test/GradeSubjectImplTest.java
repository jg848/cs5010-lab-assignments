import static org.junit.Assert.assertEquals;

import observer.CoopEligible;
import observer.GoodStanding;
import observer.Grade;
import observer.GradeObserver;
import observer.GradeRecord;
import observer.GradeSubject;
import observer.GradeSubjectImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link GradeSubjectImpl}.
 *
 * @author Jaswin Gumpella
 *
 */
public class GradeSubjectImplTest {

  private GradeSubject subject;
  private GradeRecord cS5010;
  private GradeRecord cS5800;
  private GradeObserver coopObserver;
  private GradeObserver goodStandingObserver;
  private GradeObserver graduationEligibleObserver;

  /**
   * Method to setup the test class.
   */
  @Before
  public void setUp() {
    subject = new GradeSubjectImpl();
    cS5010 = new GradeRecord("CS5010", Grade.A, 4);
    cS5800 = new GradeRecord("CS5800", Grade.A_MINUS, 4);
    coopObserver = new CoopEligible();
    goodStandingObserver = new GoodStanding();
    graduationEligibleObserver = new GoodStanding();
  }

  /**
   * Test method for {@link observer.GradeSubjectImpl#GradeSubjectImpl()}.
   */
  @Test
  public final void testGradeSubjectImpl() {
    subject.attach(coopObserver);
    assertEquals("[hours=0, goodStanding=0.0]", subject.toString());
  }

  /**
   * Test method for
   * {@link observer.GradeSubjectImpl#attach(observer.GradeObserver)}.
   */
  @Test
  public void testAttach() {
    subject.attach(coopObserver);
    subject.notify(cS5010);
    assertEquals("[hours=4, goodStanding=4.0]", subject.toString());
    subject.attach(graduationEligibleObserver);
    subject.attach(goodStandingObserver);
    subject.notify(cS5010);
    assertEquals("[hours=4, goodStanding=4.0, 4.0, 4.0]", subject.toString());
  }

  /**
   * Test method for
   * {@link observer.GradeSubjectImpl#attach(observer.GradeObserver)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAttachNull() {
    subject.attach(null);
  }

  /**
   * Test method for
   * {@link observer.GradeSubjectImpl#detach(observer.GradeObserver)}.
   */
  @Test
  public void testDetach() {
    subject.attach(coopObserver);
    subject.attach(graduationEligibleObserver);
    subject.attach(goodStandingObserver);
    subject.notify(cS5010);
    assertEquals("[hours=4, goodStanding=4.0, 4.0, 4.0]", subject.toString());
    subject.detach(graduationEligibleObserver);
    subject.detach(goodStandingObserver);
    subject.notify(cS5010);
    assertEquals("[hours=4, goodStanding=4.0]", subject.toString());
  }

  /**
   * Test method for
   * {@link observer.GradeSubjectImpl#detach(observer.GradeObserver)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDetachNull() {
    subject.detach(null);
  }

  /**
   * Test method for
   * {@link observer.GradeSubjectImpl#notify(observer.GradeRecord)}.
   */
  @Test
  public void testNotify() {
    subject.attach(coopObserver);
    subject.attach(graduationEligibleObserver);
    subject.attach(goodStandingObserver);
    subject.notify(cS5010);
    assertEquals("hours=4, goodStanding=4.0", coopObserver.toString());
    assertEquals("4.0", goodStandingObserver.toString());
    assertEquals("4.0", graduationEligibleObserver.toString());
    subject.notify(cS5800);
    assertEquals("hours=8, goodStanding=3.8335", coopObserver.toString());
    assertEquals("3.8335", goodStandingObserver.toString());
    assertEquals("3.8335", graduationEligibleObserver.toString());
  }

  /**
   * Test method for
   * {@link observer.GradeSubjectImpl#notify(observer.GradeRecord)}.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNotifyNull() {
    subject.notify(null);
  }

  /**
   * Test method for {@link observer.GradeSubjectImpl#toString()}.
   */
  @Test
  public final void testToString() {
    subject.attach(coopObserver);
    assertEquals("[hours=0, goodStanding=0.0]", subject.toString());
  }
}