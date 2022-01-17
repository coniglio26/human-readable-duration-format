package hu.webstart.humanreadabledurationformat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeUnitPresenterTest {

    private TimeFormatter timeFormatter;

    private final Object[][] testCases = {
            {1, "1 second"},
            {62, "1 minute and 2 seconds"},
            {120, "2 minutes"},
            {3600, "1 hour"},
            {3662, "1 hour, 1 minute and 2 seconds"},
            {0, "now"},
            {15731080, "182 days, 1 hour, 44 minutes and 40 seconds"},
            {132030240, "4 years, 68 days, 3 hours and 4 minutes"},
            {205851834, "6 years, 192 days, 13 hours, 3 minutes and 54 seconds"},
            {253374061, "8 years, 12 days, 13 hours, 41 minutes and 1 second"},
            {242062374, "7 years, 246 days, 15 hours, 32 minutes and 54 seconds"},
            {101956166, "3 years, 85 days, 1 hour, 9 minutes and 26 seconds"},
            {33243586, "1 year, 19 days, 18 hours, 19 minutes and 46 seconds"}
    };

    @BeforeEach
    void init() {
        timeFormatter = new TimeFormatter();
    }

    @Test
    void test_formatDuration_negative_illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> timeFormatter.formatDuration(-1));
    }

    @RepeatedTest(value = 13, name = "testSum: {currentRepetition} / {totalRepetitions}")
    void formatDuration_repeated_validValues(RepetitionInfo info) {
        int i = info.getCurrentRepetition() - 1;
        Integer input = (Integer) testCases[i][0];
        String expected = (String) testCases[i][1];
        assertEquals(expected, timeFormatter.formatDuration(input));
    }
}