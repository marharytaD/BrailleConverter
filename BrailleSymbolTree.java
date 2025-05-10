import Provided.BrailleEncoder;
import Provided.TreeNode;
import Interfaces.Tree;
public class BrailleSymbolTree implements Tree {
    private TreeNode root;
    private BrailleEncoder encoder = null;


    public BrailleSymbolTree(BrailleEncoder encoder) {
        this.encoder = encoder;
        for (char i = 'a'; i <= 'z'; i++) {
            addNode(i);
        }
        addNode(' ');
    }


    @Override
    public void addNode(char asciiCharacter) {
        byte encoded;
        if (asciiCharacter == ' ') {
            encoded = 0b000000;
        } else {
            encoded = encoder.toBinary(asciiCharacter);
        }
        if (root == null) {
            root = new TreeNode();
        }
        TreeNode current = root;
        for (int i = 0; i < 6; i++) {
            boolean goRight = (encoded & (1 << i)) != 0;
            if (goRight) {
                if (current.getRight() == null) {
                    current.setRight(new TreeNode());
                }
                current = current.getRight();
            } else {
                if (current.getLeft() == null) {
                    current.setLeft(new TreeNode());
                }
                current = current.getLeft();
            }
        }
        current.setSymbol(asciiCharacter);
    }



    @Override
    public TreeNode getNode(byte encoded) {
        TreeNode current = root;
        if (current == null) {
            return null;
        }
        for (int i = 0; i < 6; i++) {
            boolean goRight = (encoded & (1 << i)) != 0;
            current = goRight ? current.getRight() : current.getLeft();
            if (current == null) {
                return null;
            }
        }
        return current;
    }


    @Override
    public TreeNode getRoot() {
        return root;
    }
}