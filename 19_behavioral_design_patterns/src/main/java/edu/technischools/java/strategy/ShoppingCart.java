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
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

  List<Item> items;

  public ShoppingCart() {
    this.items = new ArrayList<Item>();
  }

  public void addItem(Item item) {
    this.items.add(item);
  }

  public BigDecimal calculateTotal() {
    BigDecimal sum = BigDecimal.ZERO;
    for (Item item : items) {
      sum = sum.add(item.getPrice());
    }
    return sum;
  }

  public void pay(Payment paymentMethod) {
    BigDecimal amount = calculateTotal();
    paymentMethod.pay(amount);
  }




}
