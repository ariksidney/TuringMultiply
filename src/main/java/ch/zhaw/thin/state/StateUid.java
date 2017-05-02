package ch.zhaw.thin.state;

import java.util.Objects;

/**
 * Unique identification for a state
 *
 * @author Arik, Simon
 */
public class StateUid {

    private final int id;
    private final boolean read;

    public StateUid(int id, boolean read) {
        this.id = id;
        this.read = read;
    }

    public int getId() {
        return id;
    }

    public boolean isRead() {
        return read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateUid stateUid = (StateUid) o;
        return id == stateUid.id &&
                read == stateUid.read;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, read);
    }

    @Override
    public String toString() {
        return "StateUid{" +
                "id=" + id +
                ", read=" + read +
                '}';
    }
}
