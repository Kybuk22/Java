package edu.technischools.java;

import edu.technischools.java.parcel.Envelope;
import edu.technischools.java.parcel.Parcel;
import edu.technischools.java.parcel.ParcelAdapter;
import edu.technischools.java.parcel.ParcelService;
import edu.technischools.java.shipment.Shipment;
import edu.technischools.java.shipment.ShipmentException;
import edu.technischools.java.shipment.ShipmentService;
import edu.technischools.java.tracking.TrackingService;

public class ParcelShop {

  public static void main(String[] args) throws ShipmentException {

    //TODO 11 : Odkomentować 3 kolejne linie
    
     ParcelService parcelService = new ParcelService();
     ShipmentService shipmentService = ShipmentService.getInstance();
     TrackingService trackingService = new TrackingService(shipmentService);
     

    //TODO 12 : Odkomentować 2 kolejne oraz uzupełnić metodę `createParcel` tak by stworzyć obiekt klasy `Parcel`.
    //Uzupełnić metodę `createEnvelope` tak by stworzyć obiekt klasy `Envelope`.
    
     Parcel parcel = parcelService.createParcel(0, null, null);
     Envelope envelope = parcelService.createEnvelope(null);
    

    //TODO 13 : Odkomentować 2 kolejne linie oraz stworzyć klasę `ParcelAdapter`, która będzie adapterem pomiędzy klasami `Parcel` i `Envelope`
    
    Shipment envelopShipment = shipmentService.prepare(new ParcelAdapter(envelope), "Jan Kowalski", "Piotr Nowak");
    Shipment parcelShipment = shipmentService.prepare(parcel, "Jan Kowalski", "Piotr Nowak");
    

    //TODO 14 : odkomentować
      envelopShipment.moveToStatus(Shipment.STATUS.IN_TRANSIT); 
    
    //TODO 15 : odkomentować oraz dodać obsługę wyjątku - złapać go i wypisać na konsolę.
    parcelShipment.moveToStatus(Shipment.STATUS.DELIVERED);
    
    //TODO 16 : odkomentować oraz  używając streamów wypisać na konsolę pole `data` z obiektów `barcode` dla każdej przesyłki
     shipmentService.getShipments(); 

  }

}
