package 二叉树;


import sun.reflect.generics.tree.Tree;

/**
 * @author hanbing
 * @date 2019-12-28 10:26
 */

//https://leetcode-cn.com/problems/delete-node-in-a-bst/

public class _450_删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null; //空树

        TreeNode node = toDel(root, key);  //找到需要删除的节点，如果不存在直接返回root
        if (node == null) return root;

        TreeNode pa = toDelPa(root, key);  //找到需要删除的节点的父节点

        if (hasTwoChildren(node)){   //如果节点度为2，必有前驱节点
            TreeNode be = before(node); //找到其前驱节点，用其值覆盖node的值，再删除前驱节点
            pa = toDelPa(root, be.val);  //前驱节点的父节点
            node.val = be.val;
            node = be;
        }

        //删除度为0或1的节点
        TreeNode replace = node.left!=null ? node.left : node.right;

        if (replace == null && pa==null){ //node为叶子节点、根节点
            return null;
        }
        if (replace==null && pa!=null){ //node为叶子节点，非根节点
            if (node==pa.left){
                pa.left = null;
                return root;
            }
            if (node==pa.right){
                pa.right = null;
                return root;
            }
        }
        if (replace!=null && pa==null){  //node度为1，且为根节点
            root = replace;
            return root;
        }
        if (replace!=null && pa!=null){  //node度为1，非根节点
            if (node==pa.left){
                pa.left = replace;
                return root;
            }
            if (node==pa.right){
                pa.right = replace;
                return root;
            }
        }
        return root;
    }

    //找到度为2的节点的前驱节点
    private TreeNode before(TreeNode node) {
        TreeNode be = node.left;
        while (be.right!=null){
            be = be.right;
        }
        return be;
    }

    private boolean hasTwoChildren(TreeNode node) {
        return (node.left!=null && node.right!=null);
    }


    //找到需要删除的节点的父节点
    private TreeNode toDelPa(TreeNode root, int key) {
        if (root.val == key) return null; // 根节点的父节点为null
        TreeNode node = root;
        TreeNode pa = node;

        while (node != null){
            if (key>node.val) {
                pa = node;
                node = node.right;
                continue;
            }
            if (key<node.val) {
                pa = node;
                node = node.left;
                continue;
            }
            if (key==node.val) return pa;
        }
        return pa;
    }

    private TreeNode toDel(TreeNode root, int key) {
        TreeNode node = root;

        while (node != null){
            if (key>node.val) {
                node = node.right;
                continue;
            }
            if (key<node.val) {
                node = node.left;
                continue;
            }
            if (key==node.val) return node;
        }
        return node;
    }


    //递归解法
    public TreeNode deleteNode2(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(key == root.val){
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else {
                TreeNode node = root.right;
                while(node.left != null){
                    node = node.left;
                }
                node.left = root.left;
                return root.right;
            }
        } else if(key > root.val) {
            root.right = deleteNode(root.right,key);
        } else {
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
}
