package BinaryTreeTraversal;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;

/**
 * @Description 二叉树的遍历
 * 分别使用递归和非递归的方式
 * 非递归使用循环+堆栈
 * 1
 * 2      3
 * 4   5  6    7
 * 前序遍历  中左右 123
 * 中序遍历  左中右213
 * 后序遍历  左右中231
 * @ClassName BinaryTreeTraversalWithRecursion
 * @Author zzd
 * @Date 2019/9/19 20:24
 * @Version 1.0
 **/
public class BinaryTreeTraversalWithRecursion {
    public static void main(String[] args) {
        TreeNode node = getMockData();
        System.out.println("二叉树前序遍历--递归实现方式：");
        preorderTraversalWithRecursion(node);
        System.out.println("二叉树中序遍历--递归实现方式：");
        sequentialTraversalWithRecursion(node);
        System.out.println("二叉树后序遍历--递归实现方式：");
        PostOrderTraversalWithRecursion(node);
        System.out.println("二叉树前序遍历--非递归实现方式：");
        preorderTraversalWithStack(node);
        System.out.println("二叉树中序遍历--非递归实现方式：");
        sequentialTraversalWithStack(node);
        System.out.println("二叉树后序遍历--非递归实现方式：");
        PostOrderTraversalWithStack(node);
    }


    /**
     * 递归实现二叉树的前序遍历
     * 中左右
     *
     * @param node
     */
    private static void preorderTraversalWithRecursion(TreeNode node) {
        if (null != node) {
            System.out.println(node);
            preorderTraversalWithRecursion(node.getLeft());
            preorderTraversalWithRecursion(node.getRight());
        }
    }

    /**
     * 递归实现二叉树的中序遍历
     * 左中右
     *
     * @param node
     */
    private static void sequentialTraversalWithRecursion(TreeNode node) {
        if (node != null) {
            sequentialTraversalWithRecursion(node.getLeft());
            System.out.println(node);
            sequentialTraversalWithRecursion(node.getRight());
        }

    }

    /**
     * 递归实现二叉树的后序遍历
     * 左右中
     *
     * @param node
     */
    private static void PostOrderTraversalWithRecursion(TreeNode node) {
        if (node != null) {
            PostOrderTraversalWithRecursion(node.getLeft());
            PostOrderTraversalWithRecursion(node.getRight());
            System.out.println(node);
        }
    }

    /**
     * 使用非递归的方式实现二叉树的前序遍历
     * 栈
     *
     * @param node
     */
    private static void preorderTraversalWithStack(TreeNode node) {
        if (node == null) return;
        List<TreeNode> treeNodeList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            TreeNode mNode = stack.pop();
            treeNodeList.add(mNode);
            System.out.println(mNode);
//            出栈是左右，那么入栈是右左
            if (mNode.getRight() != null) {
                TreeNode rNode = mNode.getRight();
                stack.push(rNode);
            }
            if (mNode.getLeft() != null) {
                TreeNode lNode = mNode.getLeft();
                stack.push(lNode);
            }
        }
    }

    /**
     * 使用非递归的方式实现中序遍历-左中右
     *
     * @param root
     */
    private static void sequentialTraversalWithStack(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        do {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            System.out.println(node);
            if (node.getRight() != null) {
                node = node.getRight();
            } else {
                node = null;
            }
        } while (!stack.empty() || node != null);
    }

    /**
     * 二叉树的后序遍历-非递归方式实现
     * @param root
     */
    private static void PostOrderTraversalWithStack(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prenode=null;
        do {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.peek();//查看栈顶元素
            if(node.getRight()!=null && node.getRight()!=prenode){
                node=node.getRight();
            }else{
                node=stack.pop();//弹出栈顶元素
                System.out.println(node);
                prenode=node;
                node=null;
            }
        } while (!stack.empty() || node != null);
    }

    /**
     * 获取初始数据
     *
     * @return
     */
    private static TreeNode getMockData() {
        TreeNode node = new TreeNode(1, null, null);
        node.setLeft(new TreeNode(2, null, null));
        node.setRight(new TreeNode(3, null, null));
        node.getLeft().setLeft(new TreeNode(4, null, null));
        node.getLeft().setRight(new TreeNode(5, null, null));
        node.getRight().setLeft(new TreeNode(6, null, null));
        node.getRight().setRight(new TreeNode(7, null, null));
        return node;
    }

    static class TreeNode {
        private int value;
        private TreeNode left;

        private TreeNode right;

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public TreeNode() {
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

}
