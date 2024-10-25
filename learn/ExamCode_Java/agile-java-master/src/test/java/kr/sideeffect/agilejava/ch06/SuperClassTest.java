package kr.sideeffect.agilejava.ch06;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuperClassTest {
	@Test
	public void testConstructorCalls() throws Exception {
		SuperClass superClass = new SubClass("parm");
		assertTrue(SuperClass.constructorWasCalled);
	}
}
