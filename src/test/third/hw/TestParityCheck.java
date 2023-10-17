package third.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestParityCheck {
    MainHW mainHW;
    @BeforeEach
    void setUp() {
         mainHW = new MainHW();
    }

    @Test
    void testEvenNumber() {
        int n = 4;
        boolean value = mainHW.evenOddNumber(n);
        Assertions.assertTrue(value);
    }

    @Test
    void testOddNumber() {
        int n = 3;
        boolean value = mainHW.evenOddNumber(n);
        Assertions.assertFalse(value);
    }

}
