package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ThirdTaskTest {

    // Вспомогательный метод: перехватывает вывод generateSubsets и возвращает его строкой
    private String captureOutput(int[] values) {
        PrintStream originalOut = System.out;

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));

        try {
            int[] current = new int[values.length];
            ThirdTask.generateSubsets(values, 0, current, 0);
        } finally {
            System.setOut(originalOut);
        }

        return buffer.toString();
    }

    // Считает непустые строки в выводе
    private long countLines(String output) {
        long count = 0;
        for (String line : output.split("\\R")) {
            if (!line.trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    @Test
    void threeElementsProduceEightSubsets() {
        // Проверка из задания: для {1, 2, 3} должно быть 8 подмножеств
        String output = captureOutput(new int[]{1, 2, 3});
        assertEquals(8, countLines(output));
    }

    @Test
    void emptySetIsPrinted() {
        // Пустое множество должно присутствовать
        String output = captureOutput(new int[]{1, 2, 3});
        assertTrue(output.contains("{ }"));
    }

    @Test
    void fullSetIsPrinted() {
        // Исходное множество тоже должно присутствовать
        String output = captureOutput(new int[]{1, 2, 3});
        assertTrue(output.contains("{ 1 2 3 }"));
    }

    @Test
    void singleElementProducesTwoSubsets() {
        // Базовый случай для массива из одного элемента: {} и {1}
        String output = captureOutput(new int[]{1});
        assertEquals(2, countLines(output));
    }

    @Test
    void twoElementsProduceFourSubsets() {
        // Ещё один рекурсивный случай: для {1, 2} → 4 подмножества
        String output = captureOutput(new int[]{1, 2});
        assertEquals(4, countLines(output));
    }
}