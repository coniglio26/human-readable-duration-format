package hu.webstart.humanreadabledurationformat;

import java.util.Map;

public class TimeUnitPresenter {
    private Map<TimeUnit, Integer> timeUnitAndValues;

    public TimeUnitPresenter() {
    }

    public TimeUnitPresenter(Map<TimeUnit, Integer> timeUnitAndValues) {
        this.timeUnitAndValues = timeUnitAndValues;
    }


    public Map<TimeUnit, Integer> getTimeUnitAndValues() {
        return timeUnitAndValues;
    }

    public void setTimeUnitAndValues(Map<TimeUnit, Integer> timeUnitAndValues) {
        this.timeUnitAndValues = timeUnitAndValues;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        if (timeUnitAndValues.size() == 0) {
            result.append("now");

        } else {
            int j = 1;

            for (Map.Entry<TimeUnit, Integer> unit : timeUnitAndValues.entrySet()) {

                result.append(unit.getValue())
                        .append(" ")
                        .append(unit.getKey().toString().toLowerCase())
                        .append((unit.getValue()) > 1 ? "s" : "")
                        .append(
                                switch (timeUnitAndValues.size() - j) {
                                    case 0 -> "";
                                    case 1 -> " and ";
                                    default -> ", ";
                                });
                j++;
            }
        }
        return result.toString();
    }
}
