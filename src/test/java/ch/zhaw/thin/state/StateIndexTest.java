package ch.zhaw.thin.state;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Arik, Simon
 */
public class StateIndexTest {

    private final int multiplyStatesLength = StateTable.MULTIPLY.getStates().length / 2;
    private final StateIndex index = new StateIndex(StateTable.MULTIPLY);

    @Test
    public void multiplyIndexPrimitive() {
        for (int i = 0; i < multiplyStatesLength; i++) {
            assertNotNull("Did not have value for true::" + i, index.get(i, true));
            assertNotNull("Did not have value for false::" + i, index.get(i, false));
        }
    }

    @Test
    public void multiplyIndex() {
        for (int i = 0; i < multiplyStatesLength; i++) {
            assertNotNull("Did not have value for true::" + i, index.get(new StateUid(i, true)));
            assertNotNull("Did not have value for false::" + i, index.get(new StateUid(i, false)));
        }
    }

}