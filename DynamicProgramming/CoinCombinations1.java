package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinCombinations1 {
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
		int x = sc.nextInt();
		
		int a[] = new int [n];
		for(int i = 0 ; i < n ; i++){
		    a[i] = sc.nextInt();
		}
		int dp[] = new int [x+1];
	    dp[0] = 1;
	    for(int i = 1 ; i <= x ; i++){
	        for(int j = 0 ; j < n ; j++){
//	            if(i < a[j])continue;
	            if(i- a[j] >= 0){
//	            	int z = (int)(i-a[j]);
//	            	(dp[i] += dp[i-c[j]]) %= mod;
	            	dp[i] += dp[i-a[j]];
	            	dp[i] = dp[i] % mod;
//	                dp[i] = (dp[i] + dp[i-a[j]]) % mod;
	            }
	        }
	        
	    }
	    System.out.println(dp[x] % mod);
	}
}