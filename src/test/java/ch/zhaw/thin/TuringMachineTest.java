package ch.zhaw.thin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Arik, Simon
 */
public class TuringMachineTest {

    @Test
    public void multiply3Times4() {
        Band band = new Band(stars(3, 4));
        TuringMachine tm = new TuringMachine(band, false);
        String result = tm.run();
        assertEquals("Calc wrong for 3*4", stars(3 * 4), result);
        assertEquals("Step count has changed", 261, tm.getStepCount());
    }


    @Test
    public void multiply13Times27() {
        Band band = new Band(stars(13, 27));
        TuringMachine tm = new TuringMachine(band, false);
        String result = tm.run();
        assertEquals("Calc wrong for 3*4", stars(13 * 27), result);
        assertEquals("Step count has changed", 134306, tm.getStepCount());
    }

    @Test
    public void multiplyByZero() {
        Band band = new Band(stars(1));
        TuringMachine tm = new TuringMachine(band, false);
        String result = tm.run();
        assertEquals("Calc wrong for 1*0", "", result);
        assertEquals("Step count has changed", 5, tm.getStepCount());
    }

    private static String stars(int c1, int c2) {
        return stars(c1) + ' ' + stars(c2);
    }

    private static String stars(int count) {
        char[] chars = new char[count];
        for (int i = 0; i < count; i++) {
            chars[i] = '*';
        }
        return String.copyValueOf(chars);
    }
}