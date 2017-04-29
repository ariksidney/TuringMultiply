package ch.zhaw.thin;

import org.junit.Test;

public class TuringMachineTest {

    @Test
    public void calc() {
        Band band = new Band("*** ****");
        TuringMachine tm = new TuringMachine(band, false);
        tm.run();
    }
}