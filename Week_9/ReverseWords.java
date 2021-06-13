/**
*@Descriptor  翻转字符串里的单词
*  说明：
*输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
*翻转后单词间应当仅用一个空格分隔。
*翻转后的字符串中不应包含额外的空格。
*
输入：s = "  hello world  "
输出："world hello"
解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
*
*https://leetcode-cn.com/problems/reverse-words-in-a-string/
*
*
**/
public class ReverseWords{
      public String reverseWords(String s) {
              String[] s1=s.split(" ");
        StringBuilder ans=new StringBuilder();
        for (int i = s1.length-1; i >=0 ; i--) {
            if ((s1[i]).length()!=0){
                ans.append(s1[i]+" ");
            }
        }
        return ans.toString().trim();
    }
}