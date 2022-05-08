package commands;

import model.Command;
import model.Slot;
import service.ParkingLotService;
import validator.OutputPrinter;

import java.util.List;

public class statusOfParkingLot extends CommandExecutor{
    public statusOfParkingLot(ParkingLotService parkingLotService,
                               OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return true;
    }

    @Override
    public void execute(Command command) {
        List<Slot> occupiedSlots = parkingLotService.getOccupiedSlots();
        if(occupiedSlots==null){
            outputPrinter.printWithNewLine("All slots available");
            return;
        }
        for(int i=0;i<occupiedSlots.size();i++){
            outputPrinter.printWithNewLine("Slot "+occupiedSlots.get(i).getSlotId()+" is occupied");
        }
    }
}
