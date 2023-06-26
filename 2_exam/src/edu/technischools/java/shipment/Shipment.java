package edu.technischools.java.shipment;

import edu.technischools.java.parcel.Parcel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Shipment {

  private UUID uuid;
  private String sender;
  private String recipient;
  private Barcode barcode;
  private Parcel parcel;

  private List<STATUS> statuses = new ArrayList<>();

  public enum STATUS {
    PREPARED,
    IN_TRANSIT,
    DELIVERED,
    LOST;

    @Override
    public String toString() {
      // TODO Auto-generated method stub
      return super.toString();
    }
  }

  public Shipment(String sender, String recipient, Parcel parcel) {
    this.uuid = UUID.randomUUID();
    this.sender = sender;
    this.recipient = recipient;
    //TODO 5 : odkomentować kod budujący obiekt klasy `Barcode` oraz dodać brakujące metody, tak by stworzyć obiekt klasy `Bardode` ze wszytskimi polami
     this.barcode = Barcode.Builder();
  

    
    //this.parcel = parcel;
    //statuses.add(STATUS.PREPARED);

  }

  public Shipment(UUID uuid, String sender, String recipient, Barcode barcode, Parcel parcel, List<STATUS> statuses) {
    this.uuid = uuid;
    this.sender = sender;
    this.recipient = recipient;
    this.barcode = barcode;
    this.parcel = parcel;
    this.statuses = statuses;
  }

  public UUID getUuid() {
    return uuid;
  }

  public String getSender() {
    return sender;
  }

  public String getRecipient() {
    return recipient;
  }

  public Barcode getBarcode() {
    return barcode;
  }

  public Parcel getParcel() {
    return parcel;
  }
  

  //TODO 6 :Stworzyć wyjątek `InvalidStatusException` dziedziczący z klasy `ShipmentException` oraz dodać go deklaracji metody `Shipment.moveToStatus`. 
  // Uzupełnić metodę `moveToStatus` tak by nie pozwlała zmienić statusu z `PREPARED` na `DELIVERED`. (aktualny status znajduje się zawsze na ostatnim miejscu w liście statusów).
  public Shipment moveToStatus(STATUS status) throws ShipmentException {
    var e = statuses.get(statuses.size() - 1);
      if(e.toString()=="PREPARED" && status==STATUS.DELIVERED){
        throw new ShipmentException("No");
      }
    this.statuses.add(status);
    
    return this;
  }
}

