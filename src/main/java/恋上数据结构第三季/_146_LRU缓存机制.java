package 恋上数据结构第三季;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanbing
 * @date 2020-10-14 21:56
 */

//https://leetcode-cn.com/problems/lru-cache/
public class _146_LRU缓存机制 {

    /**
     * 总体思路：HashMap加双向链表实现
     */

    //存储节点
    private Map<Integer, Node> map;
    //容量
    private int capacity;
    //虚拟头结点
    private Node first;
    //虚拟尾结点
    private Node tail;

    /**
     * 构造方法
     *
     * @param capacity
     */
    public _146_LRU缓存机制(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        first = new Node();
        tail = new Node();

        first.next = tail;
        tail.prev = first;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        //将访问过的元素放到链表最前边
        removeNode(node);
        addAfterFirst(node);
        return node.value;
    }

    /**
     * 将节点插入到头结点后边
     *
     * @param node
     */
    private void addAfterFirst(Node node) {
        node.prev = first;
        node.next = first.next;

        node.prev.next = node;
        node.next.prev = node;
    }

    /**
     * 从双向链表中删除节点
     *
     * @param node
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) { //更新
            node.value = value;
            removeNode(node);
            addAfterFirst(node);
        } else {
            if (map.size() == capacity) { //需要淘汰最近最少使用的一个元素
                Node nodeToDel = map.remove(tail.prev.key);
                removeNode(nodeToDel);
            }
            Node nodeToAdd = new Node(key, value);
            addAfterFirst(nodeToAdd);
            map.put(key, nodeToAdd);
        }
    }

    //自定义双向链表的节点
    private static class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
