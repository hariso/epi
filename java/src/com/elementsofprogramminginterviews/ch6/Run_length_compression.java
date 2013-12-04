// Copyright (c) 2013 Elements of Programming Interviews. All rights reserved.
package com.elementsofprogramminginterviews.ch6;

public class Run_length_compression {
	// @include
	static String decoding(String s) {
		int count = 0;
		StringBuilder ret = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				count = count * 10 + c - '0';
			} else { // isalpha.
				for (int i = 1; i <= count; i++) {
					ret.append(c);
				}
				count = 0;
			}
		}
		return ret.toString();
	}

	static String encoding(String s) {
		int count = 1;
		StringBuilder ss = new StringBuilder();
		for (int i = 1; i < s.length(); ++i) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				++count;
			} else {
				ss.append(count);
				ss.append(s.charAt(i - 1));
				count = 1;
			}
		}
		ss.append(count);
		ss.append(s.charAt(s.length() - 1));
		return ss.toString();
	}

	// @exclude

	public static void main(String[] args) {
		if (args.length == 2) {
			System.out.println(encoding(args[0]) + ' ' + decoding(args[1]));
		}

		assert ("4a1b3c2a".equals(encoding("aaaabcccaa")));
		assert ("eeeffffee".equals(decoding("3e4f2e")));
		assert ("aaaaaaaaaaffffee".equals(decoding("10a4f2e")));
	}
}
