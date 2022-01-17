package hu.webstart.humanreadabledurationformat;

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

        return timeUnitValuesMap;
    }
}
