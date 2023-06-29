package Homework_2;

import java.util.Scanner;

/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
public class Task_01 {

    public static void main(String[] args) {

        System.out.println(askDigit());
    }

    public static float askDigit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите дробное число: ");
        while (true) {
            String digit = sc.nextLine();
            if (digit.contains(".")) {
                if (isNumeric(digit)) {
                    return Float.parseFloat(digit);
                }
            } else {
                System.out.print("Введите дробное число снова: ");
            }
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

