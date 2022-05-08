package exception;

public class NoNextSlotAvailable extends ParkingLotException{
    public NoNextSlotAvailable(String message){
        super(message);
    }
}
