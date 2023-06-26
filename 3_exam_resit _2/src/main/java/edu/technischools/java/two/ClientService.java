/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.two;

import edu.technischools.java.two.exception.ItemAlreadyManagedByDatabaseException;
import edu.technischools.java.two.exception.ItemDoesNotExistException;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

  private Database database;

  public ClientService(Database database) {
    this.database = database;
  }

  public Client createClient(String firstName, String lastName, Integer age) throws ItemAlreadyManagedByDatabaseException {
    Client client = new Client();

    client.setFirstName(firstName);
    client.setLastName(lastName);
    client.setAge(age);

    return this.database.create(client);
  }

  public List<Client> getAllClients() {
    return this.database.getAll();
  }

  public List<Client> getClientByAge(Integer age) {
    List<Client> clients = this.getAllClients();
    List<Client> filtered = new ArrayList<>();

    for (Client product : clients) {
      if (product.getAge().compareTo(age) == 0) {
        filtered.add(product);
      }
    }

    return filtered;

  }

  public Client updateClient(Client product) throws ItemDoesNotExistException {
    return this.database.update(product);
  }

}
