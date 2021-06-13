/**
*@Descriptor 颠倒二进制位
* 颠倒给定的 32 位无符号整数的二进制位
*输入：11111111111111111111111111111101
*输出：10111111111111111111111111111111
*解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
*因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111
*
*https://leetcode-cn.com/problems/reverse-bits/
*@auth luoye
*@Date 2021-6-13
*
**/
public class ReverseBits{
     public int reverseBits(int n) {
        int output = 0;
        for(int i = 0; i < 32; i++){
            output = output | (((n >>> i) & 1 ) << (31 - i));
        }
        return output;
    }
}