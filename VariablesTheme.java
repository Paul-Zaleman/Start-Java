import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VariablesTheme {
    public static void main(String[] args) {
        final long startNano = System.nanoTime();
        final LocalTime startTime = LocalTime.now();
        System.out.println("1. ВЫВОД ASCII-ГРАФИКИ");

        // первый способ (с помощью конкатенации)
        System.out.println("                     /\\");
        System.out.println("   J    a  v     v  /  \\");
        System.out.println("   J   a a  v   v  /_( )\\");
        System.out.println("J  J  aaaaa  V V  /      \\");
        System.out.println(" JJ  a     a  V  /___/\\___\\");

        // второй способ (с помощью текстового блока)
        String textBlock = """
                         /\\
                   J    /  \\  v     v  a
                   J   /_( )\\  v   v  a a
                J  J  /      \\  V V  aaaaa
                 JJ  /___/\\___\\  V  a     a
                """;
        System.out.println(textBlock);
        
        System.out.println("\n2. РАСЧЕТ СТОИМОСТИ ТОВАРА");

        // с использованием float без округления результата
        float pricePenRub = 105.5f;
        float priceBookRub = 235.23f;
        float discountPercent = 11.0f;
        float basePriceRub = pricePenRub + priceBookRub;
        System.out.println("Стоимость товаров без скидки = " + basePriceRub + " руб.");
        float discountAmount = (pricePenRub * priceBookRub) / 100;
        System.out.println("Сумма скидки = " + discountAmount + " руб.");
        float discountPrice = basePriceRub - discountAmount;
        System.out.println("Стоимость товаров со скидкой " + discountPrice + " руб.");

        // с использованием BigDecimal с округлением до двух знаков после запятой
        BigDecimal pricePenRubBd = new BigDecimal("105.5");
        BigDecimal priceBookRubBd = new BigDecimal("235.23");
        BigDecimal discountPercentBd = new BigDecimal("11.0");
        BigDecimal basePriceRubBd = pricePenRubBd.add(priceBookRubBd).setScale(2, RoundingMode.HALF_UP);
        System.out.println("\nСтоимость товаров без скидки = " + basePriceRubBd + " руб.");
        BigDecimal discountAmountBd = pricePenRubBd
                .multiply(priceBookRubBd)
                .divide(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_UP);
        System.out.println("Сумма скидки = " + discountAmountBd + " руб.");
        BigDecimal discountPriceBd = basePriceRubBd.subtract(discountAmountBd);
        System.out.println("Стоимость товаров со скидкой " + discountPriceBd + " руб.");

        System.out.println("\n3. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");
        int a1 = 2;
        int b1 = 5;

        // третья переменная
        int tmp = a1;
        a1 = b1;
        b1 = tmp;
        System.out.println("Метод: третья переменная");
        System.out.println("Результат: А1 = " + a1 + ", B1 = " + b1);

        // арифметический
        a1 += b1;
        b1 = a1 - b1;
        a1 -= b1;
        System.out.println("\nМетод: арифметический");
        System.out.println("Результат: A1 = " + a1 + ", B1 = " + b1);

        // побитовый
        a1 ^= b1;
        b1 ^= a1;
        a1 ^= b1;
        System.out.println("\nМетод: побитовый");
        System.out.println("Результат: A1 = " + a1 + ", B1 = " + b1);

        System.out.println("\n4. ДЕКОДИРОВАНИЕ СООБЩЕНИЯ");
        int code1 = 1055;
        int code2 = 1088;
        int code3 = 1080;
        int code4 = 1074;
        int code5 = 1077;
        int code6 = 1090;
        System.out.printf("%-6d%-6d%-6d%-6d%-6d%-6d%n", code1, code2, code3, code4, code5, code6);
        System.out.printf("%-6c%-6c%-6c%-6c%-6c%-6c%n", code1, code2, code3, code4, code5, code6);

        System.out.println("\n5. АНАЛИЗ КОДА ТОВАРА");
        int productCode = 123;
        int productCategory = productCode / 100;
        int productSubcategory = (productCode / 10) % 10;
        int packageType = productCode % 10;
        int checksum = productCategory + productSubcategory + packageType;
        int verificationCode = productCategory * productSubcategory * packageType;
        System.out.println("Код товара: " + productCode);
        System.out.println("     категория товара - " + productCategory);
        System.out.println("     подкатегория - " + productSubcategory);
        System.out.println("     тип упаковки - " + packageType);
        System.out.println("Контрольная сумма = " + checksum);
        System.out.println("Проверочный код = " + verificationCode);

        System.out.println("\n6. ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ");
        byte temperature = Byte.MAX_VALUE;
        System.out.println("""
                [Температура, °C]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(temperature, ++temperature, --temperature));

        short pressure = Short.MAX_VALUE;
        System.out.println("""
                [Давление, Па]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(pressure, ++pressure, --pressure));

        char systemCode = Character.MAX_VALUE;
        System.out.println("""
                [Код состояния, ]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted((int) systemCode, (int) (++systemCode), (int) (--systemCode)));

        int distance = Integer.MAX_VALUE;
        System.out.println("""
                [Расстояние, м]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(distance, ++distance, --distance));

        long time = Long.MAX_VALUE;
        System.out.println("""
                [Время, мс]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(time, ++time, --time));

        System.out.println("\n7. ВЫВОД ПАРАМЕТРОВ JVM И ОС");
        Runtime runtime = Runtime.getRuntime();
        long mb = 1024L * 1024L;

        // характеристики JVM
        int cores = runtime.availableProcessors();
        long totalMb = runtime.totalMemory() / mb;
        long freeMemory = runtime.freeMemory() / mb;
        long usedMemory = (totalMb - freeMemory) / mb;
        long maxMemory = runtime.maxMemory() / mb;
        System.out.printf("""
            Характеристики JVM
            Доступное число ядер: %d
            Выделенная память (МБ): %d
            Свободная память (Мб): %d
            Используемая память (Мб): %d
            Максимально доступная для выделения память (Мб): %d
                """, cores, totalMb, freeMemory, usedMemory, maxMemory);

        // параметры ОС
        String osDisk = System.getProperty("user.home").charAt(0) + ":";
        String osVersion = System.getProperty("os.name") + " " + System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String pathSeparator = System.getProperty("file.separator");

        // Вывод характеристик ОС
        System.out.printf("""
                \nСистемный диск: %s
                Версия ОС: %s
                Версия Java: %s
                Символ разделения пути (сепаратор): %s
                """, osDisk, osVersion, javaVersion, pathSeparator);

        System.out.println("\n8. ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА");
        LocalTime endTime = LocalTime.now();
        long endNano = System.nanoTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        System.out.println("Старт проверки: " + startTime.format(formatter));
        System.out.println("Финиш проверки: " + endTime.format(formatter));
        double timeSeconds = (endNano - startNano) / 1e9;
        System.out.printf("Время работы: %.3f сек\n", timeSeconds);
    }
}