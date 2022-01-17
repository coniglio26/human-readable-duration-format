package hu.webstar.humanreadabledurationformat;

import java.util.EnumMap;
import java.util.Map;

public class TimeFormatter {

    public String formatDuration(int second) {

        if (second < 0) {
            throw new IllegalArgumentException("Seconds value cannot be negative!");
        }

        return new TimeUnitPresenter(convertSecondsToMap(second)).toString();
    }

    public Map<TimeUnit, Integer> convertSecondsToMap(int second) {

        Map<TimeUnit, Integer> timeUnitValuesMap = new EnumMap<>(TimeUnit.class);

        if (second == 0) {
            return timeUnitValuesMap;
        }

        int remainder = second;

        for (TimeUnit unit : TimeUnit.values()) {
            int quotient = remainder / unit.getDivisor();
            if (quotient > 0) {
                timeUnitValuesMap.put(unit, quotient);
                remainder %= unit.getDivisor();
            }
        }
        return timeUnitValuesMap;
    }
}
