package DP;

public class Knapsack01 {
	
	/*
	 * public int knapsackRecur(int p[],int w[],int cap, int n) { int mem[][]=new
	 * int[n+1][cap+1]; for (int i = 0; i < n+1 + 1; i++) for (int j = 0; j < cap +
	 * 1; j++) mem[i][j] = -1; return knapsackRecur(p,w,cap,n, mem); }
	 * 
	 * private int knapsackRecur(int[] p, int[] w, int cap, int n, int mem[][]) { //
	 * TODO Auto-generated method stub if(cap==0||n==0) { return 0; }
	 * if(mem[n][cap]!=-1) { return mem[n][cap]; } int p1=0; if(w[n-1]<=cap) {
	 * p1=p[n-1]+knapsackRecur(p,w,cap-w[n-1],n-1,mem);
	 * 
	 * int p2=knapsackRecur(p,w,cap,n-1,mem);
	 * 
	 * mem[n][cap]=Math.max(p1, p2); } return mem[n][cap]; }
	 * 
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * Knapsack01 ks=new Knapsack01(); int p[]= { 60, 100, 120 }; int w[]= { 10, 20,
	 * 30 }; int cap=50; int n=p.length; System.out.println("max profit is" +
	 * ks.knapsackRecur(p,w,cap,n));
	 * 
	 * }
	 */
	static int knapSackRec(int W, int wt[], int val[],
			int n, int[][] dp)
	{

		// Base condition
		if (n == 0 || W == 0)
			return 0;

		if (dp[n][W] != -1)
			return dp[n][W];

		if (wt[n - 1] > W)

			// Store the value of function call
			// stack in table before return
			return dp[n][W]
					= knapSackRec(W, wt, val, n - 1, dp);

		else

			// Return value of table after storing
			return dp[n][W]
					= Math.max((val[n - 1]
							+ knapSackRec(W - wt[n - 1], wt, val,
									n - 1, dp)),
							knapSackRec(W, wt, val, n - 1, dp));
	}

	static int knapSack(int W, int wt[], int val[], int N)
	{

		// Declare the table dynamically
		int dp[][] = new int[N + 1][W + 1];

		// Loop to initially filled the
		// table with -1
		for (int i = 0; i < N + 1; i++)
			for (int j = 0; j < W + 1; j++)
				dp[i][j] = -1;

		return knapSackRec(W, wt, val, N, dp);
	}

	// Driver Code
	public static void main(String[] args)
	{
		int profit[] = { 60, 100, 120 };
		int weight[] = { 10, 20, 30 };

		int W = 50;
		int N = profit.length;

		System.out.println(knapSack(W, weight, profit, N));
	}
}
