package org.example;

import java.util.Arrays;

public class hw01 {
    public static void main(String[] args) {

        String[][] arr2d = new String[][] {{"1","2","3"}, {"3","2","1"}};
        int[] arrInt_1 = new int[]{1, 2, 3};
        int[] arrInt_2 = new int[]{3, 2, 1};
        int[] arrInt_bad = new int[]{3, 2, 1, 0};

        System.out.println(sum2d(arr2d));
        System.out.println("task_2: " + Arrays.toString(task2(arrInt_1, arrInt_2)));
        System.out.println("task_2: " + Arrays.toString(task2(arrInt_1, arrInt_bad)));
        System.out.println("task_3: " + Arrays.toString(task3(arrInt_1, arrInt_2)));
        System.out.println("task_3: " + Arrays.toString(task3(arrInt_1, arrInt_bad)));
    }

//    Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
//    Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?





    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }


    public static int[] task2(int[] arr1, int[] arr2) {
        //    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
        //    и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
        //    Если длины массивов не равны, необходимо как-то оповестить пользователя.
        if (arr1.length != arr2.length) {
            System.out.println("Длины массивов не равны");
            return null;
        }
        int[] arrResult = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arrResult[i] = arr1[i] - arr2[i];
        }
        return arrResult;
    }

    public static int[] task3(int[] arr1, int[] arr2) {
        //* Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
        // каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
        // Если длины массивов не равны, необходимо как-то оповестить пользователя.
        // Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException,
        // т.е. ваше.
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны");
        }
        int[] arrResult = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arrResult[i] = arr1[i] / arr2[i];
        }
        return arrResult;
    }
}
