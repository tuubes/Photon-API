package com.electronwill.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for manipulating Strings. TextUtils is faster than the equivalent methods of the standard
 * Java library.
 *
 * @author TheElectronWill
 *
 */
public final class StringUtils {

	/**
	 * Removes a character from a String.
	 *
	 * @return a new String contaning the given String without the character to remove
	 */
	public static String remove(String seq, char toRemove) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < seq.length(); i++) {
			final char ch = seq.charAt(i);
			if (ch != toRemove) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	/**
	 * Removes several character from a String.
	 *
	 * @return a new String contaning the given String without the characters to remove
	 */
	public static String remove(String seq, char... toRemove) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < seq.length(); i++) {
			final char ch = seq.charAt(i);
			boolean append = true;
			for (int j = 0; j < toRemove.length; j++) {
				final char c = toRemove[j];
				if (ch == c) {
					append = false;
					break;
				}
			}
			if (append) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	/**
	 * Splits a String around occurences of a character. The result is similar to
	 * {@link String#split(String)}.
	 */
	public static List<String> split(String cs, char sep) {
		List<String> list = new ArrayList<>(4);
		split(cs, sep, list);
		return list;
	}

	/**
	 * Splits a String around occurences of a character, and put the result in a List. The result is similar
	 * to {@link String#split(String)}.
	 */
	public static void split(String str, char sep, List<String> list) {
		int pos0 = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == sep) {
				list.add(str.substring(pos0, i));
				pos0 = i + 1;
			}
		}
		if (pos0 < str.length()) {
			list.add(str.substring(pos0, str.length()));
		}
	}

	private StringUtils() {
	}

}
