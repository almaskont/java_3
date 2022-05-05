import java.util.Arrays;

public class Homework {

    private static final int[] ARR1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    private static final int[] ARR2 = new int[100];
    private static final int[] ARR3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    private static final int[][] ARR4 = new int[7][7];
    private static final int LENGTH = 5;
    private static final int VALUE = 8;
    private static final int ARRAY_LENGTH = 10;
    private static final int[] ARR7 = {2, 2, 2, 1, 2, 2, 10, 1};

    public static void main(String[] args) {

        firstProblem(ARR1);

        secondProblem(ARR2);

        thirdProblem(ARR3);

        fourthProblem(ARR4);

        fifthProblem(LENGTH, VALUE);

        sixthProblem(ARRAY_LENGTH);

        seventhProblem(ARRAY_LENGTH, ARR7);

        eighthProblem(ARRAY_LENGTH, 2);
    }

    private static void firstProblem(int[] arr1) {
        System.out.print("Задание 1: ");
        changeZerosToOnes(arr1);
    }

    private static void secondProblem(int[] arr2) {
        System.out.print("Задание 2: ");
        fillArray(arr2);
    }

    private static void thirdProblem(int[] arr3) {
        System.out.print("Задание 3: ");
        multiplyNumbers(arr3);
    }

    private static void fourthProblem(int[][] arr4) {
        System.out.println("Задание 4: ");
        diagonal(arr4);
        System.out.println();
        System.out.println("Другое решение");
        diagonalAnother(arr4);
    }

    private static void fifthProblem(int len, int initialValue) {
        System.out.print("Задание 5: ");
        System.out.println(Arrays.toString(declareArray(len, initialValue)));
    }

    private static void sixthProblem(int arrayLength) {
        System.out.print("Задание 6: ");
        int[] randomArray6 = declareRandomArray(arrayLength);
        System.out.println(Arrays.toString(randomArray6));
        System.out.printf("Min: %d%n", minValue(randomArray6));
        System.out.printf("Max: %d%n", maxValue(randomArray6));
    }

    private static void seventhProblem(int randomArrayLength, int[] trueArray) {
        System.out.print("Задание 7: ");
        int[] randomArray7 = declareRandomArray(randomArrayLength);
        System.out.println(Arrays.toString(randomArray7));
        System.out.println(checkBalance(randomArray7));
        System.out.println(Arrays.toString(trueArray));
        System.out.println(checkBalance(trueArray));
    }

    private static void eighthProblem(int randomArrayLength, int shift) {
        System.out.print("Задание 8: ");
        int[] randomArray8 = declareRandomArray(randomArrayLength);
        System.out.println(Arrays.toString(randomArray8));
        System.out.printf("Shifting to the right on %d positions%n", shift);
        shiftArray(randomArray8, shift);
        System.out.printf("Shifting to the left on %d positions%n", -shift);
        shiftArray(randomArray8, -shift);
    }

    static void changeZerosToOnes(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void multiplyNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void printingTwoDArray(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static void diagonal(int[][] arr) {
        int k = 0;
        int l = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == k || j == l) {
                    arr[i][j] = 1;
                }
            }
            k++;
            l--;
        }
        printingTwoDArray(arr);
    }

    static void diagonalAnother(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == i) {
                    arr[i][j] = 1;
                }
            }
        }
        printingTwoDArray(arr);
    }

    static int[] declareArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    static int[] declareRandomArray(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    static int minValue(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static int maxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static boolean checkBalance(int[] arr) {
        int sum = 0;
        int halfSum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 2 == 0) {
            for (int j : arr) {
                halfSum += j;
                if (halfSum == sum / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    static int[] shiftArray(int[] arr, int n) {
        if (n > 0) {
            return moveRight(arr, n);
        } else if (n < 0) {
            return moveLeft(arr, -n);
        } else {
            return arr;
        }
    }

    static int[] moveRight(int[] arr, int n) {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
        return arr;
    }

    static int[] moveLeft(int[] arr, int n) {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        return arr;
    }
}
