import java.util.ArrayList;

/**
 * Created by ariksidney on 28.04.17.
 */
public class Band {

    private String input;
    private ArrayList<Character> band;
    private int pointer = 0;
    private String output;

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

    private ArrayList<Character> prepareBand(String in) {
        ArrayList<Character> b = new ArrayList<>();
        in = in + " ";
        for(char c : in.toCharArray()) {
            b.add(c);
        }
        return b;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (char c : band) {
            builder.append(c);
        }
        String result = builder.toString().trim();
        int len = result.length();
        return result + " (" + len + ")";
    }

}
