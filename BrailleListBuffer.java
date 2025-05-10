import Interfaces.List;
import Interfaces.ListBuffer;
import Provided.ListNode;
public class BrailleListBuffer implements ListBuffer {
    private static final char SPACE_SYMBOL=' ';
    private List list;



    BrailleListBuffer(List list) {  // Hint: pass your BrailleLinkedList to this constructor
        this.list =list;
    }


    @Override
    public int size() {
        return list.size();
    }


    @Override
    public void push(char[][] bitmap) {
        if (bitmap==null){
            return;
        }
        list.addLast(new ListNode(bitmap));
    }

    @Override
    public char[][] pop() {
        ListNode removedNode =list.removeLast();
        return (removedNode!=null)? removedNode.getBitmap() : null;
    }


    @Override
    public void insert(int position, char[][] bitmap) {
        if (bitmap==null){
            return;
        }
        list.insert(new ListNode(bitmap),position);
    }


    @Override
    public char[][] delete(int position) {
        ListNode removeNode = list.remove(position);
        return (removeNode!=null)?removeNode.getBitmap():null;
    }


    @Override
    public void clearBuffer() {
        list.clear();
    }


    @Override
    public String[] renderScanlines(int spacing) {
        if (list.size() == 0) {
            return null;
        }
        char[][] firstBitmap = list.get(0).getBitmap();
        if (firstBitmap == null || firstBitmap.length == 0 || firstBitmap[0].length == 0) {
            return null;
        }

        int height = firstBitmap.length;
        int width = firstBitmap[0].length;
        int numCharacters = list.size();

        int totalWidth = numCharacters * width + (numCharacters - 1) * spacing;

        char[][] output = new char[height][totalWidth];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < totalWidth; j++) {
                output[i][j] = SPACE_SYMBOL;
            }
        }

        int colIndex = 0;
        for (int i = 0; i < numCharacters; i++) {
            char[][] bitmap = list.get(i).getBitmap();

            if (bitmap.length != height || bitmap[0].length != width) {
                return null;
            }
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    output[row][colIndex + col] = bitmap[row][col];
                }
            }

            colIndex += width+ spacing;
        }
        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = new String(output[i]);
        }

        return result;

    }
}

