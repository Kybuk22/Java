/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {

  private List<Client> clients = new ArrayList<>();

  private ClientService clientService;

  private TransferService transferService;

  public Bank(ClientService clientService, TransferService transferService) {
    this.clientService = clientService;
    this.transferService = transferService;
  }


  public List<Client> getClients() {
    return clients;
  }

  public Client addNewClient(String firstName, String lastName, String address) {
    Client client = this.clientService.createClient(firstName, lastName, address);

    this.clients.add(client);

    return client;
  }

  public Client findClientById(Integer cid) throws BankException {
    return this.clients.stream().filter(client -> Objects.equals(client.getCid(), cid)).findFirst().orElse(null);
  }

  public Client setupNewAccount(Client client, String currency) {
    return this.clientService.createNewAccount(client, currency);
  }

  public void transferMoney(Client from, Client to, BigDecimal amount) throws InsufficientFundsException {
    this.transferService.transfer(from.getAccount(), to.getAccount(), amount);
  }

  public void transferMoney(Integer fromCid, Integer toCid, BigDecimal amount) throws BankException {
    Client from = this.findClientById(fromCid);
    Client to = this.findClientById(toCid);
    this.transferService.transfer(from.getAccount(), to.getAccount(), amount);
  }

}
