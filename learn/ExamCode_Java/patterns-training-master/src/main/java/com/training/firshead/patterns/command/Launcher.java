package com.training.firshead.patterns.command;

import java.util.Scanner;

import com.training.firshead.patterns.command.commands.*;
import com.training.firshead.patterns.command.device.Door;
import com.training.firshead.patterns.command.device.Light;
import com.training.firshead.patterns.command.device.Stereo;
import com.training.firshead.patterns.command.device.Thermostat;


/**
 * @author vkulinsky
 * date: 23.07.2012
 * time: 0:40:17
 *
 */
public class Launcher {
   
   public static void main(String[] args) throws Exception{
	  Light light = new Light();
	  Door door = new Door();
	  Stereo stereo = new Stereo();
	  Thermostat thermostat = new Thermostat();
	  
	  RemoteControl remoteControl = new RemoteControl(4);
	  remoteControl.setSlot(0, new LightOnCommand(light), new LightOffCommand(light));
	  remoteControl.setSlot(1, new DoorOnCommand(door), new DoorOffCommand(door));
	  remoteControl.setSlot(2, new StereoOnCommand(stereo), new StereoOffCommand(stereo));
	  remoteControl.setSlot(3, new ThermostatOnCommand(thermostat), new ThermostatOffCommand(thermostat));
	  Scanner in = new Scanner(System.in); 
	  while(true) {
		 System.out.print("\n"+remoteControl.toString());
		 
		 int slotNumber = readSlot(4, in);
		 if (slotNumber < 0) break;
		 if (4 == slotNumber) {
			remoteControl.undoLatestCommand();
			continue;
		 }
		 
		 int commandNumber = readCommand(in);
		 if (commandNumber < 0) break;
		 switch (commandNumber) {
			case 0:
			   remoteControl.pressOnButton(slotNumber);
			   break;
			case 1:
			   remoteControl.pressOffButton(slotNumber);
			   break;
		 }		
	  }
	  
	  in.close();
   }
   
   private static int readSlot(int numberOfSlots, Scanner scanner) throws Exception {
	  int slotNumber = 0;
	  
	  while(true) {
		 System.out.println("\nNumber of slot to execute [0:"+(numberOfSlots-1)+"]; "+
	         numberOfSlots+": to undo previous action ; -1:  to exit the application;");
		 if (scanner.hasNextInt()) {
			slotNumber = scanner.nextInt();
			break;
		 } 
	  }
	  
	  return slotNumber;
   }
   
   
   private static int readCommand(Scanner scanner) throws Exception {
	  int commandNumber = 0;
	  
	  while(true) {
		 System.out.println("Command to execute: 0: on command , 1: off command , -1: exit the application");
		 if (scanner.hasNextInt()) {
			commandNumber = scanner.nextInt();
			if (commandNumber < -1 || commandNumber > 1) continue;
			break;
		 } 
	  }
	  
	  return commandNumber;
   }

}
