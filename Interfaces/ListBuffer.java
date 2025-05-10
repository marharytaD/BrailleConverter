package Interfaces;

public interface ListBuffer {
    int size();

    void push(char [][] bitmap);
    char[][] pop();

    void insert(int position, char[][] bitmap);
    char[][] delete(int position);

    void clearBuffer();

    String[] renderScanlines(int spacing);
}
