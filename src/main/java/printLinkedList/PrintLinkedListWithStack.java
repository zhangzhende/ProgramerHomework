package printLinkedList;

import java.util.Stack;

/**
 * @Description 从尾到头打印链表
 * 使用栈的方式
 * @ClassName PrintLinkedList
 * @Author zzd
 * @Date 2019/9/19 15:53
 * @Version 1.0
 **/
public class PrintLinkedListWithStack {

    public static void main(String[] args) {
        Node node = getMockData(10);
        Stack<Node> stack = new Stack();
        while (node.next != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.empty()) {
            Node out = stack.pop();
            System.out.println(out.toString());
        }
    }


    private static Node getMockData(int size) {
        Node node = new Node(0, null);
        for (int i = 1; i < size; i++) {
            Node newnode = new Node(i, node);
            node = newnode;
        }
        return node;
    }


    static class Node {
        private int value;

        private Node next;

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
