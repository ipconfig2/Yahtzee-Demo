
//class
import java.util.Random;//So it can randomize stuff

public class Die {
  // Instance Variable
  private int roll = 0;

  public Die() {
    roll();
  }

  // This method rolls a die
  public int roll() {

    Random rand = new Random();// random object
    roll = 1 + rand.nextInt(6);// 1 min 6 max
    return roll;//Returns the desired value
  }

  // This method get a value of a die
  public int getValue() {
    return roll;
  }

}