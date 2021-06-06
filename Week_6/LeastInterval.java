/**
 *
 @Descriptor  任务调度器（Facebook 在半年内面试中常考）
https://leetcode-cn.com/problems/task-scheduler/
给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表
输入：tasks = ["A","A","A","B","B","B"], n = 2
输出：8
解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
@auth luoye
@Date 2021-6-6
 *
 */
public class LeastInterval{
 public int leastInterval(char[] tasks, int n) {
  if (n == 0) {
        return tasks.length;
    }
    // 统计每个任务的次数
    int[] counts = new int[26];
    for (char ch : tasks) {
        counts[ch - 'A']++;
    }
    // maxExec 最多的任务的次数
    // maxCount 有maxExec次的任务有多少个
    int maxExec = 0, maxCount = 0;
    for (int i = 0; i < 26; i++) {
        if (counts[i] > maxExec) {
            maxExec = counts[i];
            maxCount = 1;
        } else if (counts[i] == maxExec) {
            maxCount++;
        }
    }
    return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}