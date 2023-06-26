package edu.technischools.java.bank;

public class InsufficientFundsException extends BankException {

  public InsufficientFundsException() {
  }

  public InsufficientFundsException(String message) {
    super(message);
  }

  
}