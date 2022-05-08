package commands;

import exception.InputNotValid;
import model.Command;
import service.ParkingLotService;
import validator.OutputPrinter;

public class leaveParkingLot extends CommandExecutor{
    public leaveParkingLot(ParkingLotService parkingLotService,
                           OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
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
        int slotNumber = Integer.parseInt(command.getCommand());
        parkingLotService.makeSlotFree(slotNumber);
        outputPrinter.printWithNewLine("Slot "+slotNumber+" is free");
    }
}
