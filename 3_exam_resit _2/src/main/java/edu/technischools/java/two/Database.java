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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

  private static int SEQUENCE = 0;
  private static final Map<Integer, Client> db = new HashMap<>();

  public Client create(Client client) throws ItemAlreadyManagedByDatabaseException {
    if (client.getId() != null) {
      throw new ItemAlreadyManagedByDatabaseException();
    }

    client.setId(SEQUENCE++);
    db.put(client.getId(), client);

    return client;
  }

  public Client getById(Integer id) throws ItemDoesNotExistException {
    Client client = db.get(id);

    if (client == null) {
      throw new ItemDoesNotExistException();
    }

    return client;
  }

  public List<Client> getAll() {
    return db.values().stream().toList();
  }

  public Client update(Client client) throws ItemDoesNotExistException {
    Client oldclient = db.get(client.getId());

    if (oldclient == null) {
      throw new ItemDoesNotExistException();
    }

    return db.put(client.getId(), client);
  }
}
