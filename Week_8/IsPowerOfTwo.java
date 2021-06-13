/**
*@Descriptor 2 的幂
* 返回其二进制表达式中数字位数为 '1' 的个数
* https://leetcode-cn.com/problems/power-of-two/
*输入：n = 1
*输出：true
*解释：2零次方= 1
*@auth luoye
*@Date 2021-6-13
*
**/
public class IsPowerOfTwo{
    public boolean isPowerOfTwo(int n) {
        if(n>0){
          return Integer.bitCount(n) == 1;
        }
        return false;
    }
}