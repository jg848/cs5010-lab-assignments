import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import transmission.AutomaticTransmission;
import transmission.Transmission;

/**
 * Test class for AutomaticTransmission. Used to test the transmission of a car
 * by checking the changing current speed and current gear with the expected
 * values.
 * 
 * @author Jaswin Gumpella
 *
 */
public class AutomaticTransmissionTest {

  Transmission transmission;

  /**
   * Method used to setup the transmission object of a car and initializing the
   * AutomaticTransmission class and setting a current speed.
   * 
   * @throws IllegalArgumentException when invalid arguments are passed.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    transmission = new AutomaticTransmission(4, 8, 12, 18, 30);
    transmission.increaseSpeed().increaseSpeed().increaseSpeed();
  }

  /**
   * Method used to test creating an object of Transmission. Constructor of
   * AutomaticTransmission class is called by passing the required valid
   * arguments.
   */
  @Test
  public final void testAutomaticTransmission() {
    Transmission transmission1 = new AutomaticTransmission(4, 8, 12, 18, 30);
    assertEquals(transmission.getClass(), transmission1.getClass());
  }

  /**
   * Test method for
   * {@link Transmission#AutomaticTransmission(int, int, int, int, int)} to test
   * IllegalArgumentException for the invalid threshold 1 value being passed to
   * the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAutomaticTransmissionInvalidThreshold1() {
    new AutomaticTransmission(-4, 8, 12, 18, 30);
  }

  /**
   * Test method for
   * {@link Transmission#AutomaticTransmission(int, int, int, int, int)} to test
   * IllegalArgumentException for the invalid threshold 2 value being passed to
   * the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAutomaticTransmissionInvalidThreshold2() {
    new AutomaticTransmission(4, -8, 12, 18, 30);
  }

  /**
   * Test method for
   * {@link Transmission#AutomaticTransmission(int, int, int, int, int)} to test
   * IllegalArgumentException for the invalid threshold 3 value being passed to
   * the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAutomaticTransmissionInvalidThreshold3() {
    new AutomaticTransmission(4, 8, -12, 18, 30);
  }

  /**
   * Test method for
   * {@link Transmission#AutomaticTransmission(int, int, int, int, int)} to test
   * IllegalArgumentException for the invalid threshold 4 value being passed to
   * the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAutomaticTransmissionInvalidThreshold4() {
    new AutomaticTransmission(4, 8, 12, -18, 30);
  }

  /**
   * Test method for
   * {@link Transmission#AutomaticTransmission(int, int, int, int, int)} to test
   * IllegalArgumentException for the invalid threshold 5 value being passed to
   * the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAutomaticTransmissionInvalidThreshold5() {
    new AutomaticTransmission(4, 8, 12, 18, -30);
  }

  /**
   * Method used to test increasing the speed of the car.
   */
  @Test
  public final void testIncreaseSpeed() {
    transmission.increaseSpeed();
    assertEquals(transmission.getSpeed(), 8);
  }

  /**
   * Method used to test decreasing the speed of the car.
   */
  @Test
  public final void testDecreaseSpeed() {
    transmission.decreaseSpeed();
    assertEquals(transmission.getSpeed(), 4);
  }

  /**
   * Test method for
   * {@link Transmission#AutomaticTransmission(int, int, int, int, int)} to test
   * IllegalStateException for the invalid threshold 5 value being passed to the
   * constructor.
   */
  @Test(expected = IllegalStateException.class)
  public final void testNegativeDecreaseSpeed() {
    transmission.decreaseSpeed().decreaseSpeed().decreaseSpeed().decreaseSpeed();
  }

  /**
   * Method used to test the current speed of the car.
   */
  @Test
  public final void testGetSpeed() {
    assertEquals(transmission.getSpeed(), 6);
  }

  /**
   * Method used to test the current gear of the car.
   */
  @Test
  public final void testGetGear() {
    assertEquals(transmission.getGear(), 2);
  }

  /**
   * Method used to test gear 1 of the car.
   */
  @Test
  public final void testGear1() {
    transmission.decreaseSpeed().decreaseSpeed();
    assertEquals(transmission.getGear(), 1);
  }

  /**
   * Method used to test gear 2 of the car.
   */
  @Test
  public final void testGear2() {
    transmission.decreaseSpeed();
    assertEquals(transmission.getGear(), 2);
  }

  /**
   * Method used to test gear 3 of the car.
   */
  @Test
  public final void testGear3() {
    transmission.increaseSpeed();
    assertEquals(transmission.getGear(), 3);
  }

  /**
   * Method used to test gear 4 of the car.
   */
  @Test
  public final void testGear4() {
    transmission.increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed();
    assertEquals(transmission.getGear(), 4);
  }

  /**
   * Method used to test gear 5 of the car.
   */
  @Test
  public final void testGear5() {
    transmission.increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed()
        .increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed()
        .increaseSpeed();
    assertEquals(transmission.getGear(), 5);
  }

  /**
   * Method used to test gear 6 of the car.
   */
  @Test
  public final void testGear6() {
    transmission.increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed()
        .increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed()
        .increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed().increaseSpeed()
        .increaseSpeed();
    assertEquals(transmission.getGear(), 6);
  }

  /**
   * Method used to test the overridden toString method.
   */
  @Test
  public final void testToString() {
    assertEquals(transmission.toString(), "Transmission (speed = 6, gear = 2)");
  }

}
