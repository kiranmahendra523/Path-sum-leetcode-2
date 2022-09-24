import java.util.*;

class Solution {
        public void solve(TreeNode root,List<Integer> temp,List<List<Integer>> lt,int sum){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null&&((sum-root.val)==0)){
            temp.add(root.val);
            lt.add(new ArrayList(temp));
            temp.remove(temp.size()-1);
            return;
        }
        if(root.left!=null){
            temp.add(root.val);
            sum -= root.val;
            solve(root.left,temp,lt,sum);
            temp.remove(temp.size()-1);
            sum += root.val;
        }
        if(root.right!=null){
            temp.add(root.val);
            sum -= root.val;
            solve(root.right,temp,lt,sum);
            temp.remove(temp.size()-1);
            sum += root.val;
        }
        return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lt = new ArrayList();
        solve(root,new ArrayList(),lt,targetSum);
        return lt;
        
    }
}
