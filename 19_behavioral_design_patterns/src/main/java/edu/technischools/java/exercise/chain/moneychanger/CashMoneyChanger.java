/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.exercise.chain.moneychanger;

public class CashMoneyChanger implements MoneyChanger {

  private Integer amount;

  public CashMoneyChanger(Integer amount) {
    this.amount = amount;
  }

  @Override
  public MoneyChange change(MoneyChange money, MoneyChangerChain chain) {
    int noOfBills = money.getAmount() / amount;
    int rest = money.getAmount() % amount;

    money.getChange().put(amount, noOfBills);
    money.setAmount(rest);


    return chain.doChange(money);
  }
}
