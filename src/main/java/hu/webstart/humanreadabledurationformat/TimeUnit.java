package hu.webstart.humanreadabledurationformat;

public enum TimeUnit {

    YEAR (365 * 24 * 60 * 60),
    DAY(24 * 60 * 60),
    HOUR(60 * 60),
    MINUTE(60),
    SECOND(1);

    private final int divisor;

    TimeUnit(int divisor) {
        this.divisor = divisor;
    }

    public int getDivisor() {
        return divisor;
    }
}

