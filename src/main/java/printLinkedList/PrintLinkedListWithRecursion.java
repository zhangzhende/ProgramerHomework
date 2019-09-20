package printLinkedList;

/**
 * @Description 从尾到头逆序输出链表
 * 使用递归方式
 * @ClassName PrintLinkedListWithRecursion
 * @Author zzd
 * @Date 2019/9/19 16:09
 * @Version 1.0
 **/
public class PrintLinkedListWithRecursion {


    public static void main(String[] args) {
        Node node = getMockData(10);
        printNode(node);

    }

    private static void printNode(Node node) {
        if (null != node.next) {
            printNode(node.next);
        }
        System.out.println(node);


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
