package third.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestInterval {
    Interval interval;

    @BeforeEach
    void setUp() {
        interval = new Interval();
    }

    @ParameterizedTest
    @ValueSource( ints = {26, 50, 99})
        void testGetInInterval (int num) {
        boolean value = interval.numberInInterval(num);
        Assertions.assertTrue(value);
    }

    @ParameterizedTest
    @ValueSource( ints = {24, 25, 100, 101})
    void testOutOfInterval (int num) {
        boolean value = interval.numberInInterval(num);
        Assertions.assertFalse(value);
    }

}
