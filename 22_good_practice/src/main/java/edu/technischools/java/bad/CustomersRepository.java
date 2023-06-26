/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bad;

import java.util.List;
import java.util.Map;

public class CustomersRepository {

  private static int SEQUENCE = 0;
  private Map<Integer, Customer> customerMap;

  public Customer getCustomerById(Integer id) {
    return customerMap.get(id);
  }

  public List<Customer> fetchAll() {
    if (customerMap != null) {
      return customerMap.values().stream().toList();
    }
    return null;
  }

  public List<Customer> findCustomerByCity(String city) {
    if (customerMap != null) {
      return customerMap.values().stream().filter(customer -> customer.city.equalsIgnoreCase(city)).toList();
    }
    return null;
  }

  // tworzy lub uaktualnia klienta, jeśli nie istnieje
  public Customer Save(Customer customer) {
    if (customerMap.get(customer.cid) != null) {
      customerMap.put(customer.cid, customer);
    } else {
      customer.cid = SEQUENCE += 1;
      customerMap.put(customer.cid, customer);  
    }

    return customer;
  }
}
