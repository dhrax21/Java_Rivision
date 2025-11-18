package BinaryTrees;

import java.util.Stack;

public class HasPathSum {
    public boolean hasPathSum(SymmetricTree.TreeNode root, int targetSum) {
        if(root==null) return false;

        Stack<SymmetricTree.TreeNode> path=new Stack<>();
        Stack<Integer> sumPath=new Stack<>();

        path.push(root);
        sumPath.push(root.val);

        while(!path.isEmpty()){
            SymmetricTree.TreeNode temp=path.pop();
            int tempVal=sumPath.pop();

            if(temp.left==null && temp.right==null && tempVal==targetSum){
                return true;
            }

            if(temp.right != null){
                path.push(temp.right);
                sumPath.push(temp.right.val+tempVal);
            }
            if(temp.left != null){
                path.push(temp.left);
                sumPath.push(temp.left.val + tempVal);
            }
        }
        return false;
    }
}
