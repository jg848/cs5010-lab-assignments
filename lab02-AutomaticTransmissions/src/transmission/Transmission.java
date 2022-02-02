package transmission;

/**
 * Interface which is used to build a class that represents a single car
 * transmission.
 * 
 * @author Jaswin Gumpella
 *
 **/
public interface Transmission {

  /**
   * Method used to increase current speed by 2 and change gear if required.
   * 
   * @return Transmission object.
   */
  public Transmission increaseSpeed();

  /**
   * Method used to decrease current speed by 2 and change gear if required.
   * 
   * @return Transmission object.
   * @throws IllegalStateException if speed becomes invalid.
   */
  public Transmission decreaseSpeed();

  /**
   * Method used to get the current speed.
   * 
   * @return integer storing current speed.
   */
  public int getSpeed();

  /**
   * Method used to get the current gear.
   * 
   * @return integer storing current gear.
   */
  public int getGear();
}
