/**
@Descriptor 分发饼干
https://leetcode-cn.com/problems/assign-cookies/
输入: g = [1,2,3], s = [1,1]
输出: 1 
@auth luoye
@Date 2021-5-12
**/
public class DistrCookies{
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, sj = 0;
        while (gi < g.length && sj < s.length) {
            if (g[gi] <= s[sj]) {
                gi++;  //满足时gi加1
            }
            sj++;  //满足不满足 同时加1
        }
        return gi;
    }
}