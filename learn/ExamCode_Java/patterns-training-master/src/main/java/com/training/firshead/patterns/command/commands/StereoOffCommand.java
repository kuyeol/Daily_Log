package com.training.firshead.patterns.command.commands;

import com.training.firshead.patterns.command.Command;
import com.training.firshead.patterns.command.device.Stereo;


/**
 * @author vkulinsky
 * date: 23.07.2012
 * time: 0:35:37
 *
 */
public class StereoOffCommand implements Command {

   private Stereo stereo;
   
   public StereoOffCommand(Stereo stereo) {
	  this.stereo = stereo;
   }

   public void execute() {
	  stereo.switchOff();
   }

   public void undo() {
	  stereo.switchOn();
   }

   @Override
   public String toString() {
	  return "Switch Stereo off";
   }
}
