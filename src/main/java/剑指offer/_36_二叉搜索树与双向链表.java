package 剑指offer;


//https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
public class _36_二叉搜索树与双向链表 {

    public Node treeToDoublyList(Node root) {
        if (root==null) return null;
        Node core = core(root);
        while (core.left!=null){
            core = core.left;
        }
        Node last = core;
        while (last.right!=null){
            last = last.right;
        }
        core.left = last;
        last.right = core;

        return core;
    }

    public Node core(Node root){
        if (root == null) return null;
        if (root.left==null && root.right==null) return root;

        Node left = core(root.left);
        Node right = core(root.right);

        if (left!=null){
            while (left.right!=null){
                left = left.right;
            }
            root.left = left;
            left.right = root;
        }
        if (right!=null){
            while (right.left!=null){
                right = right.left;
            }
            root.right = right;
            right.left = root;
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        _36_二叉搜索树与双向链表 example = new _36_二叉搜索树与双向链表();
        Node node = example.treeToDoublyList(root);
        int i = 9;
    }
}
