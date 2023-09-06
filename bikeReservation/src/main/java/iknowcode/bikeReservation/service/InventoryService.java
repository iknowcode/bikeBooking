package iknowcode.bikeReservation.service;

import iknowcode.bikeReservation.Entity.Inventory;

import java.util.List;
public interface InventoryService {
    Inventory saveInventory(Inventory iv);
    default List<Inventory> fetchAllInventory() {
        return null;
    }
    Inventory fetchById(Long id);
    String updateInventory(Inventory iv, Long id);
    String deleteInventoryById(Long id);

}
