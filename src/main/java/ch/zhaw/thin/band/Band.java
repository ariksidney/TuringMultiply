package ch.zhaw.thin.band;

import gnu.trove.list.TCharList;
import gnu.trove.list.array.TCharArrayList;

import static ch.zhaw.thin.band.BandUtil.*;

/**
 * @author Arik, Simon
 */
public class Band {

    private static final String SPACES = spaces(15);

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
            charList.add(BandSymbol.space());
        }
    }

    public char getCurrentPosition() {
        return charList.get(pointer);
    }

    public void deleteCurrentPosition() {
        charList.set(pointer, BandSymbol.space());
    }

    public void writeToCurrentPosition() {
        charList.set(pointer, BandSymbol.star());
    }

    public int getPointer() {
        return pointer;
    }

    public String toRawString() {
        return useEmptySpace(toBandString()).trim();
    }

    public String toBandString() {
        return String.copyValueOf(charList.toArray());
    }

    @Override
    public String toString() {
        String readerHead = head(pointer);
        return SPACES + toBandString() + SPACES + " (" + toRawString().length() + ")\n" + SPACES + readerHead;
    }

}
