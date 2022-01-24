package hu.webstar.humanreadabledurationformat;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class TimeQuantities {

    private final Map<TimeUnit, Integer> timeUnitAndValues;

    public TimeQuantities() {
        timeUnitAndValues = new EnumMap<>(TimeUnit.class);
    }

    public Integer getQuantity (TimeUnit timeUnit) {
        return timeUnitAndValues.get(timeUnit);
    }

    public void setQuantity(TimeUnit timeUnit, Integer value) {
        timeUnitAndValues.put(timeUnit, value);
    }

    public Set<TimeUnit> getAvailableTimeUnits() {
        return timeUnitAndValues.keySet();
    }
}
