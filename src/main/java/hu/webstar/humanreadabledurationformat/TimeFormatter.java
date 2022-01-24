package hu.webstar.humanreadabledurationformat;

public class TimeFormatter {

    public String formatDuration(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Seconds value cannot be negative!");
        }
        return new TimePresenter(new TimeConverter().convertTime(seconds)).presentTime();
    }
}
