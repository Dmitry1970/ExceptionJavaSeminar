package Seminar_2.Homework_2;

/*
Если необходимо, исправьте данный код:
try {
   int d = 0;
   double catchedRes1 = intArray[8] / d;
   System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArithmeticException e) {
   System.out.println("Catching exception: " + e);
}

 */
public class Task_02 {
    public static void main(String[] args) {

        int[] intArray = new int[] {1,4,7,9,3,6,8,45,23,67};

        try {
            double d = 5;  // надо было исправить int на double, иначе результат округляется до целых значений
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}