package service;

import exception.ParkingLotException;
import model.Car;
import model.Slot;
import model.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    private parkingLot ParkingLot;

    public void createParkingLot(parkingLot ParkingLot){
        if(this.ParkingLot!=null){
            throw new ParkingLotException(" Parking lot already exists");
        }
        this.ParkingLot = ParkingLot;
    }

    public int park(Car car){
        validateParkingLotExists();
        int availableSlot = ParkingLot.nextAvailableSlot();
        ParkingLot.parkCar(car,availableSlot);
        return availableSlot;
    }

    public void makeSlotFree(int slotNumber){
        validateParkingLotExists();
        ParkingLot.makeSlotFree(slotNumber);
    }

    public List<Slot> getOccupiedSlots(){
        validateParkingLotExists();
        List<Slot> occupiedSlots = new ArrayList<>();
        List<Slot> allSlots = ParkingLot.getSlots();
        for(int i=1;i<=ParkingLot.getCapacity();i++){
            if(!allSlots.get(i-1).isSlotFree()){
                occupiedSlots.add(allSlots.get(i));
            }
        }
        return occupiedSlots;
    }
    public List<Slot> getFreeSlots(){
        validateParkingLotExists();
        List<Slot> freeSlots = new ArrayList<>();
        List<Slot> allSlots = ParkingLot.getSlots();
        for(int i=1;i<=ParkingLot.getCapacity();i++){
            if(allSlots.get(i)==null){
                freeSlots.add(allSlots.get(i));
            }
        }
        return freeSlots;
    }

    private void validateParkingLotExists() {
        if(ParkingLot==null){
            throw new ParkingLotException("Parking lot does not exist");
        }
    }

}
