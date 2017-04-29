package ch.zhaw.thin;

/**
 * Created by ariksidney on 28.04.17.
 */
public class State {

    private final int state;
    private final boolean read;
    private final boolean write;
    private final Step moveDirection;
    private final int nextState;

    public State(int state, boolean read, boolean write, Step moveDirection, int nextState) {
        this.state = state;
        this.read = read;
        this.write = write;
        this.moveDirection = moveDirection;
        this.nextState = nextState;
    }

    public int getState() {
        return state;
    }

    public boolean isRead() {
        return read;
    }

    public boolean isWrite() {
        return write;
    }

    public Step getMoveDirection() {
        return moveDirection;
    }

    public int getNextState() {
        return nextState;
    }
}
