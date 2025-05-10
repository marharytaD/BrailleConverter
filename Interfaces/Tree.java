package Interfaces;
import Provided.TreeNode;
public interface Tree {
    void addNode(char asciiCharacter);
    TreeNode getNode(byte encoded);
    TreeNode getRoot();
}

