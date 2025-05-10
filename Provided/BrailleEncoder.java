package Provided;
public class BrailleEncoder {


    private static final byte[] brailleLUT = {
            0b000001, 0b000011, 0b001001, 0b011001, 0b010001,   // a-e
            0b001011, 0b011011, 0b010011, 0b001010, 0b011010,   // f-j
            0b000101, 0b000111, 0b001101, 0b011101, 0b010101,   // k-o
            0b001111, 0b011111, 0b010111, 0b001110, 0b011110,   // p-t
            0b100101, 0b100111, 0b111010, 0b101101, 0b111101,   // u-y
            0b110101                                            // z
    };


    public byte toBinary(char asciiChar) {
        return brailleLUT[asciiChar - 'a'];
    }
}


