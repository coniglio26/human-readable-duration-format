package hu.webstar.humanreadabledurationformat;

import hu.webstar.humanreadabledurationformat.TimeFormatter;
import hu.webstar.humanreadabledurationformat.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.util.Random;

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

    @RepeatedTest(value = 50, name = "testSum: {currentRepetition} / {totalRepetitions}")
    public void randomTestsWithPositiveNumbers_validValues() {
        Random r = new Random();

        int[] randomTimeUnits = {r.nextInt(48) + 2,
                r.nextInt(363) + 2,
                r.nextInt(22) + 2,
                r.nextInt(58) + 2,
                r.nextInt(58) + 2};

        int[] randomTimeUnitsInSeconds =
                {randomTimeUnits[0] * TimeUnit.YEAR.getDivisor(),
                        randomTimeUnits[1] * TimeUnit.DAY.getDivisor(),
                        randomTimeUnits[2] * TimeUnit.HOUR.getDivisor(),
                        randomTimeUnits[3] * TimeUnit.MINUTE.getDivisor(),
                        randomTimeUnits[4]};

        int input = 0;
        for (int j = 0; j < 5; j++) {
            input += randomTimeUnitsInSeconds[j];
        }

        StringBuilder expected = new StringBuilder();

        expected.append(randomTimeUnits[0]).append(" years, ")
                .append(randomTimeUnits[1]).append(" days, ")
                .append(randomTimeUnits[2]).append(" hours, ")
                .append(randomTimeUnits[3]).append(" minutes and ")
                .append(randomTimeUnits[4]).append(" seconds");

        assertEquals(expected.toString(), timeFormatter.formatDuration(input));
    }
}