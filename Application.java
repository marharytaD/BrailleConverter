import java.util.Arrays;
import Provided.BrailleEncoder;
import Provided.BrailleFont;
import Provided.ListNode;
import Provided.TreeNode;

public class Application {
    public static void main(String[] args) {


        BrailleFont font = new BrailleFont(3, 2, 'o', '.', new BrailleEncoder());


        BrailleLinkedList list = new BrailleLinkedList();


        BrailleListBuffer brailleListBuffer = new BrailleListBuffer(list);


        String message = "Hello,Everyone!";
        for (char c : message.toCharArray()) {
            brailleListBuffer.push(font.getBitmap(Character.toLowerCase(c)));
        }


        String[] lines = brailleListBuffer.renderScanlines(4);


        if (lines.length > 0) {
            Arrays.asList(lines).forEach(System.out::println);
        }


        BrailleDecoder decoder = new BrailleDecoder(new BrailleEncoder());


        BrailleReader reader = new BrailleReader(decoder);


        String asciiText = reader.translate(lines, 'o', 4);


        System.out.println(asciiText);
    }
}

