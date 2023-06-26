package edu.technischools.java.tracking;

import edu.technischools.java.shipment.Shipment;
import edu.technischools.java.shipment.ShipmentNotFoundException;
import edu.technischools.java.shipment.ShipmentService;

import java.util.List;
import java.util.UUID;

public class TrackingService {

  private ShipmentService shipmentService;

  public TrackingService(ShipmentService service) {
    this.shipmentService = service;
  }

  public List<Shipment> findByStatus(Shipment.STATUS status) throws ShipmentNotFoundException
    {
      if(status==null){
        throw new ShipmentNotFoundException("ok");
      }
    shipmentService.getShipments().stream().filter(e ->e.toString()==status.toString());
    return shipmentService.getShipments();
    }
  

  public List<Shipment> findByUUID(UUID uuid) throws ShipmentNotFoundException{
    if(uuid==null){
      throw new ShipmentNotFoundException("ok");
    }
    shipmentService.getShipments().stream().filter(e ->e.getUuid() ==uuid);
    return shipmentService.getShipments();

  }
}
