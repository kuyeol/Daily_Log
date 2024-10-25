package kr.sideeffect.agilejava.ch07;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoopTest {
	@Test
	public void testPalindrome() throws Exception {
		assertFalse(isPalindrome("abcdef"));
		assertFalse(isPalindrome("abccda"));
		assertTrue(isPalindrome("abccba"));
		assertFalse(isPalindrome("abcxba"));
		assertTrue(isPalindrome("a"));
		assertTrue(isPalindrome("aa"));
		assertFalse(isPalindrome("ab"));
		assertTrue(isPalindrome(""));
		assertTrue(isPalindrome("aaa"));
		assertTrue(isPalindrome("aba"));
		assertTrue(isPalindrome("abbba"));
		assertTrue(isPalindrome("abba"));
		assertFalse(isPalindrome("abbaa"));
		assertFalse(isPalindrome("abcda"));
	}

	public static boolean isPalindrome(String string) {
		if (string.length() == 0) {
			return true;
		}
		int limit = string.length() / 2;
		for (int forward = 0, backward = string.length() -1; forward < limit; forward++, backward--) {
			if (string.charAt(forward) != string.charAt(backward)) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testFibonacci() {
		assertEquals(0, fib(0));
		assertEquals(1, fib(1));
		assertEquals(1, fib(2));
		assertEquals(2, fib(3));
		assertEquals(3, fib(4));
		assertEquals(5, fib(5));
		assertEquals(8, fib(6));
		assertEquals(13, fib(7));
		assertEquals(21, fib(8));
		assertEquals(34, fib(9));
		assertEquals(55, fib(10));
	}

	private int fib(int x) {
		if (x == 0) return 0;
		if (x == 1) return 1;
		return fib(x-1) + fib(x-2);
	}
	
	@Test
	public void testCommas() {
		String sequence = "1,2,3,4,5";
		assertEquals(sequence, sequenceUsingDo(1, 5));
		assertEquals(sequence, sequenceUsingFor(1, 5));
		assertEquals(sequence, sequenceUsingWhile(1, 5));
		
		sequence = "8";
		assertEquals(sequence, sequenceUsingDo(8, 8));
		assertEquals(sequence, sequenceUsingFor(8, 8));
		assertEquals(sequence, sequenceUsingWhile(8, 8));
	}

	private String sequenceUsingDo(int start, int stop) {
		StringBuilder builder = new StringBuilder();
		int i = start;
		do {
			if (i > start) {
				builder.append(',');
			}
			builder.append(i);
		} while(++i <= stop);
		return builder.toString();
	}
	
	private String sequenceUsingFor(int start, int stop) {
		StringBuilder builder = new StringBuilder();
		for (int i = start; i <= stop; i++) {
			if (i > start) {
				builder.append(',');
			}
			builder.append(i);
		}
		return builder.toString();
	}
	
	private String sequenceUsingWhile(int start, int stop) {
		StringBuilder builder = new StringBuilder();
		int i = start;
		while (i <= stop) {
			if (i > start) {
				builder.append(',');
			}
			builder.append(i);
			i++;
		}
		return builder.toString();
	}
	
	@Test
	public void testEndTrim() {
		assertEquals("", endTrim(""));
		assertEquals(" x", endTrim(" x "));
		assertEquals("y", endTrim("y"));
		assertEquals("xaxa", endTrim("xaxa"));
		assertEquals("", endTrim(" "));
		assertEquals("xxx", endTrim("xxx    "));
	}

	public String endTrim(String source) {
		int i = source.length()-1;
		while (i >= 0) {
			if (source.charAt(i) != ' ') {
				break;
			}
			i--;
		}
		return source.substring(0, i + 1);
	}
}
