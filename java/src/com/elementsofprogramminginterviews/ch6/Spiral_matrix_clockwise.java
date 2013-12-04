// Copyright (c) 2013 Elements of Programming Interviews. All rights reserved.
package com.elementsofprogramminginterviews.ch6;

import static java.lang.Math.ceil;

import java.util.Random;

public class Spiral_matrix_clockwise {
	// @include
	static void print_matrix_clockwise(int[][] A, int offset) {
	  if (offset == A.length - offset - 1) {  // for matrix with odd size.
		  System.out.print(A[offset][offset]);
	  }

	  for (int j = offset; j < A.length - offset - 1; ++j) {
	    System.out.print(A[offset][j] + " ");
	  }
	  for (int i = offset; i < A.length - offset - 1; ++i) {
	    System.out.print(A[i][A.length - offset - 1] + " ");
	  }
	  for (int j = A.length - offset - 1; j > offset; --j) {
	    System.out.print(A[A.length - offset - 1][j] + " ");
	  }
	  for (int i = A.length - offset - 1; i > offset; --i) {
	    System.out.print(A[i][offset] + " ");
	  }
	}

	static void print_matrix_in_spiral_order(int[][] A) {
	  for (int offset = 0; offset < ceil(0.5 * A.length); ++offset) {
	    print_matrix_clockwise(A, offset);
	  }
	}
	// @exclude

	public static void main(String[] args) {
		Random gen = new Random();
		int N;
		if (args.length == 1) {
			N = Integer.valueOf(args[0]);
		} else {
			N = gen.nextInt(50) + 1;
		}
		int[][] A = new int[N][N];
		int x = 1;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				A[i][j] = x++;
			}
		}
		print_matrix_in_spiral_order(A);
	}
}
