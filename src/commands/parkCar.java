package commands;

import model.Car;
import model.Command;
import service.ParkingLotService;
import validator.OutputPrinter;

public class parkCar extends CommandExecutor{

    public parkCar(ParkingLotService parkingLotService, OutputPrinter outputPrinter){
        super(parkingLotService,outputPrinter);
    }
    @Override
    public boolean validate(Command registrationNumber) {
        return true;
    }

    public boolean validateColour(Command colour){
        return true;
    }

    @Override
    public void execute(Command command) {

    }
    public void parkCar(Command registrationNumber, Command colour){
        Car car = new Car(registrationNumber.getCommand(),colour.getCommand());
        try{
            Integer slot = parkingLotService.park(car);
            outputPrinter.printWithNewLine("Allocated slot number : "+slot);
        }catch(Exception exception){
            outputPrinter.printWithNewLine("Parking lot full");
        }
    }
}
