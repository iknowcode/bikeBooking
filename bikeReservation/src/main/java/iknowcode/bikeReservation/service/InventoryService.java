package iknowcode.bikeReservation.service;

import iknowcode.bikeReservation.Entity.Inventory;
import iknowcode.bikeReservation.Repository.InventoryRepository;

import java.util.List;
public interface InventoryService {

    Inventory saveInventory(Inventory iv);

    default List<Inventory> fetchAllInventory() {
        return null;
    }

    String updateInventory(Inventory iv, Long id);

    String delteInventoryById(Long id);

}
