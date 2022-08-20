package l;

import util.PrintUtil;
import util.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode297 {

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        LeetCode297 test = new LeetCode297();
        TreeNode root = PrintUtil.costructTreeNode("[1,2,3,null,null,4,5]");
        System.out.println(root);
        String value = test.serialize(root);
        System.out.println(value);
    }

    private static final String spliter = ",";
    private static final String NN = "X";

    // 中序遍历的成序列
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }

    // 反序列化，首先是根据间隔符得到节点元素，然后在
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
