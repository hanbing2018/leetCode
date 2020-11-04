package 算法;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hanbing
 * @date 2020-11-04 20:07
 */
public class _判断图是否有环 {

    //判断图是否有环，使用dfs方法
    public boolean isCycle(List<Node> mapp) {
        if (mapp == null || mapp.size() == 0) {
            return false;
        }

        for (Node node : mapp) {
            List<Node> visited = new LinkedList<>();
            if (cycle(node, visited)) return true;
        }
        return false;
    }

    public boolean cycle(Node root, List<Node> visited) {
        if (root == null) return false;
        if (visited.contains(root)) return true;
        //将当前节点放入visited列表中
        visited.add(root);
        for (Node nextNode : root.nextNodes) {
            if (cycle(nextNode, visited)) return true;
        }

        return false;
    }


    //图的节点
    private static class Node {
        public int value;
        public List<Node> nextNodes;

        public Node() {
        }

        public Node(int value, List<Node> nextNodes) {
            this.value = value;
            this.nextNodes = nextNodes;
        }
    }
}

