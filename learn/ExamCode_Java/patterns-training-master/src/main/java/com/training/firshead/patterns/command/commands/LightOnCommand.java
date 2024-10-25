package com.training.firshead.patterns.command.commands;

import com.training.firshead.patterns.command.Command;
import com.training.firshead.patterns.command.device.Light;


/**
 * @author vkulinsky
 * date: 23.07.2012
 * time: 0:29:15
 *
 */
public class LightOnCommand implements Command {
   
   private Light light;

   public LightOnCommand(Light light) {
	  super();
	  this.light = light;
   }

   public void execute() {
	  light.on();
   }

   public void undo() {
	  light.off();
   }

   @Override
   public String toString() {
	  return "Switch light on";
   }
   
}
