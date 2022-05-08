package model;

public class Slot {

    private int slotId;
    private Car carParked;

    public Slot(int slotId){
        this.slotId = slotId;
    }

    public void assignCar(Car carParked) {
        this.carParked = carParked;
    }

    public int getSlotId() {
        return slotId;
    }

    public Car getCarParked() {
        return carParked;
    }
    public void unassignCar(){
        this.carParked = null;
    }

    public boolean isSlotFree(){
        return carParked==null;
    }
}
