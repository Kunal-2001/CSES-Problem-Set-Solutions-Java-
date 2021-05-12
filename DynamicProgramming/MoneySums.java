package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MoneySums {
	static int mod = 1000000007;

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int a[] = new int [n];
		for(int i = 0 ; i < n; i++) {
			a[i] = sc.nextInt();
		}
		HashSet<Integer> temp ;
		HashSet<Integer> hSet = new HashSet<>();
		hSet.add(a[0]);
		for(int i = 1 ; i < n ; i++) {
			temp = new HashSet<>();
			int curr = a[i];
			for(int z : hSet) {
				temp.add(z+curr);
			}
			temp.add(curr);
			hSet.addAll(temp);
		}
		System.out.println(hSet.size());
		ArrayList<Integer> aList = new ArrayList<>();
		for(int aa : hSet) {
			aList.add(aa);
		}
		Collections.sort(aList);
		for(int zz : aList) {
			System.out.print(zz + " ");
		}
	}
}