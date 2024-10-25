package com.training.firshead.patterns.command.commands;

import com.training.firshead.patterns.command.Command;
import com.training.firshead.patterns.command.device.Thermostat;


public class ThermostatOnCommand implements Command {
   
   private Thermostat thermostat;
   
   
   public ThermostatOnCommand(Thermostat thermostat) {
	  this.thermostat = thermostat;
   }

   public void execute() {
	  thermostat.turnOn();
   }

   public void undo() {
	  thermostat.turnOff();
   }

   @Override
   public String toString() {
	  return "Turn on thermostat";
   }
   
}
