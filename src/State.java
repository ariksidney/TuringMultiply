/**
 * Created by ariksidney on 28.04.17.
 */
public class State {

    private int state;
    private boolean read;
    private boolean write;
    private String moveDirection;
    private int nextState;

    public State(int state, boolean read, boolean write, String moveDirection, int nextState) {
        this.state = state;
        this.read = read;
        this.write = write;
        this.moveDirection = moveDirection;
        this.nextState = nextState;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isWrite() {
        return write;
    }

    public void setWrite(boolean write) {
        this.write = write;
    }

    public String getMoveDirection() {
        return moveDirection;
    }

    public void setMoveDirection(String moveDirection) {
        this.moveDirection = moveDirection;
    }

    public int getNextState() {
        return nextState;
    }

    public void setNextState(int nextState) {
        this.nextState = nextState;
    }
}
