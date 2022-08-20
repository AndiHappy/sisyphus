package l;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode095 {

    /**
     *
     *
     *
     * */

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        System.out.println(generateTrees(3));
    }


    public static List generateTrees(int n) {
        if(n==0) return new LinkedList(); //here is new line
        return generateSubtrees(1, n);
    }

    private static List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (s > e) {
            res.add(null); // empty tree
            return res;
        }

        for (int i = s; i <= e; ++i) {
            // 构建左节点
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            // 构建右节点
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);

            // 根据构造的左右的节点，进行构造这个树
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
