public class MinPathSum {
  public static int minPathSum(int[][] grid) {
    int n = grid[0].length;
    int x = grid.length;
    int[][] cache = new int[x][n];
    cache[x-1][n-1] = grid[x-1][n-1];
    for (int i = x - 2; i >= 0; i--) {
      cache[i][n-1] = cache[i+1][n-1] + grid[i][n-1];
    }
    for (int j = n - 2; j >= 0; j--) {
      cache[x-1][j] = cache[x-1][j+1] + grid[x-1][j];
    }

    for (int i = x - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        int val1 = cache[i+1][j];
        int val2 = cache[i][j+1];
        cache[i][j] = Math.min(val1, val2) + grid[i][j];
      }
    }
    return cache[0][0];
  }
}
