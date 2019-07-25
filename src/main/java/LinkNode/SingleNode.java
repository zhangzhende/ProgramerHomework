package LinkNode;

/**
 * @Description 说明类的用途
 * @ClassName SingleNode
 * @Author zzd
 * @Create 2019/7/15 11:55
 * @Version 1.0
 **/
public class SingleNode {


    public class SNode {


        public SNode addSNode(int data) {
            SNode temp = this.next;
            while (this.next != null) {
                temp = temp.next;
            }
            temp.next = new SNode(data);
            return this;
        }

        private SNode next;
        private int data;

        public SNode(int data) {
            this.data = data;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
