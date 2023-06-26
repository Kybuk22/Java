package edu.technischools.java.shipment;

import java.lang.reflect.Method;

public class Barcode {

  private TYPE type;
  private String data;
  private int height;
  private int width;


  public TYPE getType() {
    return type;
  }

  public void setType(TYPE type) {
    this.type = type;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public enum TYPE {
    BARCODE,
    QRCODE
  }


  public static Barcode Builder() {
    Barcode build =new Barcode();
    return build;
  }


}
