/**
@Descriptor 二叉树的最近公共祖先
@auth luoye
@Date 2021-4-14 23:19:30
**/
public class NearestBinaryTree{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p == root || q == root){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);  
        TreeNode right= lowestCommonAncestor(root.right,p,q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}