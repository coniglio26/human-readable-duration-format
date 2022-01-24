package hu.webstar.humanreadabledurationformat;

public class TimeConverter {

    public TimeQuantities convertTime(int second) {
        TimeQuantities timeQuantities = new TimeQuantities();

        if (second == 0) {
            return timeQuantities;
        }

        int remainingSeconds = second;

        for (TimeUnit unit : TimeUnit.values()) {
            int quotient = remainingSeconds / unit.getDivisor();
            if (quotient > 0) {
                timeQuantities.setQuantity(unit, quotient);
                remainingSeconds %= unit.getDivisor();
            }
        }
        return timeQuantities;
    }
}
