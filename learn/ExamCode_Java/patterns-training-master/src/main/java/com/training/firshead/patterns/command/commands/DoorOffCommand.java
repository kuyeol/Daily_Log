package com.training.firshead.patterns.command.commands;

import com.training.firshead.patterns.command.Command;
import com.training.firshead.patterns.command.device.Door;


/**
 * @author vkulinsky
 * date: 23.07.2012
 * time: 0:28:18
 *
 */
public class DoorOffCommand implements Command {

   private Door door;
   
   public DoorOffCommand(Door door) {
	  this.door = door;
   }

   public void execute() {
	  door.close();
   }

   public void undo() {
	  door.open();
   }

   @Override
   public String toString() {
	  return "Close door";
   }

}
