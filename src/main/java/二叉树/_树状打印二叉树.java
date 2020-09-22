package 二叉树;

/**
 * @author hanbing
 * @date 2019-12-27 10:55
 */
public class _树状打印二叉树 {

    //树状打印一个二叉树
    public static String toString(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        toString(root, sb, "");

        return sb.toString();
    }

    private static void toString(TreeNode node, StringBuilder sb, String prefix) {
        if (node == null) return;

        sb.append(prefix).append(node.val).append("\n");

        toString(node.left, sb, prefix + "L---");
        toString(node.right, sb, prefix + "R---");
    }
}
