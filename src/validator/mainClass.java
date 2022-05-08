package validator;

import commands.CreateParkingLot;
import commands.leaveParkingLot;
import commands.parkCar;
import commands.statusOfParkingLot;
import model.Command;
import service.ParkingLotService;

import java.util.Scanner;

public class mainClass {
    static ParkingLotService parkingLotService;
    static OutputPrinter outputPrinter;
    public static void main(String[] args) {
        System.out.println("Welcome");
        parkingLotService = new ParkingLotService();
        outputPrinter = new OutputPrinter();
        Scanner scn = new Scanner(System.in);
        int cycle = 1;
        while(cycle==1){
            outputPrinter.printWithNewLine("Please enter a command");
            String commnad = scn.nextLine();
            cycle = commandMapping(commnad,scn);
        }
    }

    private static int commandMapping(String command, Scanner scn){
        if(command.equals("create")){
            outputPrinter.printWithNewLine("Please enter capacity");
            Command capacity = new Command(scn.nextLine());
            CreateParkingLot createParkingLot = new CreateParkingLot(parkingLotService,outputPrinter);
            if(createParkingLot.validate(capacity)){
                createParkingLot.execute(capacity);
            }
        }else if(command.equals("park")){
            outputPrinter.printWithNewLine("Please enter car registration number");
            Command regNum = new Command(scn.nextLine());
            outputPrinter.printWithNewLine("Please enter car colour");
            Command colour = new Command(scn.nextLine());
            parkCar ParkCar = new parkCar(parkingLotService,outputPrinter);
            if(ParkCar.validate(regNum)&&ParkCar.validateColour(colour)){
                ParkCar.parkCar(regNum,colour);
            }

        }else if(command.equals("leave")){
            outputPrinter.printWithNewLine("Please enter the slot number");
            Command slotNumber = new Command(scn.nextLine());
            leaveParkingLot LeaveParkingLot = new leaveParkingLot(parkingLotService,outputPrinter);
            if(LeaveParkingLot.validate(slotNumber)){
                LeaveParkingLot.execute(slotNumber);
            }

        }else if(command.equals("status")){
            statusOfParkingLot StatusOfParkingLot = new statusOfParkingLot(parkingLotService,outputPrinter);
            Command blank = new Command("");
            StatusOfParkingLot.execute(blank);

        }else if(command.equals("exit")){
            return 0;
        }else{
            outputPrinter.printWithNewLine("please enter a valid command");
        }
        return 1;
    }
}
