package com.training.firshead.patterns.command;

import java.util.Formatter;


/**
 * @author vkulinsky
 * date: 23.07.2012
 * time: 0:02:24
 *
 */
public class RemoteControl {

   private String TO_STRING_FOMATTER = "[slot: %1$s]  %2$-25s %3$-25s \n";
   private int slotsNumber;
   private Command[] onCommands;
   private Command[] offCommands;
   private Command undoCommand;
   
   public RemoteControl(int slots) {
	  slotsNumber = slots;
	  onCommands = new Command[slots];
	  offCommands = new Command[slots];
	  
	  for (int i = 0 ; i < slots  ; i++) {
		 onCommands[i] = new NullCommand();
		 offCommands[i] = new NullCommand();
	  }
	  undoCommand = new NullCommand();
   }
   
   
   public void setSlot(int slot, Command onCommand, Command offCommand) {
	  onCommands[slot]  = onCommand;
	  offCommands[slot]  = offCommand;
   }
   
   public void removeSlot(int slot) {
	  onCommands[slot] = new NullCommand();
	  offCommands[slot] = new NullCommand();
   }
    
   
   public void pressOnButton(int slot) {
	  onCommands[slot].execute();
	  undoCommand = onCommands[slot];
   }
   
   public void pressOffButton(int slot) {
	  offCommands[slot].execute();
	  undoCommand = offCommands[slot];
   }
   
   public void undoLatestCommand() {
	  undoCommand.undo();
   }


   @Override
   public String toString() {
	  StringBuilder result = new StringBuilder().append("---- Remote control---\n");
	  Formatter outFormatter = new Formatter(result);
	  
	  for (int  i = 0 ; i < slotsNumber ; i++)
		 outFormatter.format(TO_STRING_FOMATTER, i, onCommands[i].toString() , offCommands[i].toString());
	  
	  result.append("[slot: ").append(slotsNumber).append("]  Undo previous action \n");
		 
	  return result.toString();
   }
   
}
