/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bad;

import java.util.Date;

public class Customer {


  public Integer cid;
  public String firstName;
  public String last_name;
  public Date dateOfBrith;
  public String addressLine1;
  public String addressLine_2;
  public String zip_code;
  public String city;
  public String country;
  public String email;
  public String phone;
  public String sex;

  /**
   * @param cid
   * @param firstName
   * @param last_name
   * @param dateOfBrith
   * @param addressLine1
   * @param addressLine_2
   * @param zip_code
   * @param city
   * @param country
   * @param email
   * @param phone
   * @param sex
   */
  public Customer(Integer cid, String firstName, String last_name, Date dob, String addressLine1, String addressLine_2, String zip_code, String city, String country, String email, String phone, String sex) {
    this.cid = cid;
    this.firstName = firstName;
    this.last_name = last_name;
    this.dateOfBrith = dateOfBrith;
    this.addressLine1 = addressLine1;
    this.addressLine_2 = addressLine_2;
    this.zip_code = zip_code;
    this.city = city;
    this.country = country;
    this.email = email;
    this.phone = phone;
    this.sex = sex;
  }

  public Integer getCid() {
    return cid;
  }

  public void setCid(Integer cid) {
    this.cid = cid;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public Date getDateOfBrith() {
    return dateOfBrith;
  }

  public void setDateOfBrith(Date dateOfBrith) {
    this.dateOfBrith = dateOfBrith;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String getAddressLine_2() {
    return addressLine_2;
  }

  public void setAddressLine_2(String addressLine_2) {
    this.addressLine_2 = addressLine_2;
  }

  public String getZip_code() {
    return zip_code;
  }

  public void setZip_code(String zip_code) {
    this.zip_code = zip_code;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }
}
