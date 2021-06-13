/**
*@Descriptor 数组的相对排序
* 给你两个数组，arr1 和 arr2，
*arr2 中的元素各不相同
*arr2 中的每个元素都出现在 arr1 中

*输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
*输出：[2,2,2,1,4,3,3,9,6,7,19]
*https://leetcode-cn.com/problems/relative-sort-array
*@auth luoye
*@Date 2021-6-13
*
**/
public class RelativeSortArray{
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] tmp=new int [1001];
        int n=arr1.length;
        for(int num:arr1){
            tmp[num]++;
        }
        int pos=0;      //arr1中索引的位置 也是arr2中含有的数字在arr1中的最大长度
        for(int num:arr2){
            while(tmp[num]>0){
                arr1[pos++]=num;
                tmp[num]--;
            }
        }
        //int check=pos;  这里是arr2中没有的值开始的位置。
        for(int i=0;i<1001;++i){
            while(tmp[i]>0){
                arr1[pos++]=i;
                tmp[i]--;
            }
        }
        //Arrays.sort(arr1,check,n);   不需要排序  计数排序在数组中遍历时已经是有序
        return arr1;
    }
}