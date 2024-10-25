package com.training.firshead.patterns.command.commands;

import com.training.firshead.patterns.command.Command;
import com.training.firshead.patterns.command.device.Thermostat;


/**
 * @author vkulinsky
 * date: 23.07.2012
 * time: 0:38:39
 *
 */
public class ThermostatOffCommand implements Command {

   private Thermostat thermostat;
   
   public ThermostatOffCommand(Thermostat thermostat) {
	  super();
	  this.thermostat = thermostat;
   }

   public void execute() {
	  thermostat.turnOff();
   }

   public void undo() {
	  thermostat.turnOn();
   }

   @Override
   public String toString() {
	  return "Turn off thermostat";
   }

}
