package DP;

public class Fibonacci {
	
	public int calFib(int n) {
		int mem[] = new int[n+1];
		return calFib(n,mem);
	}

	private int calFib(int n, int[] mem) {
		// TODO Auto-generated method stub
		if(n<2)
			return n;
		mem[n]=calFib(n-1,mem)+calFib(n-2,mem);
		return mem[n];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci fc=new Fibonacci();
		System.out.println("fibonaci value is"+fc.calFib(7));

	}

}
