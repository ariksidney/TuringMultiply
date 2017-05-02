package ch.zhaw.thin;

import ch.zhaw.thin.state.State;
import ch.zhaw.thin.state.StateIndex;
import ch.zhaw.thin.state.StateTable;
import ch.zhaw.thin.state.Step;

import static ch.zhaw.thin.state.Step.*;

/**
 * @author Arik, Simon
 */
public class TuringMachine {

    private final StateIndex stateIndex = new StateIndex(StateTable.MULTIPLY);

    private final Band band;
    private final boolean stepMode;
    private final Console console;

    private int stepCount = 1;

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
        while (!finished) {

            char current = band.getCurrentPosition();
            State state = stateIndex.get(next, shouldRead(current));


            if (stepMode) {
                printStep();
                console.waitForInput();
            }

            moveHead(state);

            if (state.isEndState()) {
                finished = true;
                printResult(state, stepCount);
            } else {
                next = state.getNextState();
                stepCount++;
            }
        }
        return band.toRawString();
    }

    private boolean shouldRead(char current) {
        return current == '*';
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

    public int getStepCount() {
        return stepCount;
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
