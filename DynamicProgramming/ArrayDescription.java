package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayDescription {
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
		int m = sc.nextInt();
		int numbers[] = new int [n];
		for(int i = 0 ; i < n ; i++) {
			numbers[i] = sc.nextInt();
		}
		long dp[][] = new long [m][n];
		for(int i = 0  ; i < n ; i++) {
			for(int j = 0 ; j < m; j++) {
				if(i == 0) {
					if(numbers[i] != 0) {
						dp[numbers[i]-1][i] = 1;
						break;
					}else {
						dp[j][i] = 1;
					}
				}else {
					if(numbers[i] == 0) {
						if(j == 0) {
							dp[j][i] = (dp[j][i-1] % mod + dp[j+1][i-1] % mod) % mod;
						}else if(j == m-1) {
							dp[j][i] = (dp[j][i-1] % mod + dp[j-1][i-1] % mod) % mod; 
						}else {
							dp[j][i] = (dp[j][i-1] % mod + dp[j-1][i-1] % mod + dp[j+1][i-1] % mod) % mod;
						}
					}else {
						if(numbers[i] == 1) {
							dp[numbers[i]-1][i] = (dp[numbers[i]-1][i-1] % mod + dp[numbers[i]][i-1] % mod) % mod;
							break;
						}else if(numbers[i] == m) {
							dp[numbers[i]-1][i] = (dp[numbers[i]-1][i-1] % mod + dp[numbers[i]-2][i-1] % mod) % mod;
							break;
						}else {
							dp[numbers[i]-1][i] = (dp[numbers[i]-1][i-1] % mod + dp[numbers[i]][i-1] % mod + dp[numbers[i]-2][i-1] % mod) % mod;
							break;
						}
					}
				}
			}
		}
		long ans = 0;
		for(int i = 0 ; i < m ; i++) {
			ans += dp[i][n-1] % mod;
		}
		System.out.println(ans%mod);
	}
}