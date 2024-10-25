package com.training.firshead.patterns.command.commands;

import com.training.firshead.patterns.command.Command;
import com.training.firshead.patterns.command.device.Light;


/**
 * @author vkulinsky
 * date: 23.07.2012
 * time: 0:32:08
 *
 */
public class LightOffCommand implements Command {

   private Light light;

   public LightOffCommand(Light light) {
	  this.light = light;
   }

   public void execute() {
	  light.off();
   }

   public void undo() {
	  light.on();
   }

   @Override
   public String toString() {
	  return "Switch light off";
   }

}
