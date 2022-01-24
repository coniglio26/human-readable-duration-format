package hu.webstar.humanreadabledurationformat;


public class TimeUnitPresenter {

    private TimeQuantities timeQuantities;

    public TimeUnitPresenter() {
    }
    public TimeUnitPresenter(TimeQuantities timeQuantities) {
        this.timeQuantities = timeQuantities;
    }

    public String presentTime() {

        if (timeQuantities.getTimeUnitsAndValuesSize() == 0) {
            return "now";
        }

        StringBuilder result = new StringBuilder();
        int remainingParts = 1;

        for (TimeUnit timeUnit : timeQuantities.getAvailableTimeUnits()) {

            result.append(timeQuantities.getQuantity(timeUnit))
                    .append(" ")
                    .append(timeUnit.toString().toLowerCase())
                    .append((timeQuantities.getQuantity(timeUnit)) > 1 ? "s" : "")
                    .append(
                            switch (timeQuantities.getTimeUnitsAndValuesSize() - remainingParts) {
                                case 0 -> "";
                                case 1 -> " and ";
                                default -> ", ";
                            });
            remainingParts++;
        }
        return result.toString();
    }
}
