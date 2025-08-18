public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. ВЫВОД ASCII-СИМВОЛОВ");

        System.out.println("2. ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");
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
    }
}