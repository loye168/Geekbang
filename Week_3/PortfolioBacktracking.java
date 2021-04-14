/**
@Descriptor 组合回溯算法
@auth luoye
@Date 2021-4-14 23:43:25
**/

public class PortfolioBacktracking{
	List<List<Integer>> lists =new ArrayList<>();
    List<Integer> list=new ArrayList<>();
    int num=0;
    public List<List<Integer>> combine(int n, int k) {
        int[] a=new int[n];
        num=k;
        for(int i=0;i<n;i++){
            a[i]=i+1;
        }
        dfs(a,0);
        return lists;
    }
    public void dfs(int[] a,int i){
        if(list.size() == num){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(i == a.length){
            return;
        }
        list.add(a[i]);
        dfs(a,i+1);
        list.remove(list.size()-1);
        dfs(a,i+1);
    }
}
