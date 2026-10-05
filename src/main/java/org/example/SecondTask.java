package org.example;

public class SecondTask {

    public static double width(double first, double ratio, int n) {
        if (n == 0) {
            return first;
        }
        return width(first, ratio, n - 1) * ratio;
    }

    public static void main(String[] args) {
        System.out.println("width(4, 2, 4) = " + width(4, 2, 4));
        System.out.println("width(100, 1, 5) = " + width(100, 1, 5));
        System.out.println("width(7, 3, 0) = " + width(7, 3, 0));
    }
}