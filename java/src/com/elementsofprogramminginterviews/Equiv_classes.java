// Copyright (c) 2013 Elements of Programming Interviews. All rights reserved.
package com.elementsofprogramminginterviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.elementsofprogramminginterviews.utils.Utils.*;

public class Equiv_classes {
	// @include
	static int backtrace(List<Integer> F, int idx) {
	  while (F.get(idx) != idx) {
	    idx = F.get(idx);
	  }
	  return idx;
	}

	/*
	 * A and B encode pairwise equivalences on a cardinality N set whose elements
	 * are indexed by 0, 1, 2, ..., N-1.
	 *
	 * For example A[i] = 6 and B[i] = 0 indicates that the 6 and 0 are to be
	 * grouped into the same equivalence class.
	 *
	 * We return the weakest equivalence relation implied by A and B in an array
	 * F of length N; F[i] holds the smallest index of all the elements that
	 * i is equivalent to.
	 */
	static List<Integer> compute_equival_classes(int n, List<Integer> A,
	                                    List<Integer> B) {
	  // Each element maps to itself.
	  List<Integer> F = new ArrayList<Integer>();
	  iota(F, n, 0);

	  for (int i = 0; i < A.size(); ++i) {
	    int a = backtrace(F, A.get(i)), b = backtrace(F, B.get(i));
	    if (a < b) {
	    	F.set(b, a);
	    } else {
	    	F.set(a, b);
	    }
	  }

	  // Generates the weakest equivalence relation.
	  for (int f : F) {
	    while (f != F.get(f)) {
	      f = F.get(f);
	    }
	  }
	  return F;
	}
	// @exclude

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[]{1, 5, 3, 6});
		  List<Integer> B = Arrays.asList(new Integer[]{2, 1, 0, 5});
		  List<Integer> res = compute_equival_classes(7, A, B);
		  simplePrint(res);
		  assert(res.get(0) == 0);
		  assert(res.get(1) == 1);
		  assert(res.get(2) == 1);
		  assert(res.get(3) == 0);
		  assert(res.get(4) == 4);
		  assert(res.get(5) == 1);
		  assert(res.get(6) == 1);
	}
}
