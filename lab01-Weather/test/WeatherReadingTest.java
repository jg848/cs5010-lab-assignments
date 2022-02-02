import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import weather.WeatherReading;

/**
 * The WeatherReadingTest class is implemented to test the WeatherReading class.
 * 
 * @author Jaswin Gumpella
 *
 */
public class WeatherReadingTest {

  WeatherReading reading;
  WeatherReading readingRH;

  /**
   * initializing the WeatherReading class with required parameters.
   * 
   * @throws java.lang.IllegalArgumentException for WeatherReading class when
   *                                            incorrect arguments are passed.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    reading = new WeatherReading(25, 20, 10, 12);
    readingRH = new WeatherReading(50, 10, 10, 10);
  }

  /**
   * Test method for {@link WeatherReading#WeatherReading(int, int, int, int)} to
   * test IllegalArgumentException with incorrect Dew Point temperature.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testWeatherReadingExceptionForDewPoint() {
    new WeatherReading(25, 26, 10, 12);
  }

  /**
   * Test method for {@link WeatherReading#WeatherReading(int, int, int, int)} to
   * test IllegalArgumentException with incorrect Wind Speed.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testWeatherReadingExceptionForWindSpeed() {
    new WeatherReading(25, 20, -10, 12);
  }

  /**
   * Test method for {@link WeatherReading#WeatherReading(int, int, int, int)} to
   * test IllegalArgumentException with incorrect Total Rain.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testWeatherReadingExceptionForTotalRain() {
    new WeatherReading(25, 20, 10, -12);
  }

  /**
   * Test method for {@link WeatherReading#WeatherReading(int, int, int, int)} to
   * test successful case of initializing WeatherReading.
   */
  @Test
  public final void testWeatherReading() {
    WeatherReading reading1 = new WeatherReading(25, 20, 10, 12);
    assertEquals(reading.getTemperature(), reading1.getTemperature());
    assertEquals(reading.getDewPoint(), reading1.getDewPoint());
    assertEquals(reading.getWindSpeed(), reading1.getWindSpeed());
    assertEquals(reading.getTotalRain(), reading1.getTotalRain());
  }

  /**
   * Test method for {@link WeatherReading#WeatherReading(int, int, int, int)} to
   * test the case where the calculated RelativeHumidity is negative and is set to
   * 0.
   */
  @Test
  public final void testWeatherReadingForNegativeRelativeHumidity() {
    WeatherReading reading1 = new WeatherReading(50, 10, 10, 10);
    assertEquals(readingRH.getTemperature(), reading1.getTemperature());
    assertEquals(readingRH.getDewPoint(), reading1.getDewPoint());
    assertEquals(readingRH.getWindSpeed(), reading1.getWindSpeed());
    assertEquals(readingRH.getTotalRain(), reading1.getTotalRain());
  }

  /**
   * Test method for {@link WeatherReading#toString()}.
   */
  @Test
  public final void testToString() {
    String expected = "Reading: T = 25, D = 20, v = 10, rain = 12";
    assertEquals(expected, reading.toString());
  }

  /**
   * Test method for {@link WeatherReading#getTemperature()}.
   */
  @Test
  public final void testGetTemperature() {
    int expected = 25;
    assertEquals(expected, reading.getTemperature());
  }

  /**
   * Test method for {@link WeatherReading#getDewPoint()}.
   */
  @Test
  public final void testGetDewPoint() {
    int expected = 20;
    assertEquals(expected, reading.getDewPoint());
  }

  /**
   * Test method for {@link WeatherReading#getWindSpeed()}.
   */
  @Test
  public final void testGetWindSpeed() {
    int expected = 10;
    assertEquals(expected, reading.getWindSpeed());
  }

  /**
   * Test method for {@link WeatherReading#getTotalRain()}.
   */
  @Test
  public final void testGetTotalRain() {
    int expected = 12;
    assertEquals(expected, reading.getTotalRain());
  }

  /**
   * Test method for {@link WeatherReading#getRelativeHumidity()}.
   */
  @Test
  public final void testGetRelativeHumidity() {
    int expected = 75;
    assertEquals(expected, reading.getRelativeHumidity());
  }

  /**
   * Test method for {@link WeatherReading#getHeatIndex()}.
   */
  @Test
  public final void testGetHeatIndex() {
    int expected = 25;
    assertEquals(expected, reading.getHeatIndex());
  }

  /**
   * Test method for {@link WeatherReading#getWindChill()}.
   */
  @Test
  public final void testGetWindChill() {
    int expected = 79;
    assertEquals(expected, reading.getWindChill());
  }

}
