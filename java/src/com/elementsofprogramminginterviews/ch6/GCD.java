//Copyright (c) 2013 Elements of Programming Interviews. All rights reserved.

package com.elementsofprogramminginterviews.ch6;

public class GCD {
	// @include
	public static long gcd(long x, long y) {
		if (x == 0) {
			return y;
		} else if (y == 0) {
			return x;
		} else if ((x & 1) == 0 && (y & 1) == 0) { // x and y are even.
			return gcd(x >> 1, y >> 1) << 1;
		} else if ((x & 1) == 0 && (y & 1) == 1) { // x is even, and y is odd.
			return gcd(x >> 1, y);
		} else if ((x & 1) == 1 && (y & 1) == 0) { // x is odd, and y is even.
			return gcd(x, y >> 1);
		} else if (x > y) { // both x and y are odd, and x > y.
			return gcd(x - y, y);
		}
		return gcd(x, y - x); // both x and y are odd, and x <= y.
	}
	
	// @exclude
	long anotherGCD(long a, long b) {
	  if (b != 0) {
	    while (((a %= b) != 0) && ((b %= a) != 0));
	  }
	  
	  return a + b;
	}

}