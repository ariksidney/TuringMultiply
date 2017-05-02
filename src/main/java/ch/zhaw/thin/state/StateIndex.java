package ch.zhaw.thin.state;

import java.util.HashMap;
import java.util.Map;

/**
 * Index states by their unique identification values
 *
 * @author Arik, Simon
 */
public class StateIndex {

    private final Map<StateUid, State> stateByUid;

    public StateIndex(StateTable stateTable) {
        State[] states = stateTable.getStates();
        this.stateByUid = new HashMap<>(states.length);
        for (State state : states) {
            this.stateByUid.put(state.getUid(), state);
        }
    }

    public State get(StateUid uid) {
        return stateByUid.get(uid);
    }

    public State get(int id, boolean read) {
        return get(new StateUid(id, read));
    }
}
