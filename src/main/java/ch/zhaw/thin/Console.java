package ch.zhaw.thin;


import ch.zhaw.thin.band.Band;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Prompt for input
 *
 * @author Arik, Simon
 */
public class Console {

    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out, true);

    public static void main(String[] args) {
        Console console = new Console();
        String input = console.readBand();
        boolean stepMode = console.readIsStepMode();

        Band band = new Band(input);
        TuringMachine tm = new TuringMachine(band, stepMode, console);
        tm.run();

        console.close();
    }

    public void waitForInput() {
        scanner.nextLine();
    }

    private String readBand() {
        writer.printf("%s", "Enter band content: ");
        return scanner.nextLine();
    }

    private boolean readIsStepMode() {
        writer.printf("%s", "Step mode [y/n]?: ");
        return "y".equals(scanner.nextLine());
    }

    private void close() {
        writer.close();
        scanner.close();
    }
}
