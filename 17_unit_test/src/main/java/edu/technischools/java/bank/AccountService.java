/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
// @Ignore

public class AccountService {

  public Account setupAccount(Account.Currency currency, String name) {

    Account account = new Account();
    account.setCurrency(currency);
    account.setName(name);
    account.setNo(UUID.randomUUID().toString());

    return account;
  }
  public List<Transaction> getTransactionsFrom(Account account) {
    List<Transaction> transactionsFrom = new ArrayList<>();
    for (Transaction transaction : account.getTransactions()) {
        if (transaction.getFrom().equals(account)) {
            transactionsFrom.add(transaction);
        }
    }
    return transactionsFrom;
}
}
