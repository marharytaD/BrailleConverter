package Provided;

public class BrailleFont {
    private final int height;
    private final int width;


    private final char[][][] lowerCaseLetters;


    private final char[][] whiteSpace;



    public BrailleFont(int height, int width, char dotSymbol, char spaceSymbol, BrailleEncoder encoder) {
        this.height = height;
        this.width = width;


        lowerCaseLetters = new char['z' - 'a' + 1][][];

        for (char character = 'a'; character <= 'z'; character++) {
            lowerCaseLetters[character - 'a'] = new char[height][width];


            byte brailleCharBin = encoder.toBinary(character);


            int index = 0;
            for (int column = 0; column < width; column++) {
                for (int row = 0; row < height; row++) {
                    lowerCaseLetters[character - 'a'][row][column] = ((brailleCharBin & (1 << index++)) != 0) ? dotSymbol : spaceSymbol;
                }
            }
        }


        whiteSpace = new char[height][width];
        for (int column = 0; column < width; column++) {
            for (int row = 0; row < height; row++) {
                whiteSpace[row][column] = spaceSymbol;
            }
        }
    }



    public char[][] getBitmap(char character) {

        if ((character >= 'a' && character <= 'z')) {
            return lowerCaseLetters[character- 'a'].clone();

        }
        if ((character >= 'A' && character <= 'Z')) {
            return lowerCaseLetters[Character.toLowerCase(character) - 'a'].clone();

        }
        return whiteSpace;
    }


    public int getHeight() {
        return height;
    }


    public int getWidth() {
        return width;
    }
}
