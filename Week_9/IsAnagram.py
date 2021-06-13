"""
* @Descriptor 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
* https://leetcode-cn.com/problems/valid-anagram/
*输入: s = "anagram", t = "nagaram"
*输出: true
*@auth luoye
*@Date 2021-6-13
"""
from collections import Counter
class IsAnagram:
   def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        s_count = Counter(s)
        t_count = Counter(t)
        for key, value in s_count.items():
            t_value = t_count.get(key, 0)
            if value != t_value:
                return False
        return True