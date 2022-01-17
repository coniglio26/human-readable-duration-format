package hu.webstart.humanreadabledurationformat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeUnitPresenterTest {

    private TimeFormatter timeFormatter;

    @BeforeEach
    void init() {
        timeFormatter = new TimeFormatter();
    }

    @Test
    void test_formatDuration_negative_illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> timeFormatter.formatDuration(-1));
    }
}