/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bad;

import java.math.BigDecimal;

public class MoneyTransferService {

  // robi przelew, zwraca -1 jeśli się nie uda i 1 jeśli się uda
  public int transferMoney(Account from, Account to, BigDecimal amount) throws NullPointerException {
    BigDecimal fromBalance = from.getBalance();
    BigDecimal toBalance = to.getBalance();

    if (fromBalance == null || toBalance == null) {
      throw new NullPointerException("Account balance cannot be null");
    }

    if (fromBalance.subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
      return -1;
    }

    from.setBalance(fromBalance.subtract(amount));
    to.setBalance(toBalance.add(amount));

    return 1;
}
}
