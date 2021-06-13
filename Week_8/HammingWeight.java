/**
*@Descriptor 编写一个函数，输入是一个无符号整数（以二进制串的形式）
* 返回其二进制表达式中数字位数为 '1' 的个数
*https://leetcode-cn.com/problems/number-of-1-bits/
*输入：00000000000000000000000000001011
*输出：3
*解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
*@auth luoye
*@Date 2021-6-13
*
**/
public class HammingWeight{
    public int hammingWeight(int n) {
        int res = 0;
        for(int i =0;i<32;i++){
            if((n>>i&1)==1){
                res++;
            }
        }
        return res;
    }
}