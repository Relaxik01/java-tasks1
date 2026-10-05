package org.example;

public class FirstTask {

    public static int countFrom(int[] arr, int startIndex) {
        if (startIndex >= arr.length) {
            return 0;
        }
        return 1 + countFrom(arr, startIndex + 1);
    }

    public static void main(String[] args) {
        int[] empty = {};
        System.out.println("Пустой массив, индекс 0: " + countFrom(empty, 0));

        int[] arr = {4, 7, 2};
        System.out.println("Массив {4, 7, 2}, индекс 0: " + countFrom(arr, 0));
        System.out.println("Массив {4, 7, 2}, индекс 1: " + countFrom(arr, 1));
    }
}