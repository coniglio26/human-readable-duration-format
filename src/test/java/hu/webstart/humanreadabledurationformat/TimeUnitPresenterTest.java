package hu.webstart.humanreadabledurationformat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeUnitPresenterTest {

    private TimeFormatter timeFormatter;

    private final Object[][] testCases = {
            {0, "now"}
    };

    @BeforeEach
    void init() {
        timeFormatter = new TimeFormatter();
    }

    @Test
    void test_formatDuration_negative_illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> timeFormatter.formatDuration(-1));
    }

    @RepeatedTest(value = 1, name = "testSum: {currentRepetition} / {totalRepetitions}")
    void formatDuration_repeated_validValues(RepetitionInfo info) {
        int i = info.getCurrentRepetition() - 1;
        Integer input = (Integer) testCases[i][0];
        String expected = (String) testCases[i][1];
        assertEquals(expected, timeFormatter.formatDuration(input));
    }
}