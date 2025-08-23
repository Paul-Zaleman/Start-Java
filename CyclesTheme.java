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
    }
}