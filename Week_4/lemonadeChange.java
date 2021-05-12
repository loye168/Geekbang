/**
@Descriptor 柠檬水找零
https://leetcode-cn.com/problems/lemonade-change/description/
输入：[5,5,5,10,20]
输出：true
@auth luoye
@Date 2021-5-12
**/
public class lemonadeChange{
  public boolean lemonadeChange(int[] bills) {
        //初始化，钱罐开始没有钱
       int count5 = 0;
        int count10 = 0;

        for (int i = 0; i < bills.length; i++) {//每一个顾客付钱都是一次循环
            if (bills[i] == 10) {//客人给的是10块的
                if (count5 == 0) {//钱罐没有5块，直接false
                    return false;
                }
                count5 -= 1;//钱罐拿出一张5块找
                count10 += 1;//钱罐加入得到的10块
            } else if (bills[i] == 20) {//客人给的是20块
                if (count10 == 0) {//钱罐没有10块的
                    if (count5 < 3) {//且钱罐中5块少于三张，则直接false
                        return false;
                    }
                    count5 -= 3;//用三张5块找20，钱罐加入一张20块的，不用奇数，找钱用不上
                } else {//钱罐有10块的
                    if (count5 < 1) {//钱罐有10块，但是没有5块的，找不了，直接false
                        return false;
                    }
                    //使用一张5块，一张十块找钱,20块直接扔进钱罐，不用奇数，找钱用不上
                    count5 -= 1;//
                    count10 -= 1;
                }
            } else {
                //顾客给的是5块的，不用找，直接往钱罐仍并计数
                count5++;
            }
        }
        return true;
    }
}