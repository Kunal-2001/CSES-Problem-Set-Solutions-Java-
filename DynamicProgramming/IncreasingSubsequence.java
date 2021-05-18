package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IncreasingSubsequence {
	static long mod = 1000000007;

	static long power(long x, long y) {
		long res = 1;

		while (y > 0) {
			if ((y & 1) != 0)
				res = (res * x) % mod;
			y = y >> 1;
			x = (x * x) % mod;
		}
		return res;
	}
	static int binarySearch(int l , int r , ArrayList<Integer> al , int x) {
		int ans = -1;
		while(l <= r) {
			int mid = l + (r-l) / 2;
			if(al.get(mid) < x) {
				l = mid+1;
			}else if(al.get(mid) > x) {
				ans = mid;
				r = mid-1;
			}else {
				return -1;
			}
		}
		return ans;
	}

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
		for(int i = 0 ; i < n ; i++) {
			a[i] = sc.nextInt();
		}
		ArrayList<Integer> aList = new ArrayList<>();
		aList.add(a[0]);
		for(int i = 1 ; i < n ; i++) {
			if(a[i] > aList.get(aList.size()-1)) {
				aList.add(a[i]);
			}else if(a[i] == aList.get(aList.size()-1)) {
				continue;
			}else {
				int size = aList.size()-1;
				int el = binarySearch(0, size , aList, a[i]);
				if(el != -1) {
					aList.set(el, a[i]);
				}
			}
		}
		System.out.println(aList.size());
	}
}
