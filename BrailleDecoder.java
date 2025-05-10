import Interfaces.Decoder;
import Provided.BrailleEncoder;
import Provided.TreeNode;
public class BrailleDecoder implements Decoder {
    private static final int BITMAP_HEIGHT = 3;
    private static final int BITMAP_WIDTH = 2;
    private static final char SPACE_SYMBOL = ' ';
    private BrailleSymbolTree decoderTree;


    public BrailleDecoder(BrailleEncoder encoder) {

        this.decoderTree = new BrailleSymbolTree(encoder);

    }


    public char decodeBitmap(char[][] bitMap, char dotSymbol) {
        byte brailCole = 0;
        int bitPos = 0;
        for (int col = 0; col < BITMAP_WIDTH; col++) {
            for (int row = 0; row < BITMAP_HEIGHT; row++) {

                if (bitMap[row][col] == dotSymbol) {
                    brailCole |= (1 << bitPos);
                }
                bitPos++;
            }
        }
        TreeNode node = decoderTree.getNode(brailCole);
        Character result = (node!=null)?node.getSymbol():null;

        return (result != null) ? result : SPACE_SYMBOL;
    }
}
