// Copyright (c) 2013 Elements of Programming Interviews. All rights reserved.
package com.elementsofprogramminginterviews.ch6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Max_difference_unlimited_pairs {
	// @include
	static int max_profit_unlimited_pairs(List<Integer> A) {
		if (A.size() <= 1) {
			return 0;
		}

		int profit = 0, buy = A.get(0);
		for (int i = 1; i < A.size() - 1; ++i) {
			if (A.get(i + 1) < A.get(i) && A.get(i - 1) <= A.get(i)) { // sell at local maximum.
				profit += A.get(i) - buy;
				buy = A.get(i + 1);
			} else if (A.get(i + 1) >= A.get(i) && A.get(i - 1) > A.get(i)) { // buy at local minimum
				buy = A.get(i);
			}
		}

		if (A.get(A.size() - 1) > buy) {
			profit += A.get(A.size() - 1) - buy;
		}
		return profit;
	}

	// @exclude

	static int check_ans(List<Integer> A) {
		int profit = 0;

		for (int i = 1; i < A.size(); ++i) {
			if (A.get(i) > A.get(i - 1)) {
				profit += A.get(i) - A.get(i - 1);
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		Random gen = new Random();
		int n = 5;
		// random tests for n = 40, k = 4 for 100 times
		for (int times = 0; times < 100; ++times) {
			List<Integer> A = new ArrayList<Integer>();
			for (int i = 0; i < n; ++i) {
				A.add(gen.nextInt(100));
			}
			System.out.println("n = " + n);
			System.out.println(check_ans(A));
			System.out.println(max_profit_unlimited_pairs(A));
			assert (check_ans(A) == max_profit_unlimited_pairs(A));
		}

		// For input
		if (args.length == 1) {
			n = Integer.valueOf(args[0]);
		} else {
			n = gen.nextInt(10000) + 1;
		}
		List<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			A.add(gen.nextInt(100));
		}
		System.out.println("n = " + n);
		System.out.println(max_profit_unlimited_pairs(A));
	}

}
