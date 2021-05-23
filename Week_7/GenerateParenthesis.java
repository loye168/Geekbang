/**
@Descriptor 括号生成
https://leetcode-cn.com/problems/generate-parentheses/
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
@auth luoye
@Date 2021-5-23
**/
public class GenerateParenthesis{
public List<String> generateParenthesis(int n) {
		dfs(0,0,"",n);
		return res;
	}
	
	List<String> res = new ArrayList<String>();
	//递归函数
	void dfs(int left,int right,String tmp,int n) {
		//递归函数的终止条件
		if(left==n && right==n) {
			res.add(tmp);
			return;
		}
		//注意左括号的数量要小于参数n，即输入的n为3时
		//最多只能生成3个左括号
		if(left<n) {
			dfs(left+1,right,tmp+"(",n);
		}
		//右括号的数量也要小于n，左括号的数量要 大于 右括号数量
		//因为 ((( 是合法的(假设程序还没处理完)
		//而),)),)))都是不合法的
		if(left>right && right<n) {
			dfs(left,right+1,tmp+")",n);
		}
	}

}