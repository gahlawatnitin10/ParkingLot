package model;

import exception.InvalidSlotException;
import exception.NoNextSlotAvailable;
import exception.ParkingLotException;
import exception.SlotAlreadyOccupiedException;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class parkingLot {
    private int maxCapacity = 1000;
    private int numberOfSlots;
    private List<Slot> slots;

    private PriorityQueue<Integer> nextSlot;

    public parkingLot(int numberOfSlots){
        if(numberOfSlots>maxCapacity || numberOfSlots<1){
            throw new ParkingLotException("Invalid given capacity");
        }
        this.numberOfSlots = numberOfSlots;
        slots = new ArrayList<Slot>(numberOfSlots);
        nextSlot = new PriorityQueue<>();
        fillPriorityForSlots(numberOfSlots);
    }

    public int getCapacity(){
        return numberOfSlots;
    }

    public void fillPriorityForSlots(int numberOfSlots){
        for(int i=1;i<=numberOfSlots;i++){
            slots.add(new Slot(i));
            nextSlot.offer(i);
        }
    }

    public List<Slot> getSlots(){
        return slots;
    }

    public Slot parkCar(Car car, int slotNumber){
        Slot slot = getSlot(slotNumber);
        if(!slot.isSlotFree()){
            throw new SlotAlreadyOccupiedException("Slot Already Occupied");
        }
        slot.assignCar(car);
        return slot;
    }

    public Slot makeSlotFree(int slotNumber){
        Slot slot = getSlot(slotNumber);
        slot.unassignCar();
        nextSlot.offer(slotNumber);
        return slot;
    }

    public Slot getSlot(int slotNumber){
        if(slotNumber>maxCapacity || slotNumber<1){
            throw new InvalidSlotException("Invalid Slot");
        }
        Slot slot = slots.get(slotNumber);
        return slot;
    }

    public int nextAvailableSlot(){
        if(nextSlot.isEmpty()){
            throw new NoNextSlotAvailable("No slot available");
        }
        return nextSlot.poll();
    }
}
