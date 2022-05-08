package model;

import java.util.List;

public class Command {
    private String commandName;

    public Command(String commandName){
        this.commandName = commandName;
    }

    public String getCommand(){
        return commandName;
    }

}
