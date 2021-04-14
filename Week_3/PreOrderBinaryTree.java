/**
@Descriptor 从前序与中序遍历序列构造二叉树（字节跳动、亚马逊、微软在半年内面试中考过）
@auth luoye
@Date 2021-4-14 23:51:20
**/
public class  PreOrderBinaryTree{
   public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,inorder,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder,int prestart,int[] inorder,int instart,int inend){
        if(prestart>=preorder.length)
            return null;
        if(inend<instart)
            return null;
        int index=find(preorder[prestart],inorder);
        TreeNode root=new TreeNode(preorder[prestart]);
        root.left=build(preorder,prestart+1,inorder,instart,index-1);
        root.right=build(preorder,prestart+index-instart+1,inorder,index+1,inend);
        return root;
    }
    private int find(int tofind,int[] inorder){
        for(int i=0;i<inorder.length;i++){
            if(tofind==inorder[i]){
                return i;
            }
        }
        return -1;
    }
} 

