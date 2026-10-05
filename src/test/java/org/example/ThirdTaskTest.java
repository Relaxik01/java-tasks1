package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ThirdTaskTest {

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
        String output = captureOutput(new int[]{1, 2, 3});
        assertEquals(8, countLines(output));
    }

    @Test
    void emptySetIsPrinted() {
        String output = captureOutput(new int[]{1, 2, 3});
        assertTrue(output.contains("{ }"));
    }

    @Test
    void fullSetIsPrinted() {
        String output = captureOutput(new int[]{1, 2, 3});
        assertTrue(output.contains("{ 1 2 3 }"));
    }

    @Test
    void singleElementProducesTwoSubsets() {
        String output = captureOutput(new int[]{1});
        assertEquals(2, countLines(output));
    }

    @Test
    void twoElementsProduceFourSubsets() {
        String output = captureOutput(new int[]{1, 2});
        assertEquals(4, countLines(output));
    }
}