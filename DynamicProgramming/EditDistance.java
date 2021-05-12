package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EditDistance {
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
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		long dp[][] = new long [s1.length()+1][s2.length()+1];
		for(int i = 0 ; i < dp.length ; i++) {
			for(int j = 0 ; j < dp[0].length ; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = 0;
				}else if(i == 0) {
					dp[i][j] = j;
				}else if(j == 0) {
					dp[i][j] = i;
				}else {
						if(s1.charAt(i-1) == s2.charAt(j-1)) {
							dp[i][j] = dp[i-1][j-1];
						}else {
							dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
						}
				}
					
			}
		}
		System.out.println(dp[s1.length()][s2.length()]);
	}
}