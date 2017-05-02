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
        // init resources
        Console console = new Console();

        // read band content
        String input = console.readBand();

        // set run or step mode
        boolean stepMode = console.readIsStepMode();
        if (stepMode) {
            Mode.setStepMode();
        } else {
            Mode.setRunMode(console.readIsVerboseMode());
        }

        // init turing machine
        Band band = new Band(input);
        TuringMachine tm = new TuringMachine(band, console);
        tm.run();

        // close resources
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

    private boolean readIsVerboseMode() {
        writer.printf("%s", "Verbose mode [y/n]?: ");
        return "y".equals(scanner.nextLine());
    }

    private void close() {
        writer.close();
        scanner.close();
    }
}
