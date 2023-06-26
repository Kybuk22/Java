/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.strategy;

import java.math.BigDecimal;

public class Item {

  private BigDecimal price;
  private String name;

  public Item(BigDecimal price, String name) {
    this.price = price;
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }
}
