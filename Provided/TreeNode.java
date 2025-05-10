package Provided;

public class TreeNode {
    private char symbol;
    private TreeNode left;
    private TreeNode right;


    public TreeNode() {
        this.symbol = 0;
        left = null;
        right = null;
    }


    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }


    public void setLeft(TreeNode left) {
        this.left = left;
    }


    public void setRight(TreeNode right) {
        this.right = right;
    }


    public char getSymbol() {
        return symbol;
    }


    public TreeNode getLeft() {
        return left;
    }


    public TreeNode getRight() {
        return right;
    }
}
