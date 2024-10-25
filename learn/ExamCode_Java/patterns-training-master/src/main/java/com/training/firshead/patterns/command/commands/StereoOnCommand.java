package com.training.firshead.patterns.command.commands;

import com.training.firshead.patterns.command.Command;
import com.training.firshead.patterns.command.device.Stereo;


/**
 * @author vkulinsky
 * date: 23.07.2012
 * time: 0:34:07
 *
 */
public class StereoOnCommand implements Command {

   private Stereo stereo;
   
   public StereoOnCommand(Stereo stereo) {
	  super();
	  this.stereo = stereo;
   }

   public void execute() {
	  stereo.switchOn();
   }

   public void undo() {
	  stereo.switchOff();
   }

   @Override
   public String toString() {
	  return "Switch Stereo on";
   }
}
