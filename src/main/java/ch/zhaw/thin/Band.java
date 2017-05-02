package ch.zhaw.thin;

import gnu.trove.list.TCharList;
import gnu.trove.list.array.TCharArrayList;

/**
 * @author Arik, Simon
 */
public class Band {

    private static final String SPACES = String.format("%15s", "");

    private final TCharList charList;
    private int pointer = 0;

    public Band(String input) {
        charList = new TCharArrayList(input.toCharArray());
    }

    public void moveLeft() {
        pointer = pointer - 1;
    }

    public void moveRight() {
        ++pointer;
        if (charList.size() == pointer) {
            charList.add(' ');
        }
    }

    public char getCurrentPosition() {
        return charList.get(pointer);
    }

    public void deleteCurrentPosition() {
        charList.set(pointer, ' ');
    }

    public void writeToCurrentPosition() {
        charList.set(pointer, '*');
    }

    public int getPointer() {
        return pointer;
    }

    public String toRawString() {
        return String.copyValueOf(charList.toArray()).trim();
    }

    @Override
    public String toString() {
        String result = toRawString();
        return SPACES + result + SPACES + " (" + result.length() + ")";
    }
}
