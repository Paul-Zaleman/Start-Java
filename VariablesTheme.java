import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
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
                .divide(new BigDecimal("100"))
                .setScale(2, RoundingMode.HALF_UP);
        System.out.println("Сумма скидки = " + discountAmountBd + " руб.");
        BigDecimal discountPriceBd = basePriceRubBd.subtract(discountAmountBd);
        System.out.println("Стоимость товаров со скидкой " + discountPriceBd + " руб.");

        System.out.println("\n3. ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");
    }
}