package Homework_3;
/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество номер телефона
Форматы данных:
фамилия, имя, отчество - строки
номер телефона - целое беззнаковое число без форматирования

Ввод всех элементов через пробел
Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><номер_телефона>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class AskPersonalData {
    public static void main(String[] args) {
        String result = inputPersonalData();
        checkData(result);
    }

    public static String inputPersonalData() {
        System.out.println("Введите фамилию, имя, отчество, номер телефона(через пробел): ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void checkData(String data) {
        String[] pd = data.split(" ");
        int countLetters = 0;
        int countDigits = 0;
        String fileName = pd[0] + ".txt";
        Path path = Path.of(fileName);
        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException ex) {
            System.out.println("Файл уже существует");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (pd.length == 4) {
            for (int i = 0; i < pd.length; i++) {  // цикл по каждому элементу массива строк
                char[] el = pd[i].toCharArray(); // разбиваем каждое слово на массив char
                for (char e : el) { // проходим по каждому элементу массива символов
                    if (Character.isLetter(e)) {
                        countLetters++;
                        if (countLetters == pd[i].length()) {
                            System.out.printf("Элемент \"%s\" - это слово", pd[i]);
                            writeDataToFile(path, pd[i] + " ");
                            countLetters = 0;
                        }
                    } else if (Character.isDigit(e)) {
                        countDigits++;
                        if (countDigits == pd[i].length()) {
                            System.out.printf("Элемент \"%s\" -  это число", pd[i]);
                            writeDataToFile(path, pd[i] + '\n');
                            countDigits = 0;
                        }
                    } else {
                        System.out.printf("Проверьте введённые данные в элементе \'%s\'\n", pd[i]);
                        break;
                    }
                }
            }
        } else if (pd.length < 4) {
            System.out.println("Вы ввели данных меньше, чем нужно. Проверьте количество введённых данных");
        } else {
            System.out.println("Вы ввели данных больше, чем нужно. Проверьте количество введённых данных");

        }
    }

    public static void writeDataToFile(Path path, String fileDatq) {
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            bw.write(fileDatq);
//            bw.write(" ");
            System.out.println("\nДанные yспешно записаны в файл");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


