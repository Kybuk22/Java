package edu.technischools.java.bank;

import java.math.BigDecimal;

public class TransferService {

  private static TransferService instance;

  private TransferService() {
  }

  public static TransferService getInstance() {
    if (instance == null) {
      instance = new TransferService();
    }

    return instance;
  }

  public void transfer(Account from, Account to, BigDecimal amount) throws InsufficientFundsException {
    if (from.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
      throw new InsufficientFundsException("Not enough money on " + from.getNo() + " account");
    }

    from.setBalance(from.getBalance().subtract(amount));
    from.addTransaction(new Transaction(from, to, amount.negate()));

    to.setBalance(to.getBalance().add(amount));
    to.addTransaction(new Transaction(from, to, amount));;
  }
  
  public void deposit(Account to, BigDecimal amount) {
    to.setBalance(to.getBalance().add(amount));
    to.addTransaction(new Transaction(null, to, amount));
  }
  
  public void withdrawn(Account from, BigDecimal amount) throws InsufficientFundsException {
    if (from.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
      throw new InsufficientFundsException("Not enough money on " + from.getNo() + " account");
    }

    from.setBalance(from.getBalance().subtract(amount));
    from.addTransaction(new Transaction(from, null, amount.negate()));
  }

  
}
