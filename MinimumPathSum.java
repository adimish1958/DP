import java.util.Arrays;
/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 */
public class MinimumPathSum {
	
	public static int minPathSum(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int dp[][] = new int[r][c];
        for(int i=0;i<r;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int one=Integer.MAX_VALUE;
                int two=Integer.MAX_VALUE;
                if(i==j && i==0){
                    dp[0][0]=grid[0][0];
                    continue;
                }
                if(i>0)
                one=dp[i-1][j]+grid[i][j];
                if(j>0)
                two=dp[i][j-1]+grid[i][j];
                dp[i][j]=Math.min(one,two);
            }
        }

        return dp[r-1][c-1];


    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[][] grid = { { 31, 100, 65, 12, 18 },
                { 10, 13, 47, 157, 6 },
                { 100, 113, 174, 11, 33 },
                { 88, 124, 41, 20, 140 },
                { 99, 32, 111, 41, 20 } };
                */
		int [][] grid= {{1,3,1},{1,5,1},{4,2,1}};
				
                 
		System.out.println(minPathSum(grid));

	}

}
