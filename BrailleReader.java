
import  Interfaces.Decoder;
public class BrailleReader {
    private final int WIDTH=2;
    private final int HEIGHT=3;

    private Decoder decoder;


    public BrailleReader(Decoder decoder){ // Hint: pass your BrailleDecoder to this constructor
        this.decoder=decoder;
    }


    private char[][] getBrailleChar(int position, int spacing, String[] brailleLine){
        if (brailleLine ==null||brailleLine.length!=HEIGHT||position<0){
            return null;
        }
        int startIndex =position*(WIDTH+spacing);
        if (startIndex+WIDTH>brailleLine[0].length()){
            return null;
        }
        char[][] bitmap =new char [HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                bitmap[i][j]=brailleLine[i].charAt(startIndex+j);
            }
        }
        return bitmap;
    }


    public String translate(String[] brailleLine, char dotSymbol, int spacing){
        if (brailleLine ==null||brailleLine.length!=HEIGHT||brailleLine[0].isEmpty()){
            return "";
        }
        int numChars = (brailleLine[0].length()+spacing)/(WIDTH+spacing);
        String res ="";
        for (int i = 0; i < numChars; i++) {
            char[][]bitmap =getBrailleChar(i,spacing,brailleLine);
            if (bitmap==null){
                continue;
            }
            res+=decoder.decodeBitmap(bitmap,dotSymbol);
        }
        return res;
    }
}
