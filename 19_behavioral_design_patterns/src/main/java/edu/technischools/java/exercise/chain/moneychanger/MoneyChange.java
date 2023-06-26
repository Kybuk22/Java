/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.exercise.chain.moneychanger;

import java.util.HashMap;
import java.util.Map;

public class MoneyChange {
  private Integer amount;

  private Map<Integer, Integer> change;
  //   100   ,   1  - > nominał , ilość
  //   50    ,   1  - >

  public MoneyChange(Integer amount) {
    this.amount = amount;
    this.change = new HashMap<>();
  }

  public Integer getAmount() {
    return amount;
  }

  public Map<Integer, Integer> getChange() {
    return change;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }
}
