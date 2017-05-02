package ch.zhaw.thin.state;

/**
 * @author Arik, Simon
 */
public class State {

    private final int id;
    private final boolean read;
    private final boolean write;
    private final Step moveDirection;
    private final int nextState;

    public State(int id, boolean read, boolean write, Step moveDirection, int nextState) {
        this.id = id;
        this.read = read;
        this.write = write;
        this.moveDirection = moveDirection;
        this.nextState = nextState;
    }

    public int getId() {
        return id;
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
