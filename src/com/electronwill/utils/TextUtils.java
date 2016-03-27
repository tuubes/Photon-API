package com.electronwill.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for manipulating CharSequences. TextUtils is faster than the equivalent methods of the standard Java
 * library.
 * 
 * @author TheElectronWill
 * 		
 */
public final class TextUtils {
	
	/**
	 * Removes a character from a CharSequence.
	 * 
	 * @return a new CharSequence contaning the given CharSequence without the character to remove
	 */
	public static CharSequence remove(CharSequence seq, char toRemove) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < seq.length(); i++) {
			final char ch = seq.charAt(i);
			if (ch != toRemove) {
				sb.append(ch);
			}
		}
		return sb;
	}
	
	/**
	 * Removes several character from a CharSequence.
	 * 
	 * @return a new CharSequence contaning the given CharSequence without the characters to remove
	 */
	public static CharSequence remove(CharSequence seq, char... toRemove) {
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
		return sb;
	}
	
	/**
	 * Splits a CharSequence around occurences of a character. The result is similar to {@link String#split(String)}.
	 */
	public static List<CharSequence> split(CharSequence cs, char sep) {
		List<CharSequence> list = new ArrayList<>(4);
		split(cs, sep, list);
		return list;
	}
	
	/**
	 * Splits a CharSequence around occurences of a character, and put the result in a List. The result is similar to
	 * {@link String#split(String)}.
	 */
	public static void split(CharSequence cs, char sep, List<CharSequence> list) {
		int pos0 = 0;
		for (int i = 0; i < cs.length(); i++) {
			char ch = cs.charAt(i);
			if (ch == sep) {
				list.add(cs.subSequence(pos0, i));
				pos0 = i + 1;
			}
		}
		if (pos0 < cs.length())
			list.add(cs.subSequence(pos0, cs.length()));
	}
	
	private TextUtils() {}
	
}
