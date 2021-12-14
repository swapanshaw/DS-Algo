package com.com.swapan.ds.matrix;

/* Java program for Dynamic Programming implementation
of Min Cost Path problem */

class MinimumCostPath
{
	/* A utility function that returns minimum of 3 integers */
	private static int min(int x, int y, int z)
	{
		if (x < y)
			return (x < z)? x : z;
		else
			return (y < z)? y : z;
	}

	private static int minCost(int cost[][], int m, int n)
	{
		int i, j;
		int tc[][]=new int[m+1][n+1];

		tc[0][0] = cost[0][0];

		/* Initialize first column of total cost(tc) array */
		for (i = 1; i < m; i++)
			tc[i][0] = tc[i-1][0] + cost[i][0];

		/* Initialize first row of tc array */
		for (j = 1; j < n; j++)
			tc[0][j] = tc[0][j-1] + cost[0][j];

		/* Construct rest of the tc array */
		for (i = 1; i < m; i++)
			for (j = 1; j < n; j++)
				tc[i][j] = min(tc[i-1][j-1],
							tc[i-1][j],
							tc[i][j-1]) + cost[i][j];

		return tc[m-1][n-1];
	}

	/* Driver program to test above functions */
	public static void main(String args[])
	{
		int cost[][]= {{1, 2, 3},
					{4, 5, 6}};

		//System.out.println(cost.length);
		//System.out.println(cost[0].length);
		System.out.println(minPathSum(cost));
	}




	static int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		int dp[][] = new int[row+1][col+1];

		dp[0][0] = grid[0][0];

		//fill 1st row
		for(int i=1; i< col; i++) {
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}

		//fill 1st col
		for(int i=1; i<row; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}

		for(int i = 1; i < row; i++) {
			for(int j=1; j <col; j++) {

				dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}


		return dp[row-1][col-1];
	}
}
// This code is contributed by Pankaj Kumar
