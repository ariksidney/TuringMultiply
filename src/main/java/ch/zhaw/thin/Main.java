package ch.zhaw.thin;

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
            else if (args[i].matches("^-?\\d+$")) {
                StringBuilder builder = new StringBuilder();
                int numbr = Integer.parseInt(args[i]);
                for(int j = 0; j < numbr; j++) {
                    builder.append("*");
                }
                input.add(builder.toString());
            }
        }
        Band band = new Band(input.get(0)+ " " + input.get(1));
        TuringMachine tm = new TuringMachine(band, false);
        tm.run();
    }
}
