package hu.webstar.humanreadabledurationformat;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class TimeQuantities {

    private Map<TimeUnit, Integer> timeUnitAndValues;

    public TimeQuantities() {
        timeUnitAndValues = new EnumMap<>(TimeUnit.class);
    }

    public TimeQuantities(Map<TimeUnit, Integer> timeUnitAndValues) {
        this.timeUnitAndValues = new EnumMap<>(TimeUnit.class);
    }

    public Integer getQuantity (TimeUnit timeUnit) {
        return timeUnitAndValues.get(timeUnit);
    }

    public Set<TimeUnit> getAvailableTimeUnits() {
        return timeUnitAndValues.keySet(); }

    public int getTimeUnitsAndValuesSize () {
        return timeUnitAndValues.size();
    }

    public void setTimeQuantities (TimeUnit timeUnit, Integer value) {
        timeUnitAndValues.put(timeUnit, value);
    }

}
