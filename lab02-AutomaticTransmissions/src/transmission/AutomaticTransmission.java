package transmission;

/**
 * Implementation class of the Transmission interface. The class represents the
 * automatic transmission of a car. The class is used to automatically change
 * the gear of the car based on the given threshold speeds. There are 6 gears in
 * order (speed to go from 1 to 2 or back, speed to go from 2 to 3 or back,
 * etc..)
 * 
 * @author Jaswin Gumpella
 *
 */
public class AutomaticTransmission implements Transmission {

  private final int threshold1;
  private final int threshold2;
  private final int threshold3;
  private final int threshold4;
  private final int threshold5;
  private int currentSpeed;
  private int currentGear;

  /**
   * Constructor which ensures that the arguments are valid.
   * 
   * @param th1 which is Threshold 1.
   * @param th2 which is Threshold 2.
   * @param th3 which is Threshold 3.
   * @param th4 which is Threshold 4.
   * @param th5 which is Threshold 5.
   * 
   * @throws IllegalArgumentException when invalid values are passed.
   */
  public AutomaticTransmission(int th1, int th2, int th3, int th4, int th5) {

    // Throwing an IllegalArgumentException if the Threshold 1 value is less than or
    // equal to 0.
    if (th1 <= 0) {
      throw new IllegalArgumentException("Threshold 1 cannot be less than or equal to 0.");
    } else {
      this.threshold1 = th1;
    }
    // Throwing an IllegalArgumentException if the Threshold 2 value is less than or
    // equal to Threshold 1.
    if (th2 <= th1) {
      throw new IllegalArgumentException(
          "Threshold 2 cannot be less than or equal to threshold 1.");
    } else {
      this.threshold2 = th2;
    }
    // Throwing an IllegalArgumentException if the Threshold 3 value is less than or
    // equal to Threshold 2.
    if (th3 <= th2) {
      throw new IllegalArgumentException(
          "Threshold 3 cannot be less than or equal to threshold 2.");
    } else {
      this.threshold3 = th3;
    }
    // Throwing an IllegalArgumentException if the Threshold 4 value is less than or
    // equal to Threshold 3.
    if (th4 <= th3) {
      throw new IllegalArgumentException(
          "Threshold 4 cannot be less than or equal to threshold 3.");
    } else {
      this.threshold4 = th4;
    }
    // Throwing an IllegalArgumentException if the Threshold 5 value is less than or
    // equal to Threshold 4.
    if (th5 <= th4) {
      throw new IllegalArgumentException(
          "Threshold 5 cannot be less than or equal to threshold 4.");
    } else {
      this.threshold5 = th5;
    }
  }

  @Override
  public Transmission increaseSpeed() {

    this.currentSpeed += 2;
    changeGear();
    return this;
  }

  @Override
  public Transmission decreaseSpeed() {

    this.currentSpeed -= 2;

    if (this.currentSpeed < 0) {
      this.currentSpeed = 0;
      throw new IllegalStateException("Speed cannot be negative.");
    }
    changeGear();
    return this;
  }

  @Override
  public int getSpeed() {
    return this.currentSpeed;
  }

  @Override
  public int getGear() {
    return this.currentGear;
  }

  /**
   * Method used to change the current gear of the vehicle by checking the speed
   * with the threshold values. Current gear is set to 0 if current speed is 0.
   * Current gear is set to 6 if current speed is greater than threshold 5.
   */
  private void changeGear() {

    // Setting the current gear to 0 if the current speed is 0.
    if (this.currentSpeed == 0) {
      this.currentGear = 0;
    }
    // Setting the current gear to 1 if the current speed is between 0 and threshold
    // 1.
    if (this.currentSpeed > 0 && this.currentSpeed < threshold1) {
      this.currentGear = 1;
    }
    // Setting the current gear to 2 if the current speed is between threshold 1 and
    // threshold 2.
    if (this.currentSpeed >= this.threshold1 && this.currentSpeed < threshold2) {
      this.currentGear = 2;
    }
    // Setting the current gear to 3 if the current speed is between threshold 2 and
    // threshold 3.
    if (this.currentSpeed >= this.threshold2 && this.currentSpeed < threshold3) {
      this.currentGear = 3;
    }
    // Setting the current gear to 4 if the current speed is between threshold 3 and
    // threshold 4.
    if (this.currentSpeed >= this.threshold3 && this.currentSpeed < threshold4) {
      this.currentGear = 4;
    }
    // Setting the current gear to 5 if the current speed is between threshold 4 and
    // threshold 5.
    if (this.currentSpeed >= this.threshold4 && this.currentSpeed < threshold5) {
      this.currentGear = 5;
    }
    // Setting the current gear to 6 if the current speed is greater than threshold
    // 5..
    if (this.currentSpeed >= this.threshold5) {
      this.currentGear = 6;
    }
  }

  @Override
  public String toString() {
    return String.format("Transmission (speed = %d, gear = %d)", this.currentSpeed,
        this.currentGear);
  }
}
