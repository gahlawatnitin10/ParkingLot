package commands;

import exception.InputNotValid;
import model.Command;
import model.parkingLot;
import service.ParkingLotService;
import validator.OutputPrinter;

public class CreateParkingLot extends CommandExecutor{
    public CreateParkingLot(ParkingLotService parkingLotService, OutputPrinter outputPrinter){
        super(parkingLotService,outputPrinter);
    }
    @Override
    public boolean validate(Command command) {
        String commandName = command.getCommand();
        try{
            Integer.parseInt(commandName);
        }catch (Exception notInteger){
            throw new InputNotValid("Invalid input");
        }
        return true;
    }

    @Override
    public void execute(Command command) {
        int parkingLotCapacity = Integer.parseInt(command.getCommand());
        parkingLot ParkingLot = new parkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(ParkingLot);
        outputPrinter.printWithNewLine("Parking lot created with "+parkingLotCapacity+" capacity");
    }
}
