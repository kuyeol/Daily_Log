package com.training.firshead.patterns.command;


/**
 * @author vkulinsky
 * date: 23.07.2012
 * time: 0:01:35
 *
 */
public interface Command {

   /**
    * Execute command
    */
   void execute();
   
   /**
    * Undo the command
    */
   void undo();
   
}
