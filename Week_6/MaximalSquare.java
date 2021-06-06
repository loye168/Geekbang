/**
* @Descriptor 最大正方形（华为、谷歌、字节跳动在半年内面试中考过）
* https://leetcode-cn.com/problems/maximal-square/submissions/
* 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
*输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]] 
  输出：4
* @auth luoye
* @Date 2021-6-6
**/
public class MaximalSquare{
public int maximalSquare(char[][] matrix) {
int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n + 1][m + 1];
        int max = 0;

        for (int i=1;i<=n;i++) {

            for (int j=1;j<=m;j++) {

                if (matrix[i - 1][j - 1] == '1') {

                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), 
                            dp[i][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}
