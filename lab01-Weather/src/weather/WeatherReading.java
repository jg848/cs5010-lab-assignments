package weather;

/**
 * Defined and implemented WeatherReading class to represent a single reading of
 * a weather reading in a Stevenson Station.
 * 
 * @author Jaswin Gumpella
 *
 */
public class WeatherReading {

  // Air temperature in Celcius.
  private int temperature;
  // Dew Point temperature in Celcius.
  private int dewPoint;
  // Wind speed in miles per hour.
  private int windSpeed;
  // Total rain received in millimeters.
  private int totalRain;
  // Relative Humidity in percent.
  private int relativeHumidity;
  // Heat index.
  private int heatIndex;
  // Wind chill.
  private int windChill;

  // Constant values used in the formula to calculate Heat Index.
  private static final double C1 = -8.78469475556;
  private static final double C2 = 1.61139411;
  private static final double C3 = 2.33854883889;
  private static final double C4 = -0.14611605;
  private static final double C5 = -0.012308094;
  private static final double C6 = -0.0164248277778;
  private static final double C7 = 0.002211732;
  private static final double C8 = 0.00072546;
  private static final double C9 = -0.000003582;

  // Constant values used in the formula to calculate Wind Chill.
  private static final double WC1 = 35.74;
  private static final double WC2 = 0.6215;
  private static final double WC3 = 35.75;
  private static final double WC4 = 0.4275;

  /**
   * Constructor for WeatherReading class which takes 4 parameters and calculates
   * relative humidity, heat index and wind chill.
   */
  public WeatherReading(int airTemp, int dewPointTemp, int wSpeed, int rainReceived)
      throws IllegalArgumentException {
    this.temperature = airTemp;
    // Value of dew point temperature cannot be greater than air temperature.
    if (dewPointTemp > airTemp) {
      throw new IllegalArgumentException(
          "Dew Point Temperature cannot be greater than Air Temperature");
    } else {
      this.dewPoint = dewPointTemp;
    }
    // Value of wind speed has to be non-negative.
    if (wSpeed < 0) {
      throw new IllegalArgumentException("Wind Speed cannot be a negative value.");
    } else {
      this.windSpeed = wSpeed;
    }
    // Value of rain received has to be non-negative.
    if (rainReceived < 0) {
      throw new IllegalArgumentException("Total Rain Received cannot be a negative value.");
    } else {
      this.totalRain = rainReceived;
    }
    // Calculating relative humidity.
    this.relativeHumidity = (int) calculateRelativeHumidity(this.temperature, this.dewPoint);
    // Calculating heat index.
    this.heatIndex = (int) calculateHeatIndex(this.temperature, this.relativeHumidity);
    // Calculating wind chill.
    this.windChill = (int) calculateWindChill(this.temperature, this.windSpeed);
  }

  /**
   * used to get input reading in the form of string.
   * 
   * @return
   */
  public String toString() {
    return "Reading: T = " + getTemperature() + ", D = " + getDewPoint() + ", v = " + getWindSpeed()
        + ", rain = " + getTotalRain();
  }

  /**
   * used to get the air temperature.
   * 
   * @return the temperature
   */
  public int getTemperature() {
    return temperature;
  }

  /**
   * used to get the dew point temperature.
   * 
   * @return the dewPoint
   */
  public int getDewPoint() {
    return dewPoint;
  }

  /**
   * used to get the wind speed.
   * 
   * @return the windSpeed
   */
  public int getWindSpeed() {
    return windSpeed;
  }

  /**
   * used to get the total rain received.
   * 
   * @return the totalRain
   */
  public int getTotalRain() {
    return totalRain;
  }

  /**
   * used to get the relative humidity.
   * 
   * @return the relativeHumidity
   */
  public int getRelativeHumidity() {
    return relativeHumidity;
  }

  /**
   * used to get the heat index.
   * 
   * @return the heatIndex
   */
  public int getHeatIndex() {
    return heatIndex;
  }

  /**
   * used to get the wind chill.
   * 
   * @return the windChill
   */
  public int getWindChill() {
    return windChill;
  }

  /**
   * Method to calculate the relative humidity by taking as input the air
   * temperature and dew point temperature. Deriving the relative humidity from
   * the formula -- D = T - (100-R)/5 --> R = 5D - 5T + 100
   * 
   * @param temp which is the air temperature
   * @param dew  which is the dew point temperature
   * @return
   */
  private double calculateRelativeHumidity(int temp, int dew) {
    double result = 0;
    result = (5 * dew) - (5 * temp) + (double) 100;
    if (result < 0) {
      result = 0;
    }
    return result;
  }

  /**
   * Method to calculate the heat index by taking the air temperature and relative
   * humidity as input. Formula to calculate heat index -- HI = c1 + c2T + c3R +
   * c4TR + c5(T^2) + c6(R^2) + c7(T^2)R + c8T(R^2) + c9(T^2)(R^2).
   * 
   * @param temp        is the air temperature.
   * @param relHumidity is the relative humidity.
   * @return
   */
  private double calculateHeatIndex(int temp, int relHumidity) {
    double result = 0;
    result = C1 + (C2 * temp) + (C3 * relHumidity) + (C4 * temp * relHumidity)
        + (C5 * Math.pow(temp, 2)) + (C6 * Math.pow(relHumidity, 2))
        + (C7 * Math.pow(temp, 2) * relHumidity) + (C8 * temp * Math.pow(relHumidity, 2))
        + (C9 * Math.pow(temp, 2) * Math.pow(relHumidity, 2));
    return result;
  }

  /**
   * Method to calculate the wind chill taking as input the air temperature which
   * will be converted from celcius to farenheit and wind speed. Formula to
   * calculate wind chill -- WC = 35.74 + 0.6215T - 35.75(v^0.16) +
   * 0.4275T(v^0.16)
   * 
   * @param temp is the air temperature.
   * @param vel  is the wind speed.
   * @return
   */
  private double calculateWindChill(int temp, int vel) {
    double result = 0;
    int tempInFahrenheit = (int) ((temp * ((double) 9 / 5)) + (double) 32);
    result = WC1 + (WC2 * tempInFahrenheit) - (WC3 * Math.pow(vel, 0.16))
        + (WC4 * tempInFahrenheit * Math.pow(vel, 0.16));
    return result;
  }

}
