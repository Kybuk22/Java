package edu.technischools.java.bank;

public class BankException extends Exception {

  public BankException() {
  }

  public BankException(String message) {
    super(message);
  }

  public BankException(Throwable cause) {
    super(cause);
  }
  
}
