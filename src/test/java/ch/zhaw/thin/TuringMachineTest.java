package ch.zhaw.thin;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Arik, Simon
 */
public class TuringMachineTest {

    @Test
    public void multiply3Times4() {
        Band band = new Band("*** ****");
        TuringMachine tm = new TuringMachine(band, false);
        String result = tm.run();
        assertEquals("Calc wrong for 3*4", "************", result);
    }

    @Test
    public void multiplyByZero() {
        Band band = new Band("*");
        TuringMachine tm = new TuringMachine(band, false);
        String result = tm.run();
        assertEquals("Calc wrong for 1*0", "", result);
    }
}