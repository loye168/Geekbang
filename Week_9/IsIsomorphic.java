/**
*@Descriptor  同构字符串
*  说明：
给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的

输入：s = "egg", t = "add"
输出：true
*
*https://leetcode-cn.com/problems/isomorphic-strings/
*
*
**/
class IsIsomorphic{
    public boolean isIsomorphic(String s, String t) {
  if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
   
}