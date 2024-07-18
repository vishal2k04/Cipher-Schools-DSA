class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class BinarySearchTree {
    TreeNode root;
    public BinarySearchTree() {
        this.root = null;
    }
    public void insert(int val) {
        root = insertRecursive(root, val);
    }
    public TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (val < root.val) {
            root.left = insertRecursive(root.left, val);
        } else {
            root.right = insertRecursive(root.right, val);
        }
        return root;
    }
    public boolean search(int val) {
        return searchRecursive(root, val);
    }
    private boolean searchRecursive(TreeNode root, int val) {
        if(root == null) {
            return false;
        }
        if(root.val == val) {
            return true;
        } else if(val < root.val) {
            return searchRecursive(root.left, val);
        } else {
            return searchRecursive(root.right, val);
        }
    }
    void inorder() {
        inorderRecursive(root);
        System.out.println();
    }
    void inorderRecursive(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }
    public void delete(int val) {
        root = deleteRec(root, val);
    }
    private TreeNode deleteRec(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            root.left = deleteRec(root.left, val);
        } else if (val > root.val) {
            root.right = deleteRec(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.val = minValue(root.right);
            root.right = deleteRec(root.right, root.val);
        }
        return root;
    }
    private int minValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }
}
public class BinaryTree {
    public static void main(String[] args) {
        var bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        System.out.println("Inorder traversal of the BST:");
        bst.inorder();
        System.out.println("Deleting 20 from the BST:");
        bst.delete(20);
        bst.inorder();
        System.out.println("Searching for 70 in the BST:");
        System.out.println("Found: " + bst.search(70));
        System.out.println("Searching for 10 in the BST:");
        System.out.println("Found: " + bst.search(10));
    }
}
