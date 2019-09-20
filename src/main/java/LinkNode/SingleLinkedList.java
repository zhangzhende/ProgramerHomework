package LinkNode;

/**
 * #链表
 * ###链表的创建，插入，删除节点
 *
 * @Description 说明类的用途
 * @ClassName SingleNode
 * @Author zzd
 * @Create 2019/7/15 11:55
 * @Version 1.0
 **/
public class SingleLinkedList {

    private int size;

    private SNode head;

    public SingleLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public SNode addHead(Object data) {
        SNode newnode = new SNode(data);
        if (size == 0) {
            this.head = newnode;
        } else {
            newnode.next = this.head;
            this.head = newnode;
        }
        return this.head;
    }

    /**
     * 有个问题，如果链表形成一个环，在添加连接点是否会是死循环
     * @param data
     */
    public void addSNode(Object data) {
        SNode newnode = new SNode(data);
        if (size == 0) {
            this.head = newnode;
        } else {
            SNode node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newnode;
        }
        size++;
    }

    public class SNode {

        private SNode next;
        private Object data;

        public SNode(Object data) {
            this.data = data;
            this.next = null;
        }

        public SNode(int data) {
            this.data = data;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
