package edu.technischools.java.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

  private String no;
  private String name;
  private Currency currency;
  private BigDecimal balance = BigDecimal.ZERO;
  private BigDecimal fee = BigDecimal.ZERO;
  private List<Transaction> transactions;


  public Account() {
    this.transactions = new ArrayList<>();
    currency = Currency.PLN;
  }

  public String getNo() {
    return no;
  }

  public void setNo(String no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public BigDecimal getFee() {
    return fee;
  }

  protected void setFee(BigDecimal fee) {
    this.fee = fee;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  public void addTransaction(Transaction transaction) {
    this.transactions.add(transaction);
  }

  @Override
  public String toString() {
    return "Account [no=" + no + ", balance=" + balance + "]";
  }

  public enum Currency {
    USD("$"),
    PLN("zł"),
    EUR(""),
    GBP("");

    Currency(String symbol) {
      this.symbol = symbol;
    }

    public String getSymbol() {
      return this.symbol;
    }

    private String symbol;

  }

}
