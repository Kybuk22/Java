/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bank.account;

import java.util.Arrays;
import java.util.function.Predicate;

public class AccountService {

  private AccountNumberGenerator accountNumberGenerator;

  public AccountService(AccountNumberGenerator accountNumberGenerator) {
    this.accountNumberGenerator = accountNumberGenerator;
  }

  public Account setupAccount(Account.Currency currency, String name) {
    if (currency == null) {
      throw new IllegalArgumentException("Currency cannot be null");
    }

    Account account = new Account();
    account.setCurrency(currency);
    account.setName(name);
    account.setNo(accountNumberGenerator.generate());

    return account;
  }


  public Account setupAccount(String currency, String name) {
    if (currency == null) {
      throw new IllegalArgumentException("Currency cannot be null");
    }

    Arrays.stream(Account.Currency.values()).filter(Predicate.isEqual(currency)).findFirst().orElseThrow(IllegalArgumentException::new);

    Account account = new Account();
    account.setCurrency(Account.Currency.valueOf(currency));
    account.setName(name);
    account.setNo(accountNumberGenerator.generate());

    return account;
  }
}
