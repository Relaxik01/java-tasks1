package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecondTaskTest {

    @Test
    void nZeroReturnsFirst() {
        // Базовый случай: n = 0 → ширина равна first
        assertEquals(4.0, SecondTask.width(4, 2, 0));
    }

    @Test
    void ratioTwoGrows() {
        // Рекурсивный случай: 4 * 2 * 2 * 2 * 2 = 64
        assertEquals(64.0, SecondTask.width(4, 2, 4));
    }

    @Test
    void ratioOneKeepsSame() {
        // Рекурсивный случай: коэффициент 1 → ширина не меняется
        assertEquals(100.0, SecondTask.width(100, 1, 5));
    }

    @Test
    void nOneReturnsFirstTimesRatio() {
        // Дополнительный: n = 1 → first * ratio
        assertEquals(20.0, SecondTask.width(10, 2, 1));
    }
}