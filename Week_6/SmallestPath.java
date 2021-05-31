/**
 *
 @Descriptor 最小路径之和
https://leetcode-cn.com/problems/minimum-path-sum/
输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。

输入：grid = [[1,2,3],[4,5,6]]
输出：12
@auth luoye
@Date 2021-5-31
 *
 */
public class SmallestPath{
   public int minPathSum(int[][] grid) {
      // 特殊值判断
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // 创建dp数组
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        // 初始化第一行
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 初始化第一列
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // 两层for循环填充每个节点，值为到该节点所需要的最小路径。每一次都是一个局部最优解
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                // 因为只能往下和往右走，所以考虑上一个节点和左边的节点哪一个需要的路径小
                // 就+上本节点的值然后填充到这个节点 dp[i -1][j],表示从上一个节点来的，也就是往下走
                // 来到的这个节点，dp[i][j - 1]表示往右走才来到的这个节点。判断该节点从哪里走过来路径小
                // 然后加上自己的路径，就是到达这个节点的答案。也是一个局部最优解
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[rows - 1][columns - 1];
    }

}
