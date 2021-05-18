package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSets {
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
		int sum = (n*(n+1)) / 2;
		if(sum % 2 == 0) {
			int half = sum / 2;
			long dp[][] = new long [n+1][half+1];
			for(int i = 0 ; i < dp.length ; i++) {
				for(int j = 0 ; j < dp[i].length ; j++) {
					if(j == 0) {
						dp[i][j] = 1;
					}else if(i == 0) {
						dp[i][j] = 0;
					}else {
						dp[i][j] = dp[i-1][j] % mod;
						if(j - i >= 0 && dp[i-1][j-i] != 0) {
							dp[i][j] += (dp[i-1][j-i] % mod);
						}
					}
				}
			}
			System.out.println(dp[n][half] / 2);
		}else {
			System.out.println(0);
		}
	}
}