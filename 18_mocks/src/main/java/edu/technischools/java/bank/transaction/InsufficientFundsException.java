package edu.technischools.java.bank.transaction;

import edu.technischools.java.bank.BankException;

public class InsufficientFundsException extends BankException {

  public InsufficientFundsException() {
  }

  public InsufficientFundsException(String message) {
    super(message);
  }

  
}
