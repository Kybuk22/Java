package edu.technischools.java.two;

import edu.technischools.java.two.exception.ItemAlreadyManagedByDatabaseException;
import edu.technischools.java.two.exception.ItemDoesNotExistException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DatabaseTest {

  Database database;

  @Before
  public void setUp() {
    database = new Database();
  }

  @Test
  public void testCreateForEmptyId() throws ItemAlreadyManagedByDatabaseException {
    // given
    Client client = new Client();
    client.setFirstName("John");
    client.setLastName("Doe");
    client.setAge(30);

    // when
    Client createdClient = database.create(client);

    // then
    Assert.assertNotNull(createdClient.getId());
    Assert.assertEquals(client.getFirstName(), createdClient.getFirstName());
    Assert.assertEquals(client.getLastName(), createdClient.getLastName());
    Assert.assertEquals(client.getAge(), createdClient.getAge());
  }

  @Test(expected = ItemAlreadyManagedByDatabaseException.class)
  public void testCreateForNonEmptyId() throws ItemAlreadyManagedByDatabaseException {
    // given
    Client client = new Client();
    client.setId(1);
    client.setFirstName("John");
    client.setLastName("Doe");
    client.setAge(30);

    // when
    database.create(client);
  }

  @Test
  public void testGetByIdForExistingOrder() throws ItemAlreadyManagedByDatabaseException, ItemDoesNotExistException {
    // given
    Client client = new Client();
    client.setFirstName("John");
    client.setLastName("Doe");
    client.setAge(30);
    Client createdClient = database.create(client);

    // when
    Client fetchedClient = database.getById(createdClient.getId());

    // then
    Assert.assertEquals(createdClient.getId(), fetchedClient.getId());
    Assert.assertEquals(createdClient.getFirstName(), fetchedClient.getFirstName());
    Assert.assertEquals(createdClient.getLastName(), fetchedClient.getLastName());
    Assert.assertEquals(createdClient.getAge(), fetchedClient.getAge());
  }

  @Test(expected = ItemDoesNotExistException.class)
  public void testGetByIdForNonExistingOrder() throws ItemDoesNotExistException {
    // when
    database.getById(22);
  }

  @Test
  public void testUpdateExistingOrder() throws ItemAlreadyManagedByDatabaseException, ItemDoesNotExistException {
    // given
    Client client = new Client();
    client.setFirstName("John");
    client.setLastName("Doe");
    client.setAge(30);
    Client createdClient = database.create(client);

    // when
    createdClient.setAge(40);
    Client updatedClient = database.update(createdClient);

    // then
    Assert.assertEquals(createdClient.getId(), updatedClient.getId());
    Assert.assertEquals(createdClient.getFirstName(), updatedClient.getFirstName());
    Assert.assertEquals(createdClient.getLastName(), updatedClient.getLastName());
    Assert.assertEquals(createdClient.getAge(), updatedClient.getAge());

    // additional check
    Client fetchedClient = database.getById(createdClient.getId());
    Assert.assertEquals(createdClient.getAge(), fetchedClient.getAge());
  }

  @Test(expected = ItemDoesNotExistException.class)
  public void testUpdateNonExistingOrder() throws ItemDoesNotExistException {
    // given
    Client client = new Client();
    client.setId(1);
    client.setFirstName("John");
    client.setLastName("Doe");
    client.setAge(30);

    // when
    database.update(client);
  }
}