package edu.technischools.java.shipment;

import edu.technischools.java.parcel.Parcel;
import edu.technischools.java.parcel.ParcelAdapter;

import java.util.ArrayList;
import java.util.List;


  public final class ShipmentService  {

  private static ShipmentService instance;
  
  // TODO 8 : Dodać brakującą metodę, tak by serwis był singletonem.  
  //8. W klasie `ShimpentService` dodać brakującą metodę, tak by serwis był singletonem. Dodać odpowiedni konstruktor. [2]
  // Dodać odpowiedni konstruktor.
  
  private List<Shipment> shipments = new ArrayList<>();



  public Shipment prepare(Parcel parcel, String sender, String recipient) {
    Shipment shipment = new Shipment(sender, recipient, parcel);
    this.shipments.add(shipment);

    return shipment;
  }

  //TODO 7 : Dodać deklarację wyjątku z TODO 6.
  public Shipment tranfer(Shipment shipment) throws ShipmentException {
    shipment.moveToStatus(Shipment.STATUS.IN_TRANSIT);
    return shipment;
  }

  //TODO 7 : Dodać deklarację wyjątku z TODO 6.
  public Shipment deliver(Shipment shipment) throws ShipmentException {
    shipment.moveToStatus(Shipment.STATUS.DELIVERED);
    return shipment;
  }

  public List<Shipment> getShipments() {
    return shipments;
  }
  public static ShipmentService getInstance() {
    if (instance == null) {
      instance = new ShipmentService();
    }
    return instance;
  }

  public Shipment prepare(ParcelAdapter parcelAdapter, String sender, String recipient) {
    return null;
  }
}
