import javax.sound.midi.Soundbank;

/**
 * Created by ariksidney on 28.04.17.
 */
public class TM {

    private State[] stateTable;
    private Band band;
    private boolean stepMode = false;

    public TM(Band band, boolean stepMode) {
        this.stateTable = createStateTable();
        this.band = band;
        this.stepMode = stepMode;
    }

    public void run() {
        int next = 0;
        boolean finished = false;
        int cnt = 1;
        while(!finished) {
            char current;
            current = band.getCurrentPosition();
            for(int i = 0; i < stateTable.length; i++) {
                State s = stateTable[i];
                if (s.getState() == next) {
                    if ((current == '*' & s.isRead()) || (current == ' ' & !s.isRead())) {
                        printStep();
                        band = moveHead(s, band);

                        if(s.getNextState() == -1) {
                            finished = true;
                            printResult(band, s, cnt);
                        }

                        next = s.getNextState();
                        cnt++;
                        break;
                    }
                }
            }
        }
    }

    private Band moveHead(State s, Band band) {
        if (s.isWrite()) {
            band.writeToCurrentPosition();
        } else {
            band.deleteCurrentPosition();
        }
        if (s.getMoveDirection().equals("R")) {
            band.moveRight();
        } else if (s.getMoveDirection().equals("L")) {
            band.moveLeft();
        }
        return band;
    }

    private void printStep() {
        System.out.println(band.toString());
        System.out.println(String.format("%15s", "^"));
    }

    private void printResult(Band band, State state, int cnt) {
        System.out.println(band.toString());
        System.out.println("Stopped at state: " + state.getState());
        System.out.println("Calculated after " + cnt + " steps");
    }

    private State[] createStateTable() {
        State[] multiplyTable = {
                new State(0, false, false, "R", 1),
                new State(0, true, false, "R", 2),
                new State(1, false, false, "R", 14),
                new State(1, true, false, "R", 2),
                new State(2, false, false, "R", 3),
                new State(2, true, true, "R", 2),
                new State(3, false, false, "L", 15),
                new State(3, true, false, "R", 4),
                new State(4, false, false, "R", 5),
                new State(4, true, true, "R", 4),
                new State(5, false, true, "L", 6),
                new State(5, true, true, "R", 5),
                new State(6, false, false, "L", 7),
                new State(6, true, true, "L", 6),
                new State(7, false, true, "L", 9),
                new State(7, true, true, "L", 8),
                new State(8, false, true, "R", 3),
                new State(8, true, true, "L", 8),
                new State(9, false, false, "L", 10),
                new State(9, true, true, "L", 9),
                new State(10, false, false, "R", 12),
                new State(10, true, true, "L", 11),
                new State(11, false, false, "R", 0),
                new State(11, true, true, "L", 11),
                new State(12, false, false, "R", 12),
                new State(12, true, false, "R", 13),
                new State(13, false, false, "-", -1),
                new State(13, true, false, "R", 13),
                new State(14, false, false, "-", -1),
                new State(14, true, false, "R", 14),
                new State(15, false, false, "L", 16),
                new State(15, true, false, "L", 15),
                new State(16, false, false, "-", -1),
                new State(16, true, false, "L", 16),
        };
        return multiplyTable;
    }
}
