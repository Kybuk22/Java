package edu.technischools.java.bank.transaction;

import edu.technischools.java.bank.account.Account;

import java.math.BigDecimal;

public class TransferService {


  /**
   *  Transfers money <code>from</code> to <code>to</code> account 
   * 
   * @param from Account from which money will be transfered
   * @param to Account to which money will be transfered
   * @param amount to transfer
   * @throws InsufficientFundsException when there is not enough money on <code>from</code> account
   */
  public void transfer(Account from, Account to, BigDecimal amount) throws InsufficientFundsException { // deklarujemy że nasza metoda rzuca wyjątek, wymusza to użycia bloku
    if (from.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0) {                            // try-catch, ew deklaracji wyjątku w metodzie w któej używamy metody transfer
      throw new InsufficientFundsException("Not enough money on " + from.getNo() + " account");
    }

    from.setBalance(from.getBalance().subtract(amount));
    from.addTransaction(new Transaction(from, to, amount.negate()));

    to.setBalance(to.getBalance().add(amount));
    to.addTransaction(new Transaction(from, to, amount));;
  }
}
