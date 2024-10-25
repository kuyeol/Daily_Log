package kr.sideeffect.agilejava.ch08;

public class Scorer {

	public int score(String input) {
		return Integer.parseInt(input);
	}

	public boolean isValid(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
