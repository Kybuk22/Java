package edu.technischools.java.parcel;

import java.math.BigDecimal;

public class Parcel  {
  private double weight;
  private BigDecimal value;
  private String description;
  
  //TODO 2 2. Dodać do klasy `Parcel` gettery oraz konstruktor ze wszystkimi polami. [1] 


  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Parcel(double weight, BigDecimal value, String description)  {
    this.weight = weight;
    this.value = value;
    this.description = description;
  }
  
}
