package iknowcode.bikeReservation.Controller;

import iknowcode.bikeReservation.Entity.Inventory;
import iknowcode.bikeReservation.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService iService;
    @GetMapping("/inventory")
    public List<Inventory> getInventory() { return iService.fetchAllInventory(); };

    @PostMapping("/inventory")
    public Inventory addInventory(@RequestBody Inventory ivt) {
        return iService.saveInventory(ivt);
    }

    @DeleteMapping("/inventory/{id}")
    public String removeInventory(@PathVariable Long id) {
        return iService.deleteInventoryById(id);
    }

}
