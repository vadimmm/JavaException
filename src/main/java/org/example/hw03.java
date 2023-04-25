package org.example;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class hw03 {

//    Напишите приложение, которое будет запрашивать у пользователя следующие данные в порядке,
//    разделенные пробелом:
//    Фамилия Имя Отчество датарождения номертелефона пол
//    Форматы данных:
//    фамилия, имя, отчество - строки
//    дата_рождения - строка формата dd.mm.yyyy
//    номер_телефона - целое беззнаковое число без форматирования
//    пол - символ латиницей f или m.
//
//    Приложение должно проверить введенные данные по количеству.
//    Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение,
//    что он ввел меньше и больше данных, чем требуется.
//
//    Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
//    Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
//    Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
//    пользователю выведено сообщение с информацией, что именно неверно.
//    Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
//    в него в одну строку должны записаться полученные данные, вида
//
//            <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//
//    Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//    Не забудьте закрыть соединение с файлом.
//    При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
//    пользователь должен увидеть стектрейс ошибки.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Фамилию Имя Отчество датарождения номертелефона пол через пробел:");
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        if (data.length > 6) {
            System.out.println("Вы ввели слишком много данных");
            return;
        }
        String surname = data[0];
        for(int i = 0; i < surname.length(); i++) {
            if(Character.isDigit(surname.charAt(i))) {
                System.out.println("Фамилия должна содержать только буквы");
                return;
            }
        }
        String name = data[1];

        String patronymic = data[2];
        String dateOfBirth = data[3];
        String phoneNumber = data[4];
        for(int i = 0; i < phoneNumber.length(); i++) {
            if(!Character.isDigit(phoneNumber.charAt(i))) {
                System.out.println("Номер телефона должен содержать только цифры");
                return;
            }
        }
        String gender = data[5];
        if (!gender.equals("m") && !gender.equals("f")) {
            System.out.println("Неверный формат пола");
            return;
        }
        String sepSymbol = ";";
        try {
            FileWriter writer = new FileWriter(surname + ".csv");
            writer.write(surname + sepSymbol +
                             name + sepSymbol +
                             patronymic + sepSymbol +
                             dateOfBirth + sepSymbol +
                             phoneNumber + sepSymbol +
                             gender);
            writer.close();
            System.out.println("Данные успешно записаны в файл " + surname + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean checkString(String value, String msg) {
        boolean check = true;
        for (int i = 0; i < value.length() && check; i++) {
            if (!Character.isDigit(value.charAt(i))) {
                System.out.println(msg);
                return false;
            }
        }
        return true;
        }

            static void checkNumb (String value, String msg){
                check = true;
                for (int i = 0; i < value.length() && check; i++) {
                    if (!Character.isDigit(value.charAt(i))) {
                        System.out.println(msg);
                        return;
                    }
                }
            }

            static void checkGender (String value, String msg){
                if (!value.equals("m") && !value.equals("f")) {
                    System.out.println(msg);
                    return;
                }
            }
        }