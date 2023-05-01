package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.DataFormatException;

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

    public static void main(String[] args) throws DataFormatException {
        inputData();
    }



    public static void inputData() throws DataFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Фамилию Имя Отчество датарождения номертелефона пол через пробел:");
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        if (data.length > 6) {
            throw new RuntimeException("Вы ввели слишком много данных");
        }
        String surname = data[0];
        if (!checkString(surname)){
            throw new RuntimeException("ОШИБКА: передано '" + surname + "', но фамилия должна содержать только буквы");
        }
        String name = data[1];
        if (!checkString(name)){
            throw new RuntimeException("ОШИБКА: передано '" + name + "', но имя должно содержать только буквы");
        }
        String patronymic = data[2];
        if (!checkString(patronymic)){
            throw new RuntimeException("ОШИБКА: передано '" + patronymic + "', но отчество должно содержать только буквы");
        }
        String dateOfBirth = data[3];
        if (!checkDateFormat("dd.MM.yyyy", dateOfBirth)){
            throw new DataFormatException("ОШИБКА: передано '" + dateOfBirth + "', но дата должна быть в правильном формате - DD.MM.YYYY");
        }
        String phoneNumber = data[4];
        if (!checkNumb(phoneNumber)){
            throw new RuntimeException("ОШИБКА: передано '" + phoneNumber + "', но номер телефона должен содержать только цифры!");
        }
        String gender = data[5];
        if (checkGender(gender)){
            throw new RuntimeException("ОШИБКА: передано '" + gender + "', но не верное определение гендера");
        }

        String sepSymbol = ";";
        try {
            FileWriter writer = new FileWriter(surname + ".csv");
            writer.write(surname + sepSymbol + name + sepSymbol +
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

    public static boolean checkString(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isLetter(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkDateFormat(String format, String dateInput){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateInput);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean checkNumb (String value){
        boolean check = true;
        for (int i = 0; i < value.length() && check; i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }




    static boolean checkGender (String value){
        boolean check = true;
        if ((!value.equals("m") && !value.equals("f") && !value.equals("м") && !value.equals("ж")) && check) {
            return true;
        }
        return false;
    }
}