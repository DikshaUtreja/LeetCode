/*In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        ResultNode xNode = getResultNode(root, x, null, 0);
        ResultNode yNode = getResultNode(root, y, null, 0);
        return xNode.depth == yNode.depth && xNode.parent != yNode.parent;
    }
    
    public ResultNode getResultNode(TreeNode node, int value, TreeNode parent, int depth) {
        if (node == null) { return null; }
        if (node.val == value) { return new ResultNode(parent, depth);}
        ResultNode leftNode = getResultNode(node.left, value, node, depth+1);
        ResultNode rightNode = getResultNode(node.right, value, node, depth+1);
        return leftNode == null ? rightNode : leftNode;
    }
}

class ResultNode {
    TreeNode parent;
    int depth;
    ResultNode(TreeNode parent, int depth) {
        this.parent = parent;
        this.depth = depth;
    }
}