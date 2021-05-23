/**
@Descriptor 最小基因变化
https://leetcode-cn.com/problems/minimum-genetic-mutation/
start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]
返回值: 1
@auth luoye
@Date 2021-5-23
**/
public class MinMutation{
int minStep = Integer.MAX_VALUE;
    char[] eml = new char[]{'A','C','G','T'};
    public int minMutation(String start, String end, String[] bank) {
        HashSet set = new HashSet(Arrays.asList(bank));
        //1.判断边界(1如果开始值，目标值为空，返回-1；若目标值不在基因库返回-1)
        if(null == start || "".equals(start)||null == end || "".equals(end))return -1;
        if(!set.contains(end)) return -1;
        if (set.contains(start)) set.remove(start);
        help(start,end,0,set);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    private void help(String start, String end,int step ,HashSet set){
        //1.结束递归条件(当变换后的字符串等于目标数组，结束迭代)
        if(start.equals(end)){
            minStep = Math.min(step,minStep);
            return;
        }
        //将字符串转化为数组，方便替换
        char[] stch = start.toCharArray();
        for (int i=0;i<stch.length;++i){
             char old = stch[i];//保留原始字段，在当前字符替换为所有可能情况,校验后还原（只替换一位元素）
            for(int j =0 ;j<eml.length;++j){
                stch[i] = eml[j];
                String newStart = new String(stch);
                if(set.contains(newStart)){//校验替换后字符串是否在基因库中，若存在则进入下一层
                    set.remove(newStart);
                    help(newStart,end,step+1,set);
                }
            }
            stch[i] = old;
        }
    }
}