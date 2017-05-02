package ch.zhaw.thin;

import ch.zhaw.thin.state.State;
import ch.zhaw.thin.state.StateTable;
import ch.zhaw.thin.state.Step;

import static ch.zhaw.thin.state.Step.*;

/**
 * @author Arik, Simon
 */
public class TuringMachine {

    private static final State[] STATES = StateTable.MULTIPLY.getStates();

    private final Band band;
    private final boolean stepMode;
    private final Console console;

    public TuringMachine(Band band) {
        this(band, false, null);
    }

    public TuringMachine(Band band, boolean stepMode) {
        this(band, stepMode, null);
    }

    public TuringMachine(Band band, boolean stepMode, Console console) {
        this.band = band;
        this.stepMode = stepMode;
        this.console = console;
    }

    /**
     * @return result
     */
    public String run() {
        int next = 0;
        boolean finished = false;
        int cnt = 1;
        while (!finished) {
            char current;
            current = band.getCurrentPosition();
            for (int i = 0; i < STATES.length; i++) {
                State state = STATES[i];
                if (state.getId() == next) {
                    if ((current == '*' && state.isRead()) || (current == ' ' && !state.isRead())) {
                        if (stepMode) {
                            printStep();
                            console.waitForInput();
                        }
                        moveHead(state);

                        if (state.getNextState() == -1) {
                            finished = true;
                            printResult(state, cnt);
                        }

                        next = state.getNextState();
                        cnt++;
                        break;
                    }
                }
            }
        }
        return band.toRawString();
    }

    private void moveHead(State state) {
        modify(state.isWrite());
        move(state.getMoveDirection());
    }

    private void modify(boolean write) {
        if (write) {
            band.writeToCurrentPosition();
        } else {
            band.deleteCurrentPosition();
        }
    }

    private void move(Step step) {
        if (step == R) {
            band.moveRight();
        } else if (step == L) {
            band.moveLeft();
        }
    }

    private void printStep() {
        System.out.println(band.toString());
        System.out.println(String.format("%" + (15 + band.getPointer()) + "s", "^"));
    }

    private void printResult(State state, int cnt) {
        System.out.println(band.toString());
        System.out.println("Stopped at state: " + state.getId());
        System.out.println("Calculated after " + cnt + " steps");
    }
}
