import java.util.ArrayList;

/**
 * Created by ariksidney on 28.04.17.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if(args[i].startsWith("*")) {
                input.add(args[i]);
            }
        }
        Band band = new Band(input.get(0)+ " " + input.get(1));
        TM tm = new TM(band);
        tm.run();
    }
}
