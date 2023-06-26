package edu.technischools.java.bank;

import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {
  private String transID;
  private Account from;
  private Account to;
  private BigDecimal amount;

  public Transaction() {
    this.transID = UUID.randomUUID().toString();
  }

  public Transaction(Account from, Account to, BigDecimal amount) {
    this();
    this.from = from;
    this.to = to;
    this.amount = amount;
  }

  public Account getFrom() {
    return from;
  }
  
  public void setFrom(Account from) {
    this.from = from;
  }
  
  public Account getTo() {
    return to;
  }
  
  public void setTo(Account to) {
    this.to = to;
  }
  
  public BigDecimal getAmount() {
    return amount;
  }
  
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return from.getNo() + "->" + to.getNo() +" : " + amount + "  " +from.getCurrency().getSymbol();
  }

  
}
