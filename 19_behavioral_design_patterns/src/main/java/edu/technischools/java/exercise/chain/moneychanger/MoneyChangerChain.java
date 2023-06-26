/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.exercise.chain.moneychanger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoneyChangerChain {

  private List<MoneyChanger> moneyChangers;


  public MoneyChangerChain() {
    moneyChangers = new ArrayList<>();
  }

  public void addChanger(MoneyChanger changer) {
    this.moneyChangers.add(changer);
  }

  void addChangers(MoneyChanger... changers) {
    this.moneyChangers.addAll(Arrays.asList(changers));
  }

 public MoneyChange doChange(MoneyChange item) {
    if (this.moneyChangers.size() > 0) {
      MoneyChanger nextFilter = this.moneyChangers.remove(0);

      return nextFilter.change(item, this);
    } else {
      return item;
    }

  }
}
