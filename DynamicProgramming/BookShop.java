package DynamicProgramming;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BookShop {
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
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int x = fs.nextInt();
        int price[] = new int [n];
		int pages[] = new int [n];
		for(int i = 0 ; i < n ; i++){
		    price[i] = fs.nextInt();
		}
		for(int i = 0 ; i < n ; i++){
		    pages[i] = fs.nextInt();
		}
		int dp[][] = new int [n+1][x+1];
		for(int i = 1 ; i < dp.length ; i++){
		    for(int j = 0 ; j < dp[0].length ; j++){
		    	dp[i][j] = dp[i-1][j];
		        int left = j-price[i-1];
		        if (left >= 0) {
		        	dp[i][j] = Math.max(dp[i][j], dp[i-1][left]+pages[i-1]);
		        }
		    }
		}
		System.out.println(dp[n][x]);
    }
}
