package DP;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="AGGTAB";
		String s2="GXTXAXB";
		char x[] = s1.toCharArray();
		char y[]= s2.toCharArray();
		int m=x.length;
		int n=y.length;
		System.out.println("Longest common subsequence length " + LCS(x,m,y,n));

	}

	private static int LCS(char[] x, int m, char[] y, int n) {
		// TODO Auto-generated method stub
		if(m==0)
			return 0;
		if(n==0)
			return 0;
		int mem[][]=new int[m+1][n+1];
		if(x[m-1]==y[n-1]) {
			mem[m][n]=1+LCS(x,m-1,y,n-1);
		}
		else {
			mem[m][n]= Math.max(LCS(x,m,y,n-1), LCS(x,m-1,y,n));
		}
		return mem[m][n];
		
	}

}
