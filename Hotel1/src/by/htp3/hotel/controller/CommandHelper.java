package by.htp3.hotel.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp3.hotel.command.Command;
import by.htp3.hotel.command.impl.AddNewRoom;
import by.htp3.hotel.command.impl.Booking;
import by.htp3.hotel.command.impl.ChangeAccount;
import by.htp3.hotel.command.impl.ChangeLanguage;
import by.htp3.hotel.command.impl.DeleteRoom;
import by.htp3.hotel.command.impl.GetFreeRooms;
import by.htp3.hotel.command.impl.Logination;
import by.htp3.hotel.command.impl.Registration;
import by.htp3.hotel.command.impl.ShowAllRooms;

public final class CommandHelper {

	private static final CommandHelper instance = new CommandHelper();
	
	private Map<CommandName, Command> commands = new HashMap<>();
	
	private CommandHelper(){
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.CHANGE_LANGUAGE, new ChangeLanguage());
		commands.put(CommandName.SHOW_FREE_ROOMS, new GetFreeRooms());
		commands.put(CommandName.REGISTRATION, new Registration());
		commands.put(CommandName.ADD_NEW_ROOM, new AddNewRoom());
		commands.put(CommandName.BOOKING, new Booking());
		commands.put(CommandName.CHANGE_ACCOUNT, new ChangeAccount());
		commands.put(CommandName.SHOW_ALL_ROOMS, new ShowAllRooms());
		commands.put(CommandName.DELETE_ROOM, new DeleteRoom());
	}
	
	public Command getCommand(String name){
		name = name.replace('-', '_'); // - ---> _
		
		CommandName commandName = CommandName.valueOf(name.toUpperCase());
		Command command = commands.get(commandName);
		return command;
	}

	public static CommandHelper getInstance() {
		return instance;
	}
}
