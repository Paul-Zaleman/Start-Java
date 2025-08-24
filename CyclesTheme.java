import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. ВЫВОД ASCII-СИМВОЛОВ");
        System.out.printf("%s %s %s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        String str = "";
        for (int i = 33; i <= 47; i++) {
            if (i % 2 != 0) {
                System.out.printf("%-1s %-9s %-10s %-20s%n", str, i, (char) i, Character.getName(i));
            }
        }

        for (int i = 98; i <= 122; i++) {
            if (i % 2 == 0) {
                System.out.printf("%-1s %-9s %-10s %-20s%n", str, i, (char) i, Character.getName(i));
            }
        }

        System.out.println("\n2. ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");
        int rows = 5;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print("-");
            }
            System.out.print(" ");

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
        System.out.print("   |");
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println("\n---+---------------------------------");
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%2d |", i);
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        System.out.println("\n4. ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");
        int count = 0;
        for (int i = 1; i < 24; i++) {
            if (i % 2 != 0) {
                System.out.printf("%3d", i);
                count++;

                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }

        int remainder = count % 5;
        if (remainder != 0) {
            for (int i = remainder; i < 5; i++) {
                System.out.printf("%3d", 0);
            }
            System.out.println();
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
        int num = originalNumber;
        int reversed = 0;
        int countTwos = 0;

        while (originalNumber > 0) {
            int digit = originalNumber % 10;
            if (digit == 2) {
                countTwos++;
            }
            reversed = reversed * 10 + digit;
            originalNumber /= 10;
        }

        boolean isPalindrome = (originalNumber == reversed);
        String evenTwos = (countTwos % 2 == 0) ? "чётным" : "нечётным";
        String palindrome = isPalindrome ? "палиндром" : "не палиндром";
        System.out.printf("%d - %s с %s (%d) количеством двоек%n", num, palindrome, evenTwos, countTwos);

        System.out.println("\n7. ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА");
        int number = 101002;
        int firstThreeNum = number / 1000;
        int lastThreeNum = number % 1000;
        int sumFirstThreeNum = (firstThreeNum / 100) + (firstThreeNum / 10 % 10) + (firstThreeNum % 10);
        int sumLastThreeNum = (lastThreeNum / 100) + (lastThreeNum / 10 % 10) + (lastThreeNum % 10);
        boolean isLike = sumFirstThreeNum == sumLastThreeNum;
        System.out.printf("%d - %s число%n", number, isLike ? "счастливое" : "не счастливое");
        System.out.printf("Сумма цифр %03d = %d%n", firstThreeNum, sumFirstThreeNum);
        System.out.printf("Сумма цифр %03d = %d%n", lastThreeNum, sumLastThreeNum);

        System.out.println("\n8. ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ");
        int lengthPassword = 8;
        Random random = new Random();
        String password = "";

        for (int i = 0; i < lengthPassword; i++) {
            char ch = (char) random.nextInt(33, 127);
            password += ch;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);

            if (Character.isLowerCase(symbol)) {
                hasLower = true;
            } else if (Character.isUpperCase(symbol)) {
                hasUpper = true;
            } else if (Character.isDigit(symbol)) {
                hasDigit = true;
            } else {
                hasSpecial = true;
            }
        }

        String strength;
        if (password.length() >= 8 && hasLower && hasUpper && hasSpecial) {
            strength = "надёжный";
        } else if (password.length() >= 8 && (hasUpper || hasDigit)) {
            strength = "средний";
        } else {
            strength = "слабый";
        }
        System.out.printf("Пароль: %s%n", password);
        System.out.printf("Надёжность: %s%n", strength);
    }
}