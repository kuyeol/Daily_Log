package com.training.firshead.patterns.command.commands;

import com.training.firshead.patterns.command.Command;
import com.training.firshead.patterns.command.device.Door;


/**
 * @author vkulinsky
 * date: 23.07.2012
 * time: 0:26:27
 *
 */
public class DoorOnCommand implements Command {

   private Door door;
   
   public DoorOnCommand(Door door) {
	  this.door = door;
   }

   public void execute() {
	  door.open();
   }

   public void undo() {
	  door.close();
   }

   @Override
   public String toString() {
	  return "Open door";
   }

}
