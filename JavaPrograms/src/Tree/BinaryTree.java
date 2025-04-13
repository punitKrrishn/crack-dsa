package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static int idx = -1;

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public TreeNode buildTree(int[] nodes) {
        idx++;
        if(nodes[idx] == -1) {
            return null;
        }
        TreeNode newNode = new TreeNode(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }
    public static void preOrderTraversal(TreeNode root) {
        if(root == null) {
            return ;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }
    public static void levelOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode currNode = q.remove();
            if(currNode == null) {
                System.out.println();
                if(q.isEmpty()) {
                    break;
                }else {
                    q.add(null);
                }
            }else {
                System.out.print(currNode.data+" ");
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }
    public static int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSubTreeCount = countNodes(root.left);
        int rightSubTreeCount = countNodes(root.right);
        int result = leftSubTreeCount + rightSubTreeCount + 1;
        return result;
    }
    public static int sumOfNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }
    public static int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return (Math.max(leftHeight,rightHeight)) + 1;
    }
    public static int diameter(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam3,Math.max(diam1,diam2));
    }

    public static class TreeInfo {
        int ht;
        int dia;

        TreeInfo(int ht, int dia) {
            this.ht = ht;
            this.dia = dia;
        }
    }
    public static TreeInfo diameterOn(TreeNode root) {
        if(root == null) {
            return new TreeInfo(0,0);
        }
        TreeInfo leftInfo = diameterOn(root.left);
        TreeInfo rightInfo = diameterOn(root.right);

        int myHeight = Math.max(leftInfo.ht,rightInfo.ht) + 1;

        int dia1 = leftInfo.dia;
        int dia2 = rightInfo.dia;
        int dia3 = leftInfo.ht + rightInfo.ht + 1;

        int myDia = Math.max(dia1,Math.max(dia2,dia3));

        TreeInfo myInfo = new TreeInfo(myHeight,myDia);

        return myInfo;
    }


    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.buildTree(nodes);
        //System.out.println(root.data);
        //preOrderTraversal(root);
        levelOrder(root);
        System.out.println("count : "+countNodes(root));
        System.out.println("sum : "+sumOfNodes(root));
        System.out.println("height : "+height(root));
        System.out.println("diameter : "+diameter(root));
        System.out.println("diameter with o of n: "+diameterOn(root).dia);



    }

   /* Inorder Traversal: 00:12:37
    Preorder Traversal: 00:14:38
    Postorder Traversal: 00:15:39
    Level Order Traversal: 00:17:00
    Tree Operations: 00:17:39
    Tree vs Graph: 00:19:48
    Benefits and Limitations: 00:23:55
    Balanced Binary Tree: 00:26:36
    Symmetric Tree: 00:35:18
    Diameter of Binary Tree: 00:43:16
    Invert/Flip Binary Tree: 00:51:45
    Maximum Depth of Binary Tree: 00:59:09
    Same Tree: 01:05:20
    Subtree of Another Tree: 01:12:47
    Count Good Nodes In Binary Tree: 01:21:19
    Find Leaves of Binary Tree: 01:32:16
    Binary Tree Right Side View: 01:42:01
    Binary Tree Level Order Traversal: 01:51:47
    Binary Tree Zigzag Level Order Traversal: 02:04:03
    Construct Binary Tree from Preorder and Inorder Traversal: 02:19:49
    Kth Smallest Element in a BST: 02:35:47
    Validate Binary Search Tree: 02:43:25
    Lowest Common Ancestor of BST: 02:53:40
    Implement Trie (Prefix Tree): 03:04:30
    Design Add And Search Words Data Structure: 03:29:51
    Binary Tree Maximum Path Sum: 03:45:52
    Serialize and Deserialize Binary Tree: 04:01:38
    Word Search II: 04:12:47
    In this course, we cover:*/
}
