package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GridPaths {
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
		int t = sc.nextInt();
        char arr[][] = new char [t][t];
        for(int i = 0 ; i < t ; i++){
            String s = sc.nextLine();
            for(int j = 0 ; j < t ; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        long dp[][] = new long [t+1][t+1];
        for(int i = 0 ; i < t+1 ; i++){
            for(int j = 0 ; j < t+1 ; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if((i == 1 && j == 1) && arr[i-1][j-1] == '.'){
                    dp[i][j] = 1;
                }else{
                    if(arr[i-1][j-1] == '.'){
                        dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
                    }else{
                        dp[i][j] = 0;   
                    }
                }
            }
        }
        System.out.println(dp[t][t] % mod);
	}
}
