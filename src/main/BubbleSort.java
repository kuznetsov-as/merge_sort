package main;

public class BubbleSort {

    public static void sortDescendingInt(int[] buffer) {
        for (int j = 0; j < buffer.length; j++) {
            for (int k = 0; k < buffer.length - 1; k++) {
                if (buffer[k] < buffer[k + 1]) {
                    int temp = buffer[k];
                    buffer[k] = buffer[k + 1];
                    buffer[k + 1] = temp;
                }
            }
        }

    }

    public static void sortAscendingInt(int[] buffer) {
        for (int j = 0; j < buffer.length; j++) {
            for (int k = 0; k < buffer.length - 1; k++) {
                if (buffer[k] > buffer[k + 1]) {
                    int temp = buffer[k];
                    buffer[k] = buffer[k + 1];
                    buffer[k + 1] = temp;
                }
            }
        }

    }

    public static void sortAscendingString(String[] buffer) {
        for (int j = 0; j < buffer.length; j++) {
            for (int k = 0; k < buffer.length - 1; k++) {
                if (buffer[k].compareTo(buffer[k + 1]) > 0) {
                    String temp = buffer[k];
                    buffer[k] = buffer[k + 1];
                    buffer[k + 1] = temp;
                }
            }
        }
    }

    public static void sortDescendingString(String[] buffer) {
        for (int j = 0; j < buffer.length; j++) {
            for (int k = 0; k < buffer.length - 1; k++) {
                if (buffer[k].compareTo(buffer[k + 1]) < 0) {
                    String temp = buffer[k];
                    buffer[k] = buffer[k + 1];
                    buffer[k + 1] = temp;
                }
            }
        }
    }
}
