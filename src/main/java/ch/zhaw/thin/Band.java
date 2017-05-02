package ch.zhaw.thin;

import java.util.ArrayList;

/**
 * @author Arik, Simon
 */
public class Band {

    private ArrayList<Character> band;
    private int pointer = 0;

    public Band(String input){
        band = prepareBand(input);
    }

    public char moveLeft() {
        pointer = pointer - 1;
        return band.get(pointer);
    }

    public char moveRight() {
        pointer = pointer + 1;
        try {
            return band.get(pointer);
        } catch (IndexOutOfBoundsException i) {
            band.add(' ');
            return band.get(pointer);
        }
    }

    public char getCurrentPosition() {
        return band.get(pointer);
    }

    public void deleteCurrentPosition() {
        band.set(pointer, ' ');
    }

    public void writeToCurrentPosition() {
        band.set(pointer, '*');
    }

    public int getPointer() { return pointer; }

    private ArrayList<Character> prepareBand(String in) {
        ArrayList<Character> b = new ArrayList<>();
        in = in + " ";
        for(char c : in.toCharArray()) {
            b.add(c);
        }
        return b;
    }

    public String toRawString() {
        StringBuilder builder = new StringBuilder();
        for (char c : band) {
            builder.append(c);
        }
        return builder.toString().trim();
    }

    @Override
    public String toString() {
        String result = toRawString();
        int len = result.length();
        String spaces =  String.format("%15s", "");
        return spaces + result + spaces + " (" + len + ")";
    }

}
