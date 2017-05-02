package ch.zhaw.thin.band;

/**
 * @author Arik, Simon
 */
public enum BandSymbol {

    SPACE(' '),
    STAR('*'),
    HEAD('^');

    private final char symbol;

    BandSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static char space() {
        return BandSymbol.SPACE.getSymbol();
    }

    public static char star() {
        return BandSymbol.STAR.getSymbol();
    }

    public static char head() {
        return BandSymbol.HEAD.getSymbol();
    }
}
