package ch.zhaw.thin.state;

/**
 * @author Arik, Simon
 */
public class State {

    private final StateUid uid;
    private final boolean write;
    private final Step moveDirection;
    private final int nextState;

    public State(int id, boolean read, boolean write, Step moveDirection, int nextState) {
        this(new StateUid(id, read), write, moveDirection, nextState);
    }

    public State(StateUid uid, boolean write, Step moveDirection, int nextState) {
        this.uid = uid;
        this.write = write;
        this.moveDirection = moveDirection;
        this.nextState = nextState;
    }

    public boolean isEndState() {
        return nextState == -1;
    }

    public StateUid getUid() {
        return uid;
    }

    public int getId() {
        return uid.getId();
    }

    public boolean isRead() {
        return uid.isRead();
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
