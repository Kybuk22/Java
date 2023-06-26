package edu.technischools.java.one;

import java.util.Map;

/**
 * A class that stores inventory in a form of map, where key is an item, and value is the quantity
 */
public class Inventory {

  private Map<String, Integer> items;

  public Inventory(Map<String, Integer> items) {
    this.items = items;
  }

  /**
   * Adds element to a map
   *
   * @param item     to add
   * @param quantity of an element
   */
  public void addItem(String item, int quantity) {
    Integer currentQuantity = items.get(item);
    if (currentQuantity == null) {
      currentQuantity = 0;
    }
    items.put(item, currentQuantity + quantity);
  }

  /**
   * Removes given number of elements from the inventory
   *
   * @param item     element to remove
   * @param quantity quantity to remove
   */
  public void removeItem(String item, int quantity) {
    Integer currentQuantity = items.get(item);
    if (currentQuantity == null || currentQuantity < quantity) {
      throw new IllegalArgumentException("Insufficient quantity");
    }
    items.put(item, currentQuantity - quantity);
  }

  /**
   * Count item
   *
   * @param item to count
   * @return quantity or 0, when item is not in the inventory
   */
  public int getItemCount(String item) {
    Integer quantity = items.get(item);
    return quantity == null ? 0 : quantity;
  }
}
