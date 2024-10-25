package com.training.firshead.patterns.singleton;

import junit.framework.TestCase;


public class SingletonTest extends TestCase {
	
	private Singleton singletonInstance;
	
   @Override
	protected void tearDown() throws Exception {
		singletonInstance = null;
	}

   
   public void testSingletonUniqueInstance() {
   	Singleton instance1 = Singleton.getInstance();
   	Singleton instance2 = Singleton.getInstance();
   	assertSame("Singleton must have only a single instance",instance1, instance2);
   }

	public void testSingletonUniqueInstanceInConcurrentEnv() {
		Runnable runnableTest = new Runnable() {
			public void run() {
				for (int i = 0 ; i < 100000 ; i++) {
					setSingletonInstance(Singleton.getInstance());
					Thread.yield();
				}
			}
		};
		
		//launch several thread to test singleton in concurrent environment
		Thread firstThread = new Thread(runnableTest); 
		Thread secondThread = new Thread(runnableTest);
		
		firstThread.start();
		secondThread.start();
		
		//wait until first thread is dead
		try {
			firstThread.join();
		} catch (InterruptedException e) {
			throw new RuntimeException("Unable to wait for thread 1",e);
		}
		
		//wait until second thread is dead
		try {
			secondThread.join();
		} catch (InterruptedException e) {
			throw new RuntimeException("Unable to wait for thread 2",e);
		}
	}
	
	
	private synchronized void setSingletonInstance(Singleton instance) {
		if (null == singletonInstance) {
			singletonInstance = instance;
			return;
		}
		
		//check instance
		assertSame("Singleton must have only a single instance",instance, singletonInstance);
	}
	
	
}
