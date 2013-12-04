// Copyright (c) 2013 Elements of Programming Interviews. All rights reserved.
package com.elementsofprogramminginterviews.ch6;

import static com.elementsofprogramminginterviews.utils.Utils.reverse;

public class Rotate_array {
	// @include
	static void rotate_array(int[] A, int i) {
		i %= A.length;
		reverse(A, 0, A.length);
		reverse(A, 0, i);
		reverse(A, i, A.length);
	}
	// @exclude
}
