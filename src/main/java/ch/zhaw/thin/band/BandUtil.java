package ch.zhaw.thin.band;

/**
 * @author Arik, Simon
 */
public class BandUtil {

    private BandUtil() {
        // utility constructor
    }

    public static String stars(int c1, int c2) {
        return build(c1, c2, BandSymbol.star(), BandSymbol.space());
    }

    public static String stars(int count) {
        return build(count, BandSymbol.star());
    }

    public static String head(int spacesBefore) {
        return spaces(spacesBefore) + BandSymbol.head();
    }

    public static String spaces(int count) {
        return build(count, BandSymbol.space());
    }

    private static String build(int count1, int count2, char symbol, char delimiter) {
        return build(count1, symbol) + delimiter + build(count2, symbol);
    }

    private static String build(int count, char symbol) {
        char[] chars = new char[count];
        for (int i = 0; i < count; i++) {
            chars[i] = symbol;
        }
        return String.copyValueOf(chars);
    }
}
