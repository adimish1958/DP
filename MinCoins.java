package DP;


//The problem of finding the minimum number of coins required to represent a given value 
//using a set of denominations
//is a classic dynamic programming problem known as the "Minimum Coin Change" problem.
public class MinCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum number of coins required: " + minCoins(coins, amount)); // Output: 3

	}

	private static int minCoins(int[] coins, int amount) {
		// TODO Auto-generated method stub
		int n=coins.length;
		int dp[]=new int[amount+1];
		for(int i=0;i<=amount;i++) {
			dp[i]=Integer.MAX_VALUE;
		}
		dp[0]=0;
		for(int i=1;i<=amount;i++) {
			for(int j=0;j<n;j++) {
				if(coins[j]<=i) {
					int subRes=dp[i-coins[j]];
					if(subRes!=Integer.MAX_VALUE && subRes+1<dp[i]) {
						dp[i]=subRes+1;
					}
				}
			}
		}
		return dp[amount];
	}

}
