package kr.sideeffect.agilejava.ch08;

import java.util.logging.*;

public class TestHandler  extends Handler{
	private LogRecord record;
	
	@Override
	public void close() throws SecurityException {
	}

	@Override
	public void flush() {
	}

	@Override
	public void publish(LogRecord record) {
		this.record = record;
	}
	
	public String getMessage() {
		return record.getMessage();
	}

}
