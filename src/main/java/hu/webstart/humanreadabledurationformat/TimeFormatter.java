package hu.webstart.humanreadabledurationformat;

public class TimeFormatter {

    public String formatDuration(int second) {
        if (second < 0) {
            throw new IllegalArgumentException("Seconds value cannot be negative!");
        }
        return null;
    }
}
