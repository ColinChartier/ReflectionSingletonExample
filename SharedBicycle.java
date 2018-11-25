/**
 * In our simulation, there's only a single bicycle, so we'll make it
 * a singleton!
 *
 * (note: bad idea!)
 */
public class SharedBicycle {
  private static SharedBicycle singleton;

  private int currentSpeed;
  private String currentRider;

  private SharedBicycle() {
    currentSpeed = 0;
    currentRider = "<n/a>";
  }

  public int getCurrentSpeed() {
    return currentSpeed;
  }

  public String getCurrentRider() {
    return currentRider;
  }

  public void mount(String rider) {
    if(!"<n/a>".equals(singleton.currentRider)) {
      throw new IllegalStateException("Bicycle is already being ridden!");
    }
    currentRider = rider;
    currentSpeed = 0;
  }

  public void accelerate() {
    if("<n/a>".equals(singleton.currentRider)) {
      throw new IllegalStateException("Bicycle needs to be ridden!");
    }
    if(currentSpeed == 2) {
      return; //2 is the max speed, speed shall not be greater than 2
    }
    currentSpeed += 1;
  }

  public static SharedBicycle singletonValue() {
    if(singleton == null) {
      singleton = new SharedBicycle();
    }
    return singleton;
  }
}
