package org.cm.transformer;

public class StringReverser {

	static String reverse(String input) {
		return new StringBuilder(input).reverse().toString();
	}
}
