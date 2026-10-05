package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FirstTaskTest {

    @Test
    void emptyArrayReturnsZero() {
        assertEquals(0, FirstTask.countFrom(new int[]{}, 0));
    }

    @Test
    void startIndexAtEndReturnsZero() {
        assertEquals(0, FirstTask.countFrom(new int[]{4, 7, 2}, 3));
    }

    @Test
    void fromZeroReturnsAllElements() {
        assertEquals(3, FirstTask.countFrom(new int[]{4, 7, 2}, 0));
    }

    @Test
    void fromMiddleReturnsRest() {
        assertEquals(2, FirstTask.countFrom(new int[]{4, 7, 2}, 1));
    }
}