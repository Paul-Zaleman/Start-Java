import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. ВЫВОД ASCII-СИМВОЛОВ");
        System.out.printf("%s %s %s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i <= 47; i++) {
            if (i % 2 != 0) {
                System.out.printf(" %-9s %-10s %-20s%n", i, (char) i, Character.getName(i));
            }
        }

        for (int i = 98; i <= 122; i++) {
            if (i % 2 == 0) {
                System.out.printf(" %-9s %-10s %-20s%n", i, (char) i, Character.getName(i));
            }
        }

        System.out.println("\n2. ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");
        int rows = 5;
        String rectangle = "---------";
        for (int i = 0; i < rows; i++) {
            System.out.print(rectangle + " ");

            for (int j = rows; j > i; j--) {
                System.out.print("*");
            }
            
            System.out.print(" ");
            for (int j = 0; j <= i * 2; j++) {
                System.out.print("^");
            }
            System.out.println();
        }

        System.out.println("\n3. ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ");
        System.out.print("   |   2   3   4   5   6   7   8   9");
        System.out.println("\n---+---------------------------------");
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%2d |", i);
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        System.out.println("\n4. ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");
        for (int i = 1, count = 1; count <= 15; i += 2, count++) {
            int value = (i < 24) ? i : 0;
            System.out.printf("%3d", value);

            if (count % 5 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n5. ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX");
        int a = 10;
        int b = 5;
        int c = -1;
        int min = a;
        int max = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n6. РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ");
        int originalNumber = 2234321;
        int originalNumCopy = originalNumber;
        int reversed = 0;
        int countTwos = 0;

        while (originalNumCopy > 0) {
            int digit = originalNumCopy % 10;
            if (digit == 2) {
                countTwos++;
            }
            reversed = reversed * 10 + digit;
            originalNumCopy /= 10;
        }

        boolean isPalindrome = (originalNumber == reversed);
        String evenTwos = (countTwos % 2 == 0) ? "чётным" : "нечётным";
        String palindrome = isPalindrome ? "палиндром" : "не палиндром";
        System.out.printf("%d - %s с %s (%d) количеством двоек%n", 
                originalNumber, palindrome, evenTwos, countTwos);

        System.out.println("\n7. ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА");
        int number = originalNumber;
        int firstHalf = number / 1000;
        int secondHalf = number % 1000;
        int sumFirst = 0;
        int sumSecond = 0;

        int tmpFirst = firstHalf;
        while (tmpFirst > 0) {
            sumFirst += tmpFirst % 10;
            tmpFirst /= 10;
        }

        int tmpSecond = secondHalf;
        while (tmpSecond > 0) {
            sumSecond += tmpSecond % 10;
            tmpSecond /= 10;
        }

        boolean isLucky = (sumFirst == sumSecond);

        System.out.printf("%d - %s число%n", number, isLucky ? "счастливое" : "не счастливое");
        System.out.printf("Сумма цифр %03d = %d%n", firstHalf, sumFirst);
        System.out.printf("Сумма цифр %03d = %d%n", secondHalf, sumSecond);

        System.out.println("\n8. ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ");
        int passwordLength = 8;
        Random random = new Random();
        String password = "";

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < passwordLength; i++) {
            char ch = (char) random.nextInt(33, 127);
            password += ch;

            if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecial = true;
            }
        }

        String strength = "слабый";
        if (password.length() >= passwordLength && hasLower && hasUpper && hasSpecial) {
            strength = "надёжный";
        } else if (password.length() >= passwordLength && (hasUpper || hasDigit)) {
            strength = "средний";
        }

        System.out.printf("Пароль: %s%n", password);
        System.out.printf("Надёжность: %s%n", strength);
    }
}