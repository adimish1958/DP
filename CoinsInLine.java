package DP;

public class CoinsInLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {8, 15, 3, 7};
        System.out.println("Maximum value that can be obtained: " + maxCoins(coins));

	}

	private static int maxCoins(int[] coins) {
		// TODO Auto-generated method stub
		// Function to find the maximum value that can be obtained
	    // by a player, given the values of the coins
		int n=coins.length;
		int dp[][]=new int[n+1][n+1];
		for(int gap=0;gap<n;gap++) {
			for(int i=0,j=gap;j<n;i++,j++) {
				int x=i+2<=j?dp[i+2][j]:0;
				int y=i+1<=j-1?dp[i+1][j-1]:0;
				int z=i<=j-2?dp[i][j-2]:0;
				dp[i][j]=Math.max(coins[i]+Math.min(x, y), coins[j]+Math.min(y, z));
				//System.out.println("first player sum: " + coins[i]+Math.min(x, y) + "second player sum: "+coins[j]+Math.min(y, z) );
			}
		}
		return dp[0][n-1];
	}

}
