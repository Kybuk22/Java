/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bank.client;

import edu.technischools.java.bank.account.Account;

public class Client {

  private Integer cid;

  private String firstName;

  private String lastName;

  private Account account;

  private String pesel;

  public Client(Integer cid, String firstName, String lastName, String pesel) {
    this.cid = cid;
    this.firstName = firstName;
    this.lastName = lastName;
    this.pesel = pesel;
  }

  public Integer getCid() {
    return cid;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public String getPesel() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel = pesel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Client client)) {
      return false;
    }

    return cid.equals(client.cid);
  }

  @Override
  public int hashCode() {
    return cid.hashCode();
  }
}
