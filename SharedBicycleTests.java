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
    //I want to test that speeding up twice works, but I can't
    //because the maximum speed is 2, and the speed is only 1,
    //and speed is a private field
  }
}
