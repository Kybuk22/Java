/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java;

public class Car implements Comparable<Car> {

  private Integer speed;

  public Car(Integer speed) {
    this.speed = speed;
  }

  public Integer getSpeed() {
    return speed;
  }

  @Override
  public String toString() {
    return "Car{" +
        "speed=" + speed +
        '}';
  }

  @Override
  public int compareTo(Car car) {
    return this.speed - car.speed;
  }



  /*
   * Typów generycznych można również używać w metodach, w takim wypadku,
   * typ generyczny należy określić przed typem zwracanym w < >, a identyfikatora typu używamy wtedy do określania typu parametru
   *
   */
  public <U extends Number> boolean fasterThan(U number) {
    return this.speed > number.doubleValue();
  }
}
