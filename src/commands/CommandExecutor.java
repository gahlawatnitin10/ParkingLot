package commands;

import model.Command;
import service.ParkingLotService;
import validator.OutputPrinter;

public abstract class CommandExecutor {
    ParkingLotService parkingLotService;
    OutputPrinter outputPrinter;

    public CommandExecutor(ParkingLotService parkingLotService,OutputPrinter outputPrinter){
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }

    public abstract boolean validate(Command command);
    public abstract void execute(Command command);
}
