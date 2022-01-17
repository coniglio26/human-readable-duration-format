package hu.webstar.humanreadabledurationformat;

public class TimeFormatterApp {
    public static void main(String[] args) {
        TimeFormatter timeFormatter = new TimeFormatter();
        System.out.println(timeFormatter.formatDuration(132030240));
    }
}
