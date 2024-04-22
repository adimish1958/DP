package DP;

public class EqualSubsetSumPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] set = {1, 5, 11, 5};
        int n = set.length;
        System.out.println(isEqualSumPartition(set, n)); // true

        int[] set1 = {1, 5, 3};
        int n1 = set1.length;
        System.out.println(isEqualSumPartition(set1, n1)); // false

	}

	private static boolean isEqualSumPartition(int[] set, int n) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=set[i];
		}
		if(sum%2!=0)
			return false;
		
		int mem[][]=new int[sum+1][n+1];
		for(int i=0;i<mem.length;i++) {
			for(int j=0;j<mem[i].length;j++) {
				mem[i][j]=-1;
			}
		}
		
		return isSubsetSum(set,sum/2,n,mem);
	}

	private static boolean isSubsetSum(int[] set, int sum, int n, int[][] mem) {
		// TODO Auto-generated method stub
		if(sum==0)
			return true;
		if(n==0)
			return false;
		if(mem[sum][n]!=-1)
			return mem[sum][n]==1?true:false;
		
		if(set[n-1]>sum) {
			boolean flag=isSubsetSum(set,sum,n-1,mem);
			mem[sum][n]=flag?1:0;
			return flag;
		}
		boolean flag=isSubsetSum(set,sum-set[n-1],n-1,mem)||isSubsetSum(set,sum,n-1,mem);
		mem[sum][n]=flag?1:0;
		return flag;
		
	}

}
