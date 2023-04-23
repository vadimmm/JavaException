package org.example;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class hw02 {
    public static void main(String[] args) throws Exception {
//        task 1
//        System.out.println("Вы ввели число: " + inputFloat());

        // task 4
        System.out.println("Вы ввели следующие данные: " + inputNotNull());

    }

//  Дан следующий код, исправьте его там, где требуется
//  (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//  Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//  Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    public static Float inputFloat() {
        //  Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
        //  и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
        //  вместо этого, необходимо повторно запросить у пользователя ввод данных.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дробное число: ");
        float number = 0;
        try {
            number = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число, попробуйте снова!");
            inputFloat();
        }
        return number;
    }

    public void task2(int[] intArray){
        //  2. Если необходимо, исправьте данный код
        //  (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
        if (intArray == null){
            System.out.println("Входящий массив пустой!");
        }
        try {
            int d = 0;
            double catchedRes1 = (double) intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    public void task3(int a, int b){
        //  Дан следующий код, исправьте его там, где требуется
        //  (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
        System.out.println(a / b);
        try {
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

    public static String inputNotNull() throws Exception {
//          Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//          Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите данные: ");
        String value = scanner.nextLine();
        if (value.isEmpty()){
            throw new Exception("Пустые строки вводить нельзя");
        } else {
            System.out.println("Данные приняты");
        }
        return value;
    }
}