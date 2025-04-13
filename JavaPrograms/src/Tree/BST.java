package Tree;

public class BST {
    public static TreeNode root = null;

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
    public static TreeNode insert(TreeNode root,int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        if(val < root.data) {
            //insert left
            root.left = insert(root.left,val);
        }else {
            //insert right
            root.right = insert(root.right,val);

        }
        return root;
    }
    private static boolean search(TreeNode root, int target) {
        if(root == null) {
            return false;
        }
        if(root.data == target) {
            return true;
        }
        else if(target > root.data) {
           return search(root.right, target);
        }
        else  {
           return search(root.left,target);
        }

    }

    private static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }


    public static void main(String[] args) {
        int[] values = {15,1,3,4,2,7};

        for(int i=0; i<values.length; i++) {
            root = insert(root,values[i]);
        }

        //Print all values
        inOrder(root);
        System.out.println();

        // search
        int target = 70;
        if(search(root,target)) {
            System.out.println(target+" Target is found");
        }else {
            System.out.println(target+" Target is not found");
        }
    }
}
