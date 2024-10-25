package com.training.firshead.patterns.command;



/**
 * Command implementation that does nothing (just a commdn stub)
 * 
 * @author vkulinsky
 * date: 23.07.2012
 * time: 0:04:37
 *
 */
public class NullCommand implements Command {

   public void execute() {
	//just do nothing
   }

   public void undo() {
	//just do nothing
   }

}
