package ch.zhaw.thin;

import ch.zhaw.thin.band.Band;
import ch.zhaw.thin.band.BandSymbol;
import ch.zhaw.thin.state.State;
import ch.zhaw.thin.state.StateIndex;
import ch.zhaw.thin.state.StateTable;
import ch.zhaw.thin.state.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ch.zhaw.thin.state.Step.L;
import static ch.zhaw.thin.state.Step.R;

/**
 * @author Arik, Simon
 */
public class TuringMachine {

    private static final Logger LOG = LoggerFactory.getLogger(TuringMachine.class);

    private final StateIndex stateIndex = new StateIndex(StateTable.MULTIPLY);

    private final Band band;
    private final Console console;

    private int stepCount = 1;

    public TuringMachine(Band band, Console console) {
        this.band = band;
        this.console = console;
    }

    /**
     * @return raw result
     */
    public String run() {
        int next = 0;
        boolean finished = false;
        while (!finished) {

            char current = band.getCurrentPosition();
            State state = getState(next, current);
            printStep(state.getId());

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

    private State getState(int id, char currentSymbol) {
        return stateIndex.get(id, shouldRead(currentSymbol));
    }

    private boolean shouldRead(char current) {
        return current == BandSymbol.star();
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

    private void printStep(int stateId) {
        LOG.debug("{} S{}", band, stateId);
        if (LOG.isTraceEnabled()) {
            console.waitForInput();
        }
    }

    private void printResult(State state, int cnt) {
        LOG.info("{} S{}", band, state.getId());
        LOG.info("Stopped at state: {}", state.getId());
        LOG.info("Calculated after {} steps", cnt);
    }
}
