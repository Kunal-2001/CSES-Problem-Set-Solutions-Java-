package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RectangleCutting {
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
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int dp[][] = new int [a+1][b+1];
		for(int i = 0 ; i < dp.length ; i++) {
			for(int j = 0 ; j < dp[0].length ; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				}else if(i == j){
					dp[i][j] = 0;
				}else {
					int minimum = Integer.MAX_VALUE;
					for(int k = 1 ; k <= i/2 ; k++) {
						minimum = Math.min(minimum, dp[k][j] + dp[i-k][j]);
					}
					for(int h = 1 ; h <= j/2 ; h++) {
						minimum = Math.min(minimum, dp[i][h] + dp[i][j-h]);
					}
					dp[i][j] = minimum+1;
				}
			}
		}
		System.out.println(dp[a][b]);
	}
}