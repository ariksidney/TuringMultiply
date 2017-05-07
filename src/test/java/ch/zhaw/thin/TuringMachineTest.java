package ch.zhaw.thin;

import ch.zhaw.thin.band.Band;
import org.junit.BeforeClass;
import org.junit.Test;

import static ch.zhaw.thin.band.BandUtil.stars;
import static org.junit.Assert.assertEquals;

/**
 * @author Arik, Simon
 */
public class TuringMachineTest {

    private static final Console CONSOLE = new Console();

    @BeforeClass
    public static void setUp() {
        Mode.setRunMode(false);
    }

    @Test
    public void multiply3Times4() {
        Band band = new Band(stars(3, 4));
        TuringMachine tm = new TuringMachine(band, CONSOLE);
        String result = tm.run();
        assertEquals("Calc wrong for 3*4", stars(3 * 4), result);
        assertEquals("Step count has changed", 261, tm.getStepCount());
    }

    @Test
    public void multiply13Times27() {
        Band band = new Band(stars(13, 27));
        TuringMachine tm = new TuringMachine(band, CONSOLE);
        String result = tm.run();
        assertEquals("Calc wrong for 3*4", stars(13 * 27), result);
        assertEquals("Step count has changed", 134306, tm.getStepCount());
    }

    @Test
    public void multiplyByZero() {
        Band band = new Band(stars(1));
        TuringMachine tm = new TuringMachine(band, CONSOLE);
        String result = tm.run();
        assertEquals("Calc wrong for 1*0", "", result);
        assertEquals("Step count has changed", 5, tm.getStepCount());
    }

    @Test
    public void multiplyByOne() {
        Band band = new Band(stars(1, 1));
        TuringMachine tm = new TuringMachine(band, CONSOLE);
        String result = tm.run();
        assertEquals("Calc wrong for 1*1", stars(1 * 1), result);
        assertEquals("Step count has changed", 12, tm.getStepCount());
    }
}