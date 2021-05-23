/**
@Descriptor 单词接龙
https://leetcode-cn.com/problems/word-ladder/
输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
输出：5
解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
@auth luoye
@Date 2021-5-23
**/
public class LadderLength{
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //这里利用set的值的唯一性,其实这里的set就是queue
        Set<String> wordSet = new HashSet<>(wordList);
        //这里提前处理边界值，如果endword都不在wordList中，肯定最后不可转换成功
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endset = new HashSet<>();

        int len = 1;
        //备忘录，避免将wordSet中的单词重复添加
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endset.add(endWord);
        while (!beginSet.isEmpty() && !endset.isEmpty()) {
            //1 通过beginSet和endset的交换来实现双向BFS
            //第一次beginset前进,beginSet.size() > endset.size()，这时候交换，下一次前进的就是原来endset中的值
            if (beginSet.size() > endset.size()) {
                Set<String> set = beginSet;
                beginSet = endset;
                endset = set;
            }

            Set<String> temp = new HashSet<>();
            //2 每次对beginSet里的单词进行遍历和替换
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i=0; i<chs.length; i++) {
                    for (char c='a'; c<='z'; c++) {
                        char old = chs[i];  //使用old暂存
                        chs[i] = c; //将单词中某个字符依次替换成26个字母中的一个
                        String target = String.valueOf(chs);
                        // 两个方向遍历找到了重合的地方，满足条件，返回
                        if (endset.contains(target) && wordSet.contains(target)) {
                            return len+1;
                        }
                        //如果没访问过且在给定的list中,表示替换后的target满足条件，放入temp中，最后赋值给beginSet
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old; //还原
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}