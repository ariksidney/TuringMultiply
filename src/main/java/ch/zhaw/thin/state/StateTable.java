package ch.zhaw.thin.state;

/**
 * @author Arik, Simon
 */
public enum StateTable {

    MULTIPLY(new State[]{
            new State(0, false, false, Step.R, 1),
            new State(0, true, false, Step.R, 2),
            new State(1, false, false, Step.R, 14),
            new State(1, true, false, Step.R, 2),
            new State(2, false, false, Step.R, 3),
            new State(2, true, true, Step.R, 2),
            new State(3, false, false, Step.L, 15),
            new State(3, true, false, Step.R, 4),
            new State(4, false, false, Step.R, 5),
            new State(4, true, true, Step.R, 4),
            new State(5, false, true, Step.L, 6),
            new State(5, true, true, Step.R, 5),
            new State(6, false, false, Step.L, 7),
            new State(6, true, true, Step.L, 6),
            new State(7, false, true, Step.L, 9),
            new State(7, true, true, Step.L, 8),
            new State(8, false, true, Step.R, 3),
            new State(8, true, true, Step.L, 8),
            new State(9, false, false, Step.L, 10),
            new State(9, true, true, Step.L, 9),
            new State(10, false, false, Step.R, 12),
            new State(10, true, true, Step.L, 11),
            new State(11, false, false, Step.R, 0),
            new State(11, true, true, Step.L, 11),
            new State(12, false, false, Step.R, 12),
            new State(12, true, false, Step.R, 13),
            new State(13, false, false, Step.N, -1),
            new State(13, true, false, Step.R, 13),
            new State(14, false, false, Step.N, -1),
            new State(14, true, false, Step.R, 14),
            new State(15, false, false, Step.L, 16),
            new State(15, true, false, Step.L, 15),
            new State(16, false, false, Step.N, -1),
            new State(16, true, false, Step.L, 16),
    });

    private final State[] states;

    StateTable(State[] states) {
        this.states = states;
    }

    public State[] getStates() {
        return states;
    }
}
