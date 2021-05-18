package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimizingCoins {
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
		long a[] = new long [n];
		for(int i = 0 ; i < n ; i++){
		    a[i] = sc.nextLong();
		}
		long dp[] = new long [x+1];
		for(int i = 0 ; i <= x ; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
	    dp[0] = 0;
	    for(int i = 1 ; i <= x ; i++){
	        for(int j = 0 ; j < n ; j++){
	            if(i- a[j] >= 0){
	            	int z = (int)(i-a[j]);
	                dp[i] = Math.min(dp[i] , dp[z]+1);
	            }
	        }
	        
	    }
	   if(dp[x] == Integer.MAX_VALUE){
	       System.out.println("-1");
	   }else{
	       System.out.println(dp[x]);
	   }
	}
}