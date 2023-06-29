package Homework_2;

import java.util.Scanner;

/*
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class Task_04 {
    public static void main(String[] args) {
        EmptyStringException();
    }

    public static void EmptyStringException() {
        System.out.print("Введите строку: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                String str = sc.nextLine();
                if (str.isEmpty()) {
                    throw new RuntimeException();
                } else {
                    System.out.printf("Вы ввели строку: %s", str);
                    break;
                }
            } catch (RuntimeException e) {
                System.out.println("Пустые строки вводить нельзя. Введите строку снова: ");
            }
        }
    }
}

