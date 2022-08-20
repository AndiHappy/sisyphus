package l;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {


    /**
     * Given the root of a binary tree and an integer targetSum,
     * return all root-to-leaf paths where each path's sum equals targetSum.
     *
     * A leaf is a node with no children.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * Output: [[5,4,11,2],[5,8,4,5]]
     * Example 2:
     *
     *
     * Input: root = [1,2,3], targetSum = 5
     * Output: []
     * Example 3:
     *
     * Input: root = [1,2], targetSum = 0
     * Output: []
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 5000].
     * -1000 <= Node.val <= 1000
     * -1000 <= targetSum <= 1000
     *
     * */


    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        // [5,4,8,11,null,13,4,7,2,null,null,5,1]
        //22
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//
//        //4
//        root.left.left = new TreeNode(11);
//
//        //8
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//
//        //11
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        //4
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right=new TreeNode(1);
//
        System.out.println(pathSum(root,5));


    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        pathSum(root,result,targetSum,0,new ArrayList<>());
        return result;
    }


    private  static void pathSum(TreeNode root,  List<List<Integer>> result,int targetSum, int i, ArrayList<Integer> es) {
        if(root == null){
            return;
        }else if(root != null){
            es.add(root.val);
            if(i+ root.val == targetSum && root.left ==null && root.right == null){
                result.add(new ArrayList<>(es));
                es.remove(es.size()-1);
                return;
            }else{
                if(root.left != null){
                    pathSum(root.left,result,targetSum,i+root.val,es);
                }

                if(root.right != null){
                    pathSum(root.right,result,targetSum,i+root.val,es);
                }
            }
            es.remove(es.size()-1);
        }



    }
}