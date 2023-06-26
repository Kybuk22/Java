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

public class CashPayment implements Payment {

  public CashPayment() {
  }

  @Override
  public void pay(BigDecimal amount) {
    System.out.println("Paid " + amount + " with cash");
  }
}
