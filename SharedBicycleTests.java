import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * In our simulation, there's only a single bicycle, so we'll make it
 * a singleton!
 *
 * (note: bad idea!)
 */
public class SharedBicycleTests {
  private void resetBicycleSingleton() {
    try {
      Field singletonField = SharedBicycle.class
          .getDeclaredField("singleton");
      singletonField.setAccessible(true);
      singletonField.set(null, null);
    } catch(ReflectiveOperationException ex) {
      throw new RuntimeException(ex);
    }
  }

  @Test
  public void testRider() {
    resetBicycleSingleton();
    SharedBicycle b = SharedBicycle.singletonValue();
    b.mount("steve");
    assertEquals("steve", b.getCurrentRider());
    b.accelerate();
    assertEquals(1, b.getCurrentSpeed());
  }

  @Test
  public void testSpeedUp() {
    resetBicycleSingleton();
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
