import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * In our simulation, there's only a single bicycle, so we'll make it
 * a singleton!
 *
 * (note: bad idea!)
 */
public class SharedBicycleTests {
  @Test
  public void testRider() {
    SharedBicycle b = SharedBicycle.singletonValue();
    b.mount("steve");
    assertEquals("steve", b.getCurrentRider());
    b.accelerate();
    assertEquals(1, b.getCurrentSpeed());
  }

  @Test
  public void testSpeedUp() {
    SharedBicycle b = SharedBicycle.singletonValue();
    b.mount("steve");
    assertEquals(0, b.getCurrentSpeed());
    b.accelerate();
    assertEquals(1, b.getCurrentSpeed());
    b.accelerate();
    assertEquals(2, b.getCurrentSpeed());
    b.accelerate(); //we've hit max speed, should not accelerate
    assertEquals(2, b.getCurrentSpeed());
  }
}
