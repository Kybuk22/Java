package edu.technischools.java.one;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class InventoryTest {

  Inventory inventory;

  Map<String, Integer> items = new HashMap<>();

  @Before
  public void setUp() throws Exception {
    inventory = new Inventory(items);
  }

  @Test
  public void testAddOnce() {

  }

  @Test
  public void testAddMultipleTimes() {

  }

  @Test
public void testAddAndRemoveFlow() {
  // Initialize the inventory with some items
  inventory.addItem("abc", 1);
  inventory.addItem("def", 2);
  inventory.addItem("ghi", 3);

  // Verify the initial state of the inventory
  Assert.assertEquals(1, inventory.getItemCount("abc"));
  Assert.assertEquals(2, inventory.getItemCount("def"));
  Assert.assertEquals(3, inventory.getItemCount("ghi"));

  // Remove some items from the inventory
  inventory.removeItem("abc", 1);
  inventory.removeItem("def", 1);
  inventory.removeItem("ghi", 2);

  // Verify the final state of the inventory
  Assert.assertEquals(0, inventory.getItemCount("abc"));
  Assert.assertEquals(1, inventory.getItemCount("def"));
  Assert.assertEquals(1, inventory.getItemCount("ghi"));
}

}
