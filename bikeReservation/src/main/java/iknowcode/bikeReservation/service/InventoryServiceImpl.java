package iknowcode.bikeReservation.service;

import iknowcode.bikeReservation.Entity.Inventory;
import iknowcode.bikeReservation.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository iRep;
    @Override
    public Inventory saveInventory(Inventory iv){
        return iRep.save(iv);
    }
    @Override
    public List<Inventory> fetchAllInventory(){
        return (List<Inventory>)iRep.findAll();
    }
    @Override
    public String updateInventory(Inventory iv, Long id){
        Optional<Inventory> i = iRep.findById(id);

        if(i.isPresent()) {
            Inventory found = i.get();
            found.setBike_name(iv.getBike_name());
            found.setBrand(iv.getBrand());
            found.setBikeId(iv.getBikeId());
            found.setEngine(iv.getEngine());
        }else {
            return "Inventory not found!!";
        }

        return "Inventory Updated!!!";
    }
    @Override
    public String delteInventoryById(Long id){
        Optional<Inventory> i = iRep.findById(id);
        if(i.isPresent()) {
            iRep.deleteById(id);
        }else
            return "Inventory not found!!";

        return "Inventory Removed Successfully";
    }


}
