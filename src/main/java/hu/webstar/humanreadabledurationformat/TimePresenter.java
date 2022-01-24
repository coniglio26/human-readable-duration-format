package hu.webstar.humanreadabledurationformat;


public class TimePresenter {

    private TimeQuantities timeQuantities = new TimeQuantities();

    public TimePresenter() {
    }

    public TimePresenter(TimeQuantities timeQuantities) {
        this.timeQuantities = timeQuantities;
    }

    public String generateTime() {
        if (timeQuantities.getAvailableTimeUnits().size() == 0) {
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
                            switch (timeQuantities.getAvailableTimeUnits().size() - remainingParts) {
                                case 0 -> "";
                                case 1 -> " and ";
                                default -> ", ";
                            });
            remainingParts++;
        }
        return result.toString();
    }
}
